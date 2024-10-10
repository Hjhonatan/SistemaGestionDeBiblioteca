package com.mycompany.sistemagestionbiblioteca; // Declaración del paquete

import javax.swing.JOptionPane; // Importación de la clase JOptionPane

public class SistemaGestionBiblioteca { // Declaración de la clase

    // Declaración de variables de instancia para almacenar libros y usuarios
    private ListaEnlazada<Libro> libros = new ListaEnlazada<>();
    private ListaEnlazada<Usuario> usuarios = new ListaEnlazada<>();

    // Método principal que ejecuta el sistema
    public void ejecutar() {
        int opcion = -1; // Variable para almacenar la opción del usuario
        while (opcion != 0) { // Bucle para mostrar el menú hasta que se seleccione la opción de salida
            try { // Captura de excepciones
                opcion = mostrarMenu(); // Llama al método para mostrar el menú y obtener la opción del usuario

                // Switch para realizar diferentes acciones según la opción seleccionada
                switch (opcion) {
                    case 1: // Opción para agregar un libro
                        agregarLibro();
                        break;
                    case 2: // Opción para listar libros
                        listarLibros();
                        break;
                    case 3: // Opción para agregar un usuario
                        agregarUsuario();
                        break;
                    case 4: // Opción para listar usuarios
                        listarUsuarios();
                        break;
                    case 5: // Opción para borrar un libro
                        borrarLibro();
                        break;
                    case 6: // Opción para borrar un usuario
                        borrarUsuario();
                        break;
                    case 7: // Opción para prestar un libro
                        prestarLibro();
                        break;
                    case 8: // Opción para devolver un libro
                        devolverLibro();
                        break;
                    case 0: // Opción para salir del sistema
                        JOptionPane.showMessageDialog(null, "Gracias por usar el sistema.");
                        break;
                    default: // Opción por defecto para manejar entradas inválidas
                        JOptionPane.showMessageDialog(null, "Opción no válida.");
                        break;
                }
            } catch (NumberFormatException e) { // Captura de excepción para entradas no numéricas
                JOptionPane.showMessageDialog(null, "Por favor, introduzca un número válido.");
            }
        }
    }

    // Método para mostrar el menú y obtener la opción del usuario
    private int mostrarMenu() {
        String input = JOptionPane.showInputDialog(null,
                "--- Sistema de Gestión de Biblioteca ---\n"
                + // Menú mostrado al usuario
                "1. Agregar libro\n"
                + "2. Listar libros\n"
                + "3. Agregar usuario\n"
                + "4. Listar usuarios\n"
                + "5. Borrar libro\n"
                + "6. Borrar usuario\n"
                + "7. Prestar libro\n"
                + "8. Devolver libro\n"
                + "0. Salir\n"
                + "Seleccione una opción:");
        return Integer.parseInt(input); // Devuelve la opción seleccionada como un entero
    }

    // Método para agregar un libro
    private void agregarLibro() {
        // Solicita al usuario que ingrese el título, autor e ISBN del libro
        String titulo = JOptionPane.showInputDialog(null, "Ingrese el título del libro:");
        String autor = JOptionPane.showInputDialog(null, "Ingrese el autor del libro:");
        String isbn = JOptionPane.showInputDialog(null, "Ingrese el ISBN del libro:");
        libros.insertarEnPrimero(new Libro(titulo, autor, isbn)); // Crea un nuevo libro y lo agrega a la lista de libros
        JOptionPane.showMessageDialog(null, "Libro agregado exitosamente."); // Muestra un mensaje de éxito
    }

    // Método para listar libros
    private void listarLibros() {
        if (!libros.estaVacia()) { // Comprueba si hay libros en la lista
            String listado = libros.listar(); // Obtiene un listado de libros
            JOptionPane.showMessageDialog(null, "Listado de libros:\n" + listado); // Muestra el listado de libros al usuario
        } else {
            JOptionPane.showMessageDialog(null, "No hay libros en la biblioteca."); // Mensaje si no hay libros
        }
    }

    private void agregarUsuario() {
        // Solicitar al usuario que ingrese el nombre del usuario
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del usuario:");
        // Solicitar al usuario que ingrese el ID del usuario
        String id = JOptionPane.showInputDialog(null, "Ingrese el ID del usuario:");
        // Crear un nuevo objeto Usuario con el nombre y el ID proporcionados y agregarlo a la lista de usuarios
        usuarios.insertarEnPrimero(new Usuario(nombre, id));
        // Mostrar un mensaje indicando que el usuario ha sido agregado exitosamente
        JOptionPane.showMessageDialog(null, "Usuario agregado exitosamente.");
    }

