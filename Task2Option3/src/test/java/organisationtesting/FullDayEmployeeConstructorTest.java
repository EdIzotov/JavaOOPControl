package organisationtesting;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.util.Calendar;
import java.util.Date;
import organisation.*;

public class FullDayEmployeeConstructorTest {
    private String firstName = "Vasiliy";
    private String lastName = "Ivanov";
    private JobTitles position = JobTitles.DepartmentBoss;
    private int salary = 45000;
    private Date dateToday;
    private JobTitles defaultPosition = FullDayEmployee.DEFAULT_POSITION;
    private int defaultSalary = FullDayEmployee.DEFAULT_SALARY;

    @BeforeClass
    public void beforeClassInits() {
        Calendar myCalendar = Calendar.getInstance();
        dateToday = myCalendar.getTime();
    }
    @Test
    public void testConstructorDefault() {
        FullDayEmployee myEmployee = new FullDayEmployee(firstName, lastName);
        assertEquals(firstName, myEmployee.getEmployeeFirstName());
        assertEquals(lastName, myEmployee.getEmployeeLastName());
        assertEquals(defaultPosition, myEmployee.getEmployeePosition());
        assertEquals(defaultSalary, myEmployee.getEmployeeSalary());
        assertNotNull(myEmployee.getEmployeeHireDate());
    }
    @Test
    public void testConstructorExtended() {
        FullDayEmployee myEmployee = new FullDayEmployee(firstName, lastName, position, salary);
        assertEquals(firstName, myEmployee.getEmployeeFirstName());
        assertEquals(lastName, myEmployee.getEmployeeLastName());
        assertEquals(position, myEmployee.getEmployeePosition());
        assertEquals(salary, myEmployee.getEmployeeSalary());
        assertNotNull(myEmployee.getEmployeeHireDate());
    }
    @Test
    public void testConstructorExtendedWithHireDate() {
        FullDayEmployee myEmployee = new FullDayEmployee(firstName, lastName, position, salary, dateToday);
        assertEquals(firstName, myEmployee.getEmployeeFirstName());
        assertEquals(lastName, myEmployee.getEmployeeLastName());
        assertEquals(position, myEmployee.getEmployeePosition());
        assertEquals(salary, myEmployee.getEmployeeSalary());
        assertEquals(dateToday, myEmployee.getEmployeeHireDate());
    }
}
