/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.EnterprisePackage;

import Business.DrugPackage.DrugDirectory;
import Business.OrganizationPackage.InventoryManagerOrganization;
import Business.OrganizationPackage.Organization;
import Business.OrganizationPackage.WarehouseManagerOrganization;
import Business.RolePackage.Role;
import java.util.ArrayList;

/**
 *
 * @author Atul
 */
public class WarehouseEnterprise extends Enterprise{
    private  InventoryManagerOrganization inventoryManagerOrganization;
    private WarehouseManagerOrganization warehouseManagerOrganization;
    private ArrayList<String> allApprovedDrugs;

    public InventoryManagerOrganization getInventoryManagerOrganization() {
        return inventoryManagerOrganization;
    }

    public void setInventoryManagerOrganization(InventoryManagerOrganization inventoryManagerOrganization) {
        this.inventoryManagerOrganization = inventoryManagerOrganization;
    }

    public WarehouseManagerOrganization getWarehouseManagerOrganization() {
        return warehouseManagerOrganization;
    }

    public void setWarehouseManagerOrganization(WarehouseManagerOrganization warehouseManagerOrganization) {
        this.warehouseManagerOrganization = warehouseManagerOrganization;
    }

    public ArrayList<String> getAllApprovedDrugs() {
        return allApprovedDrugs;
    }

    public void setAllApprovedDrugs(ArrayList<String> allApprovedDrugs) {
        this.allApprovedDrugs = allApprovedDrugs;
    }

    
    
    
    
    public WarehouseEnterprise(String name)
    {
        super(name, Enterprise.EnterpriseType.Warehouse);
         warehouseManagerOrganization = (WarehouseManagerOrganization)getOrganizationDirectory().addOrganization(Organization.Type.WarehouseManager);
        inventoryManagerOrganization = (InventoryManagerOrganization)getOrganizationDirectory().addOrganization(Organization.Type.InventoryManager);
        allApprovedDrugs = new ArrayList<>();
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
