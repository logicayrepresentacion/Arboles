/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.binario.listaligada.ejemplos;

import arbol.binario.listaligada.ArbolBinarioListaLigada;
import arbol.binario.listaligada.NodoBinario;
import arbol.binario.listaligada.busqueda.NodoBinarioBusqueda;

/**
 *
 * @author alejandroescobar
 */
public class EjemploReconstruccionConCaracter {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        String inorden = "gehicbfdajklnmop";
        String preorden = "abceghidflkjmnop";
        
        Character[] inordenCH  = convertirChar2Character( inorden );
        Character[] preordenCH = convertirChar2Character( preorden );
        
        ArbolBinarioListaLigada abll = new ArbolBinarioListaLigada();
        NodoBinario raiz = ArbolBinarioListaLigada.construyeArbolCadenaPREyIN( preordenCH, inordenCH);
        
        abll.setRaiz(raiz);
        ArbolBinarioListaLigada.inorden(raiz);
    }

    private static Character[] convertirChar2Character(String cadena) {
        Character[] nuevoCH = new Character[ cadena.length()]; 
        for (int i = 0; i < cadena.length(); i++) {
            Character c = cadena.charAt(i);
            nuevoCH[i] = c;
        }
        return nuevoCH;
    }
    
}
