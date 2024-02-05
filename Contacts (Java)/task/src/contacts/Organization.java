package contacts;

import java.time.LocalDateTime;

public class Organization extends Contact {
    private String address;

    public Organization(int id, String inputName, String inputAddress) {
        setId(id);
        setName(inputName);
        setAddress(inputAddress);
        setPerson(false);
        setTimeCreated(LocalDateTime.now());
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    void editContact(String fieldName, String inputValue) {
        switch (fieldName) {
            case "address" -> setAddress(inputValue);
            case "phone" -> setPhoneNumber(inputValue);
            default -> System.out.println(Messages.INVALID_CMD.getMessage());
        }
        setTimeEdited(LocalDateTime.now()); //TODO: но так будет обновляться время даже при подаче некорректной команды
    }

    @Override
    String printContactName() {
        return getId() + ". " + getName();
    }

    @Override
    String printContactInfo() {
        return "Organization name: " + getName() +
                "\nAddress: " + getAddress() +
                "\nNumber: " + getPhoneNumber() +
                "\nTime created: " + getTimeCreated() +
                "\nTime last edit: " + getTimeEdited();
    }
}
