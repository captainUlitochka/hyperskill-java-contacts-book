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
            out.printf(Messages.ENTER_DATA.getMessage(), "name");
            String name = input.nextLine();
            out.printf(Messages.ENTER_DATA.getMessage(), "surname");
            String lastName = input.nextLine();
            out.printf(Messages.ENTER_DATA.getMessage(), "birth date");
            String birthDate = input.nextLine();
            out.printf(Messages.ENTER_DATA.getMessage(), "gender (M, F)");
            String gender = input.nextLine();
            out.printf(Messages.ENTER_DATA.getMessage(), "number");
            String personNumber = input.nextLine();
            Person person = new Person(nextId, name, lastName, birthDate, gender, personNumber);
            contactList.add(person);
            nextId++;
        } else if (contactType.equals("organization")) {
            out.printf(Messages.ENTER_DATA.getMessage(), "organization name");
            String orgName = input.nextLine();
            out.printf(Messages.ENTER_DATA.getMessage(), "address");
            String address = input.nextLine();
            out.printf(Messages.ENTER_DATA.getMessage(), "number");
            String orgNumber = input.nextLine();
            Organization organization = new Organization(nextId, orgName, address, orgNumber);
            contactList.add(organization);
            nextId++;
        } else {
            out.printf(Messages.INVALID_DATA.getMessage(), "type");
        }

        /*
        try {
            Person person = new Person(nextId, firstName, lastName, number);
            nextId++;
            personList.add(person);
        } catch (Exception e) {
            out.println(e.getMessage());
        }

         */
        out.printf(Messages.RECORD_SUCCESS.getMessage(), "added");
    }

}
