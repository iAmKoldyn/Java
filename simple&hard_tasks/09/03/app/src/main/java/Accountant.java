import java.util.Objects;

public class Accountant extends Employee implements Printable {
    protected String department;

    public Accountant(String name, String department, double salary) {
        super(name, salary);
        this.position = "Бухгалтер";
        this.department = department;
    }

    public double giveMoney(double money) {
        return money;
    }

    @Override
    public String toString() {
        return "Бухгалтер{" +
                "отдел ответственности ='" + department + '\'' +
                ", имя='" + name + '\'' +
                ", должность='" + position + '\'' +
                ", зарплата=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accountant that = (Accountant) o;
        return department.equals(that.department) && name.equals(that.name) && salary == that.salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(department);
    }

    @Override
    public void print() {
        System.out.println(this);
    }
}
