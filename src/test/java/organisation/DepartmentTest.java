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
    private String firstName2 = "Petr";
    private String lastName2 = "Petrov";
    private String firstName3 = "Sergey";
    private String lastName3 = "Sergeev";

    private final Employee myEmployee = new Employee(firstName, lastName, position, salary);
    private final Employee myEmployee1 = new Employee(firstName1, lastName1, position1, salary1);
    private final Employee myEmployee2 = new Employee(firstName2, lastName2);
    private final Employee myEmployee3 = new Employee(firstName3, lastName3);

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
        assertEquals(defaultDepartmentSize, myDepartment.getAllDepartmentEmployeesSortedBySalary().length);
    }
    @Test
    public void testConstructorExtended() {
        Employee[] employeeArr = {myEmployee};
        Department myDepartment = new Department(departmentName, employeeArr);
        assertEquals(departmentName, myDepartment.getDepartmentName());
        assertEquals(employeeArr.length, myDepartment.getDepartmentEmployeesQty());
        assertEquals(employeeArr.length, myDepartment.getAllDepartmentEmployees().length);
        assertEquals(employeeArr.length, myDepartment.getAllDepartmentEmployeesSortedBySalary().length);
        Employee[] employeeArr1 = {myEmployee, myEmployee1, myEmployee2, myEmployee3};
        Department myDepartment1 = new Department(departmentName1, employeeArr1);
        assertEquals(employeeArr1.length, myDepartment1.getDepartmentEmployeesQty());
        assertEquals(employeeArr1.length, myDepartment1.getAllDepartmentEmployees().length);
        assertEquals(employeeArr1.length, myDepartment1.getAllDepartmentEmployeesSortedBySalary().length);
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
        assertEquals(defaultDepartmentSize + 1, myDepartment.getAllDepartmentEmployeesSortedBySalary().length);
        myDepartment.hireDepartmentEmployee(myEmployee1);
        assertEquals(defaultDepartmentSize + 2, myDepartment.getDepartmentEmployeesQty());
        assertEquals(defaultDepartmentSize + 2, myDepartment.getAllDepartmentEmployees().length);
        assertEquals(defaultDepartmentSize + 2, myDepartment.getAllDepartmentEmployeesSortedBySalary().length);
        Employee[] employeeArr = {myEmployee1, myEmployee2, myEmployee3};
        Department myDepartment1 = new Department(departmentName1, employeeArr);
        assertEquals(employeeArr.length, myDepartment1.getDepartmentEmployeesQty());
        assertEquals(employeeArr.length, myDepartment1.getAllDepartmentEmployees().length);
        assertEquals(employeeArr.length, myDepartment1.getAllDepartmentEmployeesSortedBySalary().length);
        myDepartment1.hireDepartmentEmployee(myEmployee);
        assertEquals(employeeArr.length + 1, myDepartment1.getDepartmentEmployeesQty());
        assertEquals(employeeArr.length + 1, myDepartment1.getAllDepartmentEmployees().length);
        assertEquals(employeeArr.length + 1, myDepartment1.getAllDepartmentEmployeesSortedBySalary().length);
    }
    @Test
    public void testFireDepartmentEmployee() {
        Employee[] employeeArr = {myEmployee, myEmployee1};
        Department myDepartment = new Department(departmentName, employeeArr);
        assertEquals(employeeArr.length, myDepartment.getDepartmentEmployeesQty());
        myDepartment.fireDepartmentEmployee(myEmployee.getEmployeeLastName(), myEmployee.getEmployeeFirstName(), myEmployee.getEmployeePosition());
        assertEquals(employeeArr.length - 1, myDepartment.getDepartmentEmployeesQty());
        assertEquals(employeeArr.length - 1, myDepartment.getAllDepartmentEmployees().length);
        assertEquals(employeeArr.length - 1, myDepartment.getAllDepartmentEmployeesSortedBySalary().length);
        myDepartment.fireDepartmentEmployee(myEmployee1.getEmployeeLastName(), myEmployee1.getEmployeeFirstName(), myEmployee1.getEmployeePosition());
        assertEquals(employeeArr.length - 2, myDepartment.getDepartmentEmployeesQty());
        assertEquals(employeeArr.length - 2, myDepartment.getAllDepartmentEmployees().length);
        assertEquals(employeeArr.length - 2, myDepartment.getAllDepartmentEmployeesSortedBySalary().length);
        myDepartment.fireDepartmentEmployee(myEmployee2.getEmployeeLastName(), myEmployee2.getEmployeeFirstName(), myEmployee2.getEmployeePosition());
        assertEquals(employeeArr.length - 2, myDepartment.getDepartmentEmployeesQty());
        assertEquals(employeeArr.length - 2, myDepartment.getAllDepartmentEmployees().length);
        assertEquals(employeeArr.length - 2, myDepartment.getAllDepartmentEmployeesSortedBySalary().length);
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
        assertEquals(myEmployee.getEmployeeFirstName(), foundEmployee.getEmployeeFirstName());
        assertEquals(myEmployee.getEmployeeLastName(), foundEmployee.getEmployeeLastName());
        assertEquals(myEmployee.getEmployeePosition(), foundEmployee.getEmployeePosition());
        assertEquals(myEmployee.getEmployeeSalary(), foundEmployee.getEmployeeSalary());
        Employee[] employeeArr1 = {myEmployee, myEmployee1, myEmployee2, myEmployee3};
        Department myDepartment1 = new Department(departmentName1, employeeArr1);
        Employee foundEmployee1 = myDepartment1.getDepartmentEmployeeByName(myEmployee3.getEmployeeFirstName(), myEmployee3.getEmployeeLastName());
        assertEquals(myEmployee3.getEmployeeFirstName(), foundEmployee1.getEmployeeFirstName());
        assertEquals(myEmployee3.getEmployeeLastName(), foundEmployee1.getEmployeeLastName());
        assertEquals(myEmployee3.getEmployeePosition(), foundEmployee1.getEmployeePosition());
        assertEquals(myEmployee3.getEmployeeSalary(), foundEmployee1.getEmployeeSalary());
        Employee[] employeeArr2 = {myEmployee, myEmployee1, myEmployee3};
        Department myDepartment2 = new Department(departmentName2, employeeArr2);
        assertNull(myDepartment2.getDepartmentEmployeeByName(myEmployee2.getEmployeeFirstName(), myEmployee2.getEmployeeLastName()));
        myDepartment2.hireDepartmentEmployee(myEmployee2);
        Employee foundEmployee2 = myDepartment2.getDepartmentEmployeeByName(myEmployee2.getEmployeeFirstName(), myEmployee2.getEmployeeLastName());
        assertEquals(myEmployee2.getEmployeeFirstName(), foundEmployee2.getEmployeeFirstName());
        assertEquals(myEmployee2.getEmployeeLastName(), foundEmployee2.getEmployeeLastName());
        assertEquals(myEmployee2.getEmployeePosition(), foundEmployee2.getEmployeePosition());
        assertEquals(myEmployee2.getEmployeeSalary(), foundEmployee2.getEmployeeSalary());
        myDepartment2.fireDepartmentEmployee(myEmployee2.getEmployeeLastName(), myEmployee2.getEmployeeFirstName(), myEmployee2.getEmployeePosition());
        assertNull(myDepartment2.getDepartmentEmployeeByName(myEmployee2.getEmployeeFirstName(), myEmployee2.getEmployeeLastName()));
    }
    @Test
    public void testGetAllDepartmentEmployees() {
        Employee[] employeeArr = {myEmployee2, myEmployee3, myEmployee1, myEmployee};
        Department myDepartment = new Department(departmentName, employeeArr);
        assertEquals(employeeArr.length, myDepartment.getAllDepartmentEmployees().length);
        Employee foundEmployee = myDepartment.getDepartmentEmployeeByName(myEmployee.getEmployeeFirstName(), myEmployee.getEmployeeLastName());
        assertEquals(myEmployee.getEmployeeFirstName(), foundEmployee.getEmployeeFirstName());
        assertEquals(myEmployee.getEmployeeLastName(), foundEmployee.getEmployeeLastName());
        assertEquals(myEmployee.getEmployeePosition(), foundEmployee.getEmployeePosition());
        assertEquals(myEmployee.getEmployeeSalary(), foundEmployee.getEmployeeSalary());
        Employee foundEmployee1 = myDepartment.getDepartmentEmployeeByName(myEmployee1.getEmployeeFirstName(), myEmployee1.getEmployeeLastName());
        assertEquals(myEmployee1.getEmployeeFirstName(), foundEmployee1.getEmployeeFirstName());
        assertEquals(myEmployee1.getEmployeeLastName(), foundEmployee1.getEmployeeLastName());
        assertEquals(myEmployee1.getEmployeePosition(), foundEmployee1.getEmployeePosition());
        assertEquals(myEmployee1.getEmployeeSalary(), foundEmployee1.getEmployeeSalary());
        Employee foundEmployee2 = myDepartment.getDepartmentEmployeeByName(myEmployee2.getEmployeeFirstName(), myEmployee2.getEmployeeLastName());
        assertEquals(myEmployee2.getEmployeeFirstName(), foundEmployee2.getEmployeeFirstName());
        assertEquals(myEmployee2.getEmployeeLastName(), foundEmployee2.getEmployeeLastName());
        assertEquals(myEmployee2.getEmployeePosition(), foundEmployee2.getEmployeePosition());
        assertEquals(myEmployee2.getEmployeeSalary(), foundEmployee2.getEmployeeSalary());
        Employee foundEmployee3 = myDepartment.getDepartmentEmployeeByName(myEmployee3.getEmployeeFirstName(), myEmployee3.getEmployeeLastName());
        assertEquals(myEmployee3.getEmployeeFirstName(), foundEmployee3.getEmployeeFirstName());
        assertEquals(myEmployee3.getEmployeeLastName(), foundEmployee3.getEmployeeLastName());
        assertEquals(myEmployee3.getEmployeePosition(), foundEmployee3.getEmployeePosition());
        assertEquals(myEmployee3.getEmployeeSalary(), foundEmployee3.getEmployeeSalary());
        Employee[] employeesInDepartment = myDepartment.getAllDepartmentEmployees();
        for (int i = 0; i < employeesInDepartment.length; i++) {
            assertEquals(employeeArr[i], employeesInDepartment[i]);
        }
        Employee[] employeesInDepartment1 = myDepartment.getAllDepartmentEmployeesSortedBySalary();
        for (int i = 0; i < (employeesInDepartment1.length - 1); i++) {
            assertTrue(employeesInDepartment1[i].getEmployeeSalary() <= employeesInDepartment1[i + 1].getEmployeeSalary());
        }
    }
}
