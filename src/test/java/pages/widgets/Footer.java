package pages.widgets;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Footer {
    private SelenideElement container = $("#footerPanel");
    public void clickLinkByText(String linkText) {
        container.$(byText(linkText)).click();
    }
}
