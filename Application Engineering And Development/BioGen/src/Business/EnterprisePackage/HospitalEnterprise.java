/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.EnterprisePackage;

import Business.DrugPackage.DrugDirectory;
import Business.OrganizationPackage.DispenserManagerOrganization;
import Business.OrganizationPackage.DoctorOrganization;
import Business.OrganizationPackage.Organization;
import Business.OrganizationPackage.PreClinicalTesterOrgnization;
import Business.RolePackage.Role;
import java.util.ArrayList;

/**
 *
 * @author Atul
 */
public class HospitalEnterprise extends Enterprise{
    
    private DoctorOrganization doctorOrganization;
    private DispenserManagerOrganization dispenserManagerOrganization;
    private ArrayList<String> allApprovedDrugs;

    public ArrayList<String> getAllApprovedDrugs() {
        return allApprovedDrugs;
    }

    public void setAllApprovedDrugs(ArrayList<String> allApprovedDrugs) {
        this.allApprovedDrugs = allApprovedDrugs;
    }


    
    
    public HospitalEnterprise(String name)
    {
        super(name, Enterprise.EnterpriseType.Hospital);
        doctorOrganization = (DoctorOrganization)getOrganizationDirectory().addOrganization(Organization.Type.Doctor);
        dispenserManagerOrganization=(DispenserManagerOrganization)getOrganizationDirectory().addOrganization(Organization.Type.DispenserManager);
        allApprovedDrugs= new ArrayList<String>();
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public DoctorOrganization getDoctorOrganization() {
        return doctorOrganization;
    }

    public void setDoctorOrganization(DoctorOrganization doctorOrganization) {
        this.doctorOrganization = doctorOrganization;
    }

    public DispenserManagerOrganization getDispenserManagerOrganization() {
        return dispenserManagerOrganization;
    }

    public void setDispenserManagerOrganization(DispenserManagerOrganization dispenserManagerOrganization) {
        this.dispenserManagerOrganization = dispenserManagerOrganization;
    }

    
    
    
    
}
