package organisation;

interface InterfaceEmployee {
    public static JobTitles DEFAULT_POSITION = JobTitles.Engineer;
    public static int DEFAULT_SALARY = 30000;
    String getEmployeeFirstName();
    void setEmployeeFirstName(String firstName);
    String getEmployeeLastName();
    void setEmployeeLastName(String lastName);
    JobTitles getEmployeePosition();
    void setEmployeePosition(JobTitles position);
    int getEmployeeSalary();
    void setEmployeeSalary(int salary);
}
