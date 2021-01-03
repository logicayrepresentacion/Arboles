/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.binario.listaligada.normal.ejemplos;

import arbol.binario.listaligada.normal.ArbolBinarioListaLigada;
import arbol.binario.listaligada.normal.NodoBinarioGenerico;
import arbol.nario.listageneralizada.ArbolNarioListaGeneralizada;
import arbol.nario.listageneralizada.NodoNario;

/**
 *
 * @author 57300
 */
public class EjemploArbolNarioEnBinario1 {
    public static void main(String[] args) {
        String hilera = "(a(b(c,d(e)),f,g(h,i(j,k(l)),m,n)))";
        System.out.println(hilera);
        ArbolNarioListaGeneralizada arbolLG = new ArbolNarioListaGeneralizada(hilera);
        NodoNario raizNodoNario = arbolLG.getRaiz();
        
        NodoBinarioGenerico generico = ArbolBinarioListaLigada.convertirArbolNario2ArbolBinario(raizNodoNario);

        ArbolBinarioListaLigada abll = new ArbolBinarioListaLigada(generico);
        
    }
}
