package pages;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public void login() {
        $(byName("username")).val("john");
        $(byName("password")).val("demo");
        $(byValue("Log In")).click();
    }
}
