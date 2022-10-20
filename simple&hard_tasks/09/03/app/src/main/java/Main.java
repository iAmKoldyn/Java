public class Main {
    public static void main(String[] args) {
        Employee[] employees = {
                new Accountant("Name1", "IT", 75000),
                new Engineer("Eng1", 120000),
                new MainAccountant("MainAc1", "IT", 125000),
                new Worker("Worker1", 50000)
        };

        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }
}
