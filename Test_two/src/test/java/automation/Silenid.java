package automation;

import org.junit.BeforeClass;
import org.junit.Test;

import com.codeborne.selenide.Configuration;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;



public class Silenid { 



    @BeforeClass // Выполнится перед тестом
    public static void setUp() {  // Статический класс

        Configuration.browser = "firefox";
        Configuration.timeout = 6000;
        Configuration.startMaximized = true;

          }

    @Test
    public void user_login(){

        ProfilePage loginpage = new ProfilePage();
        Inf_System Properties_info = new Inf_System();
        Search search_nav = new Search();
        loginpage.open_page_user("http://eb-arp-dev-ufos.otr.ru:8889/sufdclient/index.zul");
        loginpage.login("MOU","Qwerty1234");
        Properties_info.info("О У. М");
        search_nav.search_user("Отчетные периоды");

        sleep(2000);


            }
    }




