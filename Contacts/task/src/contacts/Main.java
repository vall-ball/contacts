package contacts;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        PhoneBook phoneBook;
        if (args.length != 0) {
            FileInputStream fis = new FileInputStream(args[0]);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);
            phoneBook = (PhoneBook) ois.readObject();
            ois.close();
        } else {
            phoneBook = new PhoneBook();
        }
        Menu menu = new Menu(phoneBook);
        menu.process();
    }

}
