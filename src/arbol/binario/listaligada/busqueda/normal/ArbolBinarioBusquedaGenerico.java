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
public class ArbolBinarioBusquedaGenerico extends ArbolBinarioListaLigada {

    public ArbolBinarioBusquedaGenerico(NodoBinarioBusqueda raiz) {
        super(raiz);
    }

    public ArbolBinarioBusquedaGenerico() {
        super(null);
    }

    /**
     * Inserta datos en el arbol
     *
     * @param dato
     * @return
     * @throws java.lang.Exception
     */
    public NodoBinarioBusqueda insertar(Comparable dato) throws Exception {
        return insertar(new NodoBinarioBusqueda(dato));

    }

    /**
     * Inserta datos en el arbol
     *
     * @param nodoDato
     * @return
     * @throws java.lang.Exception
     */
    public NodoBinarioBusqueda insertar(NodoBinarioBusqueda nodoDato) throws Exception {
        if (raiz == null) {
            raiz = nodoDato;
            return  (NodoBinarioBusqueda) raiz;
        } else {
            Comparable dato = nodoDato.getDato();
            NodoBinarioBusqueda aux = (NodoBinarioBusqueda) raiz;
            while (aux != null) {

                if (aux.getDato().compareTo(dato) == 0) {
                    return aux;
                } else if (dato.compareTo(aux.getDato()) < 0) {
                    if (aux.getLi() != null) {
                        aux = (NodoBinarioBusqueda) aux.getLi();
                    } else {  // Se debe insertar
                        aux.setLi(nodoDato);
                        return nodoDato;
                    }
                } else {
                    if (aux.getLd() != null) {
                        aux = (NodoBinarioBusqueda) aux.getLd();
                    } else {  // Se debe insertar
                        aux.setLd(nodoDato);
                        return nodoDato;
                    }
                }
            }
        }
        throw new Exception(" Falla en el recorrido para la inserción");
    }

    /**
     * Este metodo retorna el nodo si el dato se encuentra o null de lo
     * contrario
     *
     * @param dato
     * @return
     */
    public NodoBinarioBusqueda buscar(Comparable dato) {
        NodoBinarioBusqueda aux = (NodoBinarioBusqueda) raiz;
        while (aux != null) {

            if (aux.getDato().compareTo(dato) == 0) {
                return aux;
            } else if (dato.compareTo(aux.getDato()) < 0) {
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
