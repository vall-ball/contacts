package contacts;

import java.time.LocalDate;

public class Person extends Contact{

    public String name;
    public String surname;
    public LocalDate birthDate;
    public String gender;

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    Person(String name, String surname, String phoneNumber) {
        super(phoneNumber, true);
        this.name = name;
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

    @Override
    public void info() {
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        if (birthDate != null) {
            System.out.println("Birth date: " + birthDate);
        } else {
            System.out.println("Birth date: [no data]");
        }
        if (gender != null) {
            System.out.println("Gender: " + gender);
        } else {
            System.out.println("Gender: [no data]");
        }
        if (hasNumber()) {
            System.out.println("Number: " + getPhoneNumber());
        } else {
            System.out.println("Number: [no data]");
        }
        if (timeCreated != null) {
            System.out.println("Time created: " + timeCreated);
        } else {
            System.out.println("Time created: [no data]");
        }
        if (timeEdit!= null) {
            System.out.println("Time last edit: " + timeCreated);
        } else {
            System.out.println("Time last edit: [no data]");
        }
    }

    @Override
    public boolean containsQuery(String query) {
        if (hasNumber()) {
            if (getPhoneNumber().toLowerCase().contains(query.toLowerCase())) {
                return true;
            }
        }
        if (name.toLowerCase().contains(query.toLowerCase())) {
            return true;
        }
        if (surname.toLowerCase().contains(query.toLowerCase())) {
            return true;
        }
        return false;
    }
}
