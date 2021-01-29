package skp_kp12;

import com.codeborne.selenide.Condition;
import org.junit.Assert;
import org.openqa.selenium.By;


import java.io.File;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;


public class MainPage {
    long wait = 100000;
    long wait_button = 5000;
    long waitInterval = 50;
    String array[] = {"XLS", "RTF", "PDF", ""};
    String name_pdf = "Платежное поручение № 600400 от 25.08.2020.PDF";
    String path = "C:\\git_automation\\Test_two\\build\\downloads\\";
/*
    public boolean exist() {
        try {
            $x("//button[contains(@class,\"filter-button filter-plank-cancel-button z-button\")]")
                    .waitUntil(Condition.exist, wait_button, waitInterval)
                    .should(Condition.exist);
            System.out.println("НАшел");

            return true;
        } catch (AssertionError e) {
            System.out.println("Не нашел");
            return false;

        }


    }
*/ //Работает не верно

    public void folder() {


        $x(".//div/span[text()=' Все сервисы']") // Все сервисы
                .waitUntil(Condition.visible, wait, waitInterval).click();

        $x(".//div/span[text()=' Компонент санкционирования расходов: ПБС, ИПБС, АИФ']") // Компонент
                .waitUntil(Condition.visible, wait, waitInterval).click();


        $x(".//div/span[text()=' Расчетные документы']") // Расчетные документы
                .waitUntil(Condition.visible, wait, waitInterval).click();

        $x(".//div/span[text()=' Платежное поручение']")//Платежное поручение
                .waitUntil(Condition.visible, wait, waitInterval).click();

        $x("//tr[contains(@title,\"Все документы (ТОФК)\")]//div[1]") //Все документы
                .waitUntil(Condition.visible, wait, waitInterval).click();


    }


    public void print(String filter) {
        try {


            $x("//img[contains(@class,\"filterToggler z-image\")]")
                    .waitUntil(Condition.visible, wait, waitInterval)
                    .click();

            $x("//input[contains(@filter-for,\"BRE_POTYPE\")]")
                    .waitUntil(Condition.visible, wait, waitInterval)
                    .setValue(filter)
                    .pressEnter();

            $x("//div[contains(@class,\"z-listboxfakepaging-body z-word-nowrap\")]//tr[1]//span[contains(@class,\"z-listitem-checkable z-listitem-checkbox\")]")
                    .waitUntil(Condition.visible, wait, waitInterval)
                    .click();


            for (int i = 0; i < 3; i++) {
                $x("//button[contains(@title,\"Печать документа\")]")
                        .waitUntil(Condition.visible, wait, waitInterval)
                        .click();

                if (i > 0) {

                    $x("//span[contains(text(),\"Документ " + array[i] + "\")]")
                            .waitUntil(Condition.visible, wait, waitInterval)
                            .click();
                }
                $x("//button[contains(@title,\"OK\")]")
                        .waitUntil(Condition.visible, wait, waitInterval)
                        .click();


            }
            sleep(2000); //Чтобы фалы все скачались

        } finally {

            $x("//button[contains(@class,\"filter-button filter-plank-cancel-button z-button\")]")
                    .waitUntil(Condition.visible, wait, waitInterval)
                    .click();

        }
    }

    public void checkDownloadDocument() {
        int counter = 1;
        try {
            File folder = new File(path);
            File[] files = folder.listFiles();
            for (File file : files) {
                String name = file.getName();
                System.out.println(name + " " + file.getAbsolutePath());
                counter++;
            }



    } finally

    {
         counter = 1;
        File folder = new File(path);
        File[] files = folder.listFiles();
        for (File file : files) {
            file.delete();
            counter++;
        }


    }


}


}

