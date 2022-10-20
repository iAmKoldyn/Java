import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountantTest {

    Accountant accountant = new Accountant("Ivan", "Law", 150);
    @Test
    void giveMoney() {
        assertEquals(20, accountant.giveMoney(20));
    }

    @Test
    void testEquals() {
        assertEquals(accountant, new Accountant("Ivan", "Law", 150));
        assertNotEquals(accountant, new Accountant("Andrew", "Law", 150));
        assertNotEquals(accountant, new Accountant("Ivan", "Law", 1250));
        assertNotEquals(accountant, new Accountant("Ivan", "LLaw", 150));
    }

}
