package lab_13_test.task_02_test;

import org.example.lab_13.task_02.Main;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    @Test
    void testOne() {
        ArrayList<String> noun = new ArrayList<>();
        noun.add("этих");
        assertEquals(noun, Main.oleglox("Пятый этих проблем настолько очевидна."));
    }
}
