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
                case "info" -> showContactList();
                case "exit" -> {
                    return;
                }
                default -> System.out.println(Messages.INVALID_CMD.getMessage());
            }
            out.print(Messages.COMMAND_LIST.getMessage());
        }
    }

    private void showContactList() {
        Scanner input = new Scanner(System.in);
        if (!contactList.isEmpty()) {
            for (Contact contact : contactList) {
                out.printf(
                        contact.printContactName());
            }
            int contactId = input.nextInt();
            if (contactId <= contactList.size()) {
                out.println(contactList.get(contactId - 1).printContactInfo());
            } else out.printf(Messages.INVALID_DATA.getMessage(), "record id");

        } else {
            out.printf(Messages.NOTHING_TO_DO.getMessage(), "show");
        }
    }

    private void countContacts() {
        out.printf(Messages.RECORDS_COUNT.getMessage(), contactList.size());
    }

    private void editContact() {
        if (!contactList.isEmpty()) {
            Scanner numsInput = new Scanner(System.in);
            Scanner stringsInput = new Scanner(System.in);
            for (Contact contact : contactList) {
                contact.printContactName();
            }
            out.println(Messages.SELECT_RECORD.getMessage());
            int contactId = numsInput.nextInt();
            String fieldName = stringsInput.nextLine();
            String newValue = stringsInput.nextLine();
            if (contactList.get(contactId + 1).editContact(fieldName, newValue)) {
                out.printf(Messages.RECORD_SUCCESS.getMessage(), "updated");
            }
            numsInput.close();
            stringsInput.close();
        } else out.printf(Messages.NOTHING_TO_DO.getMessage(), "edit");
    }

    private void removeContact() {
        Scanner input = new Scanner(System.in);
        if (!contactList.isEmpty()) {
            for (Contact contact : contactList) {
                contact.printContactName();
            }
            out.print(Messages.SELECT_RECORD.getMessage());
            int contactId = input.nextInt();

            if (contactId <= contactList.size() && contactId >= 0) {
                contactList.remove(contactId - 1);
                out.printf(Messages.RECORD_SUCCESS.getMessage(), "removed");
            } else out.printf(Messages.INVALID_DATA.getMessage(), "record number");
        } else out.printf(Messages.NOTHING_TO_DO.getMessage(), "remove");
    }

    private void createContact() {
        Scanner input = new Scanner(System.in);
        out.println(Messages.CHOOSE_CONTACT_TYPE.getMessage());
        String contactType = input.nextLine();

        if (contactType.equals("person")) {
            Person newPerson = new Person();
            for (PersonFields fields : PersonFields.values()) {
                out.printf(Messages.ENTER_DATA.getMessage(), fields.getFullName());
                String value = input.nextLine();
                newPerson.setField(fields.getFullName(), value);
                newPerson.setId(nextId);
                newPerson.setTimeCreated(LocalDateTime.now());
                newPerson.setTimeEdited(LocalDateTime.now());
                contactList.add(newPerson);
            }
        } else if (contactType.equals("organization")) {
            Organization newOrganization = new Organization();
            for (OrganizationFields fields : OrganizationFields.values()) {
                out.printf(Messages.ENTER_DATA.getMessage(), fields.getName());
                String value = input.nextLine();
                newOrganization.setField(fields.getName(), value);
                newOrganization.setId(nextId);
                newOrganization.setTimeCreated(LocalDateTime.now());
                newOrganization.setTimeEdited(LocalDateTime.now());
                contactList.add(newOrganization);
            }
        }
        nextId++;
        out.printf(Messages.RECORD_SUCCESS.getMessage(), "added");
    }

}
