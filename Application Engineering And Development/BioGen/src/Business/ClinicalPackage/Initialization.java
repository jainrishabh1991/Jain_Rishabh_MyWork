/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.ClinicalPackage;

import Business.ClinicalPackage.Doctor;
import Business.ClinicalPackage.DiseaseDirectory;
import Business.DrugPackage.*;
import Business.ClinicalPackage.Patient;
import Business.ClinicalPackage.PatientDirectory;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Rishabh
 */
public class Initialization {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
    public static PatientDirectory initializePatientDirectory(DiseaseDirectory diseaseDirectory) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        PatientDirectory patientDirectory=new PatientDirectory();
        Patient patient=patientDirectory.addPatient();
        patient.setName("Rishabh");
        patient.setGender(true);
        patient.setHeight(5.9);
        patient.setWeight(87.5);
        patient.setDisease(diseaseDirectory.getDiseaseDirectory().get(0));
        patient.setDateOfBirth("01/01/1947");
        patient.setInfectedDate("01/01/1950");
        
        patient=patientDirectory.addPatient();
        patient.setName("Atul");
        patient.setGender(true);
        patient.setHeight(5.9);
        patient.setWeight(87.5);
        patient.setDisease(diseaseDirectory.getDiseaseDirectory().get(1));
        patient.setDateOfBirth("01/01/1947");
        patient.setInfectedDate("01/01/1950");
        
        patient=patientDirectory.addPatient();
        patient.setName("Krishna");
        patient.setGender(true);
        patient.setHeight(5.9);
        patient.setWeight(87.5);
        patient.setDisease(diseaseDirectory.getDiseaseDirectory().get(2));
        patient.setDateOfBirth("01/01/1947");
        patient.setInfectedDate("01/01/1950");
        
        patient=patientDirectory.addPatient();
        patient.setName("Keval");
        patient.setGender(true);
        patient.setHeight(5.9);
        patient.setWeight(87.5);
        patient.setDisease(diseaseDirectory.getDiseaseDirectory().get(3));
        patient.setDateOfBirth("01/01/1947");
        patient.setInfectedDate("01/01/1950");
        
        return patientDirectory;
    }
    
    public static DiseaseDirectory initializeDiseaseDirectory()
    {
        DiseaseDirectory diseaseDirectory=new DiseaseDirectory();
        Disease disease=diseaseDirectory.addDisease();
        disease.setName("HIV/Aids");
        disease.setSeverity(9);
        disease.setSymptoms("Extreme Tiredness, Memory Loss, etc.");
        
        disease=diseaseDirectory.addDisease();
        disease.setName("Ebola");
        disease.setSeverity(7);
        disease.setSymptoms("Unexplained Hamorrhage, Diarrhea, etc");
        
        disease=diseaseDirectory.addDisease();
        disease.setName("Cancer");
        disease.setSeverity(8);
        disease.setSymptoms("Bleeding, Unsual Coughing etc");
        
        disease=diseaseDirectory.addDisease();
        disease.setName("Allergies");
        disease.setSeverity(5);
        disease.setSymptoms("Dangerous Immune System, etc");
        
        disease=diseaseDirectory.addDisease();
        disease.setName("Asthama");
        disease.setSeverity(7);
        disease.setSymptoms("Unusual Coughing and Breathing, etc");
        
        disease=diseaseDirectory.addDisease();
        disease.setName("Diabetes");
        disease.setSeverity(7);
        disease.setSymptoms("Urinating Alot, Thirsty, etc");
        
        disease=diseaseDirectory.addDisease();
        disease.setName("Influenza");
        disease.setSeverity(6);
        disease.setSymptoms("Dehydration, Fatigue, etc");
           
        return diseaseDirectory;
    }
    public static DrugDirectory initializeDrugDirectory(){
        DrugDirectory drugDirectory=new DrugDirectory();
        Drug drug=drugDirectory.newDrug();
        drug.setDrugName("A");
        
        drug=drugDirectory.newDrug();
        drug.setDrugName("B");
        
        drug=drugDirectory.newDrug();
        drug.setDrugName("C");
        
        drug=drugDirectory.newDrug();
        drug.setDrugName("D");
        
        drug=drugDirectory.newDrug();
        drug.setDrugName("E");
       
        return drugDirectory;
    }
}
