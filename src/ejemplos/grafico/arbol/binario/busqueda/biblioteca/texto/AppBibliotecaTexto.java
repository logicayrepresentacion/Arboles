/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos.grafico.arbol.binario.busqueda.biblioteca.texto;

import ejemplos.grafico.arbol.binario.busqueda.biblioteca.Libro;

/**
 *
 * @author alejandro.escobar
 */
public class AppBibliotecaTexto {

    public static void main(String[] args) {
        ArbolBinarioBusquedaLibros biblioteca = new ArbolBinarioBusquedaLibros();

        Libro libro = new Libro(3, "Lo que el viento se llevo", "Mio", "600.71");

        biblioteca.insertar(libro);

        libro = new Libro(2, "La traición de Roma", "Augusto", "500.71");

        biblioteca.insertar(libro);

        libro = new Libro(10, "La traición de Pedro", "Augusto", "500.73");

        biblioteca.insertar(libro);

        System.out.println("FIN");

        System.out.println(" Libro 10 " + biblioteca.consultar(10));

        System.out.println("Lista \n" + biblioteca.listar());

    }
}
