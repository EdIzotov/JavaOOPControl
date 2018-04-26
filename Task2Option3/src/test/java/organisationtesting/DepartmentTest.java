package organisationtesting;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
import organisation.*;

public class DepartmentTest {
    private String firstName = "Vasiliy";
    private String lastName = "Ivanov";
    private JobTitles position = JobTitles.BigBoss;
    private int salary = 45000;
    private String firstName1 = "Ivan";
    private String lastName1 = "Petrov";
    private JobTitles position1 = JobTitles.Tester;
    private int salary1 = 28000;
    private String firstName2 = "Petr";
    private String lastName2 = "Petrov";
    private String firstName3 = "Sergey";
    private String lastName3 = "Sergeev";

    private final FullDayEmployee myEmployeeFull = new FullDayEmployee(firstName, lastName, position, salary);
    private final FullDayEmployee myEmployeeFull1 = new FullDayEmployee(firstName1, lastName1, position1, salary1);
    private final FullDayEmployee myEmployeeFull2 = new FullDayEmployee(firstName2, lastName2);
    private final FullDayEmployee myEmployeeFull3 = new FullDayEmployee(firstName3, lastName3);

    private final String departmentName = "Sales";
    private final String departmentName1 = "Accountants";
    private final String departmentName2 = "Management";

    private int defaultDepartmentSize = Department.DEFAULT_DEPARTMENT_EMPLOYEES;

