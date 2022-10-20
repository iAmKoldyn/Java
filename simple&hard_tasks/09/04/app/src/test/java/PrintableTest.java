import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrintableTest {

    @Test
    void print() {
        Printable[] objects = {
                new Polygon(4),
                new Polygon(5),
                new Triangle(1, 2, 3),
                new Triangle(2, 2, 3),
                new Triangle(4, 2, 3),
                new Text("Плыли дни...", "Меланхолический"),
                new Text("Опять двойка", "Грустный")
        };

        ObjectOperation objectOperation = new ObjectOperation();
        objectOperation.show(objects);
    }
}