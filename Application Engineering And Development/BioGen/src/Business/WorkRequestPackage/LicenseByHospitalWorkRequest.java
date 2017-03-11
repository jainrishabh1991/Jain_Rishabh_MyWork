/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkRequestPackage;

import Business.EnterprisePackage.HospitalEnterprise;

/**
 *
 * @author Atul
 */
public class LicenseByHospitalWorkRequest extends WorkRequest{
    
    private HospitalEnterprise hospitalEnterprise;

    public LicenseByHospitalWorkRequest(){}

    public HospitalEnterprise getHospitalEnterprise() {
        return hospitalEnterprise;
    }

    public void setHospitalEnterprise(HospitalEnterprise hospitalEnterprise) {
        this.hospitalEnterprise = hospitalEnterprise;
    }

    @Override
    public String toString() {
        return hospitalEnterprise.getOrganizationName();
    }
    
}
