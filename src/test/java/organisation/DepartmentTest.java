package organisation;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class DepartmentTest {
    private String firstName = "Vasiliy";
    private String lastName = "Ivanov";
    private String position = "Manager";
    private int salary = 45000;
    private String firstName1 = "Ivan";
    private String lastName1 = "Petrov";
    private String position1 = "Driver";
    private int salary1 = 28000;
    private String firstName2 = "Ivan";
    private String lastName2 = "Petrov";
    private String firstName3 = "Ivan";
    private String lastName3 = "Petrov";

    private String defaultPosition = InterfaceEmployee.DEFAULT_POSITION;
    private int defaultSalary = InterfaceEmployee.DEFAULT_SALARY;

    private Employee myEmployee = new Employee(firstName, lastName, position, salary);
    private Employee myEmployee1 = new Employee(firstName1, lastName1, position1, salary1);
    private Employee myEmployee2 = new Employee(firstName2, lastName2);
    private Employee myEmployee3 = new Employee(firstName3, lastName3);

    private String departmentName = "Sales";
    private String departmentName1 = "Accountants";
    private String departmentName2 = "Management";
    private String departmentName3 = "IT Department";

    private int defaultDepartmentSize = InterfaceDepartment.DEFAULT_DEPARTMENT_EMPLOYEES;

    @Test
    public void testConstructorDefault() {
        Department myDepartment = new Department(departmentName);
        assertEquals(departmentName, myDepartment.getDepartmentName());
        assertEquals(defaultDepartmentSize, myDepartment.getDepartmentEmployeesQty());
    }
    @Test
    public void testConstructorExtended() {
        Employee[] employeeArr = {new Employee(firstName, lastName, position, salary)};
        Department myDepartment = new Department(departmentName, employeeArr);
        assertEquals(departmentName, myDepartment.getDepartmentName());
        assertEquals(employeeArr.length, myDepartment.getDepartmentEmployeesQty());

    }
}
