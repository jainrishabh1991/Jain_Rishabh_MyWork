/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkRequestPackage;

import Business.OrderPackage.Batch;
import Business.OrderPackage.Order;
import Business.EnterprisePackage.WarehouseEnterprise;

/**
 *
 * @author kRISH
 */
public class ToDispenseWorkRequest extends WorkRequest{
    
    private WarehouseEnterprise wareHouseEnterprise;
    private Batch batch;
    private Order order;

    public ToDispenseWorkRequest(){}

    public WarehouseEnterprise getWareHouseEnterprise() {
        return wareHouseEnterprise;
    }

    public void setWareHouseEnterprise(WarehouseEnterprise wareHouseEnterprise) {
        this.wareHouseEnterprise = wareHouseEnterprise;
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
