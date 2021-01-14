package contacts;


import java.io.IOException;
import java.util.Scanner;

public class InputData {

    private int choice;
    public String isPerson = "";

    public String[][] add(String[][] contactList, Scanner sc) {

        System.out.println("Enter the type (person, organization):");
        isPerson = sc.nextLine();
        if (isPerson.toLowerCase().equals("person")) {
            InputDifference person = new Person(contactList, sc, choice);
            person.add(contactList, sc);
        } else if (isPerson.toLowerCase().equals("organization")) {
            InputDifference organization = new Organization(contactList, sc, choice);
            organization.add(contactList, sc);
        }
        System.out.println("The record added.");
        count(contactList);
        return contactList;
    }


    public String[][] remove(String[][] contactList, int choice) {
        try {
            if (contactList[0][0] == null) {
            }
            int i = choice;
            contactList[i - 1][0] = null;
            contactList[i - 1][1] = null;
            contactList[i - 1][2] = null;
            contactList[i - 1][3] = null;
            contactList[i - 1][4] = null;
            contactList[i - 1][5] = null;
            contactList[i - 1][6] = null;
            contactList[i - 1][7] = null;
            return contactList;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No records to remove!");
        }
        return contactList;
    }

    public String[][] edit(String[][] contactList, Scanner sc, int choice) {
        try {
            if (contactList[0][0] == null) {
                System.out.println("No records to edit.");
            } else {
                if (contactList[choice - 1][0].toLowerCase().equals("person")) {
                    InputDifference person = new Person(contactList, sc, choice);
                    person.edit(contactList, sc, choice);
                }
                if (contactList[choice - 1][0].toLowerCase().equals("organization")) {
                    InputDifference organization = new Organization(contactList, sc, choice);
                    organization.edit(contactList, sc, choice);

                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No records to edit.");
        }
        return contactList;
    }

    public static void count(String[][] contactList) {
        try {

            if (contactList[0][0] == null) {

            } else {
                System.out.println("The List has " + contactList.length + " records.");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("0 records.");
        }
    }


    public void info(String[][] contactList, String searchValue) {
        try {
            if (contactList[0][0] == null) {
                System.out.println("The List has 0 records.");
            } else {
                String textValue = "";
                int count = 0;
                for (String[] i : contactList) {

                    if (contactList[count][0].toLowerCase().equals("person")) {
                        textValue = (contactList[count][1] + " " + contactList[count][2] + " " + contactList[count][5]);
                    } else {
                        textValue = (contactList[count][1] + " " + contactList[count][3]);
                    }
                    if (textValue.toLowerCase().matches(".*" + searchValue + ".*")) {
                        if (contactList[count][0].toLowerCase().equals("person")) {
                            System.out.println((count + 1) + ". " + contactList[count][1] + " " + contactList[count][2]);
                        } else {
                            System.out.println((count + 1) + ". " + contactList[count][1]);
                        }
                    }
                    count++;
                }

            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The List has 0 records.");
        }
    }

    public void searchPhoneNumber(String[][] contactList, String searchValue, String phoneNumber, MenuExtension menuExtension, Scanner sc, InputData inputData, Main main1) {
        try {
            if (contactList[0][0] == null) {
                System.out.println("The List has 0 records.");
            } else {
                String textValue = "";
                int choice = 0;
                int count = 0;
                for (String[] i : contactList) {

                    if (contactList[count][0].toLowerCase().equals("person")) {
                        textValue = (contactList[count][1] + " " + contactList[count][2]);
                    } else {
                        textValue = (contactList[count][1]);
                    }
                    if (textValue.toLowerCase().matches(".*" + searchValue + ".*")) {
                        if (contactList[count][0].toLowerCase().equals("person") && contactList[count][5].matches(".*" + phoneNumber + ".*")) {
                            System.out.println((count + 1) + ". " + contactList[count][1] + " " + contactList[count][2]);
                            menuExtension.record(contactList, sc, inputData, choice, main1);
                            break;
                        } else if (contactList[count][3].matches(".*" + phoneNumber + ".*")) {
                            System.out.println((count + 1) + ". " + contactList[count][1]);
                            menuExtension.record(contactList, sc, inputData, choice, main1);
                            break;
                        }
                    }
                    count++;
                }

            }
        } catch (ArrayIndexOutOfBoundsException | IOException e) {
            System.out.println("The List has 0 records.");
        }
    }


    public void details(String[][] contactList, Scanner sc, int choice) {
        try {
            this.choice = choice;
            if (contactList[choice - 1][0].toLowerCase().equals("person")) {
                InputDifference person = new Person(contactList, sc, choice);
                person.details(contactList, choice);
            } else if (contactList[choice - 1][0].toLowerCase().equals("organization")) {
                InputDifference organization = new Organization(contactList, sc, choice);
                organization.details(contactList, choice);

            }
        } catch (IndexOutOfBoundsException e) {
        }
    }
}
