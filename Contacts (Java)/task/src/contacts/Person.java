package contacts;

import java.time.LocalDateTime;

public class Person extends Contact {

    private String lastName;
    private String gender;
    private String birthDate;

    public Person(int id, String inputFirstName, String inputLastName, String inputBirthDate, String inputGender, String inputNumber) {
        setId(id);
        setName(inputFirstName);
        setLastName(inputLastName);
        setBirthDate(inputBirthDate);
        setGender(inputGender);
        setPhoneNumber(inputNumber);
        setPerson(true);
        setTimeCreated(LocalDateTime.now());
        setTimeEdited(LocalDateTime.now());
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
    boolean editContact(String fieldName, String inputValue) {
        switch (fieldName) {
            case "surname" -> {
                setLastName(inputValue);
                setTimeEdited(LocalDateTime.now());
                return true;
            }
            case "name" -> {
                setName(inputValue);
                setTimeEdited(LocalDateTime.now());
                return true;
            }
            case "gender" -> {
                setGender(inputValue);
                setTimeEdited(LocalDateTime.now());
                return true;
            }
            case "birth" -> {
                setBirthDate(inputValue);
                setTimeEdited(LocalDateTime.now());
                return true;
            }
            case "number" -> {
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
        return getId() + ". " +
                getName() + " " +
                getLastName();
    }

    @Override
    String printContactInfo() {
        return "Name: " + getName() +
                "\nSurname: " + getLastName() +
                "\nBirth Date: " + getBirthDate() +
                "\nGender: " + getGender() +
                "\nNumber: " + getPhoneNumber() +
                "\nTime created: " + getTimeCreated() +
                "\nTime last edit: " + getTimeEdited();    }

}
