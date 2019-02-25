/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.binario.listaligada.busqueda.avl.ejemplos;

import arbol.binario.listaligada.busqueda.avl.ArbolAVL;

/**
 *
 * @author cadav
 */
public class EjemploAVL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArbolAVL arbolAVL = new ArbolAVL();

        arbolAVL.insertarDato('a');
        arbolAVL.insertarDato('b');
        arbolAVL.insertarDato('c');
        arbolAVL.insertarDato('d');
        arbolAVL.insertarDato('e');
        arbolAVL.insertarDato('f');
        System.out.println("Pare");
        
        System.out.println( "Buscar = " + arbolAVL.buscar('e') );
        System.out.println( "Buscar = " + arbolAVL.buscar('h') );
        
    }

}
