package lab_13_test.task_03_test;

import org.example.lab_13.task_03.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test void stringTest2() {
        String text = "never gonna give you up";
        String[] heAveragedAnHour = new String[] {"give", "up"};
        String favoriteWord = "down";
        String answer = "never gonna down you down";
        assertEquals(Main.replacingWords(text, heAveragedAnHour, favoriteWord), answer);
    }
}
