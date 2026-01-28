package com.jp_tests;

import com.jp_base.TestBase;
import com.jp_pages.CreateAccountPage;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {

    @Test
    public void createAccountTest() {

        CreateAccountPage cap = new CreateAccountPage(driver);

        // ✅ VERY IMPORTANT
        cap.acceptCookiesIfPresent();

        cap.enterFirstName("John");
        cap.enterLastName("Doe");
        cap.enterEmail("john" + System.currentTimeMillis() + "@test.com");
        cap.enterPassword("Test@1234");

        cap.clickSubmit();
    }
}
