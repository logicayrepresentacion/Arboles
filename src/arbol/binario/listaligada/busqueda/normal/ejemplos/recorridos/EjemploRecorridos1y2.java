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
package arbol.binario.listaligada.busqueda.normal.ejemplos.recorridos;

import arbol.binario.listaligada.normal.ArbolBinarioListaLigada;
import arbol.binario.listaligada.busqueda.normal.ArbolBinarioBusqueda;

/**
 *
 * @author Alejandro
 */
public class EjemploRecorridos1y2 {

    public static void main(String[] args) {

        ArbolBinarioBusqueda abb = new ArbolBinarioBusqueda();
        abb.insertar('a');
        abb.insertar('b');
        abb.insertar('d');
        abb.insertar('f');
        abb.insertar('c');
        abb.insertar('e');
        abb.recorrido1();
        System.out.println("");
        abb.recorrido2();
        System.out.println("");
        ArbolBinarioListaLigada.inorden(abb.getRaiz());
        System.out.println("");
        if (abb.buscar('f') == null) {
            System.out.println("No esta");

        } else {
            System.out.println("Si esta");
        }
    }
}
