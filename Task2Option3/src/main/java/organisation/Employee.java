package organisation;

import java.util.Comparator;
import java.util.Date;

public abstract class Employee implements InterfaceEmployee {

    private String firstName;
    private String lastName;
    private JobTitles position;
    private int salary;
    private Date hireDate;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = InterfaceEmployee.DEFAULT_POSITION;
        this.salary = InterfaceEmployee.DEFAULT_SALARY;
        this.hireDate = new Date();
    }
    public Employee(String firstName, String lastName, JobTitles position, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.salary = salary;
        this.hireDate = new Date();
    }
    public Employee(String firstName, String lastName, JobTitles position, int salary, Date hireDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.salary = salary;
        this.hireDate = hireDate;
    }
    
    public String getEmployeeFirstName() {
        return firstName;
    }
    public void setEmployeeFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getEmployeeLastName() {
        return lastName;
    }
    public void setEmployeeLastName(String lastName) {
        this.lastName = lastName;
    }
    public JobTitles getEmployeePosition() {
        return position;
    }
    public void setEmployeePosition(JobTitles position) {
        this.position = position;
    }
    public int getEmployeeSalary() {
        return salary;
    }
    public void setEmployeeSalary(int salary) {
        this.salary = salary;
    }
    public Date getEmployeeHireDate() {
        return hireDate;
    }
    public void setEmployeeHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
    public abstract int getMonthPremiumAmount();

    protected static Comparator<Employee> salaryComparatorAscending = new Comparator<Employee>() {
        public int compare(Employee emp1, Employee emp2) {
            Integer empSalary1 = emp1.getEmployeeSalary();
            Integer empSalary2 = emp2.getEmployeeSalary();
            return empSalary1.compareTo(empSalary2);
        }
    };
    protected static Comparator<Employee> salaryComparatorDescending = new Comparator<Employee>() {
        public int compare(Employee emp1, Employee emp2) {
            Integer empSalary1 = emp1.getEmployeeSalary();
            Integer empSalary2 = emp2.getEmployeeSalary();
            return empSalary2.compareTo(empSalary1);
        }
    };
    protected static Comparator<Employee> nameComparatorAscending = new Comparator<Employee>() {
        public int compare(Employee emp1, Employee emp2) {
            String empLastName1 = emp1.getEmployeeLastName();
            String empLastName2 = emp2.getEmployeeLastName();
            int lastNameComp = empLastName1.compareTo(empLastName2);
            if (lastNameComp != 0) {
                return lastNameComp;
            }
            String empFirstName1 = emp1.getEmployeeFirstName();
            String empFirstName2 = emp2.getEmployeeFirstName();
            return empFirstName1.compareTo(empFirstName2);
        }
    };
    protected static Comparator<Employee> nameComparatorDescending = new Comparator<Employee>() {
        public int compare(Employee emp1, Employee emp2) {
            String empLastName1 = emp1.getEmployeeLastName();
            String empLastName2 = emp2.getEmployeeLastName();
            int lastNameComp = empLastName2.compareTo(empLastName1);
            if (lastNameComp != 0) {
                return lastNameComp;
            }
            String empFirstName1 = emp1.getEmployeeFirstName();
            String empFirstName2 = emp2.getEmployeeFirstName();
            return empFirstName2.compareTo(empFirstName1);
        }
    };
}
