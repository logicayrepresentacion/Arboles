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
public class ArbolNarioListaGeneralizadaCaracteres extends ArbolNarioListaGeneralizada {

    /**
     * Convertir una hilera de caracteres que representa un arbol en su
     * representación en memoria
     *
     * @param h Hilera de caracteres como (,) az-AZ validos.
     */
    public ArbolNarioListaGeneralizadaCaracteres(String h) {
        super();
        char[] cadena = h.toCharArray();
        int longitudCadena = cadena.length;

        if (cadena[0] != '(') {
            System.err.println("La cadena no inicia correctamente");
            System.exit(-1);
        }
        if (cadena[longitudCadena - 1] != ')') {
            System.err.println("La cadena no finaliza correctamente");
            System.exit(-1);
        }

        // Minimo debe ser (a)
        if (longitudCadena < 3) {
            System.err.println("La cadena es muy corta");
            System.exit(-1);
        }

        Stack migas = new Stack();
        NodoNario ultimo;
        NodoNario primero, nodoX;
        primero = new NodoNario(cadena[1]);
        ultimo = primero;
        raiz = primero;
        int i = 3;
        int caracterParada = longitudCadena - 2;
        while (i < caracterParada) {
            nodoX = new NodoNario(null);
            ultimo.setLiga(nodoX);
            ultimo = nodoX;
            if (cadena[i + 1] == '(') {
                ultimo.setSw(1);
                migas.add(ultimo);
                nodoX = new NodoNario(cadena[i]);
                ultimo.setDato(nodoX);
                ultimo = nodoX;
                i = i + 2;
            } else {
                ultimo.setDato(cadena[i]);
                if (cadena[i + 1] == ',') {
                    i = i + 2;
                } else {
                    i = i + 1;
                    while (i < caracterParada && cadena[i] == ')') {
                        ultimo = (NodoNario) migas.pop();
                        i = i + 1;
                    }
                    if (cadena[i] == ',') {
                        i = i + 1;
                    }
                }
            }
        }
    }

    /**
     * Permite construir un arbol con un caracter que es la raiz
     *
     * @param raiz
     */
    public ArbolNarioListaGeneralizadaCaracteres(char raiz) {
        this.raiz = new NodoNario(raiz);
    }

    /**
     *
     * @param d
     * @throws Exception
     */
    public void imprimirHijosNodo(char d) throws Exception {
        NodoNario recorrido = raiz;
        Queue<NodoNario> cola = new LinkedList<>();

        // Esta parte es solo para raíz por que no tengo forma de identificar si es un padre o no
        if ((char) recorrido.getDato() == d) {
            System.out.println(getHijos(recorrido, Integer.SIZE));
            return;
        }

        while (recorrido != null) {
            if (recorrido.getSw() == 1) {
                NodoNario realHijo = (NodoNario) recorrido.getDato();
                if ((char) realHijo.getDato() == d) {
                    System.out.println(getHijos(realHijo, Integer.SIZE));
                    return;
                } else {
                    cola.add(realHijo.getLiga());
                }
            } else {
                if ((char) recorrido.getDato() == d) {
                    System.out.println("No tiene hijos, es una hoja");
                    return;
                }
            }
            recorrido = recorrido.getLiga();
            if (recorrido == null && !cola.isEmpty()) {
                recorrido = cola.remove();
            }
        }
        throw new Exception("El registro " + d + " no se encuentra en el arbol");

    }

    private String getHijos(NodoNario subraiz, Integer ch) {
        NodoNario r = subraiz.getLiga();
        int c = 1;
        StringBuilder cadena = new StringBuilder();
        while (r != null) {
            if (r.getSw() == 1) {
                NodoNario realHijo = (NodoNario) r.getDato();
                cadena.append(realHijo.getDato());
            } else {
                cadena.append(r.getDato());
            }
            r = r.getLiga();
            c++;
        }
        ch = c;
        return cadena.toString();
    }

    /**
     *
     * @param ob
     * @param dato
     */
    public void insertarNuevoHijo(char ob, char dato) {
        NodoNario recorrido = raiz;
        Queue<NodoNario> miga = new LinkedList<>();
        while (recorrido != null) {
            if (recorrido.getSw() == 0) {
                if ((char) recorrido.getDato() == ob) {
                    if (recorrido == raiz) {
                        insertarHijo(recorrido, dato, NOTRANSFORMAR);
                    } else {
                        insertarHijo(recorrido, dato, TRANSFORMAR);
                    }
                    break;
                }
            } else {
                NodoNario nreal = (NodoNario) recorrido.getDato();
                if ((char) nreal.getDato() == ob) {
                    insertarHijo(nreal, dato, NOTRANSFORMAR);
                    break;
                } else {
                    miga.add(nreal.getLiga());
                }
            }
            recorrido = recorrido.getLiga();
            if (recorrido == null && !miga.isEmpty()) {
                recorrido = miga.remove();
            }
        }
    }

    /**
     *
     * @param r
     * @param dato
     * @param TRANSFORMAR
     */
    private void insertarHijo(NodoNario r, char dato, boolean TRANSFORMAR) {
        NodoNario nuevoHijo = new NodoNario(dato);
        if (TRANSFORMAR) {
            r.setSw(1);
            NodoNario nuevoPadre = new NodoNario(r.getDato());
            r.setDato(nuevoPadre);
            nuevoPadre.setLiga(nuevoHijo);
        } else {
            nuevoHijo.setLiga(r.getLiga());
            r.setLiga(nuevoHijo);
        }
    }

