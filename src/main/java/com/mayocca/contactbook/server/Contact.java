package com.mayocca.contactbook.server;

import java.io.Serializable;

public class Contact implements Serializable {

    public String nombre;
    public String apellido;
    public String numero;

    public Contact(String nombre, String apellido, String numero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numero = numero;
    }

}
