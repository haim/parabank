package tests;

import org.junit.Test;
import pages.LoginPage;
import pages.RequestLoanPage;
import pages.widgets.LeftPanel;

public class RequestLoanTest extends BaseTest {
    @Test
    public void ApplyForLoan() {
        new LoginPage().login();

        new LeftPanel().selectMenuItem("Request Loan");
        RequestLoanPage requestLoanPage = new RequestLoanPage();
        requestLoanPage.isAt();
        requestLoanPage.setLoanAmount(1);
        requestLoanPage.setDownPayment(1);
        requestLoanPage.submitForm();

        requestLoanPage.verifyLoanIsProcessed();
    }

    @Test
    public void errorAppearsAfterSubmittingFormWithoutRequiredFieldsFilledIn() {
        new LoginPage().login();

        new LeftPanel().selectMenuItem("Request Loan");
        RequestLoanPage requestLoanPage = new RequestLoanPage();
        requestLoanPage.submitForm();

        requestLoanPage.verifyErrorIsDisplayed();
    }
}
