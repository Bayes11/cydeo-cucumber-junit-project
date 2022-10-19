package com.cydeo.step_definitions;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.OrderPage;
import com.cydeo.pages.ViewAllOrdersPage;
import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Order_StepDefinitions {

    OrderPage orderPage = new OrderPage();
    WebTableLoginPage webTableLoginPage = new WebTableLoginPage();
    BasePage basePage = new BasePage();

    ViewAllOrdersPage viewAllOrdersPage = new ViewAllOrdersPage();


    @Given("user is already logged in and on order page")
    public void user_is_already_logged_in_and_on_order_page() {
        Driver.getDriver().get("https://web-table-2.cydeo.com/login");

        webTableLoginPage.login();

        // clicking to "order" link to go to order page
        basePage.order.click();

    }
    @When("user selects product type {string}")
    public void user_selects_product_type(String string) {

        Select select = new Select(orderPage.productDropdown);
        select.selectByVisibleText(string);
    }

    @And("user enters quantity {int}")
    public void userEntersQuantity(int arg0) {

        //to delete the existing data
        //orderPage.quantityBox.sendKeys(Keys.BACK_SPACE);

        orderPage.quantityBox.clear();
        orderPage.quantityBox.sendKeys(arg0 + "");
    }

    @When("user enters costumer name {string}")
    public void user_enters_costumer_name(String string) {
        orderPage.customerNameBox.sendKeys(string);

    }
    @When("user enters street {string}")
    public void user_enters_street(String string) {
        orderPage.streetBox.sendKeys(string);

    }
    @When("user enters city {string}")
    public void user_enters_city(String string) {
        orderPage.cityBox.sendKeys(string);

    }
    @When("user enters state {string}")
    public void user_enters_state(String string) {
        orderPage.stateBox.sendKeys(string);

    }
    @When("user enters zipcode {string}")
    public void user_enters_zipcode(String string) {
        orderPage.zipBox.sendKeys(string);

    }
    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String expectedCardType) {

        //this line will loop through the list and decide which radio button to click
        BrowserUtils.clickRadioButton(orderPage.cardType, expectedCardType);
    }
    @When("user enters credit card number {string}")
    public void user_enters_credit_card_number(String string) {
        orderPage.cardNoBox.sendKeys(string);
    }
    @When("user enters expiry date {string}")
    public void user_enters_expiry_date(String string) {
        orderPage.cardExpBox.sendKeys(string);
    }
    @When("user enters process order button")
    public void user_enters_process_order_button() {
        orderPage.processOrderButton.click();
    }
    @Then("user should see {string} in first row of the web table")
    public void user_should_see_in_first_row_of_the_web_table(String expectedText) {
        String actualName = viewAllOrdersPage.newCustomerCell.getText();
        Assert.assertEquals(expectedText,actualName);


    }


}
