package organisation;

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
    public int getDepartmentEmployeesQty() {
        return departmentEmployees.length;
    }
    public int getDepartmentEmployeesSalaryAvg() {
        int salary = 0;
        for (Employee employee: departmentEmployees) {
            salary += employee.getEmployeeSalary();
        }
        return salary;
    }
    public Employee getDepartmentEmployeeByName(String firstName, String lastName) {
        for (Employee employee: departmentEmployees) {
            if ((employee.getEmployeeLastName().equals(lastName)) && (employee.getEmployeeFirstName().equals(firstName))) {
                return employee;
            }
        }
        return null;
    }
    public void fireDepartmentEmployee(String firstName, String lastName, String position) {
        for (int i = 0; i < departmentEmployees.length; i++) {
            if ((departmentEmployees[i].getEmployeeLastName().equals(lastName)) && (departmentEmployees[i].getEmployeeFirstName().equals(firstName)) && (departmentEmployees[i].getEmployeePosition().equals(position))) {
                departmentEmployees[i] = null;
                Employee[] tempDepartmentEmployees = new Employee[departmentEmployees.length - 1];
                for (int j = 0; j < departmentEmployees.length; j++) {
                    if (departmentEmployees[j] != null) {

                    }
                }                
            }
        }
    }
    public void hireDepartmentEmployee(Employee newEmployee) {
        Employee[] tempDepartmentEmployees = new Employee[departmentEmployees.length + 1];
    }
    public Employee[] getAllDepartmentEmployees() {
        return departmentEmployees;
    }
    public Employee[] getAllDepartmentEmployeesSorted() {
        return departmentEmployees;
    }
}
