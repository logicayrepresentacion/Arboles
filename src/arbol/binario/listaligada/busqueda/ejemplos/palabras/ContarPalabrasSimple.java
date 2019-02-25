/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.binario.listaligada.busqueda.ejemplos.palabras;

import arbol.binario.listaligada.busqueda.ArbolBinarioBusqueda;
import arbol.binario.listaligada.busqueda.NodoBinarioBusqueda;

/**
 *
 * @author Alejandro
 */
public class ContarPalabrasSimple {

    public static void main(String[] args) {

        ArbolBinarioBusqueda abb = new ArbolBinarioBusqueda();

        Palabra p = new Palabra("alejandro");
        NodoBinarioBusqueda nodoInsert = abb.insertar(p);

        Palabra pinsertada = (Palabra) nodoInsert.getDato();
        pinsertada.aumentar();

        System.out.println("Pinsertada " + pinsertada);

        p = new Palabra("alejandrO");
        nodoInsert = abb.insertar(p);
        pinsertada = (Palabra) nodoInsert.getDato();
        pinsertada.aumentar();
        System.out.println("Pinsertada " + pinsertada);

    }
}
