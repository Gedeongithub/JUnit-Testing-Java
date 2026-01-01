import bank.BankAccount;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BankAccountBeforeAndAfterTest {

      BankAccount bankAccount;
     @BeforeAll
     public void runBefore(){
         bankAccount = new BankAccount(500,0);
     }

    @Test
    void testWithdraw() {
        bankAccount.withdraw(300);
        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    @Disabled("Temporarily disabled for maintenance")
    void testDeposit() {
        bankAccount.deposit(500);
        assertEquals(700, bankAccount.getBalance());
    }

    @AfterAll
    public void tearDown(){
        System.out.println("Bye");
    }
}
