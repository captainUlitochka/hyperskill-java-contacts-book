package contacts;

public enum PersonFields {
    NAME("name", "name"),
    SURNAME("surname", "surname"),
    BIRTH_DATE("birth date", "birth"),
    GENDER("gender (M, F)", "gender"),
    NUMBER("number", "number");
    private final String fullName;
    private final String shortName;

    PersonFields(String fullName, String shortName) {
        this.fullName = fullName;
        this.shortName = shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }
}
