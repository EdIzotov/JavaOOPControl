package organisation;

import java.util.Date;

public class HalfDayEmployee extends Employee {
    
    public HalfDayEmployee(String firstName, String lastName) {
        super(firstName, lastName);
    }
    public HalfDayEmployee(String firstName, String lastName, JobTitles position, int salary) {
        super(firstName, lastName, position, salary);
    }
    public HalfDayEmployee(String firstName, String lastName, JobTitles position, int salary, Date hireDate) {
        super(firstName, lastName, position, salary, hireDate);
    }
    public int getMonthPremiumAmount() {
        return 0;
    }
}
