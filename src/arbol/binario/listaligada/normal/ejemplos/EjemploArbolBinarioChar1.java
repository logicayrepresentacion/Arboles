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
public class EjemploArbolBinarioChar1 {

    public static void main(String[] args) {
        String hilera = "(a(b,c(d(f(z,),g),e(h(,k),i))))";
        NodoBinarioChar raiz = ArbolBinarioListaLigadaChar.convertirHilera(hilera);
        System.out.println("raiz " + raiz);

    
        ArbolBinarioListaLigadaChar.inorden(raiz);
        
    }
}
