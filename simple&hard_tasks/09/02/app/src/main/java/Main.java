public class Main {
    public static void main(String[] args) {
        Vector a = new Vector(1, 2);
        Vector b = new Vector(3, 4);
        double scalar = 3;

        System.out.println("a: " + a);
        System.out.println("b: " + b);

        System.out.println(a + " + " + b + " = " + a.add(b));
        System.out.println(a + " - " + b + " = " + a.sub(b));
        System.out.println(a + " * " + scalar + " = " + a.multiScalar(scalar));
        System.out.println(a + " / " + scalar + " = " + a.divideScalar(scalar));
        System.out.println(b + " * " + scalar + " = " + b.multiScalar(scalar));
        System.out.println(b + " / " + scalar + " = " + b.divideScalar(scalar));
    }
}
