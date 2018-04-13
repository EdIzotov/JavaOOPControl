package organisation;

interface InterfaceEmployee {
    public static String DEFAULT_POSITION = "Engineer";
    public static int DEFAULT_SALARY = 30000;
    String getEmployeeFirstName();
    void setEmployeeFirstName(String firstName);
    String getEmployeeLastName();
    void setEmployeeLastName(String lastName);
    String getEmployeePosition();
    void setEmployeePosition(String position);
    int getEmployeeSalary();
    void setEmployeeSalary(int salary);
}
