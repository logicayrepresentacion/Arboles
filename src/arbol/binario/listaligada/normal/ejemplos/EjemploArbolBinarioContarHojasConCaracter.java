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
package arbol.binario.listaligada.normal.ejemplos;

import arbol.binario.listaligada.normal.ArbolBinarioListaLigada;
import arbol.binario.listaligada.normal.NodoBinarioGenerico;

/**
 *
 * @author alejandroescobar
 */
public class EjemploArbolBinarioContarHojasConCaracter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NodoBinarioGenerico a = new NodoBinarioGenerico("a");
        NodoBinarioGenerico b = new NodoBinarioGenerico("b");
        NodoBinarioGenerico c = new NodoBinarioGenerico("c");
        NodoBinarioGenerico d = new NodoBinarioGenerico("d");
        NodoBinarioGenerico e = new NodoBinarioGenerico("e");
        NodoBinarioGenerico f = new NodoBinarioGenerico("f");
        NodoBinarioGenerico g = new NodoBinarioGenerico("g");
        NodoBinarioGenerico h = new NodoBinarioGenerico("h");
        NodoBinarioGenerico i = new NodoBinarioGenerico("i");
        NodoBinarioGenerico j = new NodoBinarioGenerico("j");
        NodoBinarioGenerico k = new NodoBinarioGenerico("k");
        NodoBinarioGenerico l = new NodoBinarioGenerico("l");
        NodoBinarioGenerico m = new NodoBinarioGenerico("m");
        NodoBinarioGenerico n = new NodoBinarioGenerico("n");
        NodoBinarioGenerico o = new NodoBinarioGenerico("o");
        NodoBinarioGenerico p = new NodoBinarioGenerico("p");
        
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

        int cantidadHojas = ArbolBinarioListaLigada.hojas(a);
        System.out.println("Cantidad de hojas " + cantidadHojas);
        
    }
    
}
