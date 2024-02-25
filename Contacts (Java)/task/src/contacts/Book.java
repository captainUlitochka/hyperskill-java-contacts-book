package contacts;

import java.time.LocalDateTime;
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
                case "info" -> printContactCard();
                case "exit" -> {
                    return;
                }
                default -> System.out.println(Messages.INVALID_CMD.getMessage());
            }
            out.print(Messages.COMMAND_LIST.getMessage());
        }
    }

    private void countContacts() {
        out.printf(Messages.RECORDS_COUNT.getMessage(), contactList.size());
    }

    private boolean printContactList(String actionName) {
        if (!contactList.isEmpty()) {
            for (Contact contact : contactList) {
                out.println(contact.printContactName());
            }
            return true;
        } else {
            out.printf(Messages.NOTHING_TO_DO.getMessage(), actionName);
            return false;
        }
    }

    private void printContactCard() {
        Scanner inputIndex = new Scanner(System.in);
        if (printContactList("show")) {

            out.print(Messages.SELECT_RECORD.getMessage());
            int contactId = inputIndex.nextInt() - 1;
            String fieldName;
            if (contactId <= contactList.size()) {
                out.println(contactList.get(contactId).printContactInfo());
            } else out.printf(Messages.INVALID_DATA.getMessage(), "record id");
        }
    }

    private void editContact() {
        Scanner inputIndex = new Scanner(System.in);
        Scanner inputLines = new Scanner(System.in);
        if (printContactList("edit")) {
            out.print(Messages.SELECT_RECORD.getMessage());
            int contactId = inputIndex.nextInt() - 1;
            String fieldName;
            if (contactList.get(contactId).isPerson()) {
                out.print(Messages.SELECT_PERSON_FIELD.getMessage());
            } else {
                out.print(Messages.SELECT_ORGANIZATION_FIELD.getMessage());
            }
            fieldName = inputLines.nextLine();
            out.printf(Messages.ENTER_DATA.getMessage(), fieldName);
            String fieldValue = inputLines.nextLine();
            if (contactList.get(contactId).editContact(fieldName, fieldValue)) {
                out.printf(Messages.RECORD_SUCCESS.getMessage(), "updated");
            }
        }
    }

    private void removeContact() {
        Scanner inputIndex = new Scanner(System.in);
        if (printContactList("remove")) {
            out.print(Messages.SELECT_RECORD.getMessage());
            int contactId = inputIndex.nextInt() - 1;
            if (contactId <= contactList.size() && contactId >= 0) {
                contactList.remove(contactId);
                out.printf(Messages.RECORD_SUCCESS.getMessage(), "removed");
            } else out.printf(Messages.INVALID_DATA.getMessage(), "record number");
        }
    }

    private void createContact() {
        Scanner input = new Scanner(System.in);
        out.println(Messages.CHOOSE_CONTACT_TYPE.getMessage());
        String contactType = input.nextLine();

        Contact newContact = contactType.equals("person") ? new Person() : new Organization();
        newContact.inputFields();
        newContact.setId(nextId);
        newContact.setTimeCreated(LocalDateTime.now());
        newContact.setTimeEdited(LocalDateTime.now());
        contactList.add(newContact);
        nextId++;
        out.printf(Messages.RECORD_SUCCESS.getMessage(), "added");
    }

}
