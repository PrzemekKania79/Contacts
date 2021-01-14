package contacts;

import java.io.*;

public class Serialization implements Serializable {
    private String[][] contactList;
    private String filename = "C:\\b\\contacts.data";

    Serialization(String[][] contactList) {
        this.contactList = contactList;
    }

    public Serialization() {

    }

    public void writeFile(String[][] contactList) throws IOException {
        this.contactList = contactList;
        FileOutputStream fos = new FileOutputStream(filename);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(contactList);
        oos.close();
    }

    public String[][] readFile(String[][] contactList) throws IOException, ClassNotFoundException {
        this.contactList = contactList;
        FileInputStream fis = new FileInputStream(filename);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);
        contactList = (String[][]) ois.readObject();
        ois.close();
        return contactList;
    }


}
