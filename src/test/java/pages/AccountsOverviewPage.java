package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AccountsOverviewPage extends BasePage {
    public AccountsOverviewPage () {
        this.title = "ParaBank | Accounts Overview";
    }

    public void verifyAccountNumberIsPresented(String accountNumber) {
        $("tbody").shouldHave(text(accountNumber));
    }
}
