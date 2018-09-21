package pages;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import config.FormData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Date;

public class SignUp extends BasePage {

    public SignUp(){ super(); }

    @FindBy(id = "id_gender1")
    WebElement maleRadioButton;

    @FindBy(id = "id_gender2")
    WebElement femaleRadioButton;

    @FindBy(id = "customer_firstname")
    WebElement firstName;

    @FindBy(id = "customer_lastname")
    WebElement lastName;

    @FindBy(id = "passwd")
    WebElement password;

    @FindBy(id = "days")
    WebElement days;
    Select birthdateDays = new Select(days);

    @FindBy(id = "months")
    WebElement months;
    Select birthdateMonths = new Select(months);

    @FindBy(id = "years")
    WebElement years;
    Select birthdateYears = new Select(years);

    @FindBy(id = "firstname")
    WebElement addressFirstName;

    @FindBy(id = "lastname")
    WebElement addressLastName;

    @FindBy(id = "company")
    WebElement company;

    @FindBy(id = "address1")
    WebElement addressFirstLine;

    @FindBy(id = "address2")
    WebElement addressSecondLine;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "id_state")
    WebElement state;
    Select selectState = new Select(state);

    @FindBy(id = "postcode")
    WebElement postcode;

    @FindBy(id = "id_country")
    WebElement country;
    Select selectCountry = new Select(country);

    @FindBy(id = "other")
    WebElement additionalInfo;

    @FindBy(id = "phone")
    WebElement phoneNo;

    @FindBy(id = "phone_mobile")
    WebElement mobilePhoneNo;

    @FindBy(id = "alias")
    WebElement addressAlias;

    @FindBy(id = "submitAccount")
    WebElement registerButton;



    public void fillFormWithData(FormData data){
        /**
         *      Fills the form with the data supplied as parameters.
         *      Use "random" in case of strings and 0 in case of ints
         *      for random inputs.
         */


        Faker faker = new Faker();

        if(faker.bool().bool()) {
            this.maleRadioButton.click();
        }else {
            this.femaleRadioButton.click();
        }

        this.firstName.sendKeys(data.firstname.equals("random")? faker.name().firstName() : data.firstname);
        this.lastName.sendKeys(data.lastname.equals("random")? faker.name().lastName() : data.lastname);
        this.password.sendKeys(data.password.equals("random")? faker.internet().password() : data.password);

        this.birthdateDays.selectByValue(data.day == 0? Integer.toString(faker.random().nextInt(1,28)) : Integer.toString(data.day));
        this.birthdateMonths.selectByValue(data.month == 0? Integer.toString(faker.random().nextInt(1, 12)): Integer.toString(data.month));
        this.birthdateYears.selectByValue(data.year == 0? Integer.toString(faker.random().nextInt(1900,2018)) : Integer.toString(data.year));

        this.addressFirstName.sendKeys(data.addressfirstname.equals("random")? faker.name().firstName() : data.addressfirstname);
        this.addressLastName.sendKeys(data.addresslastname.equals("random")? faker.name().lastName() : data.addresslastname);
        this.company.sendKeys(data.company.equals("random")? faker.company().name() : data.company);

        //Issues with Java Faker, needs a workaround
        this.selectState.selectByVisibleText(data.state.equals("random")? "California" : data.state);
        this.postcode.sendKeys(data.postcode.equals("random")? "CA" : data.postcode);

        //Currently only the United States are available in the form. Update this if/when more countries become available
        this.selectCountry.selectByVisibleText(data.country.equals("random")? "United States" : "United States");

        this.additionalInfo.sendKeys(data.additionalinfo.equals("random")? faker.lorem().characters(true) : data.additionalinfo);
        this.phoneNo.sendKeys(data.phonenumber.equals("random")? faker.phoneNumber().phoneNumber() : data.phonenumber);
        this.mobilePhoneNo.sendKeys(data.mobilenumber.equals("random")? faker.phoneNumber().cellPhone() : data.mobilenumber);
        this.addressAlias.sendKeys(data.alias.equals("random")? faker.gameOfThrones().city() : data.alias);
    }

    public void submitForm(){
        this.registerButton.click();
    }

    public Registered submitValidForm(FormData data){

        fillFormWithData(data);
        submitForm();
        return new Registered();
    }

    public void submitInvalidForm(FormData data){

        fillFormWithData(data);
        submitForm();

    }

}