    /**
     *
     * @param x
     * @return
     * @throws Exception
     */
    public int determinarGrado(char x) throws Exception {

        Stack migas = new Stack();
        int contar = 0;
        NodoNario recorrido = raiz;

        // Esta parte es solo para raíz por que no tengo forma de identificar si es un padre o no
        if ((char) recorrido.getDato() == x) {
            NodoNario primero = recorrido.getLiga();
            while (primero != null) {
                contar++;
                primero = primero.getLiga();
            }
            return contar;
        }

        // Me ubico en el primer de la raiz
        recorrido = recorrido.getLiga();
        while (recorrido != null) {

            if (recorrido.getSw() == 0) {
                if ((char) recorrido.getDato() == x) {
                    return 0;
                }
                recorrido = recorrido.getLiga();
            } else {
                migas.push(recorrido.getLiga());
                recorrido = (NodoNario) recorrido.getDato();
                // Evaluo si el nodo que es un padre es el que busco
                if ((char) recorrido.getDato() == x) {
                    NodoNario primeroSublista = recorrido.getLiga();
                    while (primeroSublista != null) {
                        contar++;
                        primeroSublista = primeroSublista.getLiga();
                    }
                    return contar;
                } else {
                    recorrido = recorrido.getLiga();
                }
            }
            while (recorrido == null && !migas.isEmpty()) {
                recorrido = (NodoNario) migas.pop();
            }
        }
        throw new Exception("El registro " + x + " no se encuentra en el arbol");
    }

    /**
     * Evaluar un nodo y conocer su línea "pura" de sucesión a través del árbol
     * Ir recorriendo el árbol mediante la profundidad de las hojas, para esto
     * se debe utilizar una pila y no perdernos, lo que llamamos migas.
     *
     * A medida que recorro voy buscando, es decir comparando.
     *
     * Cuando encuentre me regreso por la pila validando si el nodo tienes más
     * hijos.
     *
     * @param dato
     */
    public void lineaPura(char dato) {
        Stack<NodoNario> migas = new Stack<>();
        Stack<NodoNario> ancestros = new Stack<>();

        if ((char) raiz.getDato() == (char) dato) {
            System.out.println("Es la raíz no tiene linea pura");
        }
        ancestros.push(raiz);
        // Recorrido con busqueda
        NodoNario r = raiz.getLiga();
        while (r != null) {
            if (r.getSw() == 1) {
                migas.push(r.getLiga());
                r = (NodoNario) r.getDato();
                if ((char) r.getDato() == dato) {
                    break;
                } else {
                    ancestros.push(r);
                }
                r = r.getLiga();
            } else {
                if ((char) r.getDato() == dato) {
                    break;
                }
                r = r.getLiga();
            }

            while (r == null && !migas.isEmpty()) {
                r = (NodoNario) migas.pop();
                ancestros.pop();
            }
        }
        System.out.println("Vamos a ver si tiene linea pura");
        System.out.println("La linea pura de " + dato + " es ");
        System.out.println("Ancestros" + ancestros.size());
        while (!ancestros.empty()) {
            NodoNario padre = ancestros.pop();
            NodoNario primerHijo = padre.getLiga();
            if (primerHijo.getLiga() == null) {
                System.out.println("Parte de la linea pura " + (char) padre.getDato());
            } else {
                break;
            }
        }

    }

    /**
     * Falta completar
     */
    void mostrarHileraSoloLetras() {
        Stack<NodoNario> migas = new Stack();
        NodoNario u = raiz;
        System.out.print("(");
        while (u != null) {
            if (u.getSw() == 0) {
                System.out.print(u.getDato());
                if (u.getLiga() != null) {
                    u = u.getLiga();

                } else {
                    if (!migas.empty()) {
                        u = migas.pop();
                    } else {
                        u = u.getLiga();
                    }
                }
            } else {
                if (u.getLiga() != null) {
                    migas.add(u.getLiga());
                }
                u = (NodoNario) u.getDato();
            }
        }

        System.out.print(")");
    }

    /**
     * Muestra una hilera de (,) az-AZ Ejemplo:
     * (a(b(c,d(e)),f,g(h,i(j,k(l)),m,n)))
     */
    void mostrarHilera() {
        Stack<NodoNario> migas = new Stack();
        NodoNario ultimo = raiz;
        System.out.print("(");
        System.out.print(ultimo.getDato());
        ultimo = ultimo.getLiga();
        boolean cerrar = false;
        if (ultimo != null) {
            System.out.print("(");
            cerrar = true;

        }

        while (ultimo != null) {
            if (ultimo.getSw() == 0) {
                System.out.print(ultimo.getDato());
                if (ultimo.getLiga() != null) {
                    ultimo = ultimo.getLiga();
                    System.out.print(",");
                } else {
                    ultimo = ultimo.getLiga();
                    while (!migas.empty() && ultimo == null) {
                        ultimo = migas.pop();
                        System.out.print(")");
                    }
                    if (ultimo != null) {
                        System.out.print(",");
                    }
                }
            } else {
                migas.add(ultimo.getLiga());
                ultimo = (NodoNario) ultimo.getDato();
                System.out.print(ultimo.getDato());
                System.out.print("(");
                ultimo = (NodoNario) ultimo.getLiga();
            }
        }

        System.out.print(")");
        if (cerrar) {
            System.out.print(")");
        }
    }

}
