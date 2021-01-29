package automation;

import org.junit.BeforeClass;
import org.junit.Test;

import com.codeborne.selenide.Configuration;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;



public class Silenid {

    LoginPage loginpage = new LoginPage();
    MainPage main = new MainPage();

    @BeforeClass // Выполнится перед тестом
    public static void setUp() {  // Статический класс

        Configuration.browser = "firefox";
        Configuration.timeout = 2000;
        Configuration.startMaximized = true;

          }

    @Test
    public void Test(){

        loginpage.open_page_user("http://eb-arp-dev-ufos.otr.ru:8889/sufdclient/index.zul");
        loginpage.login("MOU","Qwerty1234");
        main.info("О У. М");
        main.search_user("Отчетные периоды");

        sleep(2000);


            }
    }




