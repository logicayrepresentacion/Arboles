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
        NodoBinarioBusqueda a = new NodoBinarioBusqueda("a");
        NodoBinarioBusqueda b = new NodoBinarioBusqueda("b");
        NodoBinarioBusqueda c = new NodoBinarioBusqueda("c");
        NodoBinarioBusqueda d = new NodoBinarioBusqueda("d");
        NodoBinarioBusqueda e = new NodoBinarioBusqueda("e");
        NodoBinarioBusqueda f = new NodoBinarioBusqueda("f");
        NodoBinarioBusqueda g = new NodoBinarioBusqueda("g");
        NodoBinarioBusqueda h = new NodoBinarioBusqueda("h");
        NodoBinarioBusqueda i = new NodoBinarioBusqueda("i");
        NodoBinarioBusqueda j = new NodoBinarioBusqueda("j");
        NodoBinarioBusqueda k = new NodoBinarioBusqueda("k");
        NodoBinarioBusqueda l = new NodoBinarioBusqueda("l");
        NodoBinarioBusqueda m = new NodoBinarioBusqueda("m");
        NodoBinarioBusqueda n = new NodoBinarioBusqueda("n");
        NodoBinarioBusqueda o = new NodoBinarioBusqueda("o");
        NodoBinarioBusqueda p = new NodoBinarioBusqueda("p");
        
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
        
    }
    
}
