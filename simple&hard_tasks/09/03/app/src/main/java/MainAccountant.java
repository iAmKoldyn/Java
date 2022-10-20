import java.util.Arrays;

public class MainAccountant extends Accountant implements Printable {
    Accountant[] subordinates;
    public MainAccountant(String name, String department, double salary) {
        super(name, department, salary);
        subordinates = new Accountant[0];
        this.position = "Главный бухгалтер";
    }

    @Override
    public void print() {
        System.out.println(this);
    }

    public void setDepartmentToSub(String department, int sub) {
        subordinates[sub].department = department;
    }

    @Override
    public String toString() {
        return "Главный бухгалтер{" +
                "имя='" + name + '\'' +
                ", должность='" + position + '\'' +
                ", зарплата=" + salary +
                ", подчиненные=" + Arrays.toString(subordinates) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MainAccountant that = (MainAccountant) o;
        return Arrays.equals(subordinates, that.subordinates) && name.equals(that.name) && salary == that.salary;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(subordinates);
    }
}
