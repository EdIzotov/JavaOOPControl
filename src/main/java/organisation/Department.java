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


}
