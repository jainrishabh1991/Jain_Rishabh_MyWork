/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.OrganizationPackage;

import Business.ClinicalPackage.PatientDirectory;
import Business.ClinicalPackage.TreatmentHistory;
import Business.RolePackage.DoctorRole;
import Business.RolePackage.Role;
import Business.RolePackage.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author Rishabh
 */
public class DoctorOrganization extends Organization{
    private TreatmentHistory treatmentHistory;
    private PatientDirectory patientDirectory;
    
     public DoctorOrganization() {
         super(Type.Doctor.getValue());
         treatmentHistory= new TreatmentHistory();
         patientDirectory = new PatientDirectory();
         
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new DoctorRole());
        return roles;
    }

    public TreatmentHistory getTreatmentHistory() {
        return treatmentHistory;
    }

    public void setTreatmentHistory(TreatmentHistory treatmentHistory) {
        this.treatmentHistory = treatmentHistory;
    }

    public PatientDirectory getPatientDirectory() {
        return patientDirectory;
    }

    public void setPatientDirectory(PatientDirectory patientDirectory) {
        this.patientDirectory = patientDirectory;
    }
    
    
}
