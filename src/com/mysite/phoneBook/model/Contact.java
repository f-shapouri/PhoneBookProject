package com.mysite.phoneBook.model;

public abstract class Contact {
    private String name;

    private String phoneNumber;
    private final ContactType type;

//    public Contact(){}

    public Contact(String name, String phoneNumber, ContactType type) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.type = type;
    }

    public ContactType getType() {
        return type;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

//    public void setPhoneNumber(int phoneNumber) {
//        this.phoneNumber = "0" + phoneNumber;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = capitalizeFirstCharacter(name);
    }

    private String capitalizeFirstCharacter(String str) {
        if (str != null && !str.isEmpty()) {
            return Character.toUpperCase(str.charAt(0)) + str.substring(1);
        }
        return str;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", type=" + type;
    }
}
