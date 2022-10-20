package task;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CheckTest {
  // +7 940 776 6115
  @Test void phoneNumberTest() {
    assertTrue(Check.phoneNumber("7(940)776 61 15"));

    assertTrue(Check.phoneNumber("+7(940)776 61 15"));

    assertTrue(Check.phoneNumber("8(940)776 61 15"));

    assertTrue(Check.phoneNumber("7(940)776-61-15"));

    assertTrue(Check.phoneNumber("+7(940)776-61-15"));

    assertTrue(Check.phoneNumber("8(940)776-61-15"));

    assertTrue(Check.phoneNumber("8940776-61-15"));

    assertFalse(Check.phoneNumber("7(940776 61 15"));

    assertFalse(Check.phoneNumber("+7940)776 61 15"));

    assertFalse(Check.phoneNumber("9(940)776 61 15"));

    assertFalse(Check.phoneNumber("7(940 776-61-15"));

    assertFalse(Check.phoneNumber("+7 940)776-61-15"));

    assertFalse(Check.phoneNumber("9(940)776-61-15"));

    assertFalse(Check.phoneNumber("7(940)776 61-15"));
  }
}
