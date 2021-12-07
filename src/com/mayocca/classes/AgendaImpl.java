package com.mayocca.classes;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class AgendaImpl implements com.mayocca.interfaces.Agenda {

    private ArrayList<Contact> contacts;

    public AgendaImpl() {
        this.contacts = new ArrayList<Contact>();
        this.contacts.add(new Contact("Matias", "Yocca", "0303456"));
        this.contacts.add(new Contact("Linus", "Torvalds", "0xAAAAAAAA"));
    }

    @Override
    public ArrayList<Contact> getContacts() throws RemoteException {
        return contacts;
    }

    @Override
    public ArrayList<Contact> getContactsByName(String name) throws RemoteException {
        return contacts
                .stream()
                .filter(contact -> contact.nombre.toLowerCase().equals(name.toLowerCase()) || contact.apellido.toLowerCase().equals(name.toLowerCase()))
                .collect(Collectors.toCollection(ArrayList::new));

    }

    @Override
    public Contact addContact(Contact c) throws RemoteException {
        contacts.add(c);
        return c;
    }

    @Override
    public void clearContacts() throws RemoteException {
        contacts.clear();
    }
}
