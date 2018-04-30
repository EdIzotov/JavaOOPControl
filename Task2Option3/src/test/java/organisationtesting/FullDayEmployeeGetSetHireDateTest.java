package organisationtesting;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.util.Calendar;
import java.util.Date;
import organisation.*;

public class FullDayEmployeeGetSetHireDateTest {
    private String firstName;
    private String lastName;
    private JobTitles position;
    private int salary;
    private Date hireDateNow;
    private Date hireDateBefore;
    private Date hireDateAfter;

    @BeforeClass
    public void beforeMethod() {
        firstName = "Vasiliy";
        lastName = "Ivanov";
        position = JobTitles.OfficeManager;
        salary = 45000;
        Calendar myCalendar = Calendar.getInstance();
        hireDateNow = myCalendar.getTime();
        myCalendar.add(Calendar.DATE, -7);
        hireDateBefore = myCalendar.getTime();
        myCalendar.add(Calendar.DATE, 14);
        hireDateAfter = myCalendar.getTime();
    }

    @Test
    public void testSetEmployeeHireDate() {
        FullDayEmployee myEmployee = new FullDayEmployee(firstName, lastName, position, salary);
        myEmployee.setEmployeeHireDate(hireDateNow);
        assertEquals(hireDateNow, myEmployee.getEmployeeHireDate());
    }
    @Test
    public void testSetEmployeeHireDateBefore() {
        FullDayEmployee myEmployee = new FullDayEmployee(firstName, lastName, position, salary, hireDateNow);
        assertEquals(hireDateNow, myEmployee.getEmployeeHireDate());
        myEmployee.setEmployeeHireDate(hireDateBefore);
        assertEquals(hireDateBefore, myEmployee.getEmployeeHireDate());
    }
    @Test
    public void testSetEmployeeHireDateAfter() {
        FullDayEmployee myEmployee = new FullDayEmployee(firstName, lastName, position, salary, hireDateNow);
        assertEquals(hireDateNow, myEmployee.getEmployeeHireDate());
        myEmployee.setEmployeeHireDate(hireDateAfter);
        assertEquals(hireDateAfter, myEmployee.getEmployeeHireDate());
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSetEmployeeHireDateNullValue() throws IllegalArgumentException {
        FullDayEmployee myEmployee = new FullDayEmployee(firstName, lastName, position, salary, hireDateNow);
        assertEquals(hireDateNow, myEmployee.getEmployeeHireDate());
        myEmployee.setEmployeeHireDate(null);
    }
}
