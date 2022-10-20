package lab_13_test.task_01_test;

import org.example.lab_13.task_01.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    @Test void phoneNumberTrueTest() {
        assertTrue(Main.phoneNumber("7(940)776 61 15"));

        assertTrue(Main.phoneNumber("+7(950)766 66 15"));

        assertTrue(Main.phoneNumber("8(995)777 61 65"));

        assertTrue(Main.phoneNumber("7(988)190-11-55"));

    }
    @Test
    void phoneNumberFalseTest() {
        assertFalse(Main.phoneNumber("7(999 66 37"));

        assertFalse(Main.phoneNumber("-912)888qwe 1#s 37"));

        assertFalse(Main.phoneNumber("9(988)185 !!! !!!"));

        assertFalse(Main.phoneNumber("7(123 456-12337"));

    }
}