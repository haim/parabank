package pages;

import com.codeborne.selenide.SelenideElement;
import testData.Account;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;

public class OpenNewAccountPage extends BasePage {
    SelenideElement newAccountId =  $("#newAccountId");
    public OpenNewAccountPage() {
        this.title = "ParaBank | Open Account";
    }
    public void createNewAccount(String accountType) {
        $("#type").click();
        $("#type").selectOption(accountType);
        $("#fromAccountId").click();
        $("#type").selectOption(1);
        $(byValue("Open New Account")).click();
    }

    public void confirmationOfCreatedAccountAppeared() {
        $(".title").shouldHave(text("Account Opened!"));
    }

    public void saveAccountNumber(Account account) {
        account.setNumber(Integer.parseInt(newAccountId.getText()));
    }

    public void openNewAccountDetails() {
        newAccountId.click();
    }
}
