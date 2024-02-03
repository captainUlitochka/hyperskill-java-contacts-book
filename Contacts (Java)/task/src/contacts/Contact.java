package contacts;

abstract class Contact {
    private int id;
    private String name;
    private String phoneNumber;
    private boolean isPerson;

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
        else this.phoneNumber = Messages.NO_NUMBER.getMessage();
    }

    public boolean isPerson() {
        return isPerson;
    }

    public void setPerson(boolean person) {
        isPerson = person;
    }

    private boolean checkPhoneNumber(String phoneNumber) {
        String regex = "\\+?(\\(\\w+\\)|\\w+[ -]\\(\\w{2,}\\)|\\w+)([ -]\\w{2,})*";
        return phoneNumber.matches(regex);
    }

    abstract void editContact(String fieldName, String inputValue);

    abstract String printContactName();
    abstract String printContactInfo();

    //TODO: абстрактный метод на редактирование, а в Book вызывать для конкретного объекта из списка
}
