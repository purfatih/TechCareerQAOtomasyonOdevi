package pages;

import base.BaseMethods;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class RegisterPage extends BaseMethods {

    @Step("Üyelik kaydı için isim alanı doldurulur.")
    public RegisterPage sendKeysRegisterName(String text) {
        driver.findElement(By.id(":r0:")).sendKeys(text);
        return this;
    }

    @Step("Üyelik kaydı için soyisim alanı doldurulur.")
    public RegisterPage sendKeysRegisterSurname(String text) {
        driver.findElement(By.id(":r1:")).sendKeys(text);
        return this;
    }

    @Step("Üyelik kaydı için e-mail alanı doldurulur.")
    public RegisterPage sendKeysRegisterEmail(String text) {
        driver.findElement(By.id(":r2:")).sendKeys(text);
        return this;
    }

    @Step("Üyelik kaydı için telefon alanı doldurulur.")
    public RegisterPage sendKeysRegisterPhone(String text) {
        driver.findElement(By.id(":r3:")).sendKeys(text
        );
        return this;
    }

    @Step("Üyelik kaydı için şifre alanı doldurulur.")
    public RegisterPage sendKeysRegisterPassword(String text) {
        driver.findElement(By.id(":r4:")).sendKeys(text);
        return this;
    }

    @Step("Üyelik kaydı için şifre alanı doldurulur.")
    public RegisterPage sendKeysRegisterRepeatPassword(String text) {
        driver.findElement(By.id(":r5:")).sendKeys(text);
        return this;
    }

    @Step("Üyelik kaydı için açık rıza metni alanı seçilir.")
    public RegisterPage sendKeysRegisterAcceptConsent() {
        driver.findElement(By.name("analyticsConsent")).click();
        return this;
    }

    @Step("Üyelik kaydı için hizmet şartları ve gizlilik politikası alanı seçilir.")
    public RegisterPage sendKeysRegisterAcceptPolicies() {
        driver.findElement(By.name("policiesAccepted")).click();
        return this;
    }

    @Step("Üyelik kaydı için Hesap Oluştur butonuna tıklanır.")
    public RegisterPage clickRegisterButton() {
        driver.findElement(By.id(":r6:")).click();
        return this;
    }
    @Step("Göz ikonuna tıklanarak şifrenin görünürlüğü test edilir.")
    public RegisterPage clickPasswordEyeIcon() {
        driver.findElement(By.cssSelector("[class='iconify iconify--solar mnl__icon__root MuiBox-root css-cnvj7y']")).click();
        return this;
    }
    @Step("'Giriş Yap' butonuna tıklanarak, ilgili sayfaya yönlendirme yapıp yapmadığı kontrol edilir.")
    public RegisterPage clickLoginButton() {
        driver.findElement(By.cssSelector("[class='MuiTypography-root MuiTypography-subtitle2 MuiLink-root MuiLink-underlineHover css-z8j0pw']")).click();
        return this;
    }

    @Step("Üyelik kaydı için isim alanı boş bırakıldığında hata alınır.")
    public String getNameErrorMessage() {
        String text = driver.findElement(By.id(":r0:-helper-text")).getText();
        return text;
    }

    @Step("Üyelik kaydı için soyisim alanı boş bırakıldığında hata alınır.")
    public String getSurnameErrorMessage() {
        String text = driver.findElement(By.id(":r1:-helper-text")).getText();
        return text;
    }

    @Step("Üyelik kaydı için geçersiz e-mail girildiğinde hata alınır.")
    public String getEmailErrorMessage() {
        String text = driver.findElement(By.id(":r2:-helper-text")).getText();
        return text;
    }

    @Step("Varolan  bir kullanıcı ile kayıt olma işlemi yapıldığında hata alınır.")
    public String getExistingUserErrorMessage() {
        String text = driver.findElement(By.cssSelector("[class='MuiAlert-message css-1xsto0d']")).getText();
        return text;
    }
    @Step("Şifre 6 karakterden daha az girilir ise hata alınır.")
    public String getPasswordError() {
        String text = driver.findElement(By.id(":r4:-helper-text")).getText();
        return text;
    }
    @Step("Telefon numarası hatalı formatta girilir ise hata alınır.")
    public String getPhoneNumberError() {
        String text = driver.findElement(By.id(":r3:-helper-text")).getText();
        return text;
    }
}
