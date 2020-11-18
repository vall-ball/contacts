package contacts;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    PhoneBook phoneBook;
    final static Scanner scanner = new Scanner(System.in);

    Menu(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    public void process() {

        while (true) {
            System.out.println("[menu] Enter action (add, list, search, count, exit):");
            String answer = scanner.nextLine();

            switch (answer) {
                case "add":
                    add();
                    break;
                case "count":
                    count();
                    break;
                case "list":
                    System.out.println();
                    list();
                    break;
                case "search":
                    search();
                    break;
                case "exit":
                    return;
            }
            System.out.println();
        }
    }

    public void add() {
        System.out.println("Enter the type (person, organization):");
        String answer = scanner.nextLine();
        switch (answer) {
            case "person":
                System.out.println("Enter the name:");
                String name = scanner.nextLine();
                System.out.println("Enter the surname:");
                String surname = scanner.nextLine();
                System.out.println("Enter the birth date:");
                LocalDate date = null;
                try {
                    date = LocalDate.parse(scanner.nextLine());
                } catch (DateTimeParseException e) {
                    System.out.println("Bad birth date!");
                }
                System.out.println("Enter the gender (M, F):");
                String gender = scanner.nextLine();
                if (!gender.equals("M") && !gender.equals("F")) {
                    System.out.println("Bad gender!");
                    gender = null;
                }
                System.out.println("Enter the number:");
                String number = scanner.nextLine();
                Person person = new Person(name, surname, number);
                if (!person.hasNumber()) {
                    System.out.println("Wrong number format!");
                }
                if (date != null) {
                    person.setBirthDate(date);
                }
                if (gender != null) {
                    person.setGender(gender);
                }
                System.out.println("The record added.");
                person.setTimeCreated(LocalDateTime.now().withNano(0));
                phoneBook.addContact(person);
                break;

            case "organization":
                System.out.println("Enter the organization name:");
                String organizationName = scanner.nextLine();
                System.out.println("Enter the address:");
                String address = scanner.nextLine();
                System.out.println("Enter the number:");
                String numberPhone = scanner.nextLine();
                Organization organization = new Organization(organizationName, address, numberPhone);
                if (!organization.hasNumber()) {
                    System.out.println("Wrong number format!");
                }
                System.out.println("The record added.");
                organization.setTimeCreated(LocalDateTime.now().withNano(0));
                phoneBook.addContact(organization);
                break;
        }
        System.out.println();
    }

    public void delete(Contact contact) {
        phoneBook.contacts.remove(contact);
    }

    public void list() {
        for (int i = 0; i < phoneBook.contacts.size(); i++) {
            System.out.println((i + 1) + ". " + phoneBook.contacts.get(i));
        }
        System.out.println("[list] Enter action ([number], back):");
        String choice = scanner.nextLine();
        switch (choice) {
            case "back":
                return;
            default:
                int c = Integer.parseInt(choice);
                Contact contact = phoneBook.contacts.get(c - 1);
                contact.info();
                while (true) {
                    System.out.println("[record] Enter action (edit, delete, menu):");
                    choice = scanner.nextLine();
                    switch (choice) {
                        case "edit":
                            edit(contact);
                            break;
                        case "delete":
                            delete(contact);
                            break;
                        case "menu":
                            System.out.println();
                            return;
                    }
                }
        }

    }

    public void edit(Contact contact) {
        contact.setTimeEdit(LocalDateTime.now());
        if (!contact.isPerson) {
            System.out.println("Select a field (name, address, number):");
            String choice = scanner.nextLine();
            switch (choice) {
                case "name":
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    ((Organization) contact).setOrganizationName(name);
                    break;
                case "address":
                    System.out.println("Enter address:");
                    String address = scanner.nextLine();
                    ((Organization) contact).setAddress(address);
                    break;
                case "number":
                    System.out.println("Enter number:");
                    String number = scanner.nextLine();
                    contact.setPhoneNumber(number);
                    break;
            }
        } else {
                System.out.println("Select a field (name, surname, birth, gender, number):");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "name":
                        System.out.println("Enter name:");
                        String name = scanner.nextLine();
                        ((Person)contact).setName(name);
                        break;
                    case "surname":
                        System.out.println("Enter surname:");
                        String surname = scanner.nextLine();
                        ((Person)contact).setSurname(surname);
                        break;
                    case "number":
                        System.out.println("Enter number:");
                        String number = scanner.nextLine();
                        contact.setPhoneNumber(number);
                        break;
                    case "birth":
                        System.out.println("Enter birth:");
                        LocalDate date = LocalDate.parse(scanner.nextLine());
                        ((Person) contact).setBirthDate(date);
                        break;
                    case "gender":
                        System.out.println("Enter gender:");
                        String gender = scanner.nextLine();
                        ((Person) contact).setGender(gender);
                        break;
                }
        }
        System.out.println("Saved");
        contact.info();
        System.out.println();
    }

    public void count() {
        System.out.println("The Phone Book has " + phoneBook.contacts.size() + " records.");
    }

    public void search() {
        System.out.println("Enter search query:");
        String query = scanner.nextLine();
        List<Contact> searchResult = new ArrayList<>();
        for (Contact c : phoneBook.contacts) {
            if (c.containsQuery(query)) {
                searchResult.add(c);
            }
        }
        System.out.println("Found " + searchResult.size() + " results:");
        if (searchResult.size() > 0) {
            for (int i = 0; i < searchResult.size(); i++) {
                System.out.println((i + 1) +". " + searchResult.get(i));
            }
        }

        while (true) {
            System.out.println("[search] Enter action ([number], back, again):");
            String choice = scanner.nextLine();
            switch (choice) {
                case "again":
                    System.out.println("Enter search query:");
                    query = scanner.nextLine();
                    searchResult = new ArrayList<>();
                    for (Contact c : phoneBook.contacts) {
                        if (c.isPerson) {
                            if (((Person) c).name.toLowerCase().contains(query.toLowerCase()) || ((Person) c).surname.toLowerCase().contains(query.toLowerCase())) {
                                searchResult.add(c);
                            }
                        } else {
                            if (((Organization) c).organizationName.toLowerCase().contains((query.toLowerCase()))) {
                                searchResult.add(c);
                            }
                        }
                    }
                    System.out.println("Found " + searchResult.size() + " results:");
                    if (searchResult.size() > 0) {
                        for (int i = 0; i < searchResult.size(); i++) {
                            System.out.println((i + 1) + ". " + searchResult.get(i));
                        }
                    }
                    break;
                case "back":
                    return;
                default:
                    int number = Integer.parseInt(choice);
                    Contact c = searchResult.get(number - 1);
                    c.info();
                    while (true) {
                        System.out.println("[record] Enter action (edit, delete, menu):");
                        choice = scanner.nextLine();
                        switch (choice) {
                            case "edit":
                                edit(c);
                                break;
                            case "delete":
                                delete(c);
                                break;
                            case "menu":
                                System.out.println();
                                return;
                        }
                    }
            }
        }

    }

}


/*
   public void remove() {
        if (phoneBook.contacts.size() == 0) {
            System.out.println("No records to remove!");
        } else {
            list();
            System.out.println("Enter index to show info: ");
            int choice = Integer.parseInt(scanner.nextLine());
            phoneBook.contacts.remove(choice - 1);
            System.out.println("The record removed!");
        }
    }

     public void info() {
        if (phoneBook.contacts.size() == 0) {
            System.out.println("No records!");
        } else {
            list();
            System.out.println("Enter index to show info: ");
            int choice = Integer.parseInt(scanner.nextLine());
            phoneBook.contacts.get(choice - 1).info();
        }
    }
 */