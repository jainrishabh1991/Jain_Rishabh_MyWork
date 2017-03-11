/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.OrganizationPackage;

import Business.RolePackage.Role;
import Business.RolePackage.SystemAdminRole;
import Business.RolePackage.WarehouseManagerRole;
import java.util.ArrayList;

/**
 *
 * @author Rishabh
 */
public class WarehouseManagerOrganization extends Organization{
public WarehouseManagerOrganization() {
        super(Type.WarehouseManager.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new WarehouseManagerRole());
        return roles;
    }
}
