/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkRequestPackage;

import Business.EnterprisePackage.ManufacturerEnterprise;

/**
 *
 * @author kRISH
 */
public class ForLicenceByManuWorkRequest extends WorkRequest{
    
    private ManufacturerEnterprise manufacturerEnterprise;

    public ForLicenceByManuWorkRequest(){}

    public ManufacturerEnterprise getManufacturerEnterprise() {
        return manufacturerEnterprise;
    }

    public void setManufacturerEnterprise(ManufacturerEnterprise manufacturerEnterprise) {
        this.manufacturerEnterprise = manufacturerEnterprise;
    }

    @Override
    public String toString() {
        return manufacturerEnterprise.getOrganizationName();
    }
    
}
