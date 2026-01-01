import bank.BankAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assumptions.*;

public class BankAccountAssumptionTests {
    @Test
    @DisplayName("Test account activation after creation")
    public void testHolderNameSet(){
        BankAccount bankAccount = new BankAccount(500000000,0);
        bankAccount.setHolderName("Gedeon");
//        assumeTrue(bankAccount == null,"Account is null");
//        assumeFalse(true,"Account is null");
        assumingThat(bankAccount!=null,()->assertNotNull(bankAccount.isActive()));

    }
}
