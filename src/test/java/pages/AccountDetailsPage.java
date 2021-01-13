package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class AccountDetailsPage extends BasePage {
    public AccountDetailsPage() {
        this.title = "ParaBank | Account Activity";
    }
    public void verifyAccountTypeIs(String expectedAccountType) {
        $("#accountType").shouldHave(Condition.text(expectedAccountType));
    }

    public void verifyAccountNumberIs(String expectedAccountNumber) {
        $("#accountId").shouldHave(Condition.text(expectedAccountNumber));
    }
}
