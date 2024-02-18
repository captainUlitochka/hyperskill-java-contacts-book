package contacts;

public enum OrganizationFields {
    NAME("organization name"),
    ADDRESS("address"),
    NUMBER("number");
    private final String name;

    OrganizationFields(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
