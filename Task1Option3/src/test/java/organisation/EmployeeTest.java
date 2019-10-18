package organisation;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class EmployeeTest {
    private String firstName = "Vasiliy";
    private String lastName = "Ivanov";
    private String position = "Manager";
    private int salary = 45000;
    private String firstName1 = "Ivan";
    private String lastName1 = "Petrov";
    private String position1 = "Driver";
    private int salary1 = 28000;

    private String defaultPosition = InterfaceEmployee.DEFAULT_POSITION;
    private int defaultSalary = InterfaceEmployee.DEFAULT_SALARY;

    @Test
    public void testFake() {
        assertEquals(1, 2);
    }
    @Test
    public void testConstructorDefault() {
        Employee myEmployee = new Employee(firstName, lastName);
        assertEquals(firstName, myEmployee.getEmployeeFirstName());
        assertEquals(lastName, myEmployee.getEmployeeLastName());
        assertEquals(defaultPosition, myEmployee.getEmployeePosition());
        assertEquals(defaultSalary, myEmployee.getEmployeeSalary());
    }
    @Test
    public void testConstructorExtended() {
        Employee myEmployee = new Employee(firstName, lastName, position, salary);
        assertEquals(firstName, myEmployee.getEmployeeFirstName());
        assertEquals(lastName, myEmployee.getEmployeeLastName());
        assertEquals(position, myEmployee.getEmployeePosition());
        assertEquals(salary, myEmployee.getEmployeeSalary());
    }
    @Test
    public void testSetEmployeeFirstName() {
        Employee myEmployee = new Employee(firstName, lastName, position, salary);
        assertNotEquals(firstName, firstName1);
        myEmployee.setEmployeeFirstName(firstName1);
        assertEquals(firstName1, myEmployee.getEmployeeFirstName());
    }
    @Test
    public void testSetEmployeeLastName() {
        Employee myEmployee = new Employee(firstName, lastName, position, salary);
        assertNotEquals(lastName, lastName1);
        myEmployee.setEmployeeLastName(lastName1);
        assertEquals(lastName1, myEmployee.getEmployeeLastName());
    }
    @Test
    public void testSetEmployeePosition() {
        Employee myEmployee = new Employee(firstName, lastName, position, salary);
        assertNotEquals(position, position1);
        myEmployee.setEmployeePosition(position1);
        assertEquals(position1, myEmployee.getEmployeePosition());
    }
    @Test
    public void testSetEmployeeSalary() {
        Employee myEmployee = new Employee(firstName, lastName, position, salary);
        assertNotEquals(salary, salary1);
        myEmployee.setEmployeeSalary(salary1);
        assertEquals(salary1, myEmployee.getEmployeeSalary());
    }
}
