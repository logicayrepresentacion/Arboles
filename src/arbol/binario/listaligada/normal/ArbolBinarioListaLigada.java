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

import arbol.nario.listageneralizada.NodoNario;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author alejandroescobar
 * @param <E>
 */
public class ArbolBinarioListaLigada<E> {

    protected NodoBinarioGenerico<E> raiz;

    public ArbolBinarioListaLigada() {
    }

    public ArbolBinarioListaLigada(NodoBinarioGenerico<E> raiz) {
        this.setRaiz(raiz);
    }

    public void setRaiz(NodoBinarioGenerico<E> raiz) {
        this.raiz = raiz;
    }

    public NodoBinarioGenerico<E> getRaiz() {
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
    public NodoBinarioGenerico<E> construyeArbolCadenaPREyIN(Character[] preorden, Character[] inorden) throws Exception {
        NodoBinarioGenerico<E> r = reconstuir(preorden, inorden);
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
    private static NodoBinarioGenerico reconstuir(Character[] preorden, Character[] inorden) throws Exception {
        /**
         * Se extrae el dato con la raiz de esta ejecución y se crea el nodo con
         * ese caracter
         */
        char dr = preorden[0];
        NodoBinarioGenerico r = new NodoBinarioGenerico(dr);

        /**
         * Evalua la parte más izquierda
         */
        int posDatoRaizEnInorden = buscarEnVector(inorden, dr);
        Character[] nuevoVectorInorden = cortarIzquierda(inorden, posDatoRaizEnInorden);
        int posPreorden = 0;
        Character[] nuevoPreorden;
        if (nuevoVectorInorden.length != 0) {
            posPreorden = nuevoVectorInorden.length;
            nuevoPreorden = cortarNDatos(preorden, 1, posPreorden + 1);
            if (posPreorden != 0) {
                r.setLi(reconstuir(nuevoPreorden, nuevoVectorInorden)); // Llamado recursivo
            }
        }

        /**
         * Evalua la parte más derecha
         */
        nuevoVectorInorden = cortarDerecha(inorden, posDatoRaizEnInorden);
        if (nuevoVectorInorden.length != 0) {
            nuevoPreorden = cortarNDatos(preorden, posPreorden + 1, nuevoVectorInorden.length + posPreorden + 1);
            r.setLd(reconstuir(nuevoPreorden, nuevoVectorInorden));
        }
        return r;
    }

    /**
     * Busca un caracter en un vector de caracteres
     */
    public static int buscarEnVector(Character[] arr, char dr) throws Exception {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(dr)) {
                return i;
            }
        }
        throw new Exception("No se encuentra en el Vector");
    }

    public static Character[] cortarIzquierda(Character[] arr, int pdrin) {
        return Arrays.copyOfRange(arr, 0, pdrin);
    }

    private static Character[] cortarNDatos(Character[] arr, int i, int f) {
        return Arrays.copyOfRange(arr, i, f);
    }

    private static Character[] cortarDerecha(Character[] arr, int pdrin) {
        return Arrays.copyOfRange(arr, pdrin + 1, arr.length);
    }

    public int altura() throws Exception {
        throw new Exception("Sin codigo");
    }

    public static void inorden(NodoBinarioGenerico r) {
        if (r != null) {
            inorden(r.getLi());
            System.out.print(r.getDato());
            inorden(r.getLd());
        }
    }

    /**
     * Contar las hojas de un arbol
     *
     * @param r
     * @return
     */
    public static int hojas(NodoBinarioGenerico r) {
        int hh = 0;
        if (r != null) {
            if (r.getLi() == null && r.getLd() == null) {
                hh = hh + 1;
            } else {
                hh = hh + hojas(r.getLi()) + hojas(r.getLd());
            }

        }
        return hh;
    }

    /**
     * Se propone hacer estos metodos para contar las hojas
     *
     * public static void contarHojas() { int numeroHojas = 0; numeroHojas =
     * contarHojasRecursivo(raiz, numeroHojas); }
     *
     * public static int contarHojasRecursivo(NodoBinario r, int nh) { if (r !=
     * null) { nh = nh + contarHojasRecursivo(r.getLi(), nh); if (r.getLi() ==
     * null && r.getLd() == null) { nh = nh + 1; } nh = nh +
     * contarHojasRecursivo(r.getLd(), nh); } return nh; }
*
     */
    /**
     * Recorrido por niveles
     */
    public void recorrido1() {
        Queue<NodoBinarioGenerico> queue = new LinkedList<>();
        if (raiz != null) {
            queue.add(raiz);
            NodoBinarioGenerico a;
            while (!queue.isEmpty()) {
                a = queue.poll();
                System.out.print(a.getDato() + ",");
                if (a.getLi() != null) {
                    queue.add(a.getLi());
                }
                if (a.getLd() != null) {
                    queue.add(a.getLd());
                }
            }
        }
    }

    /**
     * Reorre la rama derecha y se va delvolviendo por la izquierda
     */
    public void recorrido2() {
        Stack<NodoBinarioGenerico> stac = new Stack<>();
        if (raiz != null) {
            stac.add(raiz);
            NodoBinarioGenerico a;
            while (!stac.isEmpty()) {
                a = stac.pop();
                System.out.print(a.getDato() + ",");
                if (a.getLi() != null) {
                    stac.add(a.getLi());
                }
                if (a.getLd() != null) {
                    stac.add(a.getLd());
                }
            }
        }
    }

    public static void inordenNR(NodoBinarioGenerico r) {
        Stack<NodoBinarioGenerico> migas = new Stack<>();
        migas.add(r);
        r = r.getLi();
        while (!migas.isEmpty() || r != null) {
            if (r != null) {
                migas.add(r);
                r = r.getLi();
            } else {
                r = migas.pop();
                System.out.print(r.getDato());
                r = r.getLd();
            }
        }
    }

    public static void preorden(NodoBinarioGenerico r) {
        if (r != null) {
            System.out.print(r.getDato());
            preorden(r.getLi());
            preorden(r.getLd());
        }
    }

    public static NodoBinarioGenerico convertirArbolNario2ArbolBinario(NodoNario rlg) {
        NodoBinarioGenerico raizBinario = new NodoBinarioGenerico(rlg.getDato());
        NodoNario p = rlg.getLiga();
        NodoNario q = null;
        NodoBinarioGenerico xBinario = raizBinario;
        NodoBinarioGenerico ultimoBinario = xBinario;
        Stack pila = new Stack();
        while (p != null) {
            if (p.getSw() == 0) {
                xBinario = new NodoBinarioGenerico(p.getDato());
            } else {
                q = ((NodoNario) p.getDato());
                xBinario = new NodoBinarioGenerico(q.getDato());
                pila.add(xBinario);
                pila.add(q.getLiga());
            }
            ultimoBinario.setLi(xBinario);
            ultimoBinario = xBinario;
            p = p.getLiga(); // que tal si es p y no q?
            while (p != null) {
                if (p.getSw() == 0) {
                    xBinario = new NodoBinarioGenerico(p.getDato());
                } else {
                    q = ((NodoNario) p.getDato());
                    xBinario = new NodoBinarioGenerico(q.getDato());
                    pila.add(xBinario);
                    pila.add(q.getLiga());
                }
                ultimoBinario.setLd(xBinario);
                ultimoBinario = xBinario;
                p = p.getLiga();
            }
            if (!pila.isEmpty()) {
                p = (NodoNario) pila.pop();
                ultimoBinario = (NodoBinarioGenerico) pila.pop();
            }

        }
        return raizBinario;

    }

}
