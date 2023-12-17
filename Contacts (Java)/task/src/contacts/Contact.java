package contacts;

public class Contact {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    public Contact(int id, String inputFirstName, String inputLastName, String inputNumber) {
        setId(id);
        setFirstName(inputFirstName);
        setLastName(inputLastName);
        setPhoneNumber(inputNumber);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (checkPhoneNumber(phoneNumber)) this.phoneNumber = phoneNumber;
        else this.phoneNumber = Messages.NO_NUMBER.getMessage();
    }

    private boolean checkPhoneNumber(String phoneNumber) {
        String regex = "\\+?(\\(\\w+\\)|\\w+[ -]\\(\\w{2,}\\)|\\w+)([ -]\\w{2,})*";
        return phoneNumber.matches(regex);
    }

}
