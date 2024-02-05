package contacts;

import java.time.LocalDateTime;

public class Person extends Contact {

    private String lastName;
    private String gender;
    private String birthDate;

    public Person(int id, String inputFirstName, String inputLastName, String inputNumber) {
        setId(id);
        setName(inputFirstName);
        setLastName(inputLastName);
        setPhoneNumber(inputNumber);
        setPerson(true);
        setTimeCreated(LocalDateTime.now());
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    void editContact(String fieldName, String inputValue) {
        switch (fieldName) {
            case "surname" -> setLastName(inputValue);
            case "name" -> setName(inputValue);
            case "gender" -> setGender(inputValue);
            case "birth" -> setBirthDate(inputValue);
            case "number" -> setPhoneNumber(inputValue);
            default -> System.out.println(Messages.INVALID_CMD.getMessage());
        }
        setTimeEdited(LocalDateTime.now()); //TODO: но так будет обновляться время даже при подаче некорректной команды
    }

    @Override
    String printContactName() {
        return getId() + ". " +
                getName() + " " +
                getLastName();
    }

    @Override
    String printContactInfo() {
        return "Name: " + getName() +
                "\nSurname: " + getLastName() +
                "\nBirth Date: " + getBirthDate() +
                "\nGender: " + getBirthDate() +
                "\nNumber: " + getPhoneNumber() +
                "\nTime created: " + getTimeCreated() +
                "\nTime last edit: " + getTimeEdited();    }

}
