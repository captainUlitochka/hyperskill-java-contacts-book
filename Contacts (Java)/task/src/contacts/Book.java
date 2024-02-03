package contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class Book {
    List<Contact> contactList;
    private int nextId = 1;
    public void start() {
        contactList = new ArrayList<>();
        out.print(Messages.COMMAND_LIST.getMessage());
        showMenu();
    }

    private void showMenu() {
        Scanner in = new Scanner(System.in);
        String command;
        while (in.hasNextLine()) {
            command = in.nextLine();
            switch (command) {
                case "add" -> createContact();
                case "remove" -> removeContact();
                case "edit" -> editContact();
                case "count" -> countContacts();
                case "info" -> showContactInfo();
                case "exit" -> {
                    return;
                }
                default -> System.out.println(Messages.INVALID_CMD.getMessage());
            }
            out.print(Messages.COMMAND_LIST.getMessage());
        }
    }

    private void showContactInfo() {
        if (!contactList.isEmpty()) {
            for (Contact contact : contactList) {
                out.printf(
                        Messages.RECORD.getMessage(),
                        contactList.indexOf(contact) + 1,
                        contact.printContactName());
            }
        } else {
            out.printf(Messages.NOTHING_TO_DO.getMessage(), "show");
        }

    }

    private void countContacts() {
        out.printf(Messages.RECORDS_COUNT.getMessage(), contactList.size());
    }

    private void editContact() {
        Scanner numsIn = new Scanner(System.in);
        if (!contactList.isEmpty()) {
            Scanner scanner = new Scanner(System.in);
            showContactInfo();
            out.print(Messages.SELECT_RECORD.getMessage());
            int recordId = numsIn.nextInt() - 1;

            if (recordId <= contactList.size() && recordId >= 0) {
                out.print(Messages.SELECT_FIELD.getMessage());
                String field = scanner.nextLine();
                if (field.equals("name")) {
                    String name = scanner.nextLine();
                    contactList.get(recordId).setFirstName(name);
                } else if (field.equals("surname")) {
                    String surname = scanner.nextLine();
                    contactList.get(recordId).setLastName(surname);
                } else if (field.equals("number")) {
                    String number = scanner.nextLine();
                    personList.get(recordId).setPhoneNumber(number);
                } else {
                    out.printf(Messages.INVALID_DATA.getMessage(), "command");
                }

            } else out.printf(Messages.INVALID_DATA.getMessage(), "record number");
            out.printf(Messages.RECORD_SUCCESS.getMessage(), "updated");
        } else out.printf(Messages.NOTHING_TO_DO.getMessage(), "edit");

    }

    private void removeContact() {
        Scanner in = new Scanner(System.in);
        if (!personList.isEmpty()) {
            showContactInfo();
            out.print(Messages.SELECT_RECORD.getMessage());
            int recordId = in.nextInt() - 1;

            if (recordId <= personList.size() && recordId >= 0) {
                personList.remove(recordId);
                out.printf(Messages.RECORD_SUCCESS.getMessage(), "removed");
            } else out.printf(Messages.INVALID_DATA.getMessage(), "record number");
        } else out.printf(Messages.NOTHING_TO_DO.getMessage(), "remove");
    }

    private void createContact() {
        Scanner in = new Scanner(System.in);
        out.print(Messages.ENTER_NAME.getMessage());
        String firstName = in.nextLine();
        out.print(Messages.ENTER_SURNAME.getMessage());
        String lastName = in.nextLine();
        out.print(Messages.ENTER_NUMBER.getMessage());
        String number = in.nextLine();

        try {
            Person person = new Person(nextId, firstName, lastName, number);
            nextId++;
            personList.add(person);
        } catch (Exception e) {
            out.println(e.getMessage());
        }

        out.printf(Messages.RECORD_SUCCESS.getMessage(), "added");
    }

    //TODO: переименовать список

}
