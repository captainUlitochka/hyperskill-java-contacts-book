package contacts;

import java.time.LocalDateTime;
import java.util.Scanner;

import static java.lang.System.out;

public class Organization extends Contact {
    private String address;

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
        return getId() + ". " + getName() + "\n";
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

    @Override
    void inputFields() {
        Scanner input = new Scanner(System.in);
        for (OrganizationFields fields : OrganizationFields.values()) {
            out.printf(Messages.ENTER_DATA.getMessage(), fields.getName());
            String value = input.nextLine();
            setField(fields.getName(), value);
        }
    }
}
