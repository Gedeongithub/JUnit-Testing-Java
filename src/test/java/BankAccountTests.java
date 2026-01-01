import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Bank account class")
public class BankAccountTests {
    @Test
    @DisplayName("Withdraw 500 successfully")
    public void testWithdraw(){
        BankAccount bankAccount = new BankAccount(500,-1000);
        bankAccount.withdraw(300);
        assertEquals(200,bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposit 400 successfully")
    public void testDeposit(){
        BankAccount bankAccount = new BankAccount(400,0);
        bankAccount.deposit(500);
        assertEquals(900,bankAccount.getBalance());
    }

    @Test
    @DisplayName("Withdraw' ll become negative")
    public void testWithdrawNotStuckAtZero(){
        BankAccount bankAccount = new BankAccount(500,-1000);
        bankAccount.withdraw(800);
        System.out.println(bankAccount.getBalance());
        assertNotEquals(0,bankAccount.getBalance());
    }

    @Test
    @DisplayName("Account activation")
    public void testActive(){
        BankAccount bankAccount = new BankAccount(500,0);
        assertTrue(bankAccount.isActive());
    }

    @Test
    @DisplayName("Account holder name")
    public void testHolderNameSet(){
        BankAccount bankAccount = new BankAccount(500000000,0);
        bankAccount.setHolderName("Gedeon");
        assertNotNull(bankAccount.getHolderName());
    }

    @Test
    @DisplayName("Test no withdraw below minimum")
    public void testNoWithdrawBelowMinum(){
        BankAccount bankAccount = new BankAccount(500,-1000);
        assertThrows(RuntimeException.class,()->bankAccount.withdraw(2000));
    }

    @Test
    @DisplayName("Test both withdraw and deposit with no execption")
    public void testWithdrawAndDepositWithNoException(){
        BankAccount bankAccount = new BankAccount(500,-1000);
        assertAll(()->bankAccount.deposit(200),()->bankAccount.withdraw(450));
    }

    @Test
    @DisplayName("Test speed to deposit")
    public void testDepositSpeed(){
        BankAccount bankAccount = new BankAccount(500,0);
        assertTimeout(Duration.ofNanos(1),()->bankAccount.deposit(500));
    }

}
