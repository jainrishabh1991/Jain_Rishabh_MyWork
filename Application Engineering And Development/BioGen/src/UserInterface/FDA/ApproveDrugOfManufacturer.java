/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.FDA;

import Business.UserAccountPackage.UserAccount;
import Business.WorkRequestPackage.WorkRequest;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import Business.ClinicalPackage.Treatment;
import Business.ClinicalPackage.TreatmentHistory;
import Business.DrugPackage.Drug;
import Business.PreClinicalPackage.AnimalTreatment;
import Business.PreClinicalPackage.AnimalTreatmentHistory;
import Business.UserAccountPackage.UserAccount;
import Business.WorkRequestPackage.DrugApprovalFromManuToFDA;
import Business.WorkRequestPackage.WorkRequest;
import UserInterface.Manufacturer.AnimalTreatmentDetails;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
/**
 *
 * @author Atul
 */
public class ApproveDrugOfManufacturer extends javax.swing.JPanel {

    JPanel userProcessContainer;
    WorkRequest workRequest;
    UserAccount userAccount;
    AnimalTreatmentHistory animalTreatmentDetails;
    TreatmentHistory treatmentHistory;
    /**
     * Creates new form ApproveDrugOfManufacturer
     */
    public ApproveDrugOfManufacturer(JPanel userProcessContainer, WorkRequest workRequest, UserAccount userAccount) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.workRequest = workRequest;
        this.userAccount = userAccount;
        DrugApprovalFromManuToFDA wr = (DrugApprovalFromManuToFDA)workRequest;
        animalTreatmentDetails = wr.getAnimalTreatmentHistory();
        treatmentHistory = wr.getPatientTreatmentHistory();
        refresh();
        
        
       /* Response/Dosage:Patient */
        DefaultCategoryDataset dcd=new DefaultCategoryDataset();
     for(Treatment t: treatmentHistory.getTreatmentHistory()){
         dcd.setValue(t.getResponse(),"Response" ,t.getDosage()+"");     
     }
        JFreeChart jchart=ChartFactory.createBarChart("Response/Dosage", "Dosage", "Response", dcd, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot=jchart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.BLACK);
        ChartPanel chartPanel=new ChartPanel(jchart);
        jPanelPatientBox.removeAll();
        jPanelPatientBox.add(chartPanel);
        jPanelPatientBox.updateUI();
        
