package com.mysite.phoneBook;

import com.mysite.phoneBook.service.PhoneBook;

public class PhoneBookList {
    public static void main(String[] args) {
        try (PhoneBook phoneBook = new PhoneBook();) {
            phoneBook.run();
        }
    }

}
