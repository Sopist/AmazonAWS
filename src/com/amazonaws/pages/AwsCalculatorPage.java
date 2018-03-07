package com.amazonaws.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazonaws.utilities.Driver;

public class AwsCalculatorPage {
	
	private WebDriver driver;
	
	public AwsCalculatorPage() {
		this.driver = Driver.getDriver(null);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "billLabel")
	public WebElement billLabel;
	
	@FindBy(xpath = "(//div[@class='gwt-PushButton small gwt-PushButton-up'])[1]/img")
	public WebElement addEC2;
	
	@FindBy(xpath = "//table[@class='SF_EC2_INSTANCE_FIELD_DESCRIPTION field textField']//input")
	public WebElement description;
	
	@FindBy(xpath = "//table[@class='SF_EC2_INSTANCE_FIELD_INSTANCES field integerNumericField']//input")
	public WebElement instances;
	
	@FindBy(xpath = "//table[@class='SF_EC2_INSTANCE_FIELD_USAGE field usageField']//input")
	public WebElement usage;
	
	@FindBy(xpath = "//table[@class='SF_EC2_INSTANCE_FIELD_USAGE field usageField']//select")
	public WebElement usageList;
	
	
	public boolean isAt() {
		return driver.getTitle().equals("Amazon Web Services Simple Monthly Calculator");
	}
	
	public double getMonthlyBill() {
		String text = billLabel.getText();
		String[] array = text.split("\\$ "); // $ cannot stand alone bc it has meaning so need \\$
		text = array[1].replace(")", "");
		return Double.parseDouble(text);
		// return Double.parseDouble(billLabel.getText().split("$ ")[1].replace(")", "")); // chain in one line
	}
	
	public int getInstanceCount() {
		return Integer.parseInt(instances.getAttribute("value"));
	}
	
//	public int get
	
	
	

}
