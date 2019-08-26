/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.binario.listaligada.busqueda.normal.ejemplos.indicepalabras;

import arbol.binario.listaligada.busqueda.normal.ArbolBinarioBusqueda;
import arbol.binario.listaligada.busqueda.normal.NodoBinarioBusqueda;

/**
 *
 * @author Usuario
 */
public class IndicePalabrasEspecial extends ArbolBinarioBusqueda {

    public NodoBinarioBusqueda insertar(Palabra dato, int pos) throws Exception {
        NodoBinarioBusqueda i = super.insertar(dato);
        if (i != null) {
            Palabra p = (Palabra) (i.getDato());
            p.aumentar();
            p.insertarPosicion(pos);
        }
        return i;
    }

}
