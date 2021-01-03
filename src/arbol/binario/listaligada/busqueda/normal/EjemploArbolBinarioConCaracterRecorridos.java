/*
 * Copyright 2019 Carlos Alejandro Escobar Marulanda ealejandro101@gmail.com
 * Permission is hereby granted, free of charge, to any person 
 * obtaining a copy of this software and associated documentation 
 * files (the "Software"), to deal in the Software without 
 * restriction, including without limitation the rights to use, 
 * copy, modify, merge, publish, distribute, sublicense, and/or 
 * sell copies of the Software, and to permit persons to whom the 
 * Software is furnished to do so, subject to the following 
 * conditions:
 * The above copyright notice and this permission notice shall 
 * be included in all copies or substantial portions of the 
 * Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, 
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES 
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND 
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 *  WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR 
 * OTHER DEALINGS IN THE SOFTWARE.
 */
package arbol.binario.listaligada.busqueda.normal;

import arbol.binario.listaligada.normal.ArbolBinarioListaLigada;

/**
 *
 * @author alejandroescobar
 */
public class EjemploArbolBinarioConCaracterRecorridos {

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
        NodoBinarioBusqueda r = new NodoBinarioBusqueda("r");
        
        h.setLd(i);
        e.setLi(g);
        e.setLd(h);
        c.setLi(e);
        c.setLd(r);
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
        
        
        System.out.println("Inorden");
        ArbolBinarioListaLigada.inorden(a);
        
        System.out.println("Preorden");
        ArbolBinarioListaLigada.preorden(a);
        System.out.println("");
        
        
        
        ArbolBinarioListaLigada abll = new ArbolBinarioListaLigada(a);
        System.out.println("recorrido 1");
        abll.recorrido1();
        System.out.println("recorrido 2");
        abll.recorrido2();
        System.out.println("");
        
    }
    
}
