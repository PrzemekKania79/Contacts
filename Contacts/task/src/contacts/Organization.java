package contacts;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Organization extends InputDifference {
    private String phoneNumber;
    String[][] contactList;
    Scanner sc;
    int choice;

    public Organization(String[][] contactList, Scanner sc, int choice) {
        this.contactList = contactList;
        this.sc = sc;
        this.choice = choice;
    }

    public String[][] add(String[][] contactList, Scanner sc) {
        contactList[contactList.length - 1][0] = "organization";
        System.out.println("Enter the organization name:");
        contactList[contactList.length - 1][1] = sc.nextLine();
        System.out.println("Enter the address:");
        contactList[contactList.length - 1][2] = sc.nextLine();
        System.out.println("Enter the number");
        phoneNumber = sc.nextLine();
        setCheckNumber(phoneNumber);
        contactList[contactList.length - 1][3] = getCheckNumber(phoneNumber);
        contactList[contactList.length - 1][4] = LocalDateTime.now().toString();
        contactList[contactList.length - 1][5] = LocalDateTime.now().toString();
        contactList[contactList.length - 1][6] = "";
        contactList[contactList.length - 1][7] = "";
        return contactList;
    }

    public String[][] edit(String[][] contactList, Scanner sc, int choice) {
        try {
            if (contactList[0][0] == null) {
            }
            int i = choice;
            int j = 0;
            System.out.println("Select a field (name, address, number):");

            do {
                sc.reset();
                String choiceEdit = sc.nextLine().toLowerCase();

                switch (choiceEdit) {
                    case "name":
                        System.out.print("Enter name: ");
                        j = 1;
                        break;
                    case "address":
                        System.out.print("Enter address: ");
                        j = 2;
                        break;
                    case "number":
                        System.out.print("Enter number: ");
                        j = 3;
                        break;
                }
            } while (j == 0);


            if (j == 3) {
                phoneNumber = sc.nextLine();
                setCheckNumber(phoneNumber);
                contactList[i - 1][j] = getCheckNumber(phoneNumber);
            } else {
                contactList[i - 1][j] = sc.nextLine();
            }
            contactList[i - 1][5] = LocalDateTime.now().toString();
            System.out.println("Saved");
            details(contactList,choice);
            return contactList;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No records to edit");

        }
        return contactList;
    }


    public void details(String[][] contactList, int choice) {
        System.out.println("Organization name: " + contactList[choice - 1][1]);
        System.out.println("Address: " + contactList[choice - 1][2]);
        System.out.println("Number: " + contactList[choice - 1][3]);
        System.out.println("Time created: " + contactList[choice - 1][4]);
        System.out.println("Time last edit: " + contactList[choice - 1][5]);
    }
}
