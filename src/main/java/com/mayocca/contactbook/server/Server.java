package com.mayocca.contactbook.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {

    public static void main(String[] args) {
        IContactBook implementation = new ContactBook();

        System.setProperty("java.security.policy", "file:./app.policy");

        try {
            IContactBook stub = (IContactBook) UnicastRemoteObject.exportObject(implementation, 0);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("agendaserver", stub);
        } catch (RemoteException ex) {
            ex.printStackTrace();
            return;
        }
        System.out.println("Servidor establecido");
        System.out.println("El servidor esperará indefinidamente por mensajes.");
    }
}
