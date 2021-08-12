package framefork;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.chrome.ChromeOptions;


import java.time.Duration;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;


public class Function {

    /**
     * Авторизация
     *
     * @param name     -Логин пользователя
     * @param password - Пароль
     */
    public void login(String name, String password) {


        $x("//input[@name='login']")
                .should(Condition.visible, Duration.ofSeconds(60))
                .sendKeys(name);

        $x("//button[@data-testid='enter-password']")
                .should(Condition.visible, Duration.ofSeconds(60))
                .click();

        $x("//input[@name='password']")
                .should(Condition.visible, Duration.ofSeconds(60))
                .sendKeys(password);

        $x("//button[@data-testid='login-to-mail']")
                .should(Condition.visible, Duration.ofSeconds(60))
                .click();


        $x("//*[@class='page default-font theme-default']")
                .should(Condition.visible, Duration.ofSeconds(60));


    }

    /**
     * Новая ссылка
     *
     * @param url -ссылка для открытия
     */
    public void open_page_url(String url) {
        open(url);
    }
    /**
     * Отправка письма
     *
     * @param name_mail -email пользователя кому отправляется письмо
     * @param text_mail -содержание письма
     */
    public void mail(String name_mail, String text_mail) {
        $x("//input[@class='container--H9L5q size_s--3_M-_'][not(@name='Subject')]")
                .should(Condition.visible, Duration.ofSeconds(60))
                .setValue(name_mail);

        $x("//*[contains(@class,'editable-container')]//descendant::div[2]")
                .should(Condition.visible, Duration.ofSeconds(60))
                .click();

        $x("//*[contains(@class,'editable-container')]//descendant::div[2]")
                .should(Condition.visible, Duration.ofSeconds(60))
                .sendKeys(text_mail);
    }

    /**
     * Настройки браузера
     *
     */
    public void Configuration() {

        ChromeOptions options = new ChromeOptions();
        browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        baseUrl="https://mail.ru/";
        //настройки браузера
        browser = CHROME;
        startMaximized = true;
        screenshots = true;



    }

}

