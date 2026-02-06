package com.jp_Test;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.jp_pages.CreateAccountPage;
import com.jp_base.TestBase;
import com.jp_utils.ExcelUtils;

public class CreateAccountTest extends TestBase {

    // ---------------- Old Hard-coded Test (Commented) ----------------
    /*
    @Test
    public void verifyCreateAccount() throws InterruptedException {

        driver.get(driver.getCurrentUrl() + "/m/create-account");

        CreateAccountPage createAccountPage = new CreateAccountPage(driver);

        String firstName = "Riya";
        String lastName  = "Sharma";
        String email     = "riya" + System.currentTimeMillis() + "@gmail.com";
        String phone     = "9876543210";

        createAccountPage.createAccount(firstName, lastName, email, phone);
    }
    */

    // ---------------- New Test Using Excel ----------------
    @Test
    public void verifyCreateAccountUsingExcel() throws InterruptedException {

        driver.get(driver.getCurrentUrl() + "/m/create-account");

        CreateAccountPage createAccountPage = new CreateAccountPage(driver);

        String filePath = "src/test/resources/CreateAccountData.xlsx";

        String firstName = ExcelUtils.getCellData(filePath, "Sheet1", 1, 0);
        String lastName  = ExcelUtils.getCellData(filePath, "Sheet1", 1, 1);
        String email     = ExcelUtils.getCellData(filePath, "Sheet1", 1, 2);
        String phone     = ExcelUtils.getCellData(filePath, "Sheet1", 1, 3);

        createAccountPage.createAccount(firstName, lastName, email, phone);
    }

    // ---------------- Error Message Test ----------------
    @Test
    public void verifyErrorMessagesForEmptyFields() throws InterruptedException {

        driver.get(driver.getCurrentUrl() + "/m/create-account");

        CreateAccountPage createAccountPage = new CreateAccountPage(driver);

        createAccountPage.clickCreateAccountButton();

        String allErrors = createAccountPage.getErrorMessagesText();

        Assert.assertTrue(allErrors.contains("Enter your first name."));
        Assert.assertTrue(allErrors.contains("Enter your last name."));
        Assert.assertTrue(allErrors.contains("Enter a valid email address."));
        // Phone has no validation, so skip
    }
}
