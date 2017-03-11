/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.RolePackage;

import Business.EcoSystem;
import javax.swing.JPanel;
import Business.UserAccountPackage.*;
import Business.OrganizationPackage.*;
import Business.EnterprisePackage.*;
import UserInterface.SystemAdmin.SystemAdminWorkAreaJPanel;

/**
 *
 * @author kRISH
 */
public class SystemAdminRole extends Role{
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system) {
        return new SystemAdminWorkAreaJPanel(userProcessContainer, system);
    }
    
}
