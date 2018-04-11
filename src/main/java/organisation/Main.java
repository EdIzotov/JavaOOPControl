package organisation;

class Main {
    public static void main(String[] args) {
        Employee myEmployee = new Employee("firstName", "lastName");
        System.out.println(myEmployee.getEmployeeFirstName());
        System.out.println(myEmployee.getEmployeeLastName());
        System.out.println(myEmployee.getEmployeePosition());
        System.out.println(myEmployee.getEmployeeSalary());
        Employee myEmployee2 = new Employee("firstName", "lastName", "QA", 44444);
        System.out.println(myEmployee2.getEmployeePosition());
    }
}
