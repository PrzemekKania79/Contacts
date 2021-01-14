package contacts;

import java.util.Scanner;

public class InputDifference {

    private String phoneNumber;
    private String gender;
    private String birthDate;
    private String genderVerificated;
    private String birthDateVerificated;
    private String phoneNumberVerificated;


    public String[][] add(String[][] contactList, Scanner sc) {
        return contactList;
    }

    public String[][] edit(String[][] contactList, Scanner sc, int choice) {
        return contactList;
    }


    public void details(String[][] contactList, int choice) {
    }



    //Validation methods
    void setCheckNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        String regexCheck = "([(]?\\d{0,3}[)]?\\s?-?[(]?\\d{2,3}[)]?\\s?-?[(]?\\w{2,4}[)]?\\s?-?\\w{2,4})||([+]?[(]?[a-zA-z]{5,7}[)]?)||([+]?[0]?\\s?\\d{2,3}\\s?-?[(]?\\w{0,3}[)]?)||([+]?\\d\\s?\\d{0,})||([+]?[0]?\\s?[(]?\\d{2,3}[)]?\\s?-?\\w{0,3}?)||([+]?[0]?\\s?[(]?\\d{2,3}[)]?\\s?-?\\d{0,3}?\\s?-?\\d{0,3}?\\s?-?\\d{0,5}?)";

        if (phoneNumber.matches(regexCheck)) {
            this.phoneNumber = phoneNumber;
            phoneNumberVerificated = phoneNumber;
        } else {
            System.out.println("Wrong phone number!");
            phoneNumberVerificated = "[no number]";
            ;

        }
    }

    public String getCheckNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        phoneNumber = phoneNumberVerificated;
        return phoneNumber;
    }

    void setGender(String gender) {
        this.gender = gender;
        String regexCheck = "M|F";

        if (gender.matches(regexCheck)) {
            this.gender = gender;
            genderVerificated = gender;
        } else {
            System.out.println("Bad gender!");
            genderVerificated = "[no data]";
        }
    }

    public String getGender(String gender) {
        this.gender = gender;
        gender = genderVerificated;
        return gender;
    }

    void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        String regexCheck = "(\\d{4}-\\d{2}-\\d{2})";

        if (birthDate.matches(regexCheck)) {
            this.birthDate = birthDate;
            birthDateVerificated = birthDate;
        } else {
            System.out.println("Bad birth date!");
            birthDateVerificated = "[no data]";
        }
    }

    public String getBirthDate(String birthDate) {
        this.birthDate = birthDate = birthDateVerificated;
        return birthDate;
    }
}
