package organisationtesting;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.util.Calendar;
import java.util.Date;
import organisation.*;

public class HalfDayEmployeeConstructorTest {
    private String firstName;
    private String lastName;
    private JobTitles position;
    private int salary;
    private Date hireDateNow;
    private Date hireDateBefore;
    private Date hireDateAfter;
    
    private JobTitles defaultPosition = HalfDayEmployee.DEFAULT_POSITION;
    private int defaultSalary = HalfDayEmployee.DEFAULT_SALARY;

    @BeforeClass
    public void beforeMethod() {
        firstName = "Vasiliy";
        lastName = "Ivanov";
        position = JobTitles.OfficeManager;
        salary = 45000;
        defaultPosition = HalfDayEmployee.DEFAULT_POSITION;
        defaultSalary = HalfDayEmployee.DEFAULT_SALARY;
        Calendar myCalendar = Calendar.getInstance();
        hireDateNow = myCalendar.getTime();
        myCalendar.add(Calendar.DATE, -7);
        hireDateBefore = myCalendar.getTime();
        myCalendar.add(Calendar.DATE, 14);
        hireDateAfter = myCalendar.getTime();
    }
    @Test
    public void testConstructorDefault() {
        HalfDayEmployee myEmployee = new HalfDayEmployee(firstName, lastName);
        assertEquals(firstName, myEmployee.getEmployeeFirstName());
        assertEquals(lastName, myEmployee.getEmployeeLastName());
        assertEquals(defaultPosition, myEmployee.getEmployeePosition());
        assertEquals(defaultSalary, myEmployee.getEmployeeSalary());
        assertNotNull(myEmployee.getEmployeeHireDate());
    }
    @Test
    public void testConstructorExtended() {
        HalfDayEmployee myEmployee = new HalfDayEmployee(firstName, lastName, position, salary);
        assertEquals(firstName, myEmployee.getEmployeeFirstName());
        assertEquals(lastName, myEmployee.getEmployeeLastName());
        assertEquals(position, myEmployee.getEmployeePosition());
        assertEquals(salary, myEmployee.getEmployeeSalary());
        assertNotNull(myEmployee.getEmployeeHireDate());
    }
    @Test
    public void testConstructorExtendedWithHireDateNow() {
        HalfDayEmployee myEmployee = new HalfDayEmployee(firstName, lastName, position, salary, hireDateNow);
        assertEquals(firstName, myEmployee.getEmployeeFirstName());
        assertEquals(lastName, myEmployee.getEmployeeLastName());
        assertEquals(position, myEmployee.getEmployeePosition());
        assertEquals(salary, myEmployee.getEmployeeSalary());
        assertEquals(hireDateNow, myEmployee.getEmployeeHireDate());
    }
    @Test
    public void testConstructorExtendedWithHireDateBefore() {
        HalfDayEmployee myEmployee = new HalfDayEmployee(firstName, lastName, position, salary, hireDateBefore);
        assertEquals(firstName, myEmployee.getEmployeeFirstName());
        assertEquals(lastName, myEmployee.getEmployeeLastName());
        assertEquals(position, myEmployee.getEmployeePosition());
        assertEquals(salary, myEmployee.getEmployeeSalary());
        assertEquals(hireDateBefore, myEmployee.getEmployeeHireDate());
    }
    @Test
    public void testConstructorExtendedWithHireDateAfter() {
        HalfDayEmployee myEmployee = new HalfDayEmployee(firstName, lastName, position, salary, hireDateAfter);
        assertEquals(firstName, myEmployee.getEmployeeFirstName());
        assertEquals(lastName, myEmployee.getEmployeeLastName());
        assertEquals(position, myEmployee.getEmployeePosition());
        assertEquals(salary, myEmployee.getEmployeeSalary());
        assertEquals(hireDateAfter, myEmployee.getEmployeeHireDate());
    }
}
