import bank.BankAccount;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(dependencies_injection.BankAccountParameterResolver.class)
public class BankAccountDITests {

    @Test
    @DisplayName("Deposit 500 successfully")
    public void testDeposit(BankAccount bankAccount){
        bankAccount.deposit(500);
        assertEquals(500,bankAccount.getBalance());
    }
}
