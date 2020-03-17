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
package arbol.nario.binariolistaligada;

import arbol.binario.listaligada.normal.NodoBinarioChar;
import arbol.nario.listageneralizada.NodoNario;
import java.util.Stack;

/**
 *
 * @author Alejandro Escobar
 */
public class UtilidadesArbolBinarioListaLigadaChar {

    public static NodoBinarioChar convertirArbolNario2ArbolBinario(NodoNario raizListaGeneralizada) {
        NodoBinarioChar raizBinario = new NodoBinarioChar((char) raizListaGeneralizada.getDato());
        NodoNario primeroRecorridoNario = raizListaGeneralizada.getLiga();
        NodoNario qRecorridoNario = null;
        NodoBinarioChar nodoXBinario = raizBinario;
        NodoBinarioChar ultimoBinario = nodoXBinario;
        Stack pila = new Stack();
        while (primeroRecorridoNario != null) {
            if (primeroRecorridoNario.getSw() == 0) {
                nodoXBinario = new NodoBinarioChar((char) primeroRecorridoNario.getDato());
            } else {
                qRecorridoNario = ((NodoNario) primeroRecorridoNario.getDato());
                nodoXBinario = new NodoBinarioChar((char) qRecorridoNario.getDato());
                pila.add(nodoXBinario);
                pila.add(qRecorridoNario.getLiga());
            }
            ultimoBinario.setLi(nodoXBinario);
            ultimoBinario = nodoXBinario;
            primeroRecorridoNario = primeroRecorridoNario.getLiga(); // que tal si es p y no q?

            while (primeroRecorridoNario != null) {
                if (primeroRecorridoNario.getSw() == 0) {
                    nodoXBinario = new NodoBinarioChar((char) primeroRecorridoNario.getDato());
                } else {
                    qRecorridoNario = ((NodoNario) primeroRecorridoNario.getDato());
                    nodoXBinario = new NodoBinarioChar((char) qRecorridoNario.getDato());
                    pila.add(nodoXBinario);
                    pila.add(qRecorridoNario.getLiga());
                }
                ultimoBinario.setLd(nodoXBinario);
                ultimoBinario = nodoXBinario;
                primeroRecorridoNario = primeroRecorridoNario.getLiga();
            }
            if (!pila.isEmpty()) { // Valido si algún nodo tenia hijos y esta en la pila
                primeroRecorridoNario = (NodoNario) pila.pop();
                ultimoBinario = (NodoBinarioChar) pila.pop();
            }

        }
        return raizBinario;

    }
}
