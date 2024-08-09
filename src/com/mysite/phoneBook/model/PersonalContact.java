package com.mysite.phoneBook.model;

public class PersonalContact extends Contact{
    private String familyName;

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }
    public PersonalContact(String name, String phoneNumber) {
        super(name, phoneNumber, ContactType.PERSONAL);
    }

    @Override
    public String toString() {
        return "PersonalContact{" +
                super.toString() +
                ", familyName='" + familyName + '\'' +
                '}';
    }
}
