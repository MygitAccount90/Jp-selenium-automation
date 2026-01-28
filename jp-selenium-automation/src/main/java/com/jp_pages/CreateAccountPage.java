package com.jp_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateAccountPage {

    WebDriver driver;
    WebDriverWait wait;

    
    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    
    By firstName = By.xpath("//input[@placeholder='First Name']");
    By lastName  = By.xpath("//input[@placeholder='Last Name']");
    By email     = By.xpath("//input[@placeholder='Email']");
    By password  = By.xpath("//input[@placeholder='Password']");
    By submitBtn = By.xpath("//button[@type='submit' or contains(text(),'Create')]");

    
    public void enterFirstName(String fname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName))
                .sendKeys(fname);
    }

    public void enterLastName(String lname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastName))
                .sendKeys(lname);
    }

    public void enterEmail(String mail) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(email))
                .sendKeys(mail);
    }

    public void enterPassword(String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(password))
                .sendKeys(pass);
    }

    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn))
                .click();
    }
}
