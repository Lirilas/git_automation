package automation;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Configuration;

public class ProfilePage {
     //   String name="MOU";
   // String password="Qwerty1234";

    public void login(String name, String password) {

        $(By.id("user")).setValue(name);
        $(By.id("psw")).setValue(password);
        $(By.id("okButton")).click();
    }
    public void open_page_user(String url) {
        open(url);
    }
}
