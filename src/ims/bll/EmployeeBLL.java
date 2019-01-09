/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.bll;

import ims.dal.EmployeeDAL;
import ims.model.Employee;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANHB
 */
public class EmployeeBLL {
    private EmployeeDAL employeeDAL;

    public EmployeeBLL() {
        employeeDAL = new EmployeeDAL(Employee.class);
    }
    
    public void save(Employee e){
        try {
            employeeDAL.save(e);
        } catch (Exception ex) {
            Logger.getLogger(EmployeeBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Employee> getAll() throws Exception{
        System.out.println("@@@@@@@@@@@@@@@@@@@@ EmployeeBLL: List<Employee> getAll(");
        return employeeDAL.getAll();
    }
}
