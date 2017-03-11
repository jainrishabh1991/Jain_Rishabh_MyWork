/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.EmployeePackage;

import java.util.ArrayList;

/**
 *
 * @author Atul
 */
public class EmployeeDirectory {
    private ArrayList<Employee> employeeDirectory;

    public EmployeeDirectory() {
        employeeDirectory =new ArrayList<>();
    }

    
    
    public ArrayList<Employee> getEmployeeDirectory() {
        return employeeDirectory;
    }

    public void setEmployeeDirectory(ArrayList<Employee> employeeDirectory) {
        this.employeeDirectory = employeeDirectory;
    }
    
    public Employee createEmployee(String firstname, String lastName)
    {
        Employee employee = new Employee();
        employee.setFirstName(firstname);
        employee.setLastName(lastName);
        employeeDirectory.add(employee);
        return employee;
    }
    
}
