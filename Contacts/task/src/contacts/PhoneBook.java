package contacts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PhoneBook implements Serializable {
    public List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
    }
}