    private void listarUsuarios() {
        // Verificar si la lista de usuarios no está vacía
        if (!usuarios.estaVacia()) {
            // Obtener una representación en forma de cadena de la lista de usuarios
            String listado = usuarios.listar();
            // Mostrar un mensaje que contiene el listado de usuarios
            JOptionPane.showMessageDialog(null, "Listado de usuarios:\n" + listado);
        } else {
            // Mostrar un mensaje si no hay usuarios registrados en la biblioteca
            JOptionPane.showMessageDialog(null, "No hay usuarios registrados.");
        }
    }

    private void borrarLibro() {
        // Solicitar al usuario que ingrese el ISBN del libro que desea borrar
        String isbn = JOptionPane.showInputDialog(null, "Ingrese el ISBN del libro a borrar:");
        // Intentar eliminar el libro con el ISBN proporcionado de la lista de libros
        boolean eliminado = libros.eliminarConPredicado(libro -> libro.getIsbn().equals(isbn));
        // Verificar si el libro fue eliminado con éxito o no
        if (eliminado) {
            // Mostrar un mensaje indicando que el libro ha sido borrado exitosamente
            JOptionPane.showMessageDialog(null, "Libro borrado exitosamente.");
        } else {
            // Mostrar un mensaje si el libro no se encontró en la lista de libros
            JOptionPane.showMessageDialog(null, "No se encontró el libro con el ISBN proporcionado.");
        }
    }

    private void borrarUsuario() {
        // Solicitar al usuario que ingrese el ID del usuario que desea borrar
        String id = JOptionPane.showInputDialog(null, "Ingrese el ID del usuario a borrar:");
        // Intentar eliminar al usuario con el ID proporcionado de la lista de usuarios
        boolean eliminado = usuarios.eliminarConPredicado(usuario -> usuario.getId().equals(id));
        // Verificar si el usuario fue eliminado con éxito o no
        if (eliminado) {
            // Mostrar un mensaje indicando que el usuario ha sido borrado exitosamente
            JOptionPane.showMessageDialog(null, "Usuario borrado exitosamente.");
        } else {
            // Mostrar un mensaje si el usuario no se encontró en la lista de usuarios
            JOptionPane.showMessageDialog(null, "No se encontró el usuario con el ID proporcionado.");
        }
    }

    private void prestarLibro() {
        // Solicitar al usuario que ingrese el ISBN del libro que desea prestar
        String isbn = JOptionPane.showInputDialog(null, "Ingrese el ISBN del libro a prestar:");
        // Solicitar al usuario que ingrese el ID del usuario al que desea prestar el libro
        String idUsuario = JOptionPane.showInputDialog(null, "Ingrese el ID del usuario a quien prestar:");
        // Buscar el libro con el ISBN proporcionado en la lista de libros
        Libro libro = libros.encontrarConPredicado(libro1 -> libro1.getIsbn().equals(isbn));
        // Buscar al usuario con el ID proporcionado en la lista de usuarios
        Usuario usuario = usuarios.encontrarConPredicado(usuario1 -> usuario1.getId().equals(idUsuario));
        // Verificar si el libro y el usuario fueron encontrados, y si el libro no está prestado actualmente
        if (libro != null && usuario != null && !libro.isPrestado()) {
            // Prestar el libro al usuario
            libro.prestarA(usuario);
            // Mostrar un mensaje indicando que el libro ha sido prestado exitosamente al usuario
            JOptionPane.showMessageDialog(null, "Libro prestado con éxito a " + usuario.getNombre());
        } else {
            // Mostrar un mensaje si el libro no está disponible para préstamo o el usuario no fue encontrado
            JOptionPane.showMessageDialog(null, "Libro no disponible para préstamo o usuario no encontrado.");
        }
    }

    private void devolverLibro() {
        // Solicitar al usuario que ingrese el ISBN del libro que desea devolver
        String isbn = JOptionPane.showInputDialog(null, "Ingrese el ISBN del libro a devolver:");
        // Buscar el libro con el ISBN proporcionado en la lista de libros que esté prestado actualmente
        Libro libro = libros.encontrarConPredicado(libro1 -> libro1.getIsbn().equals(isbn) && libro1.isPrestado());
        // Verificar si se encontró un libro prestado con el ISBN proporcionado
        if (libro != null) {
            // Marcar el libro como devuelto
            libro.devolver();
            // Mostrar un mensaje indicando que el libro ha sido devuelto exitosamente
            JOptionPane.showMessageDialog(null, "Libro devuelto con éxito.");
        } else {
            // Mostrar un mensaje si el libro no estaba prestado o no se encontró en la lista de libros
            JOptionPane.showMessageDialog(null, "Este libro no estaba prestado o no existe.");
        }
    }

    public static void main(String[] args) {
        new SistemaGestionBiblioteca().ejecutar(); // Crear una instancia del sistema y ejecutarlo
    }
}
