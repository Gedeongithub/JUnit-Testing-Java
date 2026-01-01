import bank.BankAccount;
import dependencies_injection.BankAccountParameterResolver;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

@ExtendWith(BankAccountParameterResolver.class)
//THis one can even be put down here, however it will be affect each method running under this class
//@Timeout(value = 5000, unit = TimeUnit.MILLISECONDS)
public class BankAccountTimeoutTest {

    @Test
    @Timeout(value = 5000, unit = TimeUnit.MILLISECONDS)
    public void testDepositTimeoutAssertion(BankAccount bankAccount){
        try{
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Taking too long to deposit");
        }
        bankAccount.deposit(400);
        assertEquals(400,bankAccount.getBalance());


    }

//    @Test
    @RepeatedTest(20)
    public void testDepositTimeoutAnnotation(BankAccount bankAccount){
        assertTimeout(Duration.ofMillis(500),()->{
            bankAccount.deposit(400);
        });
        assertEquals(400,bankAccount.getBalance());
    }
}
