package com.mayocca.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import com.mayocca.classes.AgendaImpl;
import com.mayocca.interfaces.Agenda;

public class ServerMain {

    public static void main(String[] args) {
        AgendaImpl implementation = new AgendaImpl();

        System.setProperty("java.security.policy","file:./app.policy");

        try {
            Agenda stub = (Agenda) UnicastRemoteObject.exportObject(implementation, 0);
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
