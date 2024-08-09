package com.mysite.phoneBook.service;

import com.mysite.phoneBook.model.BusinessContact;
import com.mysite.phoneBook.model.Contact;
import com.mysite.phoneBook.model.PersonalContact;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook implements AutoCloseable {
    private static ArrayList<Contact> contactList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void run() {
        int userInput;
        do {
            printMenu();
            userInput = scanner.nextInt();
            scanner.nextLine();
            switch (userInput) {
                case 0:
                    System.out.println("---------End of Application--------");
                    break;
                case 1:
                    addContact();
                    break;
                case 2:
                    printContacts();
                    break;
                case 3:
                    searchContact();
                case 4:
                    editContact();
                    break;
                case 5:
                    deleteContact();
                    break;
                case 6:
                    deleteAllContacts();
                    break;
                default:
                    System.out.println("Invalid input");
            }
        } while (userInput != 0);
    }

    private static void printMenu() {
        System.out.println("------------Menu------------");
        System.out.println("0.Exit");
        System.out.println("1.Add new number");
        System.out.println("2.Print all contacts");
        System.out.println("3.Search contact");
        System.out.println("4.Edit contact");
        System.out.println("5.Delete contact");
        System.out.println("6.Delete All contacts");
    }

    private void printContacts() {
        if (contactList.isEmpty()) {
            System.out.println("Phonebook is empty!");
        }
        System.out.println("------------All Contacts------------");
        for (Contact contact : contactList) {
            System.out.println(contact.toString());
        }
    }

    private void addContact() {
        System.out.println("--------select contact type------");
        String type = getInput("1.Personal\n2.Business");
        if (type.equals("1")) {
            String firstName = getInput("Enter firstName");
            String lastName = getInput("Enter lastName");
            String number = getInput("Enter Number");
            PersonalContact personalContact = new PersonalContact(firstName, number);
            personalContact.setFamilyName(lastName);
            contactList.add(personalContact);
        } else if (type.equals("2")) {
            String name = getInput("Enter name");
            String number = getInput("Enter Number");
            String faxNumber = getInput("Enter fax");
            BusinessContact businessContact = new BusinessContact(name, number);
            businessContact.setFaxNumber(faxNumber);
            contactList.add(businessContact);
        }
    }

    private String getInput(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    public void searchContact() {
        String searchType = getInput("Select Type Of Search: \n 1 : search by name \n 2: search by Family\n");
        if (searchType.equals("1")) {
            String name = getInput("Enter name :");
            for (Contact contact : contactList) {
                if (contact.getName().equalsIgnoreCase(name)) {
                    System.out.println(contact);
                }
            }
        } else if (searchType.equals("2")) {
            String family = getInput("Enter family:");
            for (Contact contact : contactList) {
                if (contact instanceof PersonalContact personalContact) {
                    if (personalContact.getFamilyName().equalsIgnoreCase(family)) {
                        System.out.println(contact);
                    }
                }
            }
        }
    }

    public void editContact() {
        String newName;
        String newFamily;
        String newNumber;
        String editItem;
        String editType = getInput("Select Type Of Contact: \n 1:Personal \n 2:Business");

        for (Contact contact : contactList) {
            if (editType.equals("1")) {
                if (contact instanceof PersonalContact personalContact) {
                    String name = getInput("Enter name:");
                    String family = getInput("Enter family");
                    if (personalContact.getName().equalsIgnoreCase(name) && personalContact.getFamilyName().equalsIgnoreCase(family)) {
                        editItem = getInput("Which item do you want to edit?\n 1:name 2:family 3:number 4:all of them");
                        if (editItem.equals("1")) {
                            newName = getInput("Enter new name:");
                            personalContact.setName(newName);
                            System.out.println(personalContact);
                        } else if (editItem.equals("2")) {
                            newFamily = getInput("Enter new family:");
                            personalContact.setFamilyName(newFamily);
                            System.out.println(personalContact);
                        } else if (editItem.equals("3")) {
                            newNumber = getInput("Enter new number:");
                            personalContact.setPhoneNumber(newNumber);
                            System.out.println(personalContact);
                        } else {
                            newName = getInput("Enter new name:");
                            newFamily = getInput("Enter new family");
                            newNumber = getInput("Enter new number");
                            personalContact.setName(newName);
                            personalContact.setFamilyName(newFamily);
                            personalContact.setPhoneNumber(newNumber);
                            System.out.println(personalContact);
                        }
                    }
                }
            } else if (editType.equals("2")) {
                if (contact instanceof BusinessContact businessContact) {
                    String companyName = getInput("Enter companyName:");
                    if (businessContact.getName().equalsIgnoreCase(companyName)) {
                        String newFax;
                        editItem = getInput("Which item do you want to edit? 1:companyName 2:number 3:fax 4:all of them");
                        if (editItem.equals("1")) {
                            newName = getInput("Enter new name:");
                            businessContact.setName(newName);
                            System.out.println(businessContact);
                        } else if (editItem.equals("2")) {
                            newNumber = getInput("Enter new number:");
                            businessContact.setPhoneNumber(newNumber);
                            System.out.println(businessContact);
                        } else if (editItem.equals("3")) {
                            newFax = getInput("Enter new fax number:");
                            businessContact.setFaxNumber(newFax);
                            System.out.println(businessContact);
                        } else {
                            newName = getInput("Enter new name:");
                            newNumber = getInput("Enter new number");
                            newFax = getInput("Enter new fax number:");
                            businessContact.setName(newName);
                            businessContact.setPhoneNumber(newNumber);
                            businessContact.setFaxNumber(newFax);
                            System.out.println(businessContact);
                        }
                    }
                }
            }
        }
    }

    private void deleteContact() {
        List<Contact> removeContacts = new ArrayList<>();
        String contactType = getInput("Select Type Of Contact: \n 1:Personal \n 2:Business\n");
        if (contactType.equals("1")) {
            String name = getInput("Enter the name:");
            String family = getInput("Enter the family:");
            for (Contact contact : contactList) {
                if (contact instanceof PersonalContact personalContact) {
                    if (personalContact.getName().equalsIgnoreCase(name) && personalContact.getFamilyName().equalsIgnoreCase(family)) {
                        removeContacts.add(personalContact);
                    }
                }
            }
        } else if (contactType.equals("2")) {
            String companyName = getInput("Enter the companyName:");
            for (Contact contact : contactList) {
                if (contact instanceof BusinessContact businessContact) {
                    if (businessContact.getName().equalsIgnoreCase(companyName)) {
                        removeContacts.add(businessContact);
                    }
                }
            }
        }
        if (!removeContacts.isEmpty()) contactList.removeAll(removeContacts);
    }

    private void deleteAllContacts() {
        List<Contact> removeAllContactsList = new ArrayList<>();
        String selectItem = getInput("Are you sure to delete all contacts?\n 1:Yes 2:No");
        if (selectItem.equals("1")) {
            for (Contact contact : contactList) {
                if (contact != null) {
                    removeAllContactsList.add(contact);
                }
            }
            if (!removeAllContactsList.isEmpty()) contactList.removeAll(removeAllContactsList);
        } else System.out.println("Delete canceled");
    }

    @Override
    public void close() {
        scanner.close();
    }
}
