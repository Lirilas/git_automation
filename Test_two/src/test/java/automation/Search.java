package automation;


import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class Search {
    public Search search_user(String text) {

                 $(byXpath("//input[contains(@title,'Для навигации по результатам поиска используйте стрелки')]")).val(text).pressEnter();


        return this;
    }
}
