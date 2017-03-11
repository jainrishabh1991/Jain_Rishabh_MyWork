/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.EnterprisePackage;

import Business.OrganizationPackage.FDAOrganization;
import Business.OrganizationPackage.Organization;
import Business.RolePackage.Role;
import java.util.ArrayList;

/**
 *
 * @author Atul
 */
public class FDAEnterprise extends Enterprise{
    
    private FDAOrganization fdaOrganization;
    
    public FDAEnterprise(String name)
    {
        super(name, EnterpriseType.FDA);
        fdaOrganization = (FDAOrganization)getOrganizationDirectory().addOrganization(Organization.Type.FDAManager);
        
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public FDAOrganization getFdaOrganization() {
        return fdaOrganization;
    }

    public void setFdaOrganization(FDAOrganization fdaOrganization) {
        this.fdaOrganization = fdaOrganization;
    }
    
    
}
