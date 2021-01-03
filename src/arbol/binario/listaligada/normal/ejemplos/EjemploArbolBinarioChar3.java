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
public class EjemploArbolBinarioChar3 {

    public static void main(String[] args) throws Exception {
        String inorden = "gehicbfdajklnmop";
        System.out.println(inorden);
        String preorden = "abceghidflkjmnop";
        System.out.println(preorden);

        char[] charPreorden;
        charPreorden = preorden.toCharArray();

        NodoBinarioChar raiz;

        raiz = ArbolBinarioListaLigadaChar.construyeArbolCadenaPREyIN(charPreorden, inorden.toCharArray());
        ArbolBinarioListaLigadaChar.inorden(raiz);
        System.out.println("");
        ArbolBinarioListaLigadaChar.preorden(raiz);
        System.out.println("");
        ArbolBinarioListaLigadaChar.posorden(raiz);

        System.out.println("");
        System.out.println("Número de hojas " + ArbolBinarioListaLigadaChar.hojas(raiz));

    }
}
