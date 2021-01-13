package pages;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {
    protected String title;

    public void isAt() {
        $("title").shouldHave(attribute("text", this.title));
    }
}
