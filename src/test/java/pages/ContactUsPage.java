package pages;

import testData.ContactData;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;

public class ContactUsPage extends BasePage {
    public ContactUsPage() {
        this.title = "ParaBank | Customer Care";
    }
    public void enterContactData(ContactData contactData) {
        $("#name").val(contactData.getName());
        $("#email").val(contactData.getEmail());
        $("#phone").val(contactData.getPhone());
    }
    public void enterMessage(String message) {
        $("#message").val(message);
    }

    public void submitForm() {
        $(byValue("Send to Customer Care")).click();
    }

    public void verifyConfirmationMessageWithNameAppeared(String name) {
        $(byText("Thank you " + name)).shouldBe(visible);
    }

    public void errorMessageAppearedForRequiredField(String field) {
        $(byText(field + " is required."));
    }
}
