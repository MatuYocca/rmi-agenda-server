package com.mayocca.contactbook.server;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class ContactBook implements IContactBook {

    private ArrayList<Contact> contacts;

    public ContactBook() {
        this.contacts = new ArrayList<Contact>();
        this.contacts.add(new Contact("Matias", "Yocca", "0303456"));
        this.contacts.add(new Contact("Linus", "Torvalds", "0xAAAAAAAA"));
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public ArrayList<Contact> getContactsByName(String name) throws RemoteException {
        return contacts;
        // .stream()
        // .filter(contact -> contact.nombre.toLowerCase().equals(name.toLowerCase())
        // || contact.apellido.toLowerCase().equals(name.toLowerCase()))
        // .collect(Collectors.toCollection(ArrayList::new));

    }

    public Contact addContact(Contact c) throws RemoteException {
        contacts.add(c);
        return c;
    }

    public void clearContacts() throws RemoteException {
        contacts.clear();
    }
}
