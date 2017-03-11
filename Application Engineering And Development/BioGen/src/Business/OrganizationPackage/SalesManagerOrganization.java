/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.OrganizationPackage;

import Business.RolePackage.Role;
import Business.RolePackage.SalesManagerRole;
import Business.RolePackage.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author Rishabh
 */
public class SalesManagerOrganization extends Organization{
    public SalesManagerOrganization() {
        super(Type.SalesManager.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new SalesManagerRole());
        return roles;
    }
}
