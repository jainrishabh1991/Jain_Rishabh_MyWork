/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkRequestPackage;

import Business.OrderPackage.Batch;
import Business.EnterprisePackage.HospitalEnterprise;
import Business.OrderPackage.Order;

/**
 *
 * @author kRISH
 */
public class FromInventoryWorkRequest extends WorkRequest{
    
    private Order order;
    private HospitalEnterprise hospitalEnterprise;
    private Batch batch;
    
    public FromInventoryWorkRequest(){}

    public HospitalEnterprise getHospitalEnterprise() {
        return hospitalEnterprise;
    }

    public void setHospitalEnterprise(HospitalEnterprise hospitalEnterprise) {
        this.hospitalEnterprise = hospitalEnterprise;
    }

      public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    @Override
    public String toString() {
        return order.getOrderID();
    }
    
    
}
