package test_m;


import com.codeborne.selenide.Condition;

import com.sun.org.glassfish.gmbal.Description;
import framefork.Function;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


import static com.codeborne.selenide.Selenide.$x;

public class Test_mail {
    @Description("Тестовое задание")


    Function functions = new Function();

@BeforeMethod
public void config() {
    functions.Configuration();
    functions.open_page_url("");
}


    @Test
    public void Test() {


        step01();
        step02();
        step03();
    }

    @Step("Авторизация")
    public void step01() {


        functions.login("tmailtestnew", "autotestnew1");


    }

    @Step("Нажать кнопку написать письмо")
    public void step02() {

        $x("//span[text()='Написать письмо']")
                .should(Condition.visible, Duration.ofSeconds(60))
                .click();


    }

    @Step("Написать и отправить письмо")
    public void step03() {

        functions.mail("test@mail.ru", "Добрый день! Это тестовое задание.");

        $x("//span[text()='Отправить']")
                .should(Condition.visible, Duration.ofSeconds(60))
                .click();

    }


}

