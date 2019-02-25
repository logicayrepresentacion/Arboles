/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.binario.listaligada.busqueda.ejemplos.varios;

import arbol.binario.listaligada.busqueda.ArbolBinarioBusqueda;

/**
 *
 * @author Alejandro
 */
public class EjemploBuscar {

    public static void main(String[] args) {

        ArbolBinarioBusqueda abb = new ArbolBinarioBusqueda();
        
        String miCadena = " Defi nición\n"
                + "Un tipo abstracto de datos (TAD) se defi ne como un conjunto de dominios D, un dominio d\n"
                + "designado de D, un conjunto de funciones F y un conjunto de axiomas.\n"
                + "Las funciones defi nen las operaciones que se pueden efectuar con los objetos de la\n"
                + "estructura y su sintaxis, y los axiomas especifi can cómo operan dichas funciones.\n"
                + "Las funciones se clasifi can en primarias y secundarias. Para cada una de ellas se debe\n"
                + "especifi car el resultado que se obtiene al ejecutarlas.\n"
                + "Las especifi caciones de cómo opera cada una de las funciones se denominan axiomas. Estas especifi caciones se defi nen utilizando recursión y la estructura clásica de decisión if-then-else, y no se emplean ciclos ni la estructura secuencia.\n"
                + "Las funciones primarias, conocidas también como generadoras o de creación, permiten crear la estructura vacía y generar o incluir todos los posibles valores del TAD. Las\n"
                + "funciones primarias no requieren axiomas.";
        char[] letras = miCadena.toCharArray();
        for (char letra : letras) {
            abb.insertar(letra);
        }
        
        System.out.println  ( abb.buscar('x')  ); 
        System.out.println  ( abb.buscar(';')  );
        
        
        System.out.println("Pare ");

    }
}
