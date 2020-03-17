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
package arbol.binario.listaligada.normal;

import java.util.Arrays;
import java.util.Stack;

/**
 *
 * @author alejandroescobar
 */
public class ArbolBinarioListaLigadaChar {

    protected NodoBinarioChar raiz;

    public ArbolBinarioListaLigadaChar() {
    }

    public ArbolBinarioListaLigadaChar(NodoBinarioChar raiz) {
        this.setRaiz(raiz);
    }

    public void setRaiz(NodoBinarioChar raiz) {
        this.raiz = raiz;
    }

    public NodoBinarioChar getRaiz() {
        return raiz;
    }

    /**
     *
     * @param r
     */
    public static void inorden(NodoBinarioChar r) {
        if (r != null) {
            inorden(r.getLi());
            System.out.print(r.getDato());
            inorden(r.getLd());
        }
    }

    /**
     *
     * @param r
     */
    public static void preorden(NodoBinarioChar r) {
        if (r != null) {
            System.out.print(r.getDato());
            preorden(r.getLi());
            preorden(r.getLd());
        }
    }

    /**
     *
     * @param r
     */
    public static void posorden(NodoBinarioChar r) {
        if (r != null) {
            preorden(r.getLi());
            preorden(r.getLd());
            System.out.print(r.getDato());
        }
    }

    /**
     * Contar las hojas de un arbol
     *
     * @param r
     * @return
     */
    public static int hojas(NodoBinarioChar r) {
        int numeroHojas = 0;
        if (r != null) {
            if (r.getLi() == null && r.getLd() == null) {
                return 1;
            } else {
                numeroHojas = numeroHojas + hojas(r.getLi()) + hojas(r.getLd());
            }
        }
        return numeroHojas;
    }

    /**
     *
     * @param hilera
     * @return
     */
    public static NodoBinarioChar convertirHilera(String hilera) {

        char[] c = hilera.toCharArray();

        NodoBinarioChar raiz, pr, u;
        pr = new NodoBinarioChar(c[1]);
        raiz = pr;
        u = raiz;
        int i = 3;
        int longitudCadena = c.length;
        int numeroParada = longitudCadena - 2;
        Stack<NodoBinarioChar> migasDerecha = new Stack();
        while (i < numeroParada) {
            if (c[i] == ',') { // Posibilidad finalizo la izquierda
                i++;
                NodoBinarioChar x = new NodoBinarioChar(c[i]);
                u.setLd(x);
                if (c[i + 1] == ')') {
                    i = i + 2;
                    if (!migasDerecha.empty()) {
                        u = migasDerecha.pop();
                    }
                } else {
                    u = x;
                    i = i + 2;
                }
            } else { // Posibilidad átomo, tiene liga izquierda
                NodoBinarioChar x = new NodoBinarioChar(c[i]);
                u.setLi(x);
                if (c[i + 1] == ',') { //No tiene hijos
                    i = i + 2;
                    if (c[i] == ')') {
                        u = migasDerecha.pop();
                        i++;
                    } else {
                        NodoBinarioChar y = new NodoBinarioChar(c[i]);
                        u.setLd(y);
                        u = y;
                        i = i + 2;
                    }
                } else if (c[i + 1] == '(') { // Tiene hijos
                    migasDerecha.add(u);
                    u = x;
                    i = i + 2;
                } else if (c[i + 1] == ')') { // Finaliza hijo derecho

                } else {  // átomo

                }
            }
        }
        return raiz;
    }

    /**
     * Para la construcción de un arbol con las cadenas PRE e IN
     *
     * @param preorden es una arreglo de caracteres para el preorden
     * @param inorden es un arreglo de caracteres para el inorden
     * @return Nodo raiz del arbol
     * @throws java.lang.Exception
     */
    public static NodoBinarioChar construyeArbolCadenaPREyIN(char[] preorden, char[] inorden) throws Exception {
        NodoBinarioChar r = reconstuir(preorden, inorden);
        return r;
    }

    /**
     * Esta función es recursiva, se llama una y otra vez Para la construcción
     * de un arbol con las cadenas PRE e IN
     *
     * @param preorden
     * @param inorden
     * @return
     */
    private static NodoBinarioChar reconstuir(char[] preorden, char[] inorden) throws Exception {
        /**
         * Se extrae el dato con la raiz de esta ejecución y se crea el nodo con
         * ese caracter
         */
        char datoRaiz = preorden[0];
        NodoBinarioChar raiz = new NodoBinarioChar(datoRaiz);

        /**
         * Evalua la parte más izquierda
         */
        int posDatoRaizEnInorden = buscarEnVector(inorden, datoRaiz);
        char[] nuevoVectorInorden = cortarIzquierda(inorden, posDatoRaizEnInorden);
        int posPreorden = 0;
        char[] nuevoPreorden;
        if (nuevoVectorInorden.length != 0) {
            posPreorden = nuevoVectorInorden.length;
            nuevoPreorden = cortarNDatos(preorden, 1, posPreorden + 1);
            if (posPreorden != 0) {
                raiz.setLi(reconstuir(nuevoPreorden, nuevoVectorInorden)); // Llamado recursivo
            }
        }

        /**
         * Evalua la parte más derecha
         */
        nuevoVectorInorden = cortarDerecha(inorden, posDatoRaizEnInorden);
        if (nuevoVectorInorden.length != 0) {
            nuevoPreorden = cortarNDatos(preorden, posPreorden + 1, nuevoVectorInorden.length + posPreorden + 1);
            raiz.setLd(reconstuir(nuevoPreorden, nuevoVectorInorden));
        }
        return raiz;
    }

    /**
     * Busca un caracter en un vector de caracteres
     *
     * @param arr
     * @param dr
     * @return
     * @throws java.lang.Exception
     */
    public static int buscarEnVector(char[] arr, char dr) throws Exception {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == dr) {
                return i;
            }
        }
        throw new Exception("No se encuentra en el Vector");
    }

    public static char[] cortarIzquierda(char[] arr, int pdrin) {
        return Arrays.copyOfRange(arr, 0, pdrin);
    }

    private static char[] cortarNDatos(char[] arr, int i, int f) {
        return Arrays.copyOfRange(arr, i, f);
    }

    private static char[] cortarDerecha(char[] arr, int pdrin) {
        return Arrays.copyOfRange(arr, pdrin + 1, arr.length);
    }

}
