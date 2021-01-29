package skp_kp12;

import automation.LoginPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.BeforeClass;
import org.junit.Test;


public class MainTest {

    LoginPage loginpage = new LoginPage();
    MainPage mainpage = new MainPage();

    @BeforeClass
    public static void setUp() {

        Configuration.browser = "chrome";
        Configuration.timeout = 2000;
        Configuration.startMaximized = true;
        Selenide.clearBrowserCookies();


// Для фаерфокса, окно с крипто все равно игрнорирует что браузер с плагином запустился.
//        ProfilesIni profile = new ProfilesIni();
//        FirefoxProfile testprofile = profile.getProfile("default-release");
//        FirefoxOptions opt = new FirefoxOptions();
//        opt.setProfile(testprofile);
//        Configuration.browserCapabilities = opt;


    }

    @Test
    public void Test() {

        loginpage.open_page_user("http://eb-exp-test-ufos.otr.ru:8889/sufdclient/index.zul");
        loginpage.login("6000_Ivanov6000.II", "1");
        mainpage.folder();
        mainpage.print("КДВ"); //Не совсем поняла надо ли искать и КДВ и КДИ, или только один из них, если все же два по очереди то переменную КДВ можно заменить на КДИ
        mainpage.checkDownloadDocument();


    }


}

