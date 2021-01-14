package contacts;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Person extends InputDifference {
    private String phoneNumber;
    private String gender;
    private String birthDate;
    int choice;
    String[][] contactList;
    Scanner sc;

    public Person(String[][] contactList, Scanner sc, int choice) {
        this.contactList = contactList;
        this.sc = sc;
        this.choice = choice;
    }


    public String[][] add(String[][] contactList, Scanner sc) {
        contactList[contactList.length - 1][0] = "person";
        System.out.println("Enter the name");
        contactList[contactList.length - 1][1] = sc.nextLine();
        System.out.println("Enter the surname");
        contactList[contactList.length - 1][2] = sc.nextLine();
        System.out.println("Enter the birth date:");
        birthDate = sc.nextLine();
        setBirthDate(birthDate);
        contactList[contactList.length - 1][3] = getBirthDate(birthDate);
        System.out.println("Enter the gender (M, F):");
        gender = sc.nextLine();
        setGender(gender);
        contactList[contactList.length - 1][4] = getGender(gender);
        System.out.println("Enter the phone number");
        phoneNumber = sc.nextLine();
        setCheckNumber(phoneNumber);
        contactList[contactList.length - 1][5] = getCheckNumber(phoneNumber);
        contactList[contactList.length - 1][6] = LocalDateTime.now().toString();
        contactList[contactList.length - 1][7] = LocalDateTime.now().toString();
        return contactList;
    }

    public String[][] edit(String[][] contactList, Scanner sc, int choice) {
        try {
            if (contactList[0][0] == null) {
            }

            int i = choice;
            int j = 0;
            System.out.println("Select a field (name, surname, birth, gender, number):");
            do {
                sc.reset();
                String choiceEdit = sc.nextLine().toLowerCase();

                switch (choiceEdit) {
                    case "name":
                        System.out.print("Enter name: ");
                        j = 1;
                        break;
                    case "surname":
                        System.out.print("Enter surname: ");
                        j = 2;
                        break;
                    case "birth":
                        System.out.print("Enter birth: ");
                        j = 3;
                        break;
                    case "gender":
                        System.out.print("Enter gender: ");
                        j = 4;
                        break;
                    case "number":
                        System.out.print("Enter number: ");
                        j = 5;
                        break;
                }
            } while (j == 0);

            if (j == 3) {
                birthDate = sc.nextLine();
                setBirthDate(birthDate);
                contactList[i - 1][j] = getBirthDate(birthDate);
            } else if (j == 4) {
                gender = sc.nextLine();
                setGender(gender);
                contactList[i - 1][j] = getGender(gender);
            } else if (j == 5) {
                phoneNumber = sc.nextLine();
                setCheckNumber(phoneNumber);
                contactList[i - 1][j] = getCheckNumber(phoneNumber);
            } else {
                contactList[i - 1][j] = sc.nextLine();
            }
            contactList[i - 1][7] = LocalDateTime.now().toString();
            System.out.println("Saved");
            details(contactList,choice);
            return contactList;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No records to edit");

        }
        return contactList;
    }


    public void details(String[][] contactList, int choice) {
        System.out.println("Name: " + contactList[choice - 1][1]);
        System.out.println("Surname: " + contactList[choice - 1][2]);
        System.out.println("Birth date: " + contactList[choice - 1][3]);
        System.out.println("Gender: " + contactList[choice - 1][4]);
        System.out.println("Number: " + contactList[choice - 1][5]);
        System.out.println("Time created: " + contactList[choice - 1][6]);
        System.out.println("Time last edit: " + contactList[choice - 1][7]);
    }
}
