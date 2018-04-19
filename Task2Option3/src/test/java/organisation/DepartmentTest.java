package organisation;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

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

    private final Employee myEmployee = new FullDayEmployee(firstName, lastName, position, salary);
    private final Employee myEmployee1 = new FullDayEmployee(firstName1, lastName1, position1, salary1);
    private final Employee myEmployee2 = new FullDayEmployee(firstName2, lastName2);
    private final Employee myEmployee3 = new FullDayEmployee(firstName3, lastName3);

    private final String departmentName = "Sales";
    private final String departmentName1 = "Accountants";
    private final String departmentName2 = "Management";

    private int defaultDepartmentSize = InterfaceDepartment.DEFAULT_DEPARTMENT_EMPLOYEES;

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
        Employee[] employeeArr = {myEmployee};
        Department myDepartment = new Department(departmentName, employeeArr);
        assertEquals(departmentName, myDepartment.getDepartmentName());
        assertEquals(employeeArr.length, myDepartment.getDepartmentEmployeesQty());
        assertEquals(employeeArr.length, myDepartment.getAllDepartmentEmployees().length);
        assertEquals(employeeArr.length, myDepartment.getAllDepartmentEmployeesSortedBySalaryAsc().length);
        assertEquals(employeeArr.length, myDepartment.getAllDepartmentEmployeesSortedBySalaryDes().length);
        assertEquals(employeeArr.length, myDepartment.getAllDepartmentEmployeesSortedByNameAsc().length);
        assertEquals(employeeArr.length, myDepartment.getAllDepartmentEmployeesSortedByNameDes().length);
        Employee[] employeeArr1 = {myEmployee, myEmployee1, myEmployee2, myEmployee3};
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
        Employee[] employeeArr = {myEmployee};
        Department myDepartment = new Department(departmentName, employeeArr);
        assertNotEquals(departmentName1, departmentName);
        myDepartment.setDepartmentName(departmentName1);
        assertEquals(departmentName1, myDepartment.getDepartmentName());
    }
    @Test
    public void testHireDepartmentEmployee() {
        Department myDepartment = new Department(departmentName);
        assertEquals(defaultDepartmentSize, myDepartment.getDepartmentEmployeesQty());
        myDepartment.hireDepartmentEmployee(myEmployee);
        assertEquals(defaultDepartmentSize + 1, myDepartment.getDepartmentEmployeesQty());
        assertEquals(defaultDepartmentSize + 1, myDepartment.getAllDepartmentEmployees().length);
        assertEquals(defaultDepartmentSize + 1, myDepartment.getAllDepartmentEmployeesSortedBySalaryAsc().length);
        assertEquals(defaultDepartmentSize + 1, myDepartment.getAllDepartmentEmployeesSortedBySalaryDes().length);
        assertEquals(defaultDepartmentSize + 1, myDepartment.getAllDepartmentEmployeesSortedByNameAsc().length);
        assertEquals(defaultDepartmentSize + 1, myDepartment.getAllDepartmentEmployeesSortedByNameDes().length);
        myDepartment.hireDepartmentEmployee(myEmployee1);
        assertEquals(defaultDepartmentSize + 2, myDepartment.getDepartmentEmployeesQty());
        assertEquals(defaultDepartmentSize + 2, myDepartment.getAllDepartmentEmployees().length);
        assertEquals(defaultDepartmentSize + 2, myDepartment.getAllDepartmentEmployeesSortedBySalaryAsc().length);
        assertEquals(defaultDepartmentSize + 2, myDepartment.getAllDepartmentEmployeesSortedBySalaryDes().length);
        assertEquals(defaultDepartmentSize + 2, myDepartment.getAllDepartmentEmployeesSortedByNameAsc().length);
        assertEquals(defaultDepartmentSize + 2, myDepartment.getAllDepartmentEmployeesSortedByNameDes().length);
        Employee[] employeeArr = {myEmployee1, myEmployee2, myEmployee3};
        Department myDepartment1 = new Department(departmentName1, employeeArr);
        assertEquals(employeeArr.length, myDepartment1.getDepartmentEmployeesQty());
        assertEquals(employeeArr.length, myDepartment1.getAllDepartmentEmployees().length);
        assertEquals(employeeArr.length, myDepartment1.getAllDepartmentEmployeesSortedBySalaryAsc().length);
        assertEquals(employeeArr.length, myDepartment1.getAllDepartmentEmployeesSortedBySalaryDes().length);
        assertEquals(employeeArr.length, myDepartment1.getAllDepartmentEmployeesSortedByNameAsc().length);
        assertEquals(employeeArr.length, myDepartment1.getAllDepartmentEmployeesSortedByNameDes().length);
        myDepartment1.hireDepartmentEmployee(myEmployee);
        assertEquals(employeeArr.length + 1, myDepartment1.getDepartmentEmployeesQty());
        assertEquals(employeeArr.length + 1, myDepartment1.getAllDepartmentEmployees().length);
        assertEquals(employeeArr.length + 1, myDepartment1.getAllDepartmentEmployeesSortedBySalaryAsc().length);
        assertEquals(employeeArr.length + 1, myDepartment1.getAllDepartmentEmployeesSortedBySalaryDes().length);
        assertEquals(employeeArr.length + 1, myDepartment1.getAllDepartmentEmployeesSortedByNameAsc().length);
        assertEquals(employeeArr.length + 1, myDepartment1.getAllDepartmentEmployeesSortedByNameDes().length);
    }
    @Test
    public void testFireDepartmentEmployee() {
        Employee[] employeeArr = {myEmployee, myEmployee1};
        Department myDepartment = new Department(departmentName, employeeArr);
        assertEquals(employeeArr.length, myDepartment.getDepartmentEmployeesQty());
        myDepartment.fireDepartmentEmployee(myEmployee.getEmployeeLastName(), myEmployee.getEmployeeFirstName(), myEmployee.getEmployeePosition());
        assertEquals(employeeArr.length - 1, myDepartment.getDepartmentEmployeesQty());
        assertEquals(employeeArr.length - 1, myDepartment.getAllDepartmentEmployees().length);
        assertEquals(employeeArr.length - 1, myDepartment.getAllDepartmentEmployeesSortedBySalaryAsc().length);
        assertEquals(employeeArr.length - 1, myDepartment.getAllDepartmentEmployeesSortedBySalaryDes().length);
        assertEquals(employeeArr.length - 1, myDepartment.getAllDepartmentEmployeesSortedByNameAsc().length);
        assertEquals(employeeArr.length - 1, myDepartment.getAllDepartmentEmployeesSortedByNameDes().length);
        myDepartment.fireDepartmentEmployee(myEmployee1.getEmployeeLastName(), myEmployee1.getEmployeeFirstName(), myEmployee1.getEmployeePosition());
        assertEquals(employeeArr.length - 2, myDepartment.getDepartmentEmployeesQty());
        assertEquals(employeeArr.length - 2, myDepartment.getAllDepartmentEmployees().length);
        assertEquals(employeeArr.length - 2, myDepartment.getAllDepartmentEmployeesSortedBySalaryAsc().length);
        assertEquals(employeeArr.length - 2, myDepartment.getAllDepartmentEmployeesSortedBySalaryDes().length);
        assertEquals(employeeArr.length - 2, myDepartment.getAllDepartmentEmployeesSortedByNameAsc().length);
        assertEquals(employeeArr.length - 2, myDepartment.getAllDepartmentEmployeesSortedByNameDes().length);
        myDepartment.fireDepartmentEmployee(myEmployee2.getEmployeeLastName(), myEmployee2.getEmployeeFirstName(), myEmployee2.getEmployeePosition());
        assertEquals(employeeArr.length - 2, myDepartment.getDepartmentEmployeesQty());
        assertEquals(employeeArr.length - 2, myDepartment.getAllDepartmentEmployees().length);
        assertEquals(employeeArr.length - 2, myDepartment.getAllDepartmentEmployeesSortedBySalaryAsc().length);
        assertEquals(employeeArr.length - 2, myDepartment.getAllDepartmentEmployeesSortedBySalaryDes().length);
        assertEquals(employeeArr.length - 2, myDepartment.getAllDepartmentEmployeesSortedByNameAsc().length);
        assertEquals(employeeArr.length - 2, myDepartment.getAllDepartmentEmployeesSortedByNameDes().length);
    }
    @Test
    public void testGetDepartmentEmployeesSalaryAvg() {
        Employee[] employeeArr = {myEmployee};
        Department myDepartment = new Department(departmentName, employeeArr);
        int avg = myEmployee.getEmployeeSalary() / employeeArr.length;
        assertEquals(avg, myDepartment.getDepartmentEmployeesSalaryAvg());
        Employee[] employeeArr1 = {myEmployee, myEmployee1, myEmployee2, myEmployee3};
        Department myDepartment1 = new Department(departmentName1, employeeArr1);
        int avg1 = (myEmployee.getEmployeeSalary() + myEmployee1.getEmployeeSalary() + myEmployee2.getEmployeeSalary() + myEmployee3.getEmployeeSalary()) / myDepartment1.getDepartmentEmployeesQty();
        assertEquals(avg1, myDepartment1.getDepartmentEmployeesSalaryAvg());
        Department myDepartment2 = new Department(departmentName2);
        int avg2 = 0;
        assertEquals(avg2, myDepartment2.getDepartmentEmployeesSalaryAvg());
    }
    @Test
    public void testGetDepartmentEmployeeByName() {
        Employee[] employeeArr = {myEmployee};
        Department myDepartment = new Department(departmentName, employeeArr);
        Employee foundEmployee = myDepartment.getDepartmentEmployeeByName(myEmployee.getEmployeeFirstName(), myEmployee.getEmployeeLastName());
        assertEquals(myEmployee, foundEmployee);
        Employee[] employeeArr1 = {myEmployee, myEmployee1, myEmployee2, myEmployee3};
        Department myDepartment1 = new Department(departmentName1, employeeArr1);
        Employee foundEmployee1 = myDepartment1.getDepartmentEmployeeByName(myEmployee3.getEmployeeFirstName(), myEmployee3.getEmployeeLastName());
        assertEquals(myEmployee3, foundEmployee1);
        Employee[] employeeArr2 = {myEmployee, myEmployee1, myEmployee3};
        Department myDepartment2 = new Department(departmentName2, employeeArr2);
        assertNull(myDepartment2.getDepartmentEmployeeByName(myEmployee2.getEmployeeFirstName(), myEmployee2.getEmployeeLastName()));
        myDepartment2.hireDepartmentEmployee(myEmployee2);
        Employee foundEmployee2 = myDepartment2.getDepartmentEmployeeByName(myEmployee2.getEmployeeFirstName(), myEmployee2.getEmployeeLastName());
        assertEquals(myEmployee2, foundEmployee2);
        myDepartment2.fireDepartmentEmployee(myEmployee2.getEmployeeLastName(), myEmployee2.getEmployeeFirstName(), myEmployee2.getEmployeePosition());
        assertNull(myDepartment2.getDepartmentEmployeeByName(myEmployee2.getEmployeeFirstName(), myEmployee2.getEmployeeLastName()));
    }
    @Test
    public void testGetAllDepartmentEmployees() {
        Employee[] employeeArr = {myEmployee2, myEmployee3, myEmployee1, myEmployee};
        Department myDepartment = new Department(departmentName, employeeArr);
        assertEquals(employeeArr.length, myDepartment.getAllDepartmentEmployees().length);
        Employee foundEmployee = myDepartment.getDepartmentEmployeeByName(myEmployee.getEmployeeFirstName(), myEmployee.getEmployeeLastName());
        assertEquals(myEmployee, foundEmployee);
        Employee foundEmployee1 = myDepartment.getDepartmentEmployeeByName(myEmployee1.getEmployeeFirstName(), myEmployee1.getEmployeeLastName());
        assertEquals(myEmployee1, foundEmployee1);
        Employee foundEmployee2 = myDepartment.getDepartmentEmployeeByName(myEmployee2.getEmployeeFirstName(), myEmployee2.getEmployeeLastName());
        assertEquals(myEmployee2, foundEmployee2);
        Employee foundEmployee3 = myDepartment.getDepartmentEmployeeByName(myEmployee3.getEmployeeFirstName(), myEmployee3.getEmployeeLastName());
        assertEquals(myEmployee3, foundEmployee3);
        Employee[] employeesInDepartment = myDepartment.getAllDepartmentEmployees();
        for (int i = 0; i < employeesInDepartment.length; i++) {
            assertEquals(employeeArr[i], employeesInDepartment[i]);
        }
    }
    @Test
    public void testGetAllDepartmentEmployeesSortedBySalary() {
        Employee[] employeeArr = {myEmployee2, myEmployee3, myEmployee1, myEmployee};
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
        Employee[] employeeArr = {myEmployee2, myEmployee3, myEmployee1, myEmployee};
        Employee[] employeeArrOrderedAsc = {myEmployee, myEmployee1, myEmployee2, myEmployee3};
        Employee[] employeeArrOrderedDes = {myEmployee3, myEmployee2, myEmployee1, myEmployee};
        Department myDepartment = new Department(departmentName, employeeArr);
        Employee[] employeesSortedByNameAsceding = myDepartment.getAllDepartmentEmployeesSortedByNameAsc();
        assertEquals(employeeArrOrderedAsc, employeesSortedByNameAsceding);
        Employee[] employeesSortedByNameDesceding = myDepartment.getAllDepartmentEmployeesSortedByNameDes();
        assertEquals(employeeArrOrderedDes, employeesSortedByNameDesceding);
    }
}
