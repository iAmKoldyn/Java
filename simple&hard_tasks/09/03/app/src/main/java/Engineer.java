import java.util.Objects;

public class Engineer extends Employee implements Printable {

    private String skill;

    public Engineer(String name, double salary) {
        super(name, salary);
        this.position = "Инженер";
        this.skill = "Компьютерный";
    }

    public void repairPc() {
        System.out.println("PC починен");
    }

    @Override
    public String toString() {
        return "Инженер{" +
                "имя='" + name + '\'' +
                ", должность='" + position + '\'' +
                ", зарплата=" + salary +
                ", навыки='" + skill + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engineer engineer = (Engineer) o;
        return skill.equals(engineer.skill) && name.equals(engineer.name) && salary == engineer.salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(skill);
    }

    @Override
    public void print() {
        System.out.println(this);
    }
}
