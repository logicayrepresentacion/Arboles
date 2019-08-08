/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    final static boolean TRANSFORMAR = true;
    final static boolean NOTRANSFORMAR = false;

    
    public ArbolNarioListaGeneralizada(String h) {
        char[] c = h.toCharArray();
        int lc = c.length;

        if (c[0] != '(') {
            System.err.println("La cadena no inicia correctamente");
            System.exit(-1);
        }
        if (c[lc - 1] != ')') {
            System.err.println("La cadena no finaliza correctamente");
            System.exit(-1);
        }

        // Minimo debe ser (a)
        if (lc < 3) {
            System.err.println("La cadena es muy corta");
            System.exit(-1);
        }

        Stack migas = new Stack();
        NodoNario u;
        NodoNario pr, nx;
        pr = new NodoNario(c[1]);
        u = pr;
        raiz = pr;
        int i = 3;
        int np = lc - 2;
        while (i < np) {
            nx = new NodoNario(null);
            u.setLiga(nx);
            u = nx;
            if (c[i + 1] == '(') {
                u.setSw(1);
                migas.add(u);
                nx = new NodoNario(c[i]);
                u.setDato(nx);
                u = nx;
                i = i + 2;
            } else {
                u.setDato(c[i]);
                if (c[i + 1] == ',') {
                    i = i + 2;
                } else {
                    i = i + 1;
                    while (i < np && c[i] == ')') {
                        u = (NodoNario) migas.pop();
                        i = i + 1;
                    }
                    if (c[i] == ',') {
                        i = i + 1;
                    }
                }
            }
        }
    }

    public static ArbolNarioListaGeneralizada parseString(String cad) {
        Stack<NodoNario> stac = new Stack<>();
        NodoNario x = new NodoNario();
        NodoNario raiz = x;
        NodoNario ultimo = x;
        int lCad = cad.length();
        for (int i = 1; i < lCad; i++) {
            char dato = cad.charAt(i);
            switch (dato) {
                case ',':
                    x = new NodoNario();
                    ultimo.setLiga(x);
                    ultimo = x;
                    break;
                case '(':
                    stac.add(ultimo);
                    x = new NodoNario();
                    ultimo.setSw(1);
                    ultimo.setDato(x);
                    ultimo = x;
                    break;
                case ')':
                    ultimo = stac.pop();
                    break;
                default:
                    ultimo.setSw(0);
                    ultimo.setDato(dato);
            }
        }
        ArbolNarioListaGeneralizada anlg = new ArbolNarioListaGeneralizada(raiz);

        return anlg;
    }

    private ArbolNarioListaGeneralizada(NodoNario raiz) {
        this.raiz = raiz;
    }

    void mostrarPorListas() {
        Stack<NodoNario> migas = new Stack();
        migas.add(raiz);
        while (!migas.empty()) {
            NodoNario pr = migas.pop();
            while (pr != null) {
                if (pr.getSw() == 0) {
                    System.out.print(pr.getDato());
                } else {
                    NodoNario npr = (NodoNario) pr.getDato();
                    migas.add(npr);
                }
                pr = pr.getLiga();
            }
        }
    }

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

    void mostrarHilera() {
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
                        System.out.print(")");
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

    public void imprimirXNivel() {
        NodoNario r = raiz;
        Queue<NodoNario> cola = new LinkedList<>();
        while (r != null) {
            if (r.getSw() == 1) {
                NodoNario realHijo = (NodoNario) r.getDato();
                System.out.print(realHijo.getDato());
                cola.add(realHijo.getLiga());
            } else {
                System.out.print(r.getDato());
            }
            r = r.getLiga();
            if (r == null && !cola.isEmpty()) {
                r = cola.remove();
            }
        }
    }

    public void imprimirHijosNodo(char d) {
        NodoNario r = raiz;
        Queue<NodoNario> cola = new LinkedList<>();
        while (r != null) {
            if (r.getSw() == 1) {
                NodoNario realHijo = (NodoNario) r.getDato();
                if ((char) realHijo.getDato() == d) {
                    System.out.println(getHijos(realHijo, Integer.SIZE));
                    break;
                } else {
                    cola.add(realHijo.getLiga());
                }
            } else {
                if ((char) r.getDato() == d) {
                    System.out.println("No tiene hijos, es una hoja");
                    break;
                }
            }
            r = r.getLiga();
            if (r == null && !cola.isEmpty()) {
                r = cola.remove();
            }
        }
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

    public void insertarNuevoHijo(char ob, char dato) {
        NodoNario r = raiz;
        Queue<NodoNario> miga = new LinkedList<>();
        while (r != null) {
            if (r.getSw() == 0) {
                if ((char) r.getDato() == ob) {
                    if (r == raiz) {
                        insertarHijo(r, dato, NOTRANSFORMAR);
                    } else {
                        insertarHijo(r, dato, TRANSFORMAR);
                    }
                    break;
                }
            } else {
                NodoNario nreal = (NodoNario) r.getDato();
                if ((char) nreal.getDato() == ob) {
                    insertarHijo(nreal, dato, NOTRANSFORMAR);
                    break;
                } else {
                    miga.add(nreal.getLiga());
                }
            }
            r = r.getLiga();
            if (r == null && !miga.isEmpty()) {
                r = miga.remove();
            }
        }
    }

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

    public int determinarGrado(char x) {

        Stack migas = new Stack();
        int contar = 0;
        NodoNario recorrido = raiz;

        // Esta parte es solo para raíz por que no tengo forma de identificar si es un padre o no
        if ((char) recorrido.getDato() == x) {
            NodoNario ph = recorrido.getLiga();
            while (ph != null) {
                contar++;
                ph = ph.getLiga();
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
                    NodoNario ph = recorrido.getLiga();
                    while (ph != null) {
                        contar++;
                        ph = ph.getLiga();
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
        return contar;
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
            }
        }
        System.out.println("Vamos a ver si tiene linea pura");
        System.out.println("La linea pura de " + dato + " es ");
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

}
