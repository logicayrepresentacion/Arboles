/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.binario.listaligada.busqueda;

import arbol.binario.listaligada.ArbolBinarioListaLigada;

/**
 *
 * @author Alejandro
 */
public class ArbolBinarioBusqueda extends ArbolBinarioListaLigada {

    public ArbolBinarioBusqueda(NodoBinarioBusqueda raiz) {
        super(raiz);
    }

    public ArbolBinarioBusqueda() {
        super(null);
    }
    
    

    /**
     * Inserta datos en el arbol
     *
     * @param dato
     * @return
     */
    public NodoBinarioBusqueda insertar(Comparable dato) {
        if (raiz == null) {
            raiz = new NodoBinarioBusqueda(dato);
            return (NodoBinarioBusqueda) raiz;
        } else {
            NodoBinarioBusqueda aux = (NodoBinarioBusqueda) raiz;
            while (aux != null) {

                if (aux.getDato().compareTo(dato) == 0) {
                    return aux;
                } else if (    dato.compareTo( aux.getDato() ) < 0) {
                    if (aux.getLi() != null) {
                        aux = (NodoBinarioBusqueda) aux.getLi();
                    } else {  // Se debe insertar
                        NodoBinarioBusqueda newnodo = new NodoBinarioBusqueda(dato);
                        aux.setLi(newnodo);
                        return newnodo;
                    }
                } else {
                    if (aux.getLd() != null) {
                        aux = (NodoBinarioBusqueda) aux.getLd();
                    } else {  // Se debe insertar
                        NodoBinarioBusqueda newnodo = new NodoBinarioBusqueda(dato);
                        aux.setLd(newnodo);
                        return newnodo;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Este metodo retorna el nodo si el dato se encuentra o null de lo contrario
     * @param dato
     * @return 
     */
    public NodoBinarioBusqueda buscar(Comparable dato) {
        NodoBinarioBusqueda aux = (NodoBinarioBusqueda) raiz;
        while (aux != null) {

            if (aux.getDato().compareTo(dato) == 0) {
                return aux;
            } else if (dato.compareTo(   aux.getDato()  ) < 0) {
                if (aux.getLi() != null) {
                    aux = (NodoBinarioBusqueda) aux.getLi();
                } else {
                    return null;
                }
            } else {
                if (aux.getLd() != null) {
                    aux = (NodoBinarioBusqueda) aux.getLd();
                } else {
                    return null;
                }
            }
        }
        return null;
    }

}
