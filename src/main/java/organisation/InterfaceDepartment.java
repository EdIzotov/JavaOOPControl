package organisation;

interface InterfaceDepartment {
    public int DEFAULT_DEPARTMENT_EMPLOYEES = 0;
    String getDepartmentName();
    void setDepartmentName(String departmentName);
    int getDepartmentEmployeesQty();
    int getDepartmentEmployeesSalaryAvg();
    Employee getDepartmentEmployeeByName(String firstName, String lastName);
    void fireDepartmentEmployee(String firstName, String lastName, String position);
    void hireDepartmentEmployee(Employee newEmployee);
    Employee[] getAllDepartmentEmployees();
    Employee[] getAllDepartmentEmployeesSorted();
}
