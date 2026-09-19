class EmployeeCompany {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    EmployeeCompany(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        EmployeeCompany emp1 = new EmployeeCompany("A", 50000);
        EmployeeCompany emp2 = new EmployeeCompany("B", 60000);
        EmployeeCompany emp3 = new EmployeeCompany("C", 70000);

        EmployeeCompany.printCompanyInfo();
    }
}
