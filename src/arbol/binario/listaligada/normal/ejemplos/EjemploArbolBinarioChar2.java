/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.binario.listaligada.normal.ejemplos;

import arbol.binario.listaligada.normal.ArbolBinarioListaLigadaChar;
import arbol.binario.listaligada.normal.NodoBinarioChar;

/**
 *
 * @author 57300
 */
public class EjemploArbolBinarioChar2 {

    public static void main(String[] args) throws Exception {
        String inorden = "gehicbfdajklnmop";
        String preorden = "abceghidflkjmnop";
        char[] charPreorden;
        charPreorden = preorden.toCharArray();

        NodoBinarioChar raiz;

        raiz = ArbolBinarioListaLigadaChar.construyeArbolCadenaPREyIN(charPreorden, inorden.toCharArray());
        ArbolBinarioListaLigadaChar.inorden(raiz);
        System.out.println("");
        ArbolBinarioListaLigadaChar.preorden(raiz);
        System.out.println("");
        ArbolBinarioListaLigadaChar.posorden(raiz);

    }
}