        /* SideEffect/Dosage:Patient */
        DefaultCategoryDataset dcd3=new DefaultCategoryDataset();
     for(Treatment t: treatmentHistory.getTreatmentHistory()){
         dcd3.setValue(t.getSideEffects(),"SideEffects" ,t.getDosage()+"");     
     }
        JFreeChart jchart3=ChartFactory.createBarChart("Response/Dosage", "Dosage", "Response", dcd3, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot3=jchart3.getCategoryPlot();
        plot3.setRangeGridlinePaint(Color.BLACK);
        ChartPanel chartPanel3=new ChartPanel(jchart);
        jPanelPatientBox1.removeAll();
        jPanelPatientBox1.add(chartPanel3);
        jPanelPatientBox1.updateUI();
        
        
        /* Response/Dosage:Animal */
        DefaultCategoryDataset dcd2=new DefaultCategoryDataset();
     for(AnimalTreatment at:animalTreatmentDetails.getAnimalTreatmentHistory()){
         dcd2.setValue(at.getResponse(),"Response" ,at.getDosage()+"");     
     }
        JFreeChart jchart2=ChartFactory.createBarChart("Response/Dosage", "Dosage", "Response", dcd2, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot2=jchart2.getCategoryPlot();
        plot2.setRangeGridlinePaint(Color.BLACK);
        ChartPanel chartPanel2=new ChartPanel(jchart);
        jPanelAnimalBox.removeAll();
        jPanelAnimalBox.add(chartPanel2);
        jPanelAnimalBox.updateUI();
        
        /* SideEffect/Dosage:Animal */
        DefaultCategoryDataset dcd4=new DefaultCategoryDataset();
     for(AnimalTreatment at:animalTreatmentDetails.getAnimalTreatmentHistory()){
         dcd4.setValue(at.getResponse(),"Response" ,at.getDosage()+"");     
     }
        JFreeChart jchart4=ChartFactory.createBarChart("SideEffect/Dosage", "Dosage", "Response", dcd4, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot4=jchart2.getCategoryPlot();
        plot4.setRangeGridlinePaint(Color.BLACK);
        ChartPanel chartPanel4=new ChartPanel(jchart4);
        jPanelAnimalBox1.removeAll();
        jPanelAnimalBox1.add(chartPanel4);
        jPanelAnimalBox1.updateUI();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTables = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPreclinicalReport = new javax.swing.JTable();
        btnApproveDrug = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblClinicalReport = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanelAnimalTestGraph = new javax.swing.JPanel();
        jPanelAnimalBox = new javax.swing.JPanel();
        jPanelAnimalBox1 = new javax.swing.JPanel();
        jPanelPatientTestGraph = new javax.swing.JPanel();
        jPanelPatientBox1 = new javax.swing.JPanel();
        jPanelPatientBox = new javax.swing.JPanel();

        jLabel1.setText("Preclinical");

        tblPreclinicalReport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TreatmentID", "Type", "Drug", "Response", "Dosage"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPreclinicalReport);
        if (tblPreclinicalReport.getColumnModel().getColumnCount() > 0) {
            tblPreclinicalReport.getColumnModel().getColumn(0).setResizable(false);
            tblPreclinicalReport.getColumnModel().getColumn(1).setResizable(false);
            tblPreclinicalReport.getColumnModel().getColumn(2).setResizable(false);
            tblPreclinicalReport.getColumnModel().getColumn(3).setResizable(false);
            tblPreclinicalReport.getColumnModel().getColumn(4).setResizable(false);
        }

        btnApproveDrug.setText("Approve Drug");
        btnApproveDrug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveDrugActionPerformed(evt);
            }
        });

