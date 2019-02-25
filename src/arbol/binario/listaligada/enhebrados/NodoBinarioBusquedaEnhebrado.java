/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.binario.listaligada.enhebrados;

import arbol.binario.listaligada.busqueda.NodoBinarioBusqueda;

/**
 *
 * @author Alejandro Escobar
 * @param <T>
 */
public class NodoBinarioBusquedaEnhebrado<T extends Comparable> extends NodoBinarioBusqueda {

    private boolean bi;
    private boolean bd;

    public NodoBinarioBusquedaEnhebrado(T d) {
        super(d);
    }

    public boolean isBd() {
        return bd;
    }

    public boolean isBi() {
        return bi;
    }

    public void setBd(boolean bd) {
        this.bd = bd;
    }

    public void setBi(boolean bi) {
        this.bi = bi;
    }

    
    public NodoBinarioBusquedaEnhebrado getLdBE() {
        return (NodoBinarioBusquedaEnhebrado) super.getLd(); 
    }

    
    public NodoBinarioBusquedaEnhebrado getLiBE() {
        return (NodoBinarioBusquedaEnhebrado) super.getLi(); 
    }

    
    
}
