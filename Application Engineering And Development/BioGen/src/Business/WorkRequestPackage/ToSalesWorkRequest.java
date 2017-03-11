/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkRequestPackage;

import Business.OrderPackage.Order;
import Business.EnterprisePackage.WarehouseEnterprise;

/**
 *
 * @author kRISH
 */
public class ToSalesWorkRequest extends WorkRequest{
    
    private WarehouseEnterprise wareHouseEnterprise;
    private Order order;
    
    public ToSalesWorkRequest(){}

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
    
    @Override
    public String toString() {
        return order.getOrderID();
    }
    
}
