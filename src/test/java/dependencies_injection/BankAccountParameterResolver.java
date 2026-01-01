package dependencies_injection;

import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.extension.*;
import bank.BankAccount;

public class BankAccountParameterResolver  implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == BankAccount.class;
    }

    @Override
    public @Nullable Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return new BankAccount(0,0);
    }
}
