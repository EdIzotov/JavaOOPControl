package organisation;

import java.util.Date;

interface InterfaceEmployee {
    String getEmployeeFirstName();
    void setEmployeeFirstName(String firstName) throws IllegalArgumentException;
    String getEmployeeLastName();
    void setEmployeeLastName(String lastName) throws IllegalArgumentException;
    JobTitles getEmployeePosition();
    void setEmployeePosition(JobTitles position) throws IllegalArgumentException;
    int getEmployeeSalary();
    void setEmployeeSalary(int salary) throws IllegalArgumentException;
    Date getEmployeeHireDate();
    void setEmployeeHireDate(Date hireDate) throws IllegalArgumentException;
}
