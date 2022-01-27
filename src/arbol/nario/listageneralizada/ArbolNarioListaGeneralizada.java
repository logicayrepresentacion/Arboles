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
package arbol.nario.listageneralizada;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Alejandro Escobar
 */
public class ArbolNarioListaGeneralizada {

    NodoNario raiz;
    // Variables globales para identificar acciones
    final static boolean TRANSFORMAR = true;
    final static boolean NOTRANSFORMAR = false;

    /**
     * Otro constructor
     *
     * @param raiz
     */
    private ArbolNarioListaGeneralizada(NodoNario raiz) {
        this.raiz = raiz;
    }

    public ArbolNarioListaGeneralizada() {
    }

    /**
     * Es una forma de pintar el arbol
     */
    void mostrarPorListas() {
        Stack<NodoNario> migas = new Stack();
        migas.add(raiz);
        while (!migas.empty()) {
            NodoNario pr = migas.pop();
            while (pr != null) {
                if (pr.getSw() == 0) {
                    System.out.print(pr.getDato()); // Operar el recorrido
                } else {
                    NodoNario npr = (NodoNario) pr.getDato(); // Operar
                    migas.add(npr);
                }
                pr = pr.getLiga();
            }
        }
    }


    /**
     * Validar
     */
    public void imprimirXNivel() {
        NodoNario r = raiz;
        Queue<NodoNario> cola = new LinkedList<>();
        while (r != null) {
            if (r.getSw() == 1) {
                NodoNario realHijo = (NodoNario) r.getDato();
                System.out.print(realHijo.getDato()); // operación
                cola.add(realHijo.getLiga());
            } else {
                System.out.print(r.getDato()); // operación
            }
            r = r.getLiga();
            if (r == null && !cola.isEmpty()) {
                r = cola.remove();
            }
        }
    }

    public NodoNario getRaiz() {
        return raiz;
    }

}
