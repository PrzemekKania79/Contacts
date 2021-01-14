package contacts;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*TODO Clean mess in code
    Move some methods to make code more clear
    Secure cases when it can o throw Exception
    Implement test Unit
*/

public class Main {

    public static String[][] contactList;
    InputData inputData = new InputData();
    MenuExtension menuExtension = new MenuExtension();
    Serialization serialization = new Serialization(contactList);


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String choiceMenu = null;
        Scanner sc = new Scanner(System.in);
        Main main1 = new Main();
        contactList = new String[0][8];
        //main1.readDatabase();
        System.out.println("open phonebook.db");
        main1.choice(sc, main1);

    }

    public void choice(Scanner sc, Main main1) throws IOException, ClassNotFoundException {
        String choiceMenu;

        do {
            System.out.println("[menu] Enter action (add, list, search, count, exit): ");

            choiceMenu = sc.nextLine();

            switch (choiceMenu) {
                case "add":
                    addMatrixRow();
                    inputData.add(contactList, sc);
                    serialization.writeFile(contactList);
                    System.out.println();
                    break;
                case "list":
                    menuExtension.list(contactList, sc, inputData, main1);
                    System.out.println();
                    break;
                case "search":
                    menuExtension.search(contactList, sc, inputData, main1, menuExtension);
                    System.out.println();
                    break;

                case "count":
                    inputData.count(contactList);
                    System.out.println();
                    break;

                case "write"://ToDo implement method in another place
                    serialization.writeFile(contactList);
                    break;

                case "read":// ToDo implement method in another place
                    readDatabase();
                    break;

            }
        }
        while (!choiceMenu.equals("exit"));

    }

    public void readDatabase() {
        try {
            String[][] contactListTemp = Arrays.copyOf(serialization.readFile(contactList), serialization.readFile(contactList).length);
            contactList = new String[contactListTemp.length][8];
            for (int i = 0; i < contactListTemp.length; i++) {
                for (int j = 0; j < contactListTemp[i].length; j++) {
                    contactList[i][j] = contactListTemp[i][j];
                }
            }

        } catch (IndexOutOfBoundsException | IOException | ClassNotFoundException e) {
        }
    }

    public void addMatrixRow() {
        try {
            if (contactList[contactList.length - 1][0] != null) {
                String[][] contactListTemp = Arrays.copyOf(contactList, contactList.length);
                contactList = new String[contactList.length + 1][8];
                for (int i = 0; i < contactListTemp.length; i++) {
                    for (int j = 0; j < contactListTemp[i].length; j++) {
                        contactList[i][j] = contactListTemp[i][j];
                    }
                }
            }
        } catch (IndexOutOfBoundsException e) {
            contactList = new String[contactList.length + 1][8];
        }
    }

    public void removeMatrixRow() {
        try {
            String[][] contactListTemp = Arrays.copyOf(contactList, contactList.length);
            int tempArrayLength = contactListTemp.length;
            contactList = new String[tempArrayLength - 1][8];
            int x = 0;
            for (int i = 0; i < contactListTemp.length; i++) {
                if (contactListTemp[i][0] != null) {
                    for (int j = 0; j < contactListTemp[i].length; j++) {
                        contactList[x][j] = contactListTemp[i][j];
                    }
                    x++;
                }
            }
            System.out.println("The record removed!");
        } catch (IndexOutOfBoundsException | NegativeArraySizeException e) {
        }
    }
}
