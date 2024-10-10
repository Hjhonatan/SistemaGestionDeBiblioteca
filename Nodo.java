package com.mycompany.sistemagestionbiblioteca;

public class Nodo<T> { // Componente fundamental para la implementación de listas enlazadas

    T info;   // T es un tipo genérico, lo que significa que esta clase Nodo puede almacenar cualquier tipo de dato.
    Nodo<T> siguiente; // Este atributo es una referencia al siguiente nodo en la lista enlazada.

    public Nodo(T info) { // Constructor de la clase Nodo
        this.info = info; // Este atributo almacena la información o el valor que el nodo actual está guardando
        this.siguiente = null; // Inicializa el siguiente nodo como null, ya que al principio el nodo no tiene un siguiente
    }
}
