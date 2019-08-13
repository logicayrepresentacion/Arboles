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
package arbol.binario.listaligada.busqueda.ejemplos.palabras;


import arbol.binario.listaligada.busqueda.NodoBinarioBusqueda;
import arbol.binario.listaligada.busqueda.ArbolBinarioBusqueda;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author alejandroescobar
 */
class IndicePalabrasABB extends ArbolBinarioBusqueda {

    public void imprimirCantidades() {
        Queue<NodoBinarioBusqueda> queue = new LinkedList<>();
        System.out.println("Comienzo recorrido1");
        NodoBinarioBusqueda raizlocal = (NodoBinarioBusqueda) getRaiz();
        if (raizlocal != null) {
            queue.add(raizlocal);
            NodoBinarioBusqueda a;
            while (!queue.isEmpty()) {
                a = queue.poll();
                Palabra p = (Palabra) a.getDato();
                System.out.println(p);
                if (a.getLi()!= null) {
                    queue.add((NodoBinarioBusqueda) a.getLi());
                }
                if (a.getLd()!= null) {
                    queue.add((NodoBinarioBusqueda) a.getLd());
                }
            }
        }
    }

    @Override
    public NodoBinarioBusqueda insertar(Comparable dato) {
        NodoBinarioBusqueda i = super.insertar(dato);
        if (i != null) {
            Palabra p = (Palabra) (i.getDato());
            int c = p.getContador();
            p.setContador(c + 1);
        }
        return i;
    }

}
