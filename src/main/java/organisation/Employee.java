package organisation;

import java.util.Comparator;

public class Employee implements InterfaceEmployee, Comparable<Employee> {

    private String firstName;
    private String lastName;
    private String position;
    private int salary;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = InterfaceEmployee.DEFAULT_POSITION;
        this.salary = InterfaceEmployee.DEFAULT_SALARY;
    }
    public Employee(String firstName, String lastName, String position, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.salary = salary;
    }
    
    public String getEmployeeFirstName() {
        return firstName;
    }
    public void setEmployeeFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getEmployeeLastName() {
        return lastName;
    }
    public void setEmployeeLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmployeePosition() {
        return position;
    }
    public void setEmployeePosition(String position) {
        this.position = position;
    }
    public int getEmployeeSalary() {
        return salary;
    }
    public void setEmployeeSalary(int salary) {
        this.salary = salary;
    }
    public int compareTo(Employee compareEmployee) {
        int compareSalary = compareEmployee.getEmployeeSalary();
        return this.salary - compareSalary;
    }
    public static Comparator<Employee> nameComparator = new Comparator<Employee>() {
        public int compare(Employee emp1, Employee emp2) {
            String empLastName1 = emp1.getEmployeeLastName();
            String empLastName2 = emp2.getEmployeeLastName();
            return empLastName1.compareTo(empLastName2);
        }
    };
}
