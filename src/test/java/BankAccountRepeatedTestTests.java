import bank.BankAccount;
import dependencies_injection.BankAccountParameterResolver;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountRepeatedTestTests {
    @RepeatedTest(6)
    @DisplayName("Deposit 500 successfully")
    public void testDeposit(BankAccount bankAccount){
        bankAccount.deposit(500);
        assertEquals(500,bankAccount.getBalance());
    }

    @RepeatedTest(6)
    @DisplayName("Deposit 500 successfully")
    public void testDepositRepetitionInfo(BankAccount bankAccount, RepetitionInfo repetitionInfo){
        bankAccount.deposit(500);
        assertEquals(500,bankAccount.getBalance());
        System.out.println(bankAccount.getBalance());
        System.out.println("Nr: "+repetitionInfo.getCurrentRepetition());
    }
}
