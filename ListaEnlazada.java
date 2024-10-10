package com.mycompany.sistemagestionbiblioteca;

import java.util.function.Predicate; // Importa Predicate para utilizar predicados

public class ListaEnlazada<T> { // Define una clase ListaEnlazada genérica con tipo T

    Nodo<T> primero; // Declara el primer nodo de la lista

    public ListaEnlazada() { // Constructor que inicializa una lista enlazada vacía
        primero = null; // Inicializa el primer nodo como null
    }

    public void insertarEnPrimero(T dato) { // Inserta un nuevo nodo al principio de la lista
        Nodo<T> temporal = new Nodo<>(dato); // Crea un nuevo nodo con el dato proporcionado
        temporal.siguiente = primero; // Establece el siguiente nodo del nuevo nodo como el primero actual
        primero = temporal; // Actualiza el primer nodo para que sea el nuevo nodo creado
    }

    public boolean estaVacia() { // Verifica si la lista está vacía
        return primero == null; // Retorna true si el primer nodo es null, lo que indica una lista vacía
    }

    public String listar() { // Método para generar una representación de cadena de la lista
        if (primero == null) { // Si la lista está vacía
            return "La lista está vacía."; // Retorna un mensaje indicando que la lista está vacía
        }
        StringBuilder listado = new StringBuilder(); // Crea un StringBuilder para almacenar los datos de la lista
        Nodo<T> aux = primero; // Inicializa un nodo auxiliar para recorrer la lista, comenzando desde el primer nodo
        while (aux != null) { // Mientras haya nodos en la lista
            listado.append(aux.info.toString()).append("\n"); // Agrega la información del nodo actual al StringBuilder
            aux = aux.siguiente; // Avanza al siguiente nodo
        }
        return listado.toString(); // Retorna la representación de cadena de la lista
    }

    public void borrarPrimero() { // Elimina el primer nodo de la lista
        if (!estaVacia()) { // Si la lista no está vacía
            primero = primero.siguiente; // El siguiente nodo después del primero se convierte en el nuevo primero
        }

    }

    public void insertarAlFinal(T dato) { // Inserta un nuevo elemento al final de la lista.
        if (estaVacia()) { // Si la lista está vacía
            insertarEnPrimero(dato); // Inserta el elemento como el primero
        } else {
            Nodo<T> aux = primero; // Inicializa un nodo auxiliar para recorrer la lista desde el primero
            while (aux.siguiente != null) { // Mientras no se llegue al último nodo
                aux = aux.siguiente; // Avanza al siguiente nodo
            }
            aux.siguiente = new Nodo<>(dato); // Agrega el nuevo nodo al final de la lista
        }
    }

    public boolean buscar(T dato) { // Busca un elemento en la lista que coincida con el dato y retorna true si lo encuentra.
        return encontrarConPredicado(elemento -> elemento.equals(dato)) != null; // Utiliza un predicado para buscar el elemento y retorna true si se encuentra
    }

    public void borrarPorDato(T dato) { // Elimina el primer nodo que contiene el dato especificado.
        if (!estaVacia()) { // Si la lista no está vacía
            if (primero.info.equals(dato)) { // Si el primer nodo contiene el dato
                primero = primero.siguiente; // El siguiente nodo después del primero se convierte en el nuevo primero
                return; // Termina la función
            }
            Nodo<T> aux = primero; // Inicializa un nodo auxiliar para recorrer la lista desde el primero
            while (aux.siguiente != null) { // Mientras no se llegue al último nodo
                if (aux.siguiente.info.equals(dato)) { // Si el siguiente nodo contiene el dato
                    aux.siguiente = aux.siguiente.siguiente; // Salta el nodo que contiene el dato
                    return; // Termina la función
                }
                aux = aux.siguiente; // Avanza al siguiente nodo
            }
        }
    }

    public void insertarEnPosicion(int posicion, T dato) { // Inserta un elemento en la posición especificada de la lista.
        if (posicion == 0) { // Si la posición es 0
            insertarEnPrimero(dato); // Inserta el elemento como el primero
        } else {
            Nodo<T> aux = primero; // Inicializa un nodo auxiliar para recorrer la lista desde el primero
            int contador = 0; // Inicializa un contador para seguir la posición actual
            while (contador < posicion - 1 && aux.siguiente != null) { // Mientras no se llegue a la posición anterior a la especificada
                aux = aux.siguiente; // Avanza al siguiente nodo
                contador++; // Incrementa el contador de posición
            }
            Nodo<T> temporal = new Nodo<>(dato); // Crea un nuevo nodo con el dato especificado
            temporal.siguiente = aux.siguiente; // El siguiente del nuevo nodo apunta al siguiente del nodo actual
            aux.siguiente = temporal; // El siguiente del nodo actual apunta al nuevo nodo
        }
    }

    public void borrarPorPosicion(int posicion) { // Elimina el nodo en la posición especificada.
        if (!estaVacia() && posicion == 0) { // Si la lista no está vacía y la posición es 0
            primero = primero.siguiente; // El siguiente nodo después del primero se convierte en el nuevo primero
        } else {
            Nodo<T> aux = primero; // Inicializa un nodo auxiliar para recorrer la lista desde el primero
            int contador = 0; // Inicializa un contador para seguir la posición actual
            while (contador < posicion - 1 && aux.siguiente != null) { // Mientras no se llegue a la posición anterior a la especificada
                aux = aux.siguiente; // Avanza al siguiente nodo
                contador++; // Incrementa el contador de posición
            }
            if (aux.siguiente != null) { // Si el siguiente nodo existe
                aux.siguiente = aux.siguiente.siguiente; // Salta el nodo en la posición especificada
            }
        }
    }

    // Método para encontrar elementos con un predicado
    public T encontrarConPredicado(Predicate<T> criterio) { // Busca el primer elemento que cumple con el criterio especificado por el predicado y retorna su información.
        Nodo<T> actual = primero; // Inicializa un nodo actual para recorrer la lista desde el primero
        while (actual != null) { // Mientras haya nodos en la lista
            if (criterio.test(actual.info)) { // Si el nodo actual cumple con el criterio especificado por el predicado
                return actual.info; // Retorna la información del nodo actual
            }
            actual = actual.siguiente; // Avanza al siguiente nodo
        }
        return null; // Retorna null si no se encontró ningún elemento que cumpla con el criterio
    }

    public boolean eliminarConPredicado(Predicate<T> criterio) { // Elimina el primer nodo que cumple con el criterio especificado por el predicado y retorna true si se realizó la eliminación.
        if (estaVacia()) {
            return false; // Si la lista está vacía, retorna false
        }
        if (criterio.test(primero.info)) { // Si el primer nodo cumple con el criterio especificado por el predicado
            primero = primero.siguiente; // Elimina el primer nodo
            return true; // Retorna true indicando que se realizó la eliminación
        }

        Nodo<T> actual = primero; // Inicializa un nodo actual para recorrer la lista desde el primero
        while (actual.siguiente != null) { // Mientras no se llegue al último nodo
            if (criterio.test(actual.siguiente.info)) { // Si el siguiente nodo cumple con el criterio especificado por el predicado
                actual.siguiente = actual.siguiente.siguiente; // Elimina el nodo siguiente
                return true; // Retorna true indicando que se realizó la eliminación
            }
            actual = actual.siguiente; // Avanza al siguiente nodo
        }
        return false; // Retorna false si no se encontró ningún nodo que cumpla con el criterio
    }
}
