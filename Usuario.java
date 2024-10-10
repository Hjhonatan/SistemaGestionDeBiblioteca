package com.mycompany.sistemagestionbiblioteca;

public class Usuario {

    // Atributos de la clase Usuario
    private String nombre;  // Nombre del usuario
    private String id;      // Identificador único del usuario

    // Constructor de la clase Usuario
    public Usuario(String nombre, String id) {
        this.nombre = nombre;   // Asigna el nombre proporcionado al usuario
        this.id = id;           // Asigna el ID proporcionado al usuario
    }

    // Método getter para obtener el nombre del usuario
    public String getNombre() {
        return nombre; // Devuelve el nombre del usuario
    }

    // Método getter para obtener el ID del usuario
    public String getId() {
        return id; // Devuelve el ID del usuario
    }

    // Método toString para representar el usuario como una cadena de texto
    @Override
    public String toString() {
        // Devuelve una cadena de texto formateada con el ID y el nombre del usuario
        return String.format("ID: %s, Nombre: %s", id, nombre);
    }
}
