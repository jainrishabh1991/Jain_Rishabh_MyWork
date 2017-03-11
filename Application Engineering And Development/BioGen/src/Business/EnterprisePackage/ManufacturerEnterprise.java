/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.EnterprisePackage;

import Business.DrugPackage.DrugDirectory;
import Business.OrganizationPackage.DrugManagerOrganization;
import Business.OrganizationPackage.FDAOrganization;
import Business.OrganizationPackage.Organization;
import Business.OrganizationPackage.PreClinicalTesterOrgnization;
import Business.OrganizationPackage.SalesManagerOrganization;
import Business.RolePackage.Role;
import java.util.ArrayList;

/**
 *
 * @author Atul
 */
public class ManufacturerEnterprise extends Enterprise{
    private DrugManagerOrganization drugManagerOrganization;
    private SalesManagerOrganization salesManagerOrganization;
    private PreClinicalTesterOrgnization preClinicalOrganization;
    private DrugDirectory unApprovedDrugDirectory;
    
    public ManufacturerEnterprise(String name)
    {
        super(name, Enterprise.EnterpriseType.Manufacturer);
        drugManagerOrganization = (DrugManagerOrganization)getOrganizationDirectory().addOrganization(Organization.Type.DrugManager);
        salesManagerOrganization = (SalesManagerOrganization)getOrganizationDirectory().addOrganization(Organization.Type.SalesManager);
        preClinicalOrganization = (PreClinicalTesterOrgnization)getOrganizationDirectory().addOrganization(Organization.Type.PreClinicalTester);
        unApprovedDrugDirectory = new DrugDirectory();
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public DrugDirectory getUnApprovedDrugDirectory() {
        return unApprovedDrugDirectory;
    }

    public void setUnApprovedDrugDirectory(DrugDirectory unApprovedDrugDirectory) {
        this.unApprovedDrugDirectory = unApprovedDrugDirectory;
    }
    
    

    public DrugManagerOrganization getDrugManagerOrganization() {
        return drugManagerOrganization;
    }

    public void setDrugManagerOrganization(DrugManagerOrganization drugManagerOrganization) {
        this.drugManagerOrganization = drugManagerOrganization;
    }

    public SalesManagerOrganization getSalesManagerOrganization() {
        return salesManagerOrganization;
    }

    public void setSalesManagerOrganization(SalesManagerOrganization salesManagerOrganization) {
        this.salesManagerOrganization = salesManagerOrganization;
    }

    public PreClinicalTesterOrgnization getPreClinicalTesterOrgnization() {
        return preClinicalOrganization;
    }

    public void setClinicalTesterOrgnization(PreClinicalTesterOrgnization preClinicalOrganization) {
        this.preClinicalOrganization = preClinicalOrganization;
    }
    
    
}
