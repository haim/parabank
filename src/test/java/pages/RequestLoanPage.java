package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;

public class RequestLoanPage extends BasePage {
    public RequestLoanPage() {
        this.title = "ParaBank | Loan Request";
    }
    public void applyForLoan() {
        $("#amount").val();
        $("#downPayment").val();
    }

    public void setLoanAmount(int amount) {
        $("#amount").val(String.valueOf(amount));
    }

    public void setDownPayment(int downPayment) {
        $("#downPayment").val(String.valueOf(downPayment));
    }

    public void submitForm() {
        $(byValue("Apply Now")).click();
    }

    public void verifyLoanIsProcessed() {
        $(byText("Loan Request Processed")).shouldBe(visible);
    }

    public void verifyErrorIsDisplayed() {
        $(byText("Error!")).shouldBe(visible);
    }
}
