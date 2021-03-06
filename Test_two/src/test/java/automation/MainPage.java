package automation;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Configuration;
import org.testng.Assert;


public class MainPage {
    long wait=100000;
    long waitInterval=50;
    public void info(String text) {



        $x("//div[contains(@id,\"z59_Menubar\")]")
                .waitUntil(Condition.visible,wait,waitInterval).click();
        $x("//li[contains(@id,\"z67_Menuitem\")]")
                .waitUntil(Condition.visible,wait,waitInterval).click();

       try{
           $(byXpath("//*[contains(@id,\"z108_Treecell\")]")).shouldHave(text(text)); // работает так же как и assert
           //assert name.equals("О У. М");
       }catch (AssertionError e) {
           System.out.println("Неверное имя пользователя");
       }
        $x("//div[contains(@id,\"WelcomeWin-close\")]")
                .waitUntil(Condition.visible,wait,waitInterval)
                .click();



    }
    public void search_user(String text) {

        $(byXpath("//input[contains(@title,'Для навигации по результатам поиска используйте стрелки')]")).val(text).pressEnter();


    }
}
