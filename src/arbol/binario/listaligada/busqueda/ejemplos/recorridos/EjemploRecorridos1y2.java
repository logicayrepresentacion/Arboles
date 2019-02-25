/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.binario.listaligada.busqueda.ejemplos.recorridos;

import arbol.binario.listaligada.ArbolBinarioListaLigada;
import arbol.binario.listaligada.busqueda.ArbolBinarioBusqueda;

/**
 *
 * @author Alejandro
 */
public class EjemploRecorridos1y2 {

    public static void main(String[] args) {

        ArbolBinarioBusqueda abb = new ArbolBinarioBusqueda();
        abb.insertar('a');
        abb.insertar('b');
        abb.insertar('d');
        abb.insertar('f');
        abb.insertar('c');
        abb.insertar('e');
        abb.recorrido1();
        System.out.println("");
        abb.recorrido2();
        System.out.println("");
        ArbolBinarioListaLigada.inorden(abb.getRaiz());
        System.out.println("");
        if (abb.buscar('f') == null) {
            System.out.println("No esta");

        } else {
            System.out.println("Si esta");
        }
    }
}