        tblClinicalReport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TreatmentID", "Patient", "Drug", "Response", "Dosage"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblClinicalReport);
        if (tblClinicalReport.getColumnModel().getColumnCount() > 0) {
            tblClinicalReport.getColumnModel().getColumn(0).setResizable(false);
            tblClinicalReport.getColumnModel().getColumn(1).setResizable(false);
            tblClinicalReport.getColumnModel().getColumn(2).setResizable(false);
            tblClinicalReport.getColumnModel().getColumn(3).setResizable(false);
            tblClinicalReport.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel2.setText("Hospital");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(630, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap(135, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnApproveDrug)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)))
                    .addGap(183, 183, 183)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel1)
                .addGap(168, 168, 168)
                .addComponent(jLabel2)
                .addContainerGap(232, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(107, 107, 107)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(92, 92, 92)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(btnApproveDrug)
                    .addContainerGap(87, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 865, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pnlTables.addTab("Reports", jPanel1);

        jPanelAnimalBox.setBorder(javax.swing.BorderFactory.createTitledBorder("Report"));
        jPanelAnimalBox.setLayout(new javax.swing.BoxLayout(jPanelAnimalBox, javax.swing.BoxLayout.LINE_AXIS));

        jPanelAnimalBox1.setBorder(javax.swing.BorderFactory.createTitledBorder("Report"));
        jPanelAnimalBox1.setLayout(new javax.swing.BoxLayout(jPanelAnimalBox1, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout jPanelAnimalTestGraphLayout = new javax.swing.GroupLayout(jPanelAnimalTestGraph);
        jPanelAnimalTestGraph.setLayout(jPanelAnimalTestGraphLayout);
        jPanelAnimalTestGraphLayout.setHorizontalGroup(
            jPanelAnimalTestGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAnimalTestGraphLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanelAnimalBox, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(183, Short.MAX_VALUE))
            .addGroup(jPanelAnimalTestGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelAnimalTestGraphLayout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addComponent(jPanelAnimalBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(184, Short.MAX_VALUE)))
        );
        jPanelAnimalTestGraphLayout.setVerticalGroup(
            jPanelAnimalTestGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAnimalTestGraphLayout.createSequentialGroup()
                .addContainerGap(260, Short.MAX_VALUE)
                .addComponent(jPanelAnimalBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addGroup(jPanelAnimalTestGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelAnimalTestGraphLayout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(jPanelAnimalBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(277, Short.MAX_VALUE)))
        );

        pnlTables.addTab("Animal Tests Grah", jPanelAnimalTestGraph);

        jPanelPatientBox1.setBorder(javax.swing.BorderFactory.createTitledBorder("Report"));
        jPanelPatientBox1.setLayout(new javax.swing.BoxLayout(jPanelPatientBox1, javax.swing.BoxLayout.LINE_AXIS));

        jPanelPatientBox.setBorder(javax.swing.BorderFactory.createTitledBorder("Report"));
        jPanelPatientBox.setLayout(new javax.swing.BoxLayout(jPanelPatientBox, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout jPanelPatientTestGraphLayout = new javax.swing.GroupLayout(jPanelPatientTestGraph);
        jPanelPatientTestGraph.setLayout(jPanelPatientTestGraphLayout);
        jPanelPatientTestGraphLayout.setHorizontalGroup(
            jPanelPatientTestGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPatientTestGraphLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPatientTestGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanelPatientBox, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                    .addComponent(jPanelPatientBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE))
                .addContainerGap(205, Short.MAX_VALUE))
        );
        jPanelPatientTestGraphLayout.setVerticalGroup(
            jPanelPatientTestGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPatientTestGraphLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanelPatientBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanelPatientBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        pnlTables.addTab("Patient tests graph", jPanelPatientTestGraph);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTables)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTables)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    
    public void refresh()
            
    {
        
        
        
        
        for(Treatment t : treatmentHistory.getTreatmentHistory())
        {
            Object row[] = new Object[5];
            row[0] = t;
            row[1] = t.getPatient().getName();
            row[2] = t.getDrug();
            row[3] = t.getResponse();
            row[4] = t.getDosage();

            ((DefaultTableModel) tblClinicalReport.getModel()).addRow(row);
        }
        
        for(AnimalTreatment t:animalTreatmentDetails.getAnimalTreatmentHistory())
            {
                Object row[] = new Object[5];
                row[0] = t;
                row[1] = t.getAnimal().getAnimalType();
                row[2] = t.getDrug();
                row[3] = t.getResponse();
                row[4] = t.getDosage();

                ((DefaultTableModel) tblPreclinicalReport.getModel()).addRow(row);
            }
        
        
    }
    private void btnApproveDrugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveDrugActionPerformed
        // TODO add your handling code here:
        DrugApprovalFromManuToFDA wr = (DrugApprovalFromManuToFDA)workRequest;
        Drug d = wr.getDrug();
        d.setIsApprovedByFDA(true);
        d.setIsWorkdonebyFDA(true);
        wr.setStatus(WorkRequest.Done);
        
    }//GEN-LAST:event_btnApproveDrugActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApproveDrug;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelAnimalBox;
    private javax.swing.JPanel jPanelAnimalBox1;
    private javax.swing.JPanel jPanelAnimalTestGraph;
    private javax.swing.JPanel jPanelPatientBox;
    private javax.swing.JPanel jPanelPatientBox1;
    private javax.swing.JPanel jPanelPatientTestGraph;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane pnlTables;
    private javax.swing.JTable tblClinicalReport;
    private javax.swing.JTable tblPreclinicalReport;
    // End of variables declaration//GEN-END:variables
}
