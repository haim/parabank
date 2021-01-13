package tests;

import org.junit.Test;
import pages.ContactUsPage;
import pages.LoginPage;
import pages.widgets.Footer;
import testData.ContactData;

public class ContactUsTest extends BaseTest {
    @Test
    public void submittingFormWithFilledInRequiredFields() {
        new LoginPage().login();

        new Footer().clickLinkByText("Contact Us");
        ContactUsPage contactUsPage = new ContactUsPage();
        contactUsPage.isAt();

        ContactData contactData = new ContactData(
                "Matilda", "matilda@test.com", "5558810");
        contactUsPage.enterContactData(contactData);
        contactUsPage.enterMessage("test message");
        contactUsPage.submitForm();

        contactUsPage.verifyConfirmationMessageWithNameAppeared(
                contactData.getName());
    }

    @Test
    public void submittingFormWithoutFilledInContactDataIsRestricted() {
        new LoginPage().login();

        new Footer().clickLinkByText("Contact Us");
        ContactUsPage contactUsPage = new ContactUsPage();
        contactUsPage.enterMessage("test message");
        contactUsPage.submitForm();

        contactUsPage.errorMessageAppearedForRequiredField("Name");
        contactUsPage.errorMessageAppearedForRequiredField("Email");
        contactUsPage.errorMessageAppearedForRequiredField("Phone");
    }

    @Test
    public void submittingFormWithoutFilledInMessageIsRestricted() {
        new LoginPage().login();

        new Footer().clickLinkByText("Contact Us");
        ContactUsPage contactUsPage = new ContactUsPage();
        ContactData contactData = new ContactData(
                "Neo", "neo@test.com", "5551190");
        contactUsPage.enterContactData(contactData);
        contactUsPage.submitForm();

        contactUsPage.errorMessageAppearedForRequiredField("Message");
    }
}
