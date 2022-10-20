import java.util.Objects;

public class Vector {
    double a;
    double b;

    public Vector(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Vector sub(Vector other) {
        return new Vector(this.a - other.a, this.b - other.b);
    }

    public Vector add(Vector other) {
        return new Vector(this.a + other.a, this.b + other.b);
    }

    public Vector multiScalar(double scalar) {
        return new Vector(this.a * scalar, this.b * scalar);
    }

    public Vector divideScalar(double scalar) {
        return new Vector(this.a / scalar, this.b / scalar);
    }

    @Override
    public String toString() {
        return "{" + a + ";" + b + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return Double.compare(vector.a, a) == 0 && Double.compare(vector.b, b) == 0;
    }
//po polyam
    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}
