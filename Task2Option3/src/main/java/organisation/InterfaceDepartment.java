package organisation;

import java.util.ArrayList;

interface InterfaceDepartment {
    public static int DEFAULT_DEPARTMENT_EMPLOYEES = 0;
    String getDepartmentName();
    void setDepartmentName(String departmentName);
    int getDepartmentEmployeesQty();
    int getDepartmentEmployeesSalaryAvg();
    Employee getDepartmentEmployeeByName(String firstName, String lastName);
    void fireDepartmentEmployee(String lastName, String firstName, JobTitles position);
    void hireDepartmentEmployee(Employee newEmployee);
    Employee[] getAllDepartmentEmployees();
    Employee[] getAllDepartmentEmployeesSortedBySalaryAsc();
    Employee[] getAllDepartmentEmployeesSortedBySalaryDes();
    Employee[] getAllDepartmentEmployeesSortedByNameAsc();
    Employee[] getAllDepartmentEmployeesSortedByNameDes();
    ArrayList<FullDayEmployee> getFullDayEmployees();
    ArrayList<HalfDayEmployee> getHalfDayEmployees();
    ArrayList<InterfaceFullDayEmployee> getTravellingEmployeesNow();
    ArrayList<InterfaceFullDayEmployee> getTravellingEmployeesByDate();
}
