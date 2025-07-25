import base.BaseMethods;
import base.BaseTests;
import org.testng.annotations.Test;
import pages.RegisterPage;

public class RegisterTests extends BaseMethods {
    RegisterPage registerPage = new RegisterPage();
    BaseTests baseTests = new BaseTests();

    @Test
    public void SuccessRegister() {
        registerPage.sendKeysRegisterName(registerName)
                .sendKeysRegisterSurname(registerSurname)
                .sendKeysRegisterEmail(registerEmail)
                .sendKeysRegisterPhone(registerPhone)
                .sendKeysRegisterPassword(registerPassword)
                .sendKeysRegisterRepeatPassword(registerRepeatPassword)
                .sendKeysRegisterAcceptConsent()
                .sendKeysRegisterAcceptPolicies()
                .clickRegisterButton();
        baseTests.sleep(5000);
        baseTests.assertEquals(driver.getCurrentUrl(), "https://qrsofra.com/dashboard");


    }
}
