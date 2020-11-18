package contacts;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {

    final boolean isPerson;
    private String phoneNumber;
    LocalDateTime timeCreated;
    LocalDateTime timeEdit;

    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated.withNano(0).withSecond(0);
    }

    public void setTimeEdit(LocalDateTime timeEdit) {
        this.timeEdit = timeEdit.withNano(0).withSecond(0);
    }

    public LocalDateTime getTimeEdit() {
        return timeEdit;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }



    public Contact(String phoneNumber, boolean isPerson) {
        if (checkNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            this.phoneNumber = "";
        }
        this.isPerson = isPerson;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (checkNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            this.phoneNumber = "";
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean hasNumber() {
        return phoneNumber.length() > 0;
    }

    private boolean checkNumber(String number) {
        Pattern pattern = Pattern.compile("\\+?\\d?[\\d \\-a-zA-Z]*(\\([\\da-zA-Z]+\\))?[\\d \\-a-zA-Z]*");
        Matcher matcher = pattern.matcher(number);
        String[] arr = number.split("[ \\-]");
        boolean l = true;
        if (arr.length > 1) {
            for (String s : arr) {
                if (s.length() < 2) {
                    l = false;
                    break;
                }
            }
        }
        return matcher.matches() && l;
    }

    public void info() {

    }

    public boolean containsQuery(String query) {
        return false;
    }

}
