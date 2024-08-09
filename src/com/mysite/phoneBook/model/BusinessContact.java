package com.mysite.phoneBook.model;

public class BusinessContact extends Contact{
    private String faxNumber;

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }
    public BusinessContact(String name, String phoneNumber) {
        super(name, phoneNumber, ContactType.BUSINESS);
    }

    @Override
    public String toString() {
        return "BusinessContact{" +
                super.toString() +
                ", faxNumber='" + faxNumber + '\'' +
                '}';
    }
}
