/*
 * Copyright 2019 Carlos Alejandro Escobar Marulanda ealejandro101@gmail.com
 * Permission is hereby granted, free of charge, to any person 
 * obtaining a copy of this software and associated documentation 
 * files (the "Software"), to deal in the Software without 
 * restriction, including without limitation the rights to use, 
 * copy, modify, merge, publish, distribute, sublicense, and/or 
 * sell copies of the Software, and to permit persons to whom the 
 * Software is furnished to do so, subject to the following 
 * conditions:
 * The above copyright notice and this permission notice shall 
 * be included in all copies or substantial portions of the 
 * Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, 
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES 
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND 
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 *  WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR 
 * OTHER DEALINGS IN THE SOFTWARE.
 */
package arbol.binario.listaligada.busqueda.normal;

import arbol.binario.listaligada.normal.ArbolBinarioListaLigada;

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
