/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.OrganizationPackage;

import Business.EmployeePackage.EmployeeDirectory;
import Business.RolePackage.Role;
import Business.UserAccountPackage.UserAccountDirectory;
import Business.WorkRequestPackage.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author Rishabh
 */
public abstract class Organization {
    private String organizationName;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private WorkQueue workQueue;

    public Organization(String organizationName) {
        this.organizationName = organizationName;
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        workQueue = new WorkQueue();
    }

    public enum Type{
        Admin("Admin Orgnization"), 
        DrugManager("Drug Manager Organization"), 
        SalesManager("Sales Manager Organization"),
        PreClinicalTester("PreClinical Tester Organization"),
        InventoryManager("Inventory Manager Organization"),
        WarehouseManager("Warehouse Manager Organization"),
        Doctor("Doctor Organization"),
        DispenserManager("Dispense Manager Organization"),
        LicenseManager("License Manager Organization"),
        FDAManager("FDA Manager Organization");
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
        
        @Override
        public String toString()
        {
            return value;
        }
    }
    
    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public void setEmployeeDirectory(EmployeeDirectory employeeDirectory) {
        this.employeeDirectory = employeeDirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }

    public abstract ArrayList<Role> getSupportedRole();

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }
    
    @Override
    public String toString() {
        return organizationName;
    }


    
    
}
