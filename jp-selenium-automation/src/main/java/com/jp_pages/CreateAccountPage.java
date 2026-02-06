package com.jp_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class CreateAccountPage {

    WebDriver driver;
    WebDriverWait wait;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    
    private By firstNameField = By.xpath("//input[contains(@placeholder,'First') or contains(@aria-label,'First')]");
    private By lastNameField  = By.xpath("//input[contains(@placeholder,'Last') or contains(@aria-label,'Last')]");
    private By emailField     = By.xpath("//input[contains(@placeholder,'Email') or contains(@aria-label,'Email')]");
    private By phoneField     = By.xpath("//input[contains(@placeholder,'Phone') or contains(@aria-label,'Phone')]");
    private By createAccountButton = By.xpath("//button[contains(text(),'Create Account')]");

    // Error messages locator (all <p> with data-ux='FormError')
    private By errorMessagesContainer = By.xpath("//p[@data-ux='FormError']");

    
    private void typeSlowly(By locator, String text) throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        var element = driver.findElement(locator);
        element.clear();
        for (char c : text.toCharArray()) {
            element.sendKeys(String.valueOf(c));
            Thread.sleep(100);
        }
    }

    public void enterFirstName(String firstName) throws InterruptedException {
        typeSlowly(firstNameField, firstName);
    }

    public void enterLastName(String lastName) throws InterruptedException {
        typeSlowly(lastNameField, lastName);
    }

    public void enterEmail(String email) throws InterruptedException {
        typeSlowly(emailField, email);
    }

    public void enterPhone(String phone) throws InterruptedException {
        typeSlowly(phoneField, phone);
    }

    public void clickCreateAccountButton() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(createAccountButton));
        Thread.sleep(500);
        driver.findElement(createAccountButton).click();
    }

    public void createAccount(String firstName,
                              String lastName,
                              String email,
                              String phone) throws InterruptedException {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterPhone(phone);
        clickCreateAccountButton();
    }

    // ---------------- Error Message Methods ----------------
    public String getErrorMessagesText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessagesContainer));

        return driver.findElements(errorMessagesContainer)
                     .stream()
                     .map(e -> e.getText())
                     .reduce("", (a,b) -> a + "\n" + b); 
    }
}
