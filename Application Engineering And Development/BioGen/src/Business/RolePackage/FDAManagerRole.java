/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.RolePackage;

import Business.EcoSystem;
import Business.EnterprisePackage.Enterprise;
import Business.OrganizationPackage.Organization;
import Business.UserAccountPackage.UserAccount;
import UserInterface.FDA.FDAManagerJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Atul
 */
public class FDAManagerRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
       return new FDAManagerJPanel(userProcessContainer, enterprise, account);//To change body of generated methods, choose Tools | Templates.
    }
    
}
