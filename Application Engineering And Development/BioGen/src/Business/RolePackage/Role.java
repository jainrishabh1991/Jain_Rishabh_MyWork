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

/**
 *
 * @author kRISH
 */
public abstract class Role {
    
    public enum RoleType{
        Admin("SystemAdmin"),
        Doctor("Doctor"),
        FDALicenseManager("FDA Licence Manager"),
        DispenserManager("Dispenser Manager"),
        LicenseManager("LicenseManager"),
        DrugManger("Drug Manger"),
        SalesManager("Sales Manager"),
        PreClinicalTester("PreClinical Tester"),
        InventoryManager("Inventory Manager"),
        WarehouseManager("WarehouseManager");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            EcoSystem business);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
}
