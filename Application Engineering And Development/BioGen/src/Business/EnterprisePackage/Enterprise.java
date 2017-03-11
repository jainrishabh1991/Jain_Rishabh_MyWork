/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.EnterprisePackage;

import Business.DrugPackage.DrugDirectory;
import Business.OrganizationPackage.*;

/**
 *
 * @author Atul
 */
public abstract class Enterprise extends Organization{
    
    private  EnterpriseType enterpriseType; 
    private  OrganizationDirectory organizationDirectory ;
    private String licence;
    private DrugDirectory drugDirectory;
    public static final String LicApproved = "Licence Approved";
    public static final String LicNotIssued = "Licence Not Issued";
    public static final String LicUnderProcess = "Licence Under Process";
    public Enterprise(String name, EnterpriseType type )
    {
        super(name);
        licence = Enterprise.LicNotIssued;
        this.enterpriseType = type;
        organizationDirectory = new OrganizationDirectory();
        drugDirectory = new DrugDirectory();
        licence = Enterprise.LicNotIssued;
        if(type.equals(Enterprise.EnterpriseType.FDA)||type.equals(Enterprise.EnterpriseType.License))
        {
            licence = Enterprise.LicApproved;
        }
        
        
    }
    
        public enum EnterpriseType{
        Hospital("Hospital"),
        FDA("FDA"),
        Manufacturer("Manufacturer"),
        License("License"),
        Warehouse("Warehouse");
        private String value;

        private EnterpriseType(String value)
        {
            this.value= value;
        }
        
        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
        
        @Override
        public String toString()
        {
            return value;
        }
    }
    
    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(EnterpriseType enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public void setOrganizationDirectory(OrganizationDirectory organizationDirectory) {
        this.organizationDirectory = organizationDirectory;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public DrugDirectory getDrugDirectory() {
        return drugDirectory;
    }

    public void setDrugDirectory(DrugDirectory drugDirectory) {
        this.drugDirectory = drugDirectory;
    }
    
}
