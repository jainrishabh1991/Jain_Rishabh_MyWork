/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.OrderPackage;

import Business.*;
import Business.DrugPackage.Drug;

/**
 *
 * @author Atul
 */
public class OrderItem {
    private String drugName;
    private int quantity;

    public OrderItem() {
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }


    



    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return drugName;
    }
    
}
