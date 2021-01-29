package skp_kp12;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Configuration;

public class LoginPage {
    long wait=100000;
    long waitInterval=50;

    public void login(String name, String password) {

        $(By.id("user"))
                .waitUntil(Condition.visible,wait,waitInterval)
                .setValue(name);
        $(By.id("psw"))
                .waitUntil(Condition.visible,wait,waitInterval)
                .setValue(password);

        $(By.id("okButton"))
                .waitUntil(Condition.visible,wait,waitInterval)
                .click();
    }
    public void open_page_user(String url) {
        open(url);
    }
}
