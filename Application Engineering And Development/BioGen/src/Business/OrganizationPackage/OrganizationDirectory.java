/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.OrganizationPackage;
import Business.OrganizationPackage.Organization;
import Business.OrganizationPackage.Organization.Type;

import java.util.ArrayList;

/**
 *
 * @author Rishabh
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<Organization>();
    }

    
    
    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(ArrayList<Organization> organizationList) {
        this.organizationList = organizationList;
    }
    
    public Organization addOrganization(Type type){
    
        Organization org = null;
       
        if(type == Organization.Type.DispenserManager)
            org = new DispenserManagerOrganization();
        else if(type == Organization.Type.Admin)
            org = new AdminOrganization();
        else if(type == Organization.Type.Doctor)
            org = new DoctorOrganization();
        else if(type == Organization.Type.DrugManager)
            org = new DrugManagerOrganization();
        else if(type == Organization.Type.FDAManager)
            org = new FDAOrganization();
        else if(type == Organization.Type.InventoryManager)
            org = new InventoryManagerOrganization();
        else if(type == Organization.Type.LicenseManager)
            org = new LicenseManagerOrganization();
        else if(type == Organization.Type.PreClinicalTester)
            org = new PreClinicalTesterOrgnization();
        else if(type == Organization.Type.SalesManager)
            org = new SalesManagerOrganization();
        else if(type == Organization.Type.WarehouseManager)
            org = new WarehouseManagerOrganization();
        
        
        return org;
    }
    
}
