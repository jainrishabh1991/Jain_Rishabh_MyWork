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
import UserInterface.Hospital.DoctorJPanel;
import UserInterface.Warehouse.WarehouseAdminJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Atul
 */
public class DoctorRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
          return new DoctorJPanel(userProcessContainer, enterprise, account, business);
    }
    
}
