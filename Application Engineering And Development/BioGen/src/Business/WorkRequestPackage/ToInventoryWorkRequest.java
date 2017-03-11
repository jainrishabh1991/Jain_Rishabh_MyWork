/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkRequestPackage;

import Business.OrderPackage.Batch;
import Business.EnterprisePackage.ManufacturerEnterprise;
import Business.OrderPackage.Order;

/**
 *
 * @author kRISH
 */
public class ToInventoryWorkRequest extends WorkRequest{
    
    private ManufacturerEnterprise manufacturerEnterprise;
    private Batch batch;
    private Order order;

    public ToInventoryWorkRequest(){}

    public ManufacturerEnterprise getManufacturerEnterprise() {
        return manufacturerEnterprise;
    }

    public void setManufacturerEnterprise(ManufacturerEnterprise manufacturerEnterprise) {
        this.manufacturerEnterprise = manufacturerEnterprise;
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
