package organisation;

public class Employee {
    String position;
    float salary;
    String firstName;
    String lastName;

    Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    Employee(String firstName, String lastName, String position, float salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.salary = salary;
    }
}
