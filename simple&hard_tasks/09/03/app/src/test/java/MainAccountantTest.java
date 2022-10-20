import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainAccountantTest {
    @Test
    void test() {
        Accountant accountant = new Accountant("Andrew", "Null", 120);
        MainAccountant mainAccountant = new MainAccountant("Andrew", "Null", 120);
        mainAccountant.subordinates = new Accountant[1];
        mainAccountant.subordinates[0] = accountant;
        mainAccountant.setDepartmentToSub("Law", 0);
        assertEquals(accountant.department, "Law")  ;
        assertNotEquals(new MainAccountant("Andrew", "Null", 120), new MainAccountant("Andrew", "Null", 130));
        assertEquals(new MainAccountant("Andrew", "Null", 130), new MainAccountant("Andrew", "Null", 130));
    }
}