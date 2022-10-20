public class Main {
    public static void main(String[] args) {
        double[][] m = {{1, 2}, {3, 4}};
        double[][] m2 = {{5, 6}, {7, 8}};
        Matrix ma1 = new Matrix(m);
        Matrix ma2 = new Matrix(m2);
        System.out.println(ma1);
        System.out.println("*");
        System.out.println(ma2);
        System.out.println("=");
        System.out.println(ma1.multi(ma2));

        System.out.println();
        System.out.println(ma1);
        System.out.println("+");
        System.out.println(ma2);
        System.out.println("=");
        System.out.println(ma1.add(ma2));

        System.out.println();
        System.out.println(ma1);
        System.out.println("-");
        System.out.println(ma2);
        System.out.println("=");
        System.out.println(ma1.sub(ma2));
    }
}
