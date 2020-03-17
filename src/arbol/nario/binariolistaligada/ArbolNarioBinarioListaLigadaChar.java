/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.nario.binariolistaligada;

import arbol.binario.listaligada.normal.ArbolBinarioListaLigadaChar;
import arbol.binario.listaligada.normal.NodoBinarioChar;

/**
 *
 * @author 57300
 */
public class ArbolNarioBinarioListaLigadaChar extends ArbolBinarioListaLigadaChar {

    public ArbolNarioBinarioListaLigadaChar(NodoBinarioChar raiz) {
        super(raiz);
    }

    public int numeroHojas() {
        return -1;
    }
}
