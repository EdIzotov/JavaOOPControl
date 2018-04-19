package organisation;

import java.util.ArrayList;
import java.util.Arrays;

public class Department implements InterfaceDepartment {
    
    private String departmentName;
    private Employee[] departmentEmployees;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        departmentEmployees = new Employee[InterfaceDepartment.DEFAULT_DEPARTMENT_EMPLOYEES];
    }
    public Department(String departmentName, Employee[] departmentEmployees) {
        this.departmentName = departmentName;
        this.departmentEmployees = departmentEmployees;
    }
    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public void hireDepartmentEmployee(Employee newEmployee) {
        Employee[] tempDepartmentEmployees = new Employee[departmentEmployees.length + 1];
        for (int i = 0; i < departmentEmployees.length; i++) {
            tempDepartmentEmployees[i] = departmentEmployees[i];
        }
        tempDepartmentEmployees[tempDepartmentEmployees.length - 1] = newEmployee;
        departmentEmployees = tempDepartmentEmployees;
    }
    public void fireDepartmentEmployee(String lastName, String firstName, JobTitles position) {
        Employee[] tempDepartmentEmployees;
        try {
            tempDepartmentEmployees = new Employee[departmentEmployees.length - 1];
        } catch (NegativeArraySizeException e) {
            tempDepartmentEmployees = new Employee[departmentEmployees.length];
        }
        for (int i = 0; i < departmentEmployees.length; i++) {
            if (departmentEmployees[i].getEmployeeLastName().equals(lastName) &&
            departmentEmployees[i].getEmployeeFirstName().equals(firstName) && 
            departmentEmployees[i].getEmployeePosition().equals(position)) {
                departmentEmployees[i] = null;
                break;
            }
        }
        int iteratee = 0;
        for (int i = 0; i < departmentEmployees.length; i++) {
            if (departmentEmployees[i] != null) {
                tempDepartmentEmployees[iteratee] = departmentEmployees[i];
                iteratee++;
            }
        }
        departmentEmployees = tempDepartmentEmployees;
    }
    public int getDepartmentEmployeesQty() {
        return departmentEmployees.length;
    }
    public int getDepartmentEmployeesSalaryAvg() {
        int salary = 0;
        for (Employee employee: departmentEmployees) {
            salary += employee.getEmployeeSalary();
        }
        try {
            return salary / departmentEmployees.length;
        } catch (ArithmeticException e) {
            return 0;
        }
    }
    public Employee getDepartmentEmployeeByName(String firstName, String lastName) {
        for (Employee employee: departmentEmployees) {
            if ((employee.getEmployeeLastName().equals(lastName)) && (employee.getEmployeeFirstName().equals(firstName))) {
                return employee;
            }
        }
        return null;
    }
    public Employee[] getAllDepartmentEmployees() {
        return departmentEmployees;
    }
    public Employee[] getAllDepartmentEmployeesSortedBySalaryAsc() {
        Employee[] tempDepartmentEmployees = departmentEmployees.clone();
        Arrays.sort(tempDepartmentEmployees, Employee.salaryComparatorAscending);
        return tempDepartmentEmployees;
    }
    public Employee[] getAllDepartmentEmployeesSortedBySalaryDes() {
        Employee[] tempDepartmentEmployees = departmentEmployees.clone();
        Arrays.sort(tempDepartmentEmployees, Employee.salaryComparatorDescending);
        return tempDepartmentEmployees;
    }
    public Employee[] getAllDepartmentEmployeesSortedByNameAsc() {
        Employee[] tempDepartmentEmployees = departmentEmployees.clone();
        Arrays.sort(tempDepartmentEmployees, Employee.nameComparatorAscending);
        return tempDepartmentEmployees;
    }
    public Employee[] getAllDepartmentEmployeesSortedByNameDes() {
        Employee[] tempDepartmentEmployees = departmentEmployees.clone();
        Arrays.sort(tempDepartmentEmployees, Employee.nameComparatorDescending);
        return tempDepartmentEmployees;
    }
    public ArrayList<FullDayEmployee> getFullDayEmployees() {
        return null;
    }
    public ArrayList<HalfDayEmployee> getHalfDayEmployees() {
        return null;
    }
    public ArrayList<InterfaceFullDayEmployee> getTravellingEmployeesNow() {
        return null;
    }
    public ArrayList<InterfaceFullDayEmployee> getTravellingEmployeesByDate() {
        return null;
    }
}
