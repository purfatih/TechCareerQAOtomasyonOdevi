import base.BaseMethods;
import base.BaseTests;
import org.testng.annotations.Test;
import pages.RegisterPage;

public class RegisterTests extends BaseMethods {
    RegisterPage registerPage = new RegisterPage();
    BaseTests baseTests = new BaseTests();

    // başarılı kullanıcı oluşturma testi

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

    // giriş yap butonunun aktifliği testi

    @Test(description = "TC002 - Register sayfasındaki Giriş Yap butonunun çalışması test edilir.")
    public void CheckLogin() {
        registerPage.clickLoginButton();
        baseTests.sleep(3000);
        baseTests.assertEquals(driver.getCurrentUrl(), "https://qrsofra.com/auth/jwt/sign-in");
    }

    // başarısız kullanıcı oluşturma testleri

    @Test(description = "TC003 - Varolan bir kullanıcı ile kayıt olma işlemi test edilir.")
    public void ExistingUserRegisterTest() {
        registerPage.sendKeysRegisterName(registerName)
                .sendKeysRegisterSurname(registerSurname)
                .sendKeysRegisterEmail("fatihnuripur@gmail.com")
                .sendKeysRegisterPhone(registerPhone)
                .sendKeysRegisterPassword(registerPassword)
                .sendKeysRegisterRepeatPassword(registerRepeatPassword)
                .sendKeysRegisterAcceptConsent()
                .sendKeysRegisterAcceptPolicies()
                .clickRegisterButton();
        baseTests.sleep(3000);
        baseTests.assertEquals(registerPage.getExistingUserErrorMessage(), "Bu e-posta veya telefon numarası ile daha önce hesap oluşturulmuş!");
    }

    @Test(description = "TC004 - E-posta alanına emoji ve özel semboller girildiğinde sistemin geçersiz e-mail uyarısı vermesi test edilir.")
    public void CheckEmailWithSymbol() {
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
        baseTests.assertEquals(registerPage.getEmailErrorMessage(), "Email geçerli bir email adresi olmalıdır!");
    }

    @Test(description = "TC005 - E-posta alanı boş bırakıldığında hata vermesi test edilir.")
    public void EmptyEmailFieldCheck() {
        registerPage.sendKeysRegisterName(registerName)
                .sendKeysRegisterSurname(registerSurname)
                .sendKeysRegisterEmail("")
                .sendKeysRegisterPhone(registerPhone)
                .sendKeysRegisterPassword(registerPassword)
                .sendKeysRegisterRepeatPassword(registerRepeatPassword)
                .sendKeysRegisterAcceptConsent()
                .sendKeysRegisterAcceptPolicies()
                .clickRegisterButton();
        baseTests.sleep(3000);
        baseTests.assertEquals(registerPage.getEmailErrorMessage(), "Email alanı zorunludur!");
    }

    @Test(description = "TC006 - İsim alanı boş bırakıldığında hata vermesi test edilir.")
    public void EmptyNameFieldCheck() {
        registerPage.sendKeysRegisterName("")
                .sendKeysRegisterSurname(registerSurname)
                .sendKeysRegisterEmail(registerEmail)
                .sendKeysRegisterPhone(registerPhone)
                .sendKeysRegisterPassword(registerPassword)
                .sendKeysRegisterRepeatPassword(registerRepeatPassword)
                .sendKeysRegisterAcceptConsent()
                .sendKeysRegisterAcceptPolicies()
                .clickRegisterButton();
        baseTests.sleep(3000);
        baseTests.assertEquals(registerPage.getNameErrorMessage(), "İsim alanı zorunludur!");
    }

    @Test(description = "TC007 - Soyisim alanı boş bırakıldığında hata vermesi test edilir.")
    public void EmptySurnameFieldCheck() {
        registerPage.sendKeysRegisterName(registerName)
                .sendKeysRegisterSurname("")
                .sendKeysRegisterEmail(registerEmail)
                .sendKeysRegisterPhone(registerPhone)
                .sendKeysRegisterPassword(registerPassword)
                .sendKeysRegisterRepeatPassword(registerRepeatPassword)
                .sendKeysRegisterAcceptConsent()
                .sendKeysRegisterAcceptPolicies()
                .clickRegisterButton();
        baseTests.sleep(3000);
        baseTests.assertEquals(registerPage.getSurnameErrorMessage(), "Soyisim alanı zorunludur!");
    }
}
