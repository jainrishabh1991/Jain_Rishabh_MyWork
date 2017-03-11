/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkRequestPackage;

import Business.EnterprisePackage.WarehouseEnterprise;

/**
 *
 * @author kRISH
 */
public class ForLicenceByWareHWorkRequest extends WorkRequest{
    
    private WarehouseEnterprise wareHouseEnterprise;

    public ForLicenceByWareHWorkRequest(){}

    public WarehouseEnterprise getWareHouseEnterprise() {
        return wareHouseEnterprise;
    }

    public void setWareHouseEnterprise(WarehouseEnterprise wareHouseEnterprise) {
        this.wareHouseEnterprise = wareHouseEnterprise;
    }

    @Override
    public String toString() {
        return wareHouseEnterprise.getOrganizationName();
    }
    
}
