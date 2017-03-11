/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.EmployeePackage.Employee;
import Business.RolePackage.SystemAdminRole;
import Business.UserAccountPackage.UserAccount;

/**
 *
 * @author Atul
 */
public class ConfigureEcoSystem {
     public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        Employee employee = system.getEmployeeDirectory().createEmployee("RRH","Atul");
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("s", "s", employee, new SystemAdminRole());
        return system;
    }
}
