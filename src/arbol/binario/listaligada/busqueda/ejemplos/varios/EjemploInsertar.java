/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.binario.listaligada.busqueda.ejemplos.varios;

import arbol.binario.listaligada.ArbolBinarioListaLigada;
import arbol.binario.listaligada.busqueda.ArbolBinarioBusqueda;

/**
 *
 * @author Alejandro
 */
public class EjemploInsertar {

    public static void main(String[] args) {

        ArbolBinarioBusqueda abb = new ArbolBinarioBusqueda();
        abb.insertar('a');
        abb.insertar('b');
        abb.insertar('d');
        abb.insertar('f');
        abb.insertar('c');
        abb.insertar('e');
        System.out.println("Pare ");
        
    }
}
