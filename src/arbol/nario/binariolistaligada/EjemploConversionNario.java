/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.nario.binariolistaligada;

import arbol.binario.listaligada.normal.NodoBinarioChar;
import arbol.nario.listageneralizada.ArbolNarioListaGeneralizada;
import arbol.nario.listageneralizada.NodoNario;

/**
 *
 * @author 57300
 */
public class EjemploConversionNario {

    public static void main(String[] args) {
        String hilera = "(a(b(c,d(e)),f,g(h,i(j,k(l)),m,n)))";
        ArbolNarioListaGeneralizada arbolNarioListaGeneralizada = new ArbolNarioListaGeneralizada(hilera);
        NodoNario raizListaGeneralizada = arbolNarioListaGeneralizada.getRaiz();
        NodoBinarioChar raizNodoBinarioChar = UtilidadesArbolBinarioListaLigadaChar.convertirArbolNario2ArbolBinario(raizListaGeneralizada);
        ArbolNarioBinarioListaLigadaChar.inorden(raizNodoBinarioChar);
        System.out.println("");
        ArbolNarioBinarioListaLigadaChar arbolNarioBinarioListaLigadaChar = new ArbolNarioBinarioListaLigadaChar(raizNodoBinarioChar);
        System.out.println("numero de hojas en el Nario " + arbolNarioBinarioListaLigadaChar.numeroHojas());
        
        System.out.println("numero de hojas en el Binario " + ArbolNarioBinarioListaLigadaChar.hojas(raizNodoBinarioChar));
    }

}
