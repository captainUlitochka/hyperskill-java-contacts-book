package contacts;

public enum Messages {
    COMMAND_LIST("\nEnter action (add, remove, edit, count, info, exit): \n"),
    RECORDS_COUNT("The Phone Book has %d records.%n"),
    ENTER_DATA("Enter %s:\n"),
    BAD_DATA("Bad %s!\n"),
    RECORD_SUCCESS("The record %s!%n"),
    NOTHING_TO_DO("No records to %s%n"),
    INVALID_DATA("Invalid %s%n"),
    INVALID_CMD("Invalid command!\n"),
    NO_DATA("[no data]"),
    WRONG_FORMAT("Wrong number format!\n"),
    SELECT_RECORD("Select a record: \n"),
    SELECT_PERSON_FIELD("Select a field (name, surname, number): \n"),
    SELECT_ORGANIZATION_FIELD("Select a field (address, number): \n"),
    ENTER_CONTACT_ID("Enter index to show info:\n"),
    CHOOSE_CONTACT_TYPE("Enter the type (person, organization):"),
    RECORD("%d. %s");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
