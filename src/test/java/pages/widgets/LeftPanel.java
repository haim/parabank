package pages.widgets;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LeftPanel {
    private SelenideElement container = $("#leftPanel");
    public void selectMenuItem(String menuItem) {
        container.$(byText(menuItem)).click();
    }
}
