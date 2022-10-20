import java.util.Objects;

public class Worker extends Employee implements Printable {

    private String experience;

    public Worker(String name, double salary) {
        super(name, salary);
        this.position = "Рабочий";
        this.experience = "Новичок";
    }

    public void workSomething() {
        System.out.println("Выполнил рутинную работу");
    }

    @Override
    public String toString() {
        return "Рабочий{" +
                "имя='" + name + '\'' +
                ", должность='" + position + '\'' +
                ", зарплата=" + salary +
                ", опыт='" + experience + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return experience.equals(worker.experience) && name.equals(worker.name) && salary == worker.salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(experience);
    }

    @Override
    public void print() {
        System.out.println(this);
    }
}
