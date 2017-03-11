/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Manufacturer;

import Business.ClinicalPackage.Treatment;
import Business.ClinicalPackage.TreatmentHistory;
import Business.DrugPackage.Drug;
import Business.EcoSystem;
import Business.EnterprisePackage.Enterprise;
import Business.EnterprisePackage.FDAEnterprise;
import Business.EnterprisePackage.HospitalEnterprise;
import Business.EnterprisePackage.ManufacturerEnterprise;
import Business.EnterprisePackage.WarehouseEnterprise;
import Business.NetworkPackage.Network;
import Business.PreClinicalPackage.AnimalTreatment;
import Business.PreClinicalPackage.AnimalTreatmentHistory;
import Business.UserAccountPackage.UserAccount;
import Business.WorkRequestPackage.AddDrugToYourDirectory;
import Business.WorkRequestPackage.DrugApprovalFromManuToFDA;
import Business.WorkRequestPackage.ForClinicalFromManuToHosp;
import Business.WorkRequestPackage.SendReportToManuFromHosp;
import Business.WorkRequestPackage.SendReportToManuFromPreclinical;
import Business.WorkRequestPackage.WorkRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Atul
 */
public class DrugApprovalStatusJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private  ManufacturerEnterprise manufacturerEnterprise;
    private Drug d;
    EcoSystem ecosystem;
    /**
     * Creates new form DrugApprovalStatusJPanel
     */
    public DrugApprovalStatusJPanel(JPanel userProcessContainer, ManufacturerEnterprise manufacturerEnterprise, UserAccount account, Drug D, int Stage, EcoSystem business) {
        initComponents();
        this.ecosystem = business;
        cmbxHospitals.removeAllItems();
        ((DefaultTableModel) tblPreclinicalReport.getModel()).setRowCount(0);
        this.userAccount=userAccount;
        this.userProcessContainer=userProcessContainer;
        this.manufacturerEnterprise=manufacturerEnterprise;
        this.d=D;
        Network network = null;
        for (WorkRequest wr : manufacturerEnterprise.getDrugManagerOrganization().getWorkQueue().getWorkRequestQueue()) {
            if(wr instanceof SendReportToManuFromPreclinical){
                SendReportToManuFromPreclinical sr1=(SendReportToManuFromPreclinical)wr;
            if(!(sr1.getStatus().equals(WorkRequest.Done)))
                        {
                            for(AnimalTreatment t:sr1.getAnimalTreatmentHistory().getAnimalTreatmentHistory())
                            {
                                Object row[] = new Object[5];
                                row[0] = t.getDrug();
                                row[1] = t.getAnimal().getAnimalType();
                                row[2] = t.getDosage();
                                row[3] = t.getResponse();
                                row[4] = t.getSideEffect();

                                ((DefaultTableModel) tblPreclinicalReport.getModel()).addRow(row);
                            }
                        }
            }
            
       
        }
        if(Stage==1)
        {
            //EcoSystem ecosystem = EcoSystem.getInstance();
            for(Network n: ecosystem.getNetworkList())
            {
                for(Enterprise e:n.getEnterprisedirectory().getEnterpriseDirectory())
                {
                    if(e.getEnterpriseType().equals(Enterprise.EnterpriseType.Manufacturer))
                    {
                        if(manufacturerEnterprise.equals((ManufacturerEnterprise)e))
                        {
                            network=n;
                        }
                        
                    }
                }
            }
            
            for(Enterprise e: network.getEnterprisedirectory().getEnterpriseDirectory())
            {
                if(e.getEnterpriseType().equals(Enterprise.EnterpriseType.Hospital))
                {
                    HospitalEnterprise hospitalEnterprise=(HospitalEnterprise)e;
                    cmbxHospitals.addItem(hospitalEnterprise);
                }
            }
            
            tblClinicalReport.setVisible(false);
            jLabel1.setVisible(false);
            btnSendtoFDAApproval.setVisible(false);
            btnDiscard2.setVisible(false);
            btnMovetoClinicalStage.setVisible(true);
            cmbxHospitals.setVisible(true);
            
        }
        else if(Stage==2)
        {
            ((DefaultTableModel) tblClinicalReport.getModel()).setRowCount(0);
            for(WorkRequest wr:manufacturerEnterprise.getDrugManagerOrganization().getWorkQueue().getWorkRequestQueue()){
                if(wr instanceof SendReportToManuFromHosp){
                    SendReportToManuFromHosp sr = (SendReportToManuFromHosp)wr;
                if(!(sr.getStatus().equals(WorkRequest.Done)))
                        {
                            for(Treatment t:sr.getTreatmentHistory().getTreatmentHistory())
                            {
                                Object row[] = new Object[5];
                                row[0] = t;
                                row[1] = t.getPatient().getName();
                                row[2] = t.getDosage();
                                row[3] = t.getResponse();
                                row[4] = t.getSideEffects();

                                ((DefaultTableModel) tblClinicalReport.getModel()).addRow(row);
                            }
                        }
                }
                
            }
            btnMovetoClinicalStage.setVisible(false);
            tblClinicalReport.setVisible(true);
            jLabel1.setVisible(true);
            btnSendtoFDAApproval.setVisible(true);
            btnDiscard2.setVisible(true);
        }
        else if(Stage==3)
        {
            ((DefaultTableModel) tblFdaApproval.getModel()).setRowCount(0);
            //for(WorkRequest wr:manufacturerEnterprise.getDrugManagerOrganization().getWorkQueue().getWorkRequestQueue()){
            for(Network net : ecosystem.getNetworkList()) {
            for(Enterprise e : net.getEnterprisedirectory().getEnterpriseDirectory()) {
                if(e instanceof FDAEnterprise) {
                    
                
            for(WorkRequest wr: ((FDAEnterprise) e).getFdaOrganization().getWorkQueue().getWorkRequestQueue()){
                if(wr instanceof DrugApprovalFromManuToFDA){
                    DrugApprovalFromManuToFDA sr = (DrugApprovalFromManuToFDA)wr;
                if((sr.getStatus().equals(WorkRequest.Done)))
                        {
                             
                                Object row[] = new Object[4];
                                row[0] = sr.getDrug();
                                row[1] = sr.getReceiver();
                                row[2] = sr.getStatus();
                                row[3] = sr.getReceiver();

                                ((DefaultTableModel) tblFdaApproval.getModel()).addRow(row);
                            
                        }
                }
            }
                }
                
            }
            }
            
            ((DefaultTableModel) tblClinicalReport.getModel()).setRowCount(0);
            for(WorkRequest wr:manufacturerEnterprise.getDrugManagerOrganization().getWorkQueue().getWorkRequestQueue()){
                if(wr instanceof SendReportToManuFromHosp){
                    SendReportToManuFromHosp sr = (SendReportToManuFromHosp)wr;
                if(!(sr.getStatus().equals(WorkRequest.Done)))
                        {
                            for(Treatment t:sr.getTreatmentHistory().getTreatmentHistory())
                            {
                                Object row[] = new Object[5];
                                row[0] = t;
                                row[1] = t.getPatient().getName();
                                row[2] = t.getDosage();
                                row[3] = t.getResponse();
                                row[4] = t.getSideEffects();

                                ((DefaultTableModel) tblClinicalReport.getModel()).addRow(row);
                            }
                        }
                }
                
            }
        }
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPreclinicalReport = new javax.swing.JTable();
        btnMovetoClinicalStage = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblClinicalReport = new javax.swing.JTable();
        btnSendtoFDAApproval = new javax.swing.JButton();
        btnDiscard = new javax.swing.JButton();
        btnDiscard2 = new javax.swing.JButton();
        cmbxHospitals = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblFdaApproval = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btnMoveToApprovedDrugs = new javax.swing.JButton();
        txtPrice = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Preclinical");

        tblPreclinicalReport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblPreclinicalReport);

        btnMovetoClinicalStage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnMovetoClinicalStage.setText("Move to Clinical Stage");
        btnMovetoClinicalStage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovetoClinicalStageActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Hospital");

        tblClinicalReport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblClinicalReport);

        btnSendtoFDAApproval.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSendtoFDAApproval.setText("Send to FDA Approval");
        btnSendtoFDAApproval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendtoFDAApprovalActionPerformed(evt);
            }
        });

        btnDiscard.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDiscard.setText("Discard");
        btnDiscard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiscardActionPerformed(evt);
            }
        });

        btnDiscard2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDiscard2.setText("Discard");
        btnDiscard2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiscard2ActionPerformed(evt);
            }
        });

        cmbxHospitals.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbxHospitals.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Hospital");

        tblFdaApproval.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblFdaApproval);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("FDA");

        btnMoveToApprovedDrugs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnMoveToApprovedDrugs.setText("Move to Approved Drugs");
        btnMoveToApprovedDrugs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoveToApprovedDrugsActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Price:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Drug Manager Area");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnDiscard)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(34, 34, 34)
                        .addComponent(cmbxHospitals, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMovetoClinicalStage))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(0, 512, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnMoveToApprovedDrugs))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnDiscard2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSendtoFDAApproval)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMovetoClinicalStage)
                    .addComponent(btnDiscard)
                    .addComponent(cmbxHospitals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSendtoFDAApproval)
                    .addComponent(btnDiscard2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMoveToApprovedDrugs)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnMovetoClinicalStageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovetoClinicalStageActionPerformed
        // TODO add your handling code here:
        int selectedRow =  tblPreclinicalReport.getSelectedRow();
        Calendar currentDate = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("MMM/dd/yyyy");
        String dateNow = formatter.format(currentDate.getTime());
        Drug d = (Drug) tblPreclinicalReport.getValueAt(selectedRow, 0);
        
        HospitalEnterprise h = (HospitalEnterprise)cmbxHospitals.getSelectedItem();
        ForClinicalFromManuToHosp wr = new ForClinicalFromManuToHosp();
        wr.setSender(userAccount);
        wr.setStatus("");
        wr.setSendingDate(dateNow);
        wr.setDrug(d);
        
        h.getDoctorOrganization().getWorkQueue().getWorkRequestQueue().add(wr);
        
        
        
        
             
        
        
        
        
        
        
        
    }//GEN-LAST:event_btnMovetoClinicalStageActionPerformed

    private void btnSendtoFDAApprovalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendtoFDAApprovalActionPerformed
        // TODO add your handling code here:
        Network network=null;
        FDAEnterprise fDAEnterprise=null;
        TreatmentHistory HosptreatmentHistory= new TreatmentHistory();
        AnimalTreatmentHistory preClinAnimalTreatmentHistory=new AnimalTreatmentHistory();
        //EcoSystem ecoSystem=EcoSystem.getInstance();
        for(Network n:ecosystem.getNetworkList()){
            for(Enterprise e:n.getEnterprisedirectory().getEnterpriseDirectory()){
                if(e.getEnterpriseType().equals(Enterprise.EnterpriseType.Manufacturer)){
                    if(manufacturerEnterprise.equals((ManufacturerEnterprise)e)){
                       network=n;
                    }
                }
            }
        }
        
        for(Enterprise enterprise:network.getEnterprisedirectory().getEnterpriseDirectory()){
            if(enterprise.getEnterpriseType().equals(Enterprise.EnterpriseType.FDA)){
                    fDAEnterprise=(FDAEnterprise)enterprise;
            }
        }
        
        for(WorkRequest wr:manufacturerEnterprise.getDrugManagerOrganization().getWorkQueue().getWorkRequestQueue()){
            if(wr instanceof SendReportToManuFromHosp)
            {
              SendReportToManuFromHosp sr = (SendReportToManuFromHosp)wr;
                if(!(sr.getStatus().equals(WorkRequest.Done)))
                        {
                            for(Treatment t:sr.getTreatmentHistory().getTreatmentHistory())
                            {
                                if(t.getDrug().equals(d))
                                {
                                    HosptreatmentHistory.addExistingTreatment(t);
                                }
                                
                            }
                        }  
            }
            
            if(wr instanceof SendReportToManuFromPreclinical){
                SendReportToManuFromPreclinical sr = (SendReportToManuFromPreclinical)wr;
                if(!(sr.getStatus().equals(WorkRequest.Done)))
                        {
                            for(AnimalTreatment t:sr.getAnimalTreatmentHistory().getAnimalTreatmentHistory())
                            {
                                if(t.getDrug().equals(d))
                                {
                                    preClinAnimalTreatmentHistory.addExistingTreatment(t);
                                }
                                
                            }
                        }  
                
            }
        }
        Calendar currentDate = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("MMM/dd/yyyy");
        String dateNow = formatter.format(currentDate.getTime());
        DrugApprovalFromManuToFDA wr = new DrugApprovalFromManuToFDA();
        wr.setAnimalTreatmentHistory(preClinAnimalTreatmentHistory);
        wr.setPatientTreatmentHistory(HosptreatmentHistory);
        wr.setSender(userAccount);
        wr.setStatus(WorkRequest.Sent);
        wr.setSendingDate(dateNow);
        wr.setDrug(d);
        
        fDAEnterprise.getFdaOrganization().getWorkQueue().getWorkRequestQueue().add(wr);
        
    }//GEN-LAST:event_btnSendtoFDAApprovalActionPerformed

    private void btnDiscardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiscardActionPerformed
        // TODO add your handling code here:
        
        manufacturerEnterprise.getDrugDirectory().removeDrug(d);
        
    }//GEN-LAST:event_btnDiscardActionPerformed

    private void btnDiscard2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiscard2ActionPerformed
        // TODO add your handling code here:
        manufacturerEnterprise.getDrugDirectory().removeDrug(d);
    }//GEN-LAST:event_btnDiscard2ActionPerformed

    private void btnMoveToApprovedDrugsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoveToApprovedDrugsActionPerformed
        // TODO add your handling code here:
        if(txtPrice.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Please enter price of drug");
            return;
        }
        if(manufacturerEnterprise.getDrugDirectory().getDrugDirectory().contains(d))
        {
            JOptionPane.showMessageDialog(null,"drug already addded");
            return;
        }
        if(d.isIsApprovedByFDA())
        {
            
            d.setNoOfUnits(0);
            d.setManufacturerName(manufacturerEnterprise.getOrganizationName());
           d.setUnitPrice(Integer.parseInt(txtPrice.getText()));
        manufacturerEnterprise.getDrugDirectory().getDrugDirectory().add(d);
        manufacturerEnterprise.getUnApprovedDrugDirectory().removeDrug(d);
        Network network =null;
        //EcoSystem ecosystem = EcoSystem.getInstance();
            for(Network n: ecosystem.getNetworkList())
            {
                for(Enterprise e:n.getEnterprisedirectory().getEnterpriseDirectory())
                {
                    if(e.getEnterpriseType().equals(Enterprise.EnterpriseType.Manufacturer))
                    {
                        if(manufacturerEnterprise.equals((ManufacturerEnterprise)e))
                        {
                            network=n;
                        }
                        
                    }
                }
            }
            
            for(Enterprise e: network.getEnterprisedirectory().getEnterpriseDirectory())
            {
                if(e.getEnterpriseType().equals(Enterprise.EnterpriseType.Hospital))
                {
                    HospitalEnterprise hospitalEnterprise=(HospitalEnterprise)e;
                    AddDrugToYourDirectory wr = new AddDrugToYourDirectory();
                    wr.setDrugName(d.getDrugName());
                    wr.setSender(userAccount);
                    wr.setStatus(WorkRequest.Sent);
                    hospitalEnterprise.getWorkQueue().getWorkRequestQueue().add(wr);
                }
                
                if(e.getEnterpriseType().equals(Enterprise.EnterpriseType.Warehouse))
                {
                    WarehouseEnterprise warehouseEnterprise=(WarehouseEnterprise)e;
                    AddDrugToYourDirectory wr = new AddDrugToYourDirectory();
                    wr.setDrugName(d.getDrugName());
                    wr.setSender(userAccount);
                    wr.setStatus(WorkRequest.Sent);
                    warehouseEnterprise.getWorkQueue().getWorkRequestQueue().add(wr);
                    
                }
                
                
                
                
                
                
                
                
            }
        
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Trying to add Unapproved Drug");
        }
    }//GEN-LAST:event_btnMoveToApprovedDrugsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDiscard;
    private javax.swing.JButton btnDiscard2;
    private javax.swing.JButton btnMoveToApprovedDrugs;
    private javax.swing.JButton btnMovetoClinicalStage;
    private javax.swing.JButton btnSendtoFDAApproval;
    private javax.swing.JComboBox cmbxHospitals;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tblClinicalReport;
    private javax.swing.JTable tblFdaApproval;
    private javax.swing.JTable tblPreclinicalReport;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
