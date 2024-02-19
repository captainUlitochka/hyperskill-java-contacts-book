package contacts;

import java.time.LocalDateTime;

abstract class Contact {
    private int id;
    private String name;
    private String phoneNumber;
    private boolean isPerson;
    private LocalDateTime timeCreated;
    private LocalDateTime timeEdited;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (checkPhoneNumber(phoneNumber)) this.phoneNumber = phoneNumber;
        else this.phoneNumber = Messages.NO_DATA.getMessage();
    }

    public boolean isPerson() {
        return isPerson;
    }

    public void setPerson(boolean person) {
        isPerson = person;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }

    public LocalDateTime getTimeEdited() {
        return timeEdited;
    }

    public void setTimeEdited(LocalDateTime timeEdited) {
        this.timeEdited = timeEdited;
    }

    private boolean checkPhoneNumber(String phoneNumber) {
        String regex = "\\+?(\\(\\w+\\)|\\w+[ -]\\(\\w{2,}\\)|\\w+)([ -]\\w{2,})*";
        return phoneNumber.matches(regex);
    }

    abstract boolean editContact(String fieldName, String inputValue);

    abstract String printContactName();

    abstract String printContactInfo();

    abstract void setField(String fieldName, String fieldValue);

    abstract void inputFields();
}