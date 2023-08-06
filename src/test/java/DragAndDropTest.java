import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class DragAndDropTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Selenide.open("https://the-internet.herokuapp.com/drag_and_drop");
    }

    @Test
    void dragAndDropTest() {
        //move element
        actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().perform();
        //check if drag and drop worked
        $("#column-a").shouldHave(Condition.text("B"));
        $("#column-b").shouldHave(Condition.text("A"));
    }

    @Test
    void dragAndDropSelenideTest() {
        //selenide drag and drop
        $("#column-a").dragAndDropTo($("#column-b"));
        //check if drag and drop worked
        $("#column-a").shouldHave(Condition.text("B"));
        $("#column-b").shouldHave(Condition.text("A"));
    }
}
