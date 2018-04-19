package organisation;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.Calendar;
import java.util.Date;

public class FullDayEmployeeTest {
    private String firstName = "Vasiliy";
    private String lastName = "Ivanov";
    private JobTitles position = JobTitles.DepartmentBoss;
    private int salary = 45000;
    private String firstName1 = "Ivan";
    private String lastName1 = "Petrov";
    private JobTitles position1 = JobTitles.Tester;
    private int salary1 = 28000;
    private Date dateToday;
    private Date dateTomorrow;
    private Date dateAfterWeek;
    private Date dateAfterCentury;
    private Date dateYesterday;

    private JobTitles defaultPosition = InterfaceEmployee.DEFAULT_POSITION;
    private int defaultSalary = InterfaceEmployee.DEFAULT_SALARY;

    @BeforeClass
    public void beforeClassInits() {
        dateToday = new Date();
        Calendar myCalendar = Calendar.getInstance();
        myCalendar.setTime(dateToday);
        myCalendar.add(Calendar.DATE, 1);
        dateTomorrow = myCalendar.getTime();
        myCalendar.setTime(dateToday);
        myCalendar.add(Calendar.DATE, 7);
        dateAfterWeek = myCalendar.getTime();
        myCalendar.setTime(dateToday);
        myCalendar.add(Calendar.DATE, 365 * 100);
        dateAfterCentury = myCalendar.getTime();
        myCalendar.setTime(dateToday);
        myCalendar.add(Calendar.DATE, -1);
        dateYesterday = myCalendar.getTime();
        myCalendar.setTime(dateToday);
        myCalendar.add(Calendar.DATE, -1 * (365 * 100));
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
    @Test
    public void testSetEmployeeFirstName() {
        Employee myEmployee = new FullDayEmployee(firstName, lastName, position, salary);
        assertNotEquals(firstName, firstName1);
        myEmployee.setEmployeeFirstName(firstName1);
        assertEquals(firstName1, myEmployee.getEmployeeFirstName());
    }
    @Test
    public void testSetEmployeeLastName() {
        Employee myEmployee = new FullDayEmployee(firstName, lastName, position, salary);
        assertNotEquals(lastName, lastName1);
        myEmployee.setEmployeeLastName(lastName1);
        assertEquals(lastName1, myEmployee.getEmployeeLastName());
    }
    @Test
    public void testSetEmployeePosition() {
        Employee myEmployee = new FullDayEmployee(firstName, lastName, position, salary);
        assertNotEquals(position, position1);
        myEmployee.setEmployeePosition(position1);
        assertEquals(position1, myEmployee.getEmployeePosition());
    }
    @Test
    public void testSetEmployeeSalary() {
        Employee myEmployee = new FullDayEmployee(firstName, lastName, position, salary);
        assertNotEquals(salary, salary1);
        myEmployee.setEmployeeSalary(salary1);
        assertEquals(salary1, myEmployee.getEmployeeSalary());
    }
    @Test
    public void testSetEmployeeHireDate() {
        Employee myEmployee = new FullDayEmployee(firstName, lastName, position, salary);
        myEmployee.setEmployeeHireDate(dateYesterday);
        assertEquals(dateYesterday, myEmployee.getEmployeeHireDate());
    }
    @Test
    public void testSetEmployeeHireDateNull() {
        Employee myEmployee = new FullDayEmployee(firstName, lastName, position, salary, dateTomorrow);
        assertEquals(dateTomorrow, myEmployee.getEmployeeHireDate());
        myEmployee.setEmployeeHireDate(null);
        assertNull(myEmployee.getEmployeeHireDate());
    }
    @Test
    public void testGetMonthPremiumAmount() {
        Employee myEmployee = new FullDayEmployee(firstName, lastName, position, salary);
        Calendar calendarNow = Calendar.getInstance();
        Date hireDate = calendarNow.getTime();
        Calendar calendarHire = Calendar.getInstance();
        calendarHire.setTime(hireDate);
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
