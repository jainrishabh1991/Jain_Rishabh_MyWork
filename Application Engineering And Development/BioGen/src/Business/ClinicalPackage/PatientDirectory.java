/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.ClinicalPackage;

import java.util.ArrayList;

/**
 *
 * @author Rishabh
 */
public class PatientDirectory {
    private ArrayList<Patient> patientDirectory;
    
    public PatientDirectory(){
        patientDirectory=new ArrayList<Patient>();
    }

    public ArrayList<Patient> getPatientDirectory() {
        return patientDirectory;
    }

    public void setPatientDirectory(ArrayList<Patient> patientDirectory) {
        this.patientDirectory = patientDirectory;
    }
    public Patient addPatient() {
        Patient patient = new Patient();
        patientDirectory.add(patient);
        return patient;
    }
    public void deletePatient(Patient patient){
        patientDirectory.remove(patient);
}}
