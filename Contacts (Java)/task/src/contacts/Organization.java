package contacts;

import java.time.LocalDateTime;

public class Organization extends Contact {
    private String address;

    public Organization(int id, String inputName, String inputAddress, String inputNumber) {
        setId(id);
        setName(inputName);
        setAddress(inputAddress);
        setPhoneNumber(inputNumber);
        setPerson(false);
        setTimeCreated(LocalDateTime.now());
        setTimeEdited(LocalDateTime.now());
    }

    public Organization() {
        setPerson(false);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    boolean editContact(String fieldName, String inputValue) {
        switch (fieldName) {
            case "address" -> {
                setAddress(inputValue);
                setTimeEdited(LocalDateTime.now());
                return true;
            }
            case "phone" -> {
                setPhoneNumber(inputValue);
                setTimeEdited(LocalDateTime.now());
                return true;
            }
            default -> {
                System.out.println(Messages.INVALID_CMD.getMessage());
                return false;
            }
        }
    }

    @Override
    String printContactName() {
        return getId() + ". " + getName();
    }

    @Override
    String printContactInfo() {
        return "Organization name: " + getName() + "\nAddress: " + getAddress() + "\nNumber: " + getPhoneNumber() + "\nTime created: " + getTimeCreated() + "\nTime last edit: " + getTimeEdited();
    }

    @Override
    void setField(String fieldName, String fieldValue) {
        if (fieldName.equals(OrganizationFields.NAME.getName())) {
            setName(fieldValue);
        }
        if (fieldName.equals(OrganizationFields.ADDRESS.getName())) {
            setAddress(fieldValue);
        }
        if (fieldName.equals(OrganizationFields.NUMBER.getName())) {
            setPhoneNumber(fieldValue);
        }

    }
}
