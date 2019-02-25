/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.binario.listaligada.ejemplos;

import arbol.binario.listaligada.ArbolBinarioListaLigada;
import arbol.binario.listaligada.busqueda.NodoBinarioBusqueda;

/**
 *
 * @author alejandroescobar
 */
public class EjemploArbolBinarioConCaracter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NodoBinario a = new NodoBinario("a");
        NodoBinario b = new NodoBinario("b");
        NodoBinario c = new NodoBinario("c");
        NodoBinario d = new NodoBinario("d");
        NodoBinario e = new NodoBinario("e");
        NodoBinario f = new NodoBinario("f");
        NodoBinario g = new NodoBinario("g");
        NodoBinario h = new NodoBinario("h");
        NodoBinario i = new NodoBinario("i");
        NodoBinario j = new NodoBinario("j");
        NodoBinario k = new NodoBinario("k");
        NodoBinario l = new NodoBinario("l");
        NodoBinario m = new NodoBinario("m");
        NodoBinario n = new NodoBinario("n");
        NodoBinario o = new NodoBinario("o");
        NodoBinario p = new NodoBinario("p");
        
        h.setLd(i);
        e.setLi(g);
        e.setLd(h);
        c.setLi(e);
        b.setLi(c);
        b.setLd(d);
        d.setLi(f);
        a.setLi(b);
        a.setLd(l);
        l.setLi(k);
        k.setLi(j);
        l.setLd(m);
        m.setLi(n);
        m.setLd(o);
        o.setLd(p);
        
        ArbolBinarioListaLigada.inorden(a);
        System.out.println("");
        ArbolBinarioListaLigada.preorden(a);
        System.out.println("");

        ArbolBinarioListaLigada miArbol = new ArbolBinarioListaLigada(a);
        int cantidadHojas = miArbol.contarHojas();
        System.out.println("Cantidad de hojas " + cantidadHojas);
        
    }
    
}
