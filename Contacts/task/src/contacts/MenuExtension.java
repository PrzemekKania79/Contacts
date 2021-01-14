package contacts;

import java.io.IOException;
import java.util.Scanner;

public class MenuExtension {

    public void list(String[][] contactList, Scanner sc, InputData inputData, Main main1) throws IOException {
        String searchValue = "";
        inputData.info(contactList, searchValue);
        String data = "";
        int choice;

        do {
            System.out.println("[list] Enter action ([number], back): ");
            data = sc.nextLine().toLowerCase();
            if (data.matches("\\d+")) {
                choice = Integer.parseInt(data);
                inputData.details(contactList, sc, choice);
                System.out.println();
                record(contactList, sc, inputData, choice, main1);
                break;
            }

        } while (!data.equals("back"));

    }

    public void search(String[][] contactList, Scanner sc, InputData inputData, Main main1, MenuExtension menuExtension) throws IOException {
        String searchValue = "";
        String data = "";
        String phoneNumber = "";
        System.out.println("Enter search query: ");
        searchValue = sc.nextLine();
        inputData.info(contactList, searchValue);
        do {
            System.out.println("[search] Enter action ([number], back, again): ");
            data = sc.nextLine().toLowerCase();
            if (data.matches("\\d+")) {
                phoneNumber = data;
                System.out.println();
                inputData.searchPhoneNumber(contactList, searchValue, phoneNumber, menuExtension, sc,inputData ,main1);
                break;
            } else if (data.equals("again")) {
                search(contactList, sc, inputData, main1, menuExtension);
            }
        } while (!searchValue.toLowerCase().equals("back"));
    }

    public void record(String[][] contactList, Scanner sc, InputData inputData, int choice, Main main1) throws IOException {
        String data = "";
        do {
            System.out.println("[record] Enter action (edit, delete, menu): ");
            data = sc.nextLine().toLowerCase();

            switch (data) {
                case "edit":
                    inputData.edit(contactList, sc, choice);
                    main1.serialization.writeFile(contactList);
                    break;
                case "delete":
                    inputData.remove(contactList, choice);
                    main1.removeMatrixRow();
                    main1.serialization.writeFile(contactList);
                    break;
            }
        } while (!data.equals("menu"));
    }


}
