package contacts;

public enum Messages {
    COMMAND_LIST("Enter action (add, remove, edit, count, list, exit): \n"),
    RECORDS_COUNT("The Phone Book has %d records.%n"),
    ENTER_NAME("Enter the name of the person:\n"),
    ENTER_SURNAME("Enter the surname of the person:\n"),
    ENTER_NUMBER("Enter the number:\n"),
    RECORD_SUCCESS("The record %s!%n"),
    NOTHING_TO_DO("No records to %s%n"),
    INVALID_DATA("Invalid %s%n"),
    INVALID_CMD("Invalid command!\n"),
    NO_NUMBER("[no number]\n"),
    WRONG_FORMAT("Wrong number format!\n"),
    SELECT_RECORD("Select a record: \n"),
    SELECT_FIELD("Select a field (name, surname, number): \n"),
    RECORD("%d. %s");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
