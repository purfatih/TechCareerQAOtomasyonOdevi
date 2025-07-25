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

    @Step("Üyelik kaydı için kayıt ol butonuna tıklanır.")
    public RegisterPage clickRegisterButton() {
        driver.findElement(By.id(":r6:")).click();
        return this;
    }
    @Step("'Giriş Yap' butonuna tıklanarak, ilgili sayfaya yönlendirme yapıp yapmadığı kontrol edilir.")
    public RegisterPage clickLoginButton() {
        driver.findElement(By.cssSelector("[class='MuiTypography-root MuiTypography-subtitle2 MuiLink-root MuiLink-underlineHover css-z8j0pw']")).click();
        return this;
    }
}
