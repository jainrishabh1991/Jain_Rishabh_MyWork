/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.ClinicalPackage;

/**
 *
 * @author Rishabh
 */
public class Doctor {
    private int doctorId;
    private String Name;
    private TreatmentHistory treatmentHistory;
    private PatientDirectory patientDirectory;
    private static int count=0;
    
    public Doctor(){
        count++;
        this.doctorId=count;
    }

    public PatientDirectory getPatientDirectory() {
        return patientDirectory;
    }

    public void setPatientDirectory(PatientDirectory patientDirectory) {
        this.patientDirectory = patientDirectory;
    }

    
    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public TreatmentHistory getTreatmentHistory() {
        return treatmentHistory;
    }

    public void setTreatmentHistory(TreatmentHistory treatmentHistory) {
        this.treatmentHistory = treatmentHistory;
    }
    
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

}
