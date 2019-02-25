/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.binario.listaligada.busqueda;

import arbol.binario.listaligada.NodoBinario;

/**
 *
 * @author Alejandro
 * @param <T>
 */
public class NodoBinarioBusqueda<T extends Comparable> extends NodoBinario<T> {

    public NodoBinarioBusqueda(T dato) {
        super(dato);
    }

    @Override
    public T getDato() {
        return dato;
    }
    
    
    
    
}
