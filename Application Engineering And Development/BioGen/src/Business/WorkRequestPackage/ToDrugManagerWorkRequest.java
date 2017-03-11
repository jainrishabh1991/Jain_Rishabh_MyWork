/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkRequestPackage;

import Business.EnterprisePackage.ManufacturerEnterprise;
import Business.OrderPackage.Order;

/**
 *
 * @author kRISH
 */
public class ToDrugManagerWorkRequest extends WorkRequest {

    private ManufacturerEnterprise manufacturerEnterprise;
    private Order order;
    
    public ToDrugManagerWorkRequest() {    }

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
    
    @Override
    public String toString() {
        return order.getOrderID();
    }
}
