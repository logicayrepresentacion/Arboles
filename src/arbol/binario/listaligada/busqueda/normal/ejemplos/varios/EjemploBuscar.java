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
package arbol.binario.listaligada.busqueda.normal.ejemplos.varios;

import arbol.binario.listaligada.busqueda.normal.ArbolBinarioBusqueda;

/**
 *
 * @author Alejandro
 */
public class EjemploBuscar {

    public static void main(String[] args) {

        ArbolBinarioBusqueda abb = new ArbolBinarioBusqueda();
        
        String miCadena = " Defi nición\n"
                + "Un tipo abstracto de datos (TAD) se defi ne como un conjunto de dominios D, un dominio d\n"
                + "designado de D, un conjunto de funciones F y un conjunto de axiomas.\n"
                + "Las funciones defi nen las operaciones que se pueden efectuar con los objetos de la\n"
                + "estructura y su sintaxis, y los axiomas especifi can cómo operan dichas funciones.\n"
                + "Las funciones se clasifi can en primarias y secundarias. Para cada una de ellas se debe\n"
                + "especifi car el resultado que se obtiene al ejecutarlas.\n"
                + "Las especifi caciones de cómo opera cada una de las funciones se denominan axiomas. Estas especifi caciones se defi nen utilizando recursión y la estructura clásica de decisión if-then-else, y no se emplean ciclos ni la estructura secuencia.\n"
                + "Las funciones primarias, conocidas también como generadoras o de creación, permiten crear la estructura vacía y generar o incluir todos los posibles valores del TAD. Las\n"
                + "funciones primarias no requieren axiomas.";
        char[] letras = miCadena.toCharArray();
        for (char letra : letras) {
            abb.insertar(letra);
        }
        
        System.out.println  ( abb.buscar('x')  ); 
        System.out.println  ( abb.buscar(';')  );
        
        
        System.out.println("Pare ");

    }
}
