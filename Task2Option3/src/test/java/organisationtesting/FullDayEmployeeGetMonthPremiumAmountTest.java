package organisationtesting;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.util.Calendar;
import java.util.Date;
import organisation.*;

public class FullDayEmployeeGetMonthPremiumAmountTest {
    private String firstName;
    private String lastName;
    private JobTitles position;
    private int salary;
    private Date hireDateNow;
    private Date hireDateBefore2Years;

    @BeforeClass
    public void beforeMethod() {
        firstName = "Vasiliy";
        lastName = "Ivanov";
        position = JobTitles.OfficeManager;
        salary = 45000;
        Calendar myCalendar = Calendar.getInstance();
        hireDateNow = myCalendar.getTime();
        myCalendar.add(Calendar.YEAR, -2);
        hireDateBefore2Years = myCalendar.getTime();
    }
    @Test
    public void testGetEmployeeMonthPremiumHireDateNow() {
        FullDayEmployee myEmployee = new FullDayEmployee(firstName, lastName, position, salary, hireDateNow);
        assertTrue(myEmployee.getMonthPremiumAmount() == 0);
    }
    @Test
    public void testGetEmployeeMonthPremiumHireDateBefore() {
        FullDayEmployee myEmployee = new FullDayEmployee(firstName, lastName, position, salary, hireDateBefore2Years);
        Calendar calendarNow = Calendar.getInstance();
        Calendar calendarHire = Calendar.getInstance();
        calendarHire.setTime(hireDateBefore2Years);
        int years = calendarNow.get(Calendar.YEAR) - calendarHire.get(Calendar.YEAR);
        if ((calendarNow.get(Calendar.MONTH) > calendarHire.get(Calendar.MONTH)) || (calendarNow.get(Calendar.MONTH) == calendarHire.get(Calendar.MONTH) && 
        calendarNow.get(Calendar.DATE) > calendarHire.get(Calendar.DATE))) {
            if (years > 0) {
                years--;
            }
        }
        int testPremium = Math.round((float) years / 20f * (float) myEmployee.getEmployeeSalary());
        assertEquals(testPremium, myEmployee.getMonthPremiumAmount());
    }
    @Test
    public void testGetMonthPremiumAmountWithDate() {
        Calendar myCalendar = Calendar.getInstance();
        Calendar myCalendar1 = Calendar.getInstance();
        myCalendar.set(Calendar.YEAR, 2014);
        myCalendar.set(Calendar.MONTH, Calendar.JUNE);
        Date newHireDate = myCalendar.getTime();
        Employee myEmployee = new FullDayEmployee(firstName, lastName, position, salary, newHireDate);
        int years = myCalendar1.get(Calendar.YEAR) - myCalendar.get(Calendar.YEAR);
        if ((myCalendar.get(Calendar.MONTH) > myCalendar1.get(Calendar.MONTH)) || (myCalendar.get(Calendar.MONTH) == myCalendar1.get(Calendar.MONTH) && 
        myCalendar.get(Calendar.DATE) > myCalendar1.get(Calendar.DATE))) {
            if (years > 0) {
                years--;
            }
        }
        int testPremium = Math.round((float) years / 20f * (float) myEmployee.getEmployeeSalary());
        if (myCalendar1.get(Calendar.MONTH) == 0) {
            testPremium += myEmployee.getEmployeeSalary();
        }
        assertEquals(testPremium, myEmployee.getMonthPremiumAmount());
    }
}
