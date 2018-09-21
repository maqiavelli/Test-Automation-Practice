package config;

public class FormData {

    /**
     *      Structure used for storing registration form data.
     *      Use "random" or 0 for random values (refer to fillFormWithData)
     */

    public String firstname, lastname, password,
            addressfirstname, addresslastname,
            company, state, postcode,  country,
            additionalinfo, phonenumber, mobilenumber, alias;
    public int day, month, year;

    public FormData(String firstname, String lastname, String password, int day, int month, int year,
                     String addressfirstname, String addresslastname, String company,
                     String state, String postcode, String country, String additionalinfo,
                     String phonenumber, String mobilenumber, String alias){

        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.day = day;
        this.month = month;
        this.year = year;
        this.addressfirstname = addressfirstname;
        this.addresslastname = addresslastname;
        this.company = company;
        this.state = state;
        this.postcode = postcode;
        this.country = country;
        this.additionalinfo = additionalinfo;
        this.phonenumber = phonenumber;
        this.mobilenumber = mobilenumber;
        this.alias = alias;


    }
}