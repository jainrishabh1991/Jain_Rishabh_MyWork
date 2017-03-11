/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.DrugPackage;

import Business.*;
import java.util.Date;

/**
 *
 * @author Atul
 */
public class Drug {
    private int drugId;
    private String drugName;
    private int noOfUnits;
    private String expiryDate;
    private boolean isApprovedByFDA;
    private boolean isApprovedByPreClinical;
    private boolean isApprovedByHospital;
    private boolean isWorkdonebyFDA;
    private String manufacturerName;
    private int unitPrice;
    private static int counter = 000;
    public Drug() {
        ++counter;
        this.drugId = counter;
    }

    public boolean isIsWorkdonebyFDA() {
        return isWorkdonebyFDA;
    }

    public void setIsWorkdonebyFDA(boolean isWorkdonebyFDA) {
        this.isWorkdonebyFDA = isWorkdonebyFDA;
    }
    
    
    public int getDrugId() {
        return drugId;
    }

    public void setDrugId(int drugId) {
        this.drugId = drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public int getNoOfUnits() {
        return noOfUnits;
    }

    public void setNoOfUnits(int noOfUnits) {
        this.noOfUnits = noOfUnits;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isIsApprovedByFDA() {
        return isApprovedByFDA;
    }

    public void setIsApprovedByFDA(boolean isApproved) {
        this.isApprovedByFDA = isApproved;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Drug.counter = counter;
    }
    
    @Override
    public String toString()
    {
        return drugName;
    }

    public boolean isIsApprovedByPreClinical() {
        return isApprovedByPreClinical;
    }

    public void setIsApprovedByPreClinical(boolean isApprovedByPreClinical) {
        this.isApprovedByPreClinical = isApprovedByPreClinical;
    }

    public boolean isIsApprovedByHospital() {
        return isApprovedByHospital;
    }

    public void setIsApprovedByHospital(boolean isApprovedByHospital) {
        this.isApprovedByHospital = isApprovedByHospital;
    }
    
    
}
