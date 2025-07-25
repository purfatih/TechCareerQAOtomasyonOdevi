import base.BaseMethods;
import base.BaseTests;
import org.testng.annotations.Test;
import pages.RegisterPage;

public class RegisterTests extends BaseMethods {
    RegisterPage registerPage = new RegisterPage();
    BaseTests baseTests = new BaseTests();

    @Test(description = "TC001 - Başarılı kullanıcı kaydı oluşturma test edilir.")
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
        baseTests.sleep(3000);
        baseTests.assertEquals(driver.getCurrentUrl(), "https://qrsofra.com/dashboard");


    }
    @Test(description = "TC002 - Register sayfasındaki Giriş Yap butonunun çalışması test edilir.")
    public void CheckLogin(){
        registerPage.clickLoginButton();
        baseTests.sleep(3000);
        baseTests.assertEquals(driver.getCurrentUrl(), "https://qrsofra.com/auth/jwt/sign-in");
    }
    @Test(description = "TC003 - E-posta alanına emoji ve özel semboller girildiğinde sistemin geçersiz e-mail uyarısı vermesi test edilir.")
    public void CheckEmailWithSymbol(){
        registerPage.sendKeysRegisterName(registerName)
                .sendKeysRegisterSurname(registerSurname)
                .sendKeysRegisterEmail("automation#@gmail.com")
                // emoji girildiğinde de hata alınıyor.
                .sendKeysRegisterPhone(registerPhone)
                .sendKeysRegisterPassword(registerPassword)
                .sendKeysRegisterRepeatPassword(registerRepeatPassword)
                .sendKeysRegisterAcceptConsent()
                .sendKeysRegisterAcceptPolicies()
                .clickRegisterButton();
        baseTests.sleep(3000);
        baseTests.assertEquals(registerPage.getEmailSymbolErrorMessage(), "Email geçerli bir email adresi olmalıdır!");
    }
}
