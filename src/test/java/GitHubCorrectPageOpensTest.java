import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class GitHubCorrectPageOpensTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void gitHubCorrectPageOpensTest() {
        //open github main page
        Selenide.open("https://github.com/");
        //click on solutions
        $(".Header-old").$(byText("Solutions")).click();
        //open enterprise page
        $("[aria-labelledby='solutions-for-heading']").$(byText("Enterprise")).click();
        //check whether it has correct text
        $(".application-main h1").shouldHave(text("Build like the best"));
    }
}
