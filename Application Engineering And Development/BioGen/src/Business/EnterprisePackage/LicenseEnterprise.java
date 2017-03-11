/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.EnterprisePackage;

import Business.OrganizationPackage.LicenseManagerOrganization;
import Business.OrganizationPackage.Organization;
import Business.RolePackage.Role;
import java.util.ArrayList;

/**
 *
 * @author Atul
 */
public class LicenseEnterprise extends Enterprise{
    private LicenseManagerOrganization licenseManagerOrganization;

    
    
    public LicenseManagerOrganization getLicenseManagerOrganization() {
        return licenseManagerOrganization;
    }

    public void setLicenseManagerOrganization(LicenseManagerOrganization licenseManagerOrganization) {
        this.licenseManagerOrganization = licenseManagerOrganization;
    }
    
    
public LicenseEnterprise(String name)
    {
        super(name, Enterprise.EnterpriseType.License);
        licenseManagerOrganization = (LicenseManagerOrganization)getOrganizationDirectory().addOrganization(Organization.Type.LicenseManager);
    
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
