/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkRequestPackage;

import Business.EnterprisePackage.HospitalEnterprise;
import Business.OrderPackage.Order;

/**
 *
 * @author kRISH
 */
public class ToWareHouseWorkRequest extends WorkRequest {

    private HospitalEnterprise hospitalEnterprise;
    private Order order;
    
    public ToWareHouseWorkRequest() {    }

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
    
    @Override
    public String toString() {
        return order.getOrderID();
    }
}
