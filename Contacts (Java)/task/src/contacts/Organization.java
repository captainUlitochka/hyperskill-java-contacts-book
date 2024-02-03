package contacts;

public class Organization extends Contact {
    private String address;

    public Organization(int id, String inputName, String inputAddress) {
        setId(id);
        setName(inputName);
        setAddress(inputAddress);
        setPerson(false);
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
    }

    @Override
    String printContactName() {

        return null;
    }

    @Override
    String printContactInfo() {
        return null;
    }
}
