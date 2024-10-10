package com.mycompany.sistemagestionbiblioteca;

public class Libro {

    // Atributos de la clase Libro
    private String titulo;  // Título del libro
    private String autor;   // Autor del libro
    private String isbn;    // ISBN del libro
    private Usuario usuarioPrestado; // Usuario al que está prestado el libro

    // Constructor de la clase Libro
    public Libro(String titulo, String autor, String isbn) {
        this.titulo = titulo;   // Asigna el título proporcionado al libro
        this.autor = autor;     // Asigna el autor proporcionado al libro
        this.isbn = isbn;       // Asigna el ISBN proporcionado al libro
        this.usuarioPrestado = null; // Inicializa el usuario prestado como null (no prestado inicialmente)
    }

    // Método para verificar si el libro está prestado
    public boolean isPrestado() {
        return usuarioPrestado != null; // Devuelve true si el libro está prestado (usuarioPrestado no es null)
    }

    // Método para prestar el libro a un usuario
    public void prestarA(Usuario usuario) {
        this.usuarioPrestado = usuario; // Asigna el usuario proporcionado como usuario prestado
    }

    // Método para devolver el libro
    public void devolver() {
        this.usuarioPrestado = null; // Asigna null al usuario prestado (el libro se devuelve y ya no está prestado)
    }

    // Getters para obtener los atributos del libro
    public String getTitulo() {
        return titulo; // Devuelve el título del libro
    }

    public String getAutor() {
        return autor; // Devuelve el autor del libro
    }

    public String getIsbn() {
        return isbn; // Devuelve el ISBN del libro
    }

    public Usuario getUsuarioPrestado() {
        return usuarioPrestado; // Devuelve el usuario al que está prestado el libro
    }

    // Método toString para representar el libro como una cadena de texto
    @Override
    public String toString() {
        // Determina el estado de préstamo del libro y crea una cadena de texto con la información del libro
        String estadoPrestamo = isPrestado() ? ", Prestado a: " + usuarioPrestado.getNombre() : ", No está prestado";
        return "--------------"
                + // Línea de separación visual
                "\nISBN: " + isbn
                + // Información del ISBN del libro
                "\nTítulo: " + titulo
                + // Información del título del libro
                "\nAutor: " + autor
                + // Información del autor del libro
                estadoPrestamo; // Información sobre si el libro está prestado y, en ese caso, a quién está prestado
    }
}
