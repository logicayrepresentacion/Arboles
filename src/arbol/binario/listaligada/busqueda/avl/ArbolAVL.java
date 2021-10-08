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
package arbol.binario.listaligada.busqueda.avl;

import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author cadav
 * @param <T>
 */
public class ArbolAVL<T extends Comparable> {

    private NodoAVL raiz;
    private int altura;
    NodoAVL ult;
    NodoAVL x;

    public ArbolAVL() {
    }

    public NodoAVL insertarDato(T dato) {

        /**
         * Crear el nodo a partir del dato
         */
        NodoAVL nodoAInsertar = new NodoAVL(dato);

        /**
         * Si aún no tengo raíz
         */
        if (raiz == null) {
            raiz = nodoAInsertar;
            return raiz;
        }

        /**
         * variables para hacer el recorrido tener presente los nodos Q, P, R,
         * padres recorrido
         */
        NodoAVL nodoRecorrido = raiz; // Registro que uso para buscar
        NodoAVL padreNodoRecorridoX = null;
        NodoAVL pivote = raiz; // Nodo que se puede desvalancear, la duda (P)
        NodoAVL padrePivote = null;
        NodoAVL nodoRecorridoParaFB; // desde donde rebalancear
        NodoAVL q;

        /**
         * Busqueda donde insertar también va dejando el rastro de donde
         * posiblemente se puede desbalancear
         *
         */
        while (nodoRecorrido != null) {
            // Validar si el nodo x esta en riesgo de desbalanceo
            if (nodoRecorrido.getfB() != 0) {
                pivote = nodoRecorrido;
                padrePivote = padreNodoRecorridoX;
            }
            // Comparo para moverme por Izq o Der y localizar donde insertar
            int comparacion = nodoAInsertar.getDato().compareTo(nodoRecorrido.getDato());
            if (comparacion == 0) {
                //es un dato existente, retorno el nodo
                return nodoRecorrido;
            } else if (comparacion < 0) {
                // n es menor
                padreNodoRecorridoX = nodoRecorrido;
                // movimiento por la IZQ
                nodoRecorrido = (NodoAVL) nodoRecorrido.getLi();

            } else {
                //n es mayor
                padreNodoRecorridoX = nodoRecorrido;
                // movimiento por la DER
                nodoRecorrido = (NodoAVL) nodoRecorrido.getLd();
            }
        }

        /**
         * Insertar el dato
         */
        int comparacion = nodoAInsertar.getDato().compareTo(padreNodoRecorridoX.getDato());
        if (comparacion > 0) {
            padreNodoRecorridoX.setLd(nodoAInsertar);
        } else if (nodoAInsertar.getDato().compareTo(padreNodoRecorridoX.getDato()) < 0) {
            padreNodoRecorridoX.setLi(nodoAInsertar);
        }

        /**
         * Calcular los nuevos factores de balance de todos los ancestros del
         * nodo insertado
         */
        if (nodoAInsertar.getDato().compareTo(pivote.getDato()) > 0) {
            pivote.setfB(pivote.getfB() - 1);
            nodoRecorridoParaFB = (NodoAVL) pivote.getLd();
        } else {
            pivote.setfB(pivote.getfB() + 1);
            nodoRecorridoParaFB = (NodoAVL) pivote.getLi();
        }
        q = nodoRecorridoParaFB;

        while (nodoRecorridoParaFB != nodoAInsertar) {
            if (nodoAInsertar.getDato().compareTo(nodoRecorridoParaFB.getDato()) > 0) {
                nodoRecorridoParaFB.setfB(nodoRecorridoParaFB.getfB() - 1);
                nodoRecorridoParaFB = (NodoAVL) nodoRecorridoParaFB.getLd();
            } else {
                nodoRecorridoParaFB.setfB(nodoRecorridoParaFB.getfB() + 1);
                nodoRecorridoParaFB = (NodoAVL) nodoRecorridoParaFB.getLi();
            }
        }

        /**
         * Valido si el nodo duda (P) quedo desbalanceado
         */
        if (!((pivote.getfB() == -2) || (pivote.getfB() == 2))) {
            return nodoAInsertar;
        }

        /**
         * En caso que si quedara desbalanceado Según las 4 opciones de balanceo
         */
        NodoAVL nuevaRaizSubArbol = null; // Estamos tentados a cambiar de raiz
        if (pivote.getfB() == +2) {
            if (q.getfB() == +1) {
                nuevaRaizSubArbol = rotacionDerecha(pivote, q);
            } else {
                nuevaRaizSubArbol = dobleRotacionDerecha(pivote, q);
            }
        } else if (pivote.getfB() == -2) {
            if (q.getfB() == -1) {
                nuevaRaizSubArbol = rotacionIzquierda(pivote, q);
            } else {
                nuevaRaizSubArbol = dobleRotacionIzquierda(pivote, q);
            }
        }

        /**
         * Consecuencias de rebalancear, validación de que pivote no fuera la
         * raíz
         */
        if (padrePivote == null) {
            raiz = nuevaRaizSubArbol;
            return nodoAInsertar;
        }

        /**
         * Liga el padre del pivote con la nueva raiz
         */
        if (padrePivote.getLi() == pivote) {
            padrePivote.setLi(nuevaRaizSubArbol);
        } else {
            padrePivote.setLd(nuevaRaizSubArbol);
        }
        return nodoAInsertar;
    }

