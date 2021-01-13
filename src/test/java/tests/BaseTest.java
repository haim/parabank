package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.*;

public abstract class BaseTest {
    @Before
    public void setUp() {
        Configuration.baseUrl = "https://parabank.parasoft.com/parabank";
        setupAllureReports();
        open("/index.htm");
    }

    @After
    public void tearDown() {
        closeWebDriver();

    }

    public void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false)
        );
    }
}
