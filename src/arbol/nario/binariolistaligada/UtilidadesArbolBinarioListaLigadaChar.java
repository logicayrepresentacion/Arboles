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

    public static NodoBinarioChar convertirArbolNario2ArbolBinarioChar(NodoNario raizListaGeneralizada) {
        
        // Creando la raiz del binario con el dato de la raiz de la lista generalizada
        NodoBinarioChar raizBinario = new NodoBinarioChar((char) raizListaGeneralizada.getDato());
        
        // Nodo de la lista generalizada para recorrer en memoria la lista generalizada
        NodoNario primeroRecorridoNario = raizListaGeneralizada.getLiga();
        // Nodo de la lista generalizada que representa la raiz de la sublista, por lo tanto siempre tiene un dato en la liga, su primer hijo
        NodoNario qRecorridoNario = null;
        
        // Nodo para ir creando la representación en binario
        NodoBinarioChar nodoXBinario = raizBinario;
        // Ultimo nodo donde adicione hermanos en el binario, concepto del ultimo de una lista ligada.
        NodoBinarioChar ultimoBinario = nodoXBinario;


        /**
         * Migas para saber en el recorrido de la lista generalizada
         * cuando ingrese a una sublista
         * Y
         * El nodo binario que es la raiz de una sublista
         * Siempre se apilan dos Objetos y se desapilan dos objetos
         * Uno NodoLG
         * Otro NodoBinario
         */
        Stack pila = new Stack();
        
        /**
         * Recorrido por la lista generalizada, siguiendo la regla 
         * del sw 0 o 1 según sea el caso
         * Siguiendo la regla de apilar cuando existe una subrama
         * Desapilar hasta llegar al nodo valido anterior.
         * NOTA: 
         * Se apila el primer hijo de la subrama en la lista generalizada
         * Se apila el nodoBinario raiz de la sublista (el que tiene hijos)
         */
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
            

            /**
             * Recorrido de la lista ligada de hijos en la lista generalizada
             * Todos van a ir ligados por la derecha en el arbol binario
             */
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
