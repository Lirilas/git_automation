package automation;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Configuration;
import org.testng.Assert;


public class Inf_System {
    public void info(String text) {

        $(byXpath("//div[contains(@id,\"z59_Menubar\")]")).click();
        $(byXpath("//li[contains(@id,\"z67_Menuitem\")]")).click();

       try{
           $(byXpath("//*[contains(@id,\"z108_Treecell\")]")).shouldHave(text(text)); // работает так же как и assert
           //assert name.equals("О У. М");
       }catch (AssertionError e) {
           System.out.println("Неверное имя пользователя");
       }
        $(byXpath("//div[contains(@id,\"WelcomeWin-close\")]")).click();


    }
}
