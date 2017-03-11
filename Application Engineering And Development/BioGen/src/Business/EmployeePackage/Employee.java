/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.EmployeePackage;


/**
 *
 * @author Atul
 */
public class Employee {
    private String employeeID;
    private String firstName;
    private String lastName;
    private static int counter = 000;

    public Employee() {
        ++counter;
        employeeID = "E" + counter;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



   

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Employee.counter = counter;
    }
    
    
}
