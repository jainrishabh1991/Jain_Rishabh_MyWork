/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Warehouse;

import Business.DrugPackage.Drug;
import Business.EcoSystem;
import Business.EnterprisePackage.Enterprise;
import Business.NetworkPackage.Network;
import Business.EnterprisePackage.ManufacturerEnterprise;
import Business.OrderPackage.Order;
import Business.OrderPackage.OrderItem;
import Business.UserAccountPackage.UserAccount;
import Business.EnterprisePackage.WarehouseEnterprise;
import Business.WorkRequestPackage.FromWareHouseWorkRequest;
import Business.WorkRequestPackage.ToSalesWorkRequest;
import Business.WorkRequestPackage.ToWareHouseWorkRequest;
import Business.WorkRequestPackage.WorkQueue;
import Business.WorkRequestPackage.WorkRequest;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rishabh
 */
public class PlaceOrderToSalesManagerJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    UserAccount userAccount;
    WarehouseEnterprise warehouseEnterprise;
    Order order;
    EcoSystem ecoSystem;

    /**
     * Creates new form PlaceOrderToWareManagerJPanel
     */
    public PlaceOrderToSalesManagerJPanel(JPanel userProcessContainer, WarehouseEnterprise enterprise, UserAccount account, EcoSystem ecoSystem) {
        initComponents();
        this.ecoSystem = ecoSystem;
        this.userProcessContainer = userProcessContainer;
        this.warehouseEnterprise = enterprise;
        this.userAccount = account;

        Calendar currentDate = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("MMM/dd/yyyy");
        String dateNow = formatter.format(currentDate.getTime());
        lblDate.setText(dateNow);

        order = new Order();
        lblOrderID.setText("Order ID : " + order.getOrderID());

        //EcoSystem ecoSystem = EcoSystem.getInstance();
        cmbChooseManufacturer.removeAllItems();
    for(Network network: ecoSystem.getNetworkList()){
        for (Enterprise e : network.getEnterprisedirectory().getEnterpriseDirectory()) {
            if ((e.getEnterpriseType().equals(Enterprise.EnterpriseType.Manufacturer)) && e.getLicence().equals(Enterprise.LicApproved)) {
                cmbChooseManufacturer.addItem(e);
            }
        }
    }

        int rowCount = tblMyCart.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            ((DefaultTableModel) tblMyCart.getModel()).removeRow(i);

            int rowCount1 = tblProposedOrder.getRowCount();
            for (int jj = rowCount1 - 1; jj >= 0; jj--) {
                ((DefaultTableModel) tblProposedOrder.getModel()).removeRow(jj);
            }

            WorkQueue workQueue = warehouseEnterprise.getWarehouseManagerOrganization().getWorkQueue();

            for (WorkRequest workRequest : workQueue.getWorkRequestQueue()) {
                if (workRequest.getStatus().equals(WorkRequest.UnderPro) && (workRequest instanceof ToWareHouseWorkRequest )) {
                    one:
                    for (OrderItem orderItem : ((ToWareHouseWorkRequest) workRequest).getOrder().getOrderItemList()) {
                        Object row[] = new Object[2];
                        row[0] = orderItem;
                        int count = 0;

                        for (int c = 0; c < tblProposedOrder.getRowCount(); c++) {
                            OrderItem oi1 = (OrderItem) tblProposedOrder.getValueAt(c, 0);
                            if (oi1.getDrugName().equals(orderItem.getDrugName())) {
                                continue one;
                            }
                        }
                        for (WorkRequest wr : workQueue.getWorkRequestQueue()) {
                             if (wr.getStatus().equals(WorkRequest.UnderPro)) {
                                for (OrderItem oi : ((ToWareHouseWorkRequest) wr).getOrder().getOrderItemList()) {
                                    if (orderItem.getDrugName().equals(oi.getDrugName())) {
                                        count += oi.getQuantity();
                                    }
                                }
                            }
                        }
                        row[1] = count;

                        ((DefaultTableModel) tblProposedOrder.getModel()).addRow(row);
                    }
                }
            }
        }
        cmbDrugs.removeAllItems();
        for(String d:warehouseEnterprise.getAllApprovedDrugs())
            cmbDrugs.addItem(d);
        
    }

    public void Refresh() {
        int rowCount = tblMyCart.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            ((DefaultTableModel) tblMyCart.getModel()).removeRow(i);
        }

        for (OrderItem orderItem : order.getOrderItemList()) {
            Object row[] = new Object[2];
            row[0] = orderItem;
            row[1] = orderItem.getQuantity();

            ((DefaultTableModel) tblMyCart.getModel()).addRow(row);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnSubmitOrder = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        cmbChooseManufacturer = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMyCart = new javax.swing.JTable();
        lblOrderID = new javax.swing.JLabel();
        btnAddtoCart = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProposedOrder = new javax.swing.JTable();
        cmbDrugs = new javax.swing.JComboBox<>();
        backJButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("My Cart");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Drug Name");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, -1, -1));
        add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 140, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Choose Manufacturer");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 350, -1, -1));

        btnSubmitOrder.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSubmitOrder.setText("Submit Order");
        btnSubmitOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitOrderActionPerformed(evt);
            }
        });
        add(btnSubmitOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 490, -1, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 67, 990, 10));

        cmbChooseManufacturer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(cmbChooseManufacturer, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 350, 140, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Quantity");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, -1, -1));

        tblMyCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Drug Name", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblMyCart);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 230, 340));

        lblOrderID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        add(lblOrderID, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 150, 30));

        btnAddtoCart.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddtoCart.setText("Add To Cart");
        btnAddtoCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddtoCartActionPerformed(evt);
            }
        });
        add(btnAddtoCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, -1, -1));

        btnRemove.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        add(btnRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Place Order To Manufacturer");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

        lblDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 10, 110, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Proposed Order");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 100, 150, -1));

        tblProposedOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Drug Name", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblProposedOrder);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 130, 260, 310));

        add(cmbDrugs, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 140, -1));

        backJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitOrderActionPerformed

        if (order.getOrderItemList().size() == 0) {
            JOptionPane.showMessageDialog(null, "Nothing In Cart");
            return;
        }

        if ((cmbChooseManufacturer.getSelectedItem() == null)) {
            JOptionPane.showMessageDialog(null, "No Manufacturer Selected ");
            return;
        }

        ToSalesWorkRequest wr = new ToSalesWorkRequest();
        wr.setOrder(order);
        wr.setSender(userAccount);
        wr.setStatus(WorkRequest.UnderPro);
        wr.setWareHouseEnterprise(warehouseEnterprise);
        wr.setSendingDate(lblDate.getText());

        ((ManufacturerEnterprise) cmbChooseManufacturer.getSelectedItem()).getSalesManagerOrganization().getWorkQueue().getWorkRequestQueue().add(wr);

        FromWareHouseWorkRequest wr1 = new FromWareHouseWorkRequest();
        wr1.setOrder(order);
        wr1.setSender(userAccount);
        wr1.setStatus(WorkRequest.UnderPro);
        wr1.setManufacturerEnterprise(((ManufacturerEnterprise) cmbChooseManufacturer.getSelectedItem()));
        wr1.setSendingDate(lblDate.getText());

        warehouseEnterprise.getWarehouseManagerOrganization().getWorkQueue().getWorkRequestQueue().add(wr1);
        JOptionPane.showMessageDialog(null, "Order " + order.getOrderID() + " Placed Successfully");

//        WareHouseManagerJPanel panel = new WareHouseManagerJPanel(userProcessContainer, warehouseEnterprise, userAccount);
//        userProcessContainer.add("back to warehouse manager", panel);
//        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
//        cardLayout.next(userProcessContainer);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSubmitOrderActionPerformed

    private void btnAddtoCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddtoCartActionPerformed

        int quantity = 0;
        try {
            quantity = Integer.parseInt(txtQuantity.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Quantity must be an interger");
            return;
        }

        OrderItem orderItem = order.newOrderItem();

        orderItem.setDrugName(cmbDrugs.getSelectedItem() + "");
        orderItem.setQuantity(quantity);

        Refresh();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddtoCartActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed

        int selectedRow = tblMyCart.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Select Row to Remove Drug from MyCart");
            return;
        }

        OrderItem orderItem = (OrderItem) tblMyCart.getValueAt(selectedRow, 0);
        order.removeOrderItem(orderItem);

        Refresh();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton btnAddtoCart;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSubmitOrder;
    private javax.swing.JComboBox cmbChooseManufacturer;
    private javax.swing.JComboBox<String> cmbDrugs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblOrderID;
    private javax.swing.JTable tblMyCart;
    private javax.swing.JTable tblProposedOrder;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
