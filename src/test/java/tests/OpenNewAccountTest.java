package tests;

import org.junit.Test;
import pages.AccountDetailsPage;
import pages.AccountsOverviewPage;
import pages.LoginPage;
import pages.OpenNewAccountPage;
import pages.widgets.LeftPanel;
import testData.Account;

public class OpenNewAccountTest extends BaseTest{
    @Test
    public void userCanCreateAccount() {
        new LoginPage().login();

        LeftPanel leftPanel = new LeftPanel();
        leftPanel.selectMenuItem("Open New Account");
        Account account = new Account("SAVINGS");
        OpenNewAccountPage openNewAccountPage = new OpenNewAccountPage();
        openNewAccountPage.createNewAccount(account.getType());
        openNewAccountPage.confirmationOfCreatedAccountAppeared();
        openNewAccountPage.saveAccountNumber(account);
        openNewAccountPage.openNewAccountDetails();

        AccountDetailsPage accountDetailsPage = new AccountDetailsPage();
        String accountNumber = account.getStringValueOfNumber();
        accountDetailsPage.verifyAccountNumberIs(accountNumber);
        accountDetailsPage.verifyAccountTypeIs(account.getType());

        leftPanel.selectMenuItem("Accounts Overview");
        new AccountsOverviewPage().verifyAccountNumberIsPresented(accountNumber);
    }
}