    /**
     * 1. void unaRotacionALaDerecha(nodoAVL p, nodoAVL q) 2.
     * p.asignaLi(q.retornaLd()) 3. q.asignaLd(p) 4. p.asignaFb(0) 5.
     * q.asignaFb(0) 6. fin(unaRotacionALaDerecha)
     *
     * @param pivote
     * @param q
     */
    private NodoAVL rotacionDerecha(NodoAVL p, NodoAVL q) {
        p.setLi(q.getLd());
        q.setLd(p);
        p.setfB(0);
        q.setfB(0);
        return q;
    }

    /**
     * 1. void dobleRotacionALaDerecha(nodoAVL p, nodoAVL q) 2. r =
     * q.retornaLd() 3. q.asignaLd(r.retornaLi()) 4. r.asignaLi(q) 5.
     * p.asignaLi(r.retornaLd() 6. r.asignaLd(p) 7. casos de r.retornaFb() 8. 0:
     * p.asignaFb(0) 9. q.asignaFb(0) 10. break 11. 1: p.asignaFb(–1) 12.
     * q.asignaFb(0) 13. break 14. –1: p.asignaFb(0) 15. q.asignaFb(1) 16.
     * fin(casos) 17. r.asignaFb(0) 18. q = r 19. fin(dobleRotacionALaDerecha)
     *
     * @param pivote
     * @param q
     */
    private NodoAVL dobleRotacionDerecha(NodoAVL p, NodoAVL q) {
        NodoAVL r = (NodoAVL) q.getLd();
        q.setLd(r.getLi());
        r.setLi(q);
        p.setLi(r.getLd());
        r.setLd(p);
        switch (r.getfB()) {
            case 0:
                p.setfB(0);
                q.setfB(0);
                break;
            case 1:
                p.setfB(-1);
                q.setfB(0);
                break;
            case -1:
                p.setfB(0);
                q.setfB(1);
                break;
        }
        r.setfB(0);
        return r;
    }

    /**
     * 1. void unaRotacionALaIzquierda(nodoAVL p, nodoAVL q) 2.
     * p.asignaLd(q.retornaLi()) 3. q.asignaLi(p) 4. p.asignaFb(0) 5.
     * q.asignaFb(0) 6. fin(unaRotacionALaIzquierda)
     *
     * @param pivote
     * @param q
     */
    private NodoAVL rotacionIzquierda(NodoAVL p, NodoAVL q) {
        p.setLd(q.getLi());
        q.setLi(p);
        p.setfB(0);
        q.setfB(0);
        return q;
    }

    /**
     *
     * @param p
     * @param q
     */
    private NodoAVL dobleRotacionIzquierda(NodoAVL p, NodoAVL q) {
        NodoAVL r = (NodoAVL) q.getLi();
        q.setLi(r.getLd());
        r.setLd(q);
        p.setLd(r.getLi());
        r.setLi(p);
        switch (r.getfB()) {
            case 0:
                p.setfB(0);
                q.setfB(0);
                break;
            case -1:
                p.setfB(1);
                q.setfB(0);
                break;
            case 1:
                p.setfB(0);
                q.setfB(-1);
                break;
        }
        r.setfB(0);
        return r;
    }

    /**
     * Retorna el nodo si se encuentra o null en caso de no encontrarse
     *
     * @param dato
     * @return
     */
    public NodoAVL buscar(T dato) {
        NodoAVL aux = raiz;
        while (aux != null) {

            if (aux.getDato().compareTo(dato) == 0) {
                return aux;
            } else if (aux.getDato().compareTo(dato) < 0) {
                if (aux.getLd() != null) {
                    aux = (NodoAVL) aux.getLd();
                } else {
                    return null;
                }
            } else {
                if (aux.getLi() != null) {
                    aux = (NodoAVL) aux.getLi();
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    public NodoAVL getRoot() {
        return raiz;
    }

    public void inorden(Writer salida) throws IOException {
        inordenR(this.raiz, salida);
    }

    private static void inordenR(NodoAVL r, Writer salida) throws IOException {
        if (r != null) {
            inordenR((NodoAVL) r.getLi(), salida);
            salida.write(r.getDato().toString() + "\n");
            inordenR((NodoAVL) r.getLd(), salida);
        }
    }

}
