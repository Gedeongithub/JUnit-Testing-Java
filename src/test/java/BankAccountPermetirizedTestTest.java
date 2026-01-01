import bank.BankAccount;
import dependencies_injection.BankAccountParameterResolver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;


import java.time.DayOfWeek;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountPermetirizedTestTest {

    @ParameterizedTest
    @ValueSource(ints = {400,500,600,700})
    @DisplayName("Deposit 500 successfully")
    public void testDepositRepetitionInfo(int amount,BankAccount bankAccount){
        bankAccount.deposit(amount);
        assertEquals(amount,bankAccount.getBalance());
        System.out.println(bankAccount.getBalance());
    }

    @ParameterizedTest
    @CsvSource({"10000, Gedeon", "500, Ted", "6000,Fuad"})
    public void testDepositAndName(double amount, String name, BankAccount bankAccount){
        bankAccount.deposit(amount);
        bankAccount.setHolderName(name);
        assertEquals(amount,bankAccount.getBalance());
        assertEquals(name,bankAccount.getHolderName());

    }

    @ParameterizedTest
    @CsvFileSource(resources = "customer.csv")
    public void testDepositAndNameFromCsvFile(double amount, String name, BankAccount bankAccount){
        bankAccount.deposit(amount);
        bankAccount.setHolderName(name);
        assertEquals(amount,bankAccount.getBalance());
        assertEquals(name,bankAccount.getHolderName());

    }

    @ParameterizedTest
    @EnumSource(value = DayOfWeek.class,names = {"TUESDAY","THURSDAY"})
    public void testDayOfWeek(DayOfWeek day){
        assertTrue(day.toString().startsWith("T"));
    }

}
