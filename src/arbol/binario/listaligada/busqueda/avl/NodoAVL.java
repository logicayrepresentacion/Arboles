/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.binario.listaligada.busqueda.avl;

import arbol.binario.listaligada.busqueda.NodoBinarioBusqueda;

/**
 *
 * @author cadav
 * @param <T>
 */
public class NodoAVL<T extends Comparable> extends NodoBinarioBusqueda {
    
    private int fB;

    public NodoAVL(T dato) {
        super(dato);
    }
    
    public int getfB() {
        return fB;
    }

    public void setfB(int fB) {
        this.fB = fB;
    }

    
}
  