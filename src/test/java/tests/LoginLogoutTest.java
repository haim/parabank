package tests;

import org.junit.Test;
import pages.AccountsOverviewPage;
import pages.IndexPage;
import pages.LoginPage;
import pages.widgets.LeftPanel;

public class LoginLogoutTest extends BaseTest {

    @Test
    public void userCanLogin() {
        new LoginPage().login();
        new AccountsOverviewPage().isAt();
    }

    @Test
    public void loggedInUserCanLogout() {
        new LoginPage().login();
        new LeftPanel().selectMenuItem("Log Out");
        new IndexPage().isAt();
    }
}