    @Test
    public void testConstructorDefault() {
        Department myDepartment = new Department(departmentName);
        assertEquals(departmentName, myDepartment.getDepartmentName());
        assertEquals(defaultDepartmentSize, myDepartment.getDepartmentEmployeesQty());
        assertEquals(defaultDepartmentSize, myDepartment.getAllDepartmentEmployees().length);
        assertEquals(defaultDepartmentSize, myDepartment.getAllDepartmentEmployeesSortedBySalaryAsc().length);
        assertEquals(defaultDepartmentSize, myDepartment.getAllDepartmentEmployeesSortedBySalaryDes().length);
        assertEquals(defaultDepartmentSize, myDepartment.getAllDepartmentEmployeesSortedByNameAsc().length);
        assertEquals(defaultDepartmentSize, myDepartment.getAllDepartmentEmployeesSortedByNameDes().length);
    }
    @Test
    public void testConstructorExtended() {
        Employee[] employeeArr = {myEmployeeFull};
        Department myDepartment = new Department(departmentName, employeeArr);
        assertEquals(departmentName, myDepartment.getDepartmentName());
        assertEquals(employeeArr.length, myDepartment.getDepartmentEmployeesQty());
        assertEquals(employeeArr.length, myDepartment.getAllDepartmentEmployees().length);
        assertEquals(employeeArr.length, myDepartment.getAllDepartmentEmployeesSortedBySalaryAsc().length);
        assertEquals(employeeArr.length, myDepartment.getAllDepartmentEmployeesSortedBySalaryDes().length);
        assertEquals(employeeArr.length, myDepartment.getAllDepartmentEmployeesSortedByNameAsc().length);
        assertEquals(employeeArr.length, myDepartment.getAllDepartmentEmployeesSortedByNameDes().length);
        Employee[] employeeArr1 = {myEmployeeFull, myEmployeeFull1, myEmployeeFull2, myEmployeeFull3};
        Department myDepartment1 = new Department(departmentName1, employeeArr1);
        assertEquals(employeeArr1.length, myDepartment1.getDepartmentEmployeesQty());
        assertEquals(employeeArr1.length, myDepartment1.getAllDepartmentEmployees().length);
        assertEquals(employeeArr1.length, myDepartment1.getAllDepartmentEmployeesSortedBySalaryAsc().length);
        assertEquals(employeeArr1.length, myDepartment1.getAllDepartmentEmployeesSortedBySalaryDes().length);
        assertEquals(employeeArr1.length, myDepartment1.getAllDepartmentEmployeesSortedByNameAsc().length);
        assertEquals(employeeArr1.length, myDepartment1.getAllDepartmentEmployeesSortedByNameDes().length);
    }
    @Test
    public void testSetDepartmentName() {
        Employee[] employeeArr = {myEmployeeFull};
        Department myDepartment = new Department(departmentName, employeeArr);
        assertNotEquals(departmentName1, departmentName);
        myDepartment.setDepartmentName(departmentName1);
        assertEquals(departmentName1, myDepartment.getDepartmentName());
    }
    @Test
    public void testHireDepartmentEmployee() {
        Department myDepartment = new Department(departmentName);
        assertEquals(defaultDepartmentSize, myDepartment.getDepartmentEmployeesQty());
        myDepartment.hireDepartmentEmployee(myEmployeeFull);
        assertEquals(defaultDepartmentSize + 1, myDepartment.getDepartmentEmployeesQty());
        assertEquals(defaultDepartmentSize + 1, myDepartment.getAllDepartmentEmployees().length);
        assertEquals(defaultDepartmentSize + 1, myDepartment.getAllDepartmentEmployeesSortedBySalaryAsc().length);
        assertEquals(defaultDepartmentSize + 1, myDepartment.getAllDepartmentEmployeesSortedBySalaryDes().length);
        assertEquals(defaultDepartmentSize + 1, myDepartment.getAllDepartmentEmployeesSortedByNameAsc().length);
        assertEquals(defaultDepartmentSize + 1, myDepartment.getAllDepartmentEmployeesSortedByNameDes().length);
        myDepartment.hireDepartmentEmployee(myEmployeeFull1);
        assertEquals(defaultDepartmentSize + 2, myDepartment.getDepartmentEmployeesQty());
        assertEquals(defaultDepartmentSize + 2, myDepartment.getAllDepartmentEmployees().length);
        assertEquals(defaultDepartmentSize + 2, myDepartment.getAllDepartmentEmployeesSortedBySalaryAsc().length);
        assertEquals(defaultDepartmentSize + 2, myDepartment.getAllDepartmentEmployeesSortedBySalaryDes().length);
        assertEquals(defaultDepartmentSize + 2, myDepartment.getAllDepartmentEmployeesSortedByNameAsc().length);
        assertEquals(defaultDepartmentSize + 2, myDepartment.getAllDepartmentEmployeesSortedByNameDes().length);
        Employee[] employeeArr = {myEmployeeFull1, myEmployeeFull2, myEmployeeFull3};
        Department myDepartment1 = new Department(departmentName1, employeeArr);
        assertEquals(employeeArr.length, myDepartment1.getDepartmentEmployeesQty());
        assertEquals(employeeArr.length, myDepartment1.getAllDepartmentEmployees().length);
        assertEquals(employeeArr.length, myDepartment1.getAllDepartmentEmployeesSortedBySalaryAsc().length);
        assertEquals(employeeArr.length, myDepartment1.getAllDepartmentEmployeesSortedBySalaryDes().length);
        assertEquals(employeeArr.length, myDepartment1.getAllDepartmentEmployeesSortedByNameAsc().length);
        assertEquals(employeeArr.length, myDepartment1.getAllDepartmentEmployeesSortedByNameDes().length);
        myDepartment1.hireDepartmentEmployee(myEmployeeFull);
        assertEquals(employeeArr.length + 1, myDepartment1.getDepartmentEmployeesQty());
        assertEquals(employeeArr.length + 1, myDepartment1.getAllDepartmentEmployees().length);
        assertEquals(employeeArr.length + 1, myDepartment1.getAllDepartmentEmployeesSortedBySalaryAsc().length);
        assertEquals(employeeArr.length + 1, myDepartment1.getAllDepartmentEmployeesSortedBySalaryDes().length);
        assertEquals(employeeArr.length + 1, myDepartment1.getAllDepartmentEmployeesSortedByNameAsc().length);
        assertEquals(employeeArr.length + 1, myDepartment1.getAllDepartmentEmployeesSortedByNameDes().length);
    }
    @Test
    public void testFireDepartmentEmployee() {
        Employee[] employeeArr = {myEmployeeFull, myEmployeeFull1};
        Department myDepartment = new Department(departmentName, employeeArr);
        assertEquals(employeeArr.length, myDepartment.getDepartmentEmployeesQty());
        myDepartment.fireDepartmentEmployee(myEmployeeFull.getEmployeeLastName(), myEmployeeFull.getEmployeeFirstName(), myEmployeeFull.getEmployeePosition());
        assertEquals(employeeArr.length - 1, myDepartment.getDepartmentEmployeesQty());
        assertEquals(employeeArr.length - 1, myDepartment.getAllDepartmentEmployees().length);
        assertEquals(employeeArr.length - 1, myDepartment.getAllDepartmentEmployeesSortedBySalaryAsc().length);
        assertEquals(employeeArr.length - 1, myDepartment.getAllDepartmentEmployeesSortedBySalaryDes().length);
        assertEquals(employeeArr.length - 1, myDepartment.getAllDepartmentEmployeesSortedByNameAsc().length);
        assertEquals(employeeArr.length - 1, myDepartment.getAllDepartmentEmployeesSortedByNameDes().length);
        myDepartment.fireDepartmentEmployee(myEmployeeFull1.getEmployeeLastName(), myEmployeeFull1.getEmployeeFirstName(), myEmployeeFull1.getEmployeePosition());
        assertEquals(employeeArr.length - 2, myDepartment.getDepartmentEmployeesQty());
        assertEquals(employeeArr.length - 2, myDepartment.getAllDepartmentEmployees().length);
        assertEquals(employeeArr.length - 2, myDepartment.getAllDepartmentEmployeesSortedBySalaryAsc().length);
        assertEquals(employeeArr.length - 2, myDepartment.getAllDepartmentEmployeesSortedBySalaryDes().length);
        assertEquals(employeeArr.length - 2, myDepartment.getAllDepartmentEmployeesSortedByNameAsc().length);
        assertEquals(employeeArr.length - 2, myDepartment.getAllDepartmentEmployeesSortedByNameDes().length);
        myDepartment.fireDepartmentEmployee(myEmployeeFull2.getEmployeeLastName(), myEmployeeFull2.getEmployeeFirstName(), myEmployeeFull2.getEmployeePosition());
        assertEquals(employeeArr.length - 2, myDepartment.getDepartmentEmployeesQty());
        assertEquals(employeeArr.length - 2, myDepartment.getAllDepartmentEmployees().length);
        assertEquals(employeeArr.length - 2, myDepartment.getAllDepartmentEmployeesSortedBySalaryAsc().length);
        assertEquals(employeeArr.length - 2, myDepartment.getAllDepartmentEmployeesSortedBySalaryDes().length);
        assertEquals(employeeArr.length - 2, myDepartment.getAllDepartmentEmployeesSortedByNameAsc().length);
        assertEquals(employeeArr.length - 2, myDepartment.getAllDepartmentEmployeesSortedByNameDes().length);
    }
    @Test
    public void testGetDepartmentEmployeesSalaryAvg() {
        Employee[] employeeArr = {myEmployeeFull};
        Department myDepartment = new Department(departmentName, employeeArr);
        int avg = myEmployeeFull.getEmployeeSalary() / employeeArr.length;
        assertEquals(avg, myDepartment.getDepartmentEmployeesSalaryAvg());
        Employee[] employeeArr1 = {myEmployeeFull, myEmployeeFull1, myEmployeeFull2, myEmployeeFull3};
        Department myDepartment1 = new Department(departmentName1, employeeArr1);
        int avg1 = (myEmployeeFull.getEmployeeSalary() + myEmployeeFull1.getEmployeeSalary() + myEmployeeFull2.getEmployeeSalary() + myEmployeeFull3.getEmployeeSalary()) / myDepartment1.getDepartmentEmployeesQty();
        assertEquals(avg1, myDepartment1.getDepartmentEmployeesSalaryAvg());
        Department myDepartment2 = new Department(departmentName2);
        int avg2 = 0;
        assertEquals(avg2, myDepartment2.getDepartmentEmployeesSalaryAvg());
    }
    @Test
    public void testGetDepartmentEmployeeByName() {
        Employee[] employeeArr = {myEmployeeFull};
        Department myDepartment = new Department(departmentName, employeeArr);
        Employee foundEmployee = myDepartment.getDepartmentEmployeeByName(myEmployeeFull.getEmployeeFirstName(), myEmployeeFull.getEmployeeLastName());
        assertEquals(myEmployeeFull, foundEmployee);
        Employee[] employeeArr1 = {myEmployeeFull, myEmployeeFull1, myEmployeeFull2, myEmployeeFull3};
        Department myDepartment1 = new Department(departmentName1, employeeArr1);
        Employee foundEmployee1 = myDepartment1.getDepartmentEmployeeByName(myEmployeeFull3.getEmployeeFirstName(), myEmployeeFull3.getEmployeeLastName());
        assertEquals(myEmployeeFull3, foundEmployee1);
        Employee[] employeeArr2 = {myEmployeeFull, myEmployeeFull1, myEmployeeFull3};
        Department myDepartment2 = new Department(departmentName2, employeeArr2);
        assertNull(myDepartment2.getDepartmentEmployeeByName(myEmployeeFull2.getEmployeeFirstName(), myEmployeeFull2.getEmployeeLastName()));
        myDepartment2.hireDepartmentEmployee(myEmployeeFull2);
        Employee foundEmployee2 = myDepartment2.getDepartmentEmployeeByName(myEmployeeFull2.getEmployeeFirstName(), myEmployeeFull2.getEmployeeLastName());
        assertEquals(myEmployeeFull2, foundEmployee2);
        myDepartment2.fireDepartmentEmployee(myEmployeeFull2.getEmployeeLastName(), myEmployeeFull2.getEmployeeFirstName(), myEmployeeFull2.getEmployeePosition());
        assertNull(myDepartment2.getDepartmentEmployeeByName(myEmployeeFull2.getEmployeeFirstName(), myEmployeeFull2.getEmployeeLastName()));
    }
    @Test
    public void testGetAllDepartmentEmployees() {
        Employee[] employeeArr = {myEmployeeFull2, myEmployeeFull3, myEmployeeFull1, myEmployeeFull};
        Department myDepartment = new Department(departmentName, employeeArr);
        assertEquals(employeeArr.length, myDepartment.getAllDepartmentEmployees().length);
        Employee foundEmployee = myDepartment.getDepartmentEmployeeByName(myEmployeeFull.getEmployeeFirstName(), myEmployeeFull.getEmployeeLastName());
        assertEquals(myEmployeeFull, foundEmployee);
        Employee foundEmployee1 = myDepartment.getDepartmentEmployeeByName(myEmployeeFull1.getEmployeeFirstName(), myEmployeeFull1.getEmployeeLastName());
        assertEquals(myEmployeeFull1, foundEmployee1);
        Employee foundEmployee2 = myDepartment.getDepartmentEmployeeByName(myEmployeeFull2.getEmployeeFirstName(), myEmployeeFull2.getEmployeeLastName());
        assertEquals(myEmployeeFull2, foundEmployee2);
        Employee foundEmployee3 = myDepartment.getDepartmentEmployeeByName(myEmployeeFull3.getEmployeeFirstName(), myEmployeeFull3.getEmployeeLastName());
        assertEquals(myEmployeeFull3, foundEmployee3);
        Employee[] employeesInDepartment = myDepartment.getAllDepartmentEmployees();
        for (int i = 0; i < employeesInDepartment.length; i++) {
            assertEquals(employeeArr[i], employeesInDepartment[i]);
        }
    }
    @Test
    public void testGetAllDepartmentEmployeesSortedBySalary() {
        Employee[] employeeArr = {myEmployeeFull2, myEmployeeFull3, myEmployeeFull1, myEmployeeFull};
        Department myDepartment = new Department(departmentName, employeeArr);
        Employee[] employeesSortedBySalaryAsceding = myDepartment.getAllDepartmentEmployeesSortedBySalaryAsc();
        for (int i = 0; i < employeesSortedBySalaryAsceding.length - 1; i++) {
            assertTrue(employeesSortedBySalaryAsceding[i].getEmployeeSalary() <= employeesSortedBySalaryAsceding[i + 1].getEmployeeSalary());
        }
        Employee[] employeesSortedBySalaryDesceding = myDepartment.getAllDepartmentEmployeesSortedBySalaryDes();
        for (int i = 0; i < employeesSortedBySalaryDesceding.length - 1; i++) {
            assertTrue(employeesSortedBySalaryDesceding[i].getEmployeeSalary() >= employeesSortedBySalaryDesceding[i + 1].getEmployeeSalary());
        }
    }
    @Test
    public void testGetAllDepartmentEmployeesSortedByName() {
        Employee[] employeeArr = {myEmployeeFull2, myEmployeeFull3, myEmployeeFull1, myEmployeeFull};
        Employee[] employeeArrOrderedAsc = {myEmployeeFull, myEmployeeFull1, myEmployeeFull2, myEmployeeFull3};
        Employee[] employeeArrOrderedDes = {myEmployeeFull3, myEmployeeFull2, myEmployeeFull1, myEmployeeFull};
        Department myDepartment = new Department(departmentName, employeeArr);
        Employee[] employeesSortedByNameAsceding = myDepartment.getAllDepartmentEmployeesSortedByNameAsc();
        assertEquals(employeeArrOrderedAsc, employeesSortedByNameAsceding);
        Employee[] employeesSortedByNameDesceding = myDepartment.getAllDepartmentEmployeesSortedByNameDes();
        assertEquals(employeeArrOrderedDes, employeesSortedByNameDesceding);
    }
}
