/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos.grafico.arbol.binario.busqueda.biblioteca.texto;

import ejemplos.grafico.arbol.binario.busqueda.biblioteca.Libro;
import ejemplos.grafico.arbol.binario.busqueda.biblioteca.NodoBinario;

/**
 *
 * @author alejandro.escobar
 */
public class ArbolBinarioBusquedaLibros {

    NodoBinario raiz;

    public Libro insertar(Libro nuevoLibro) {
        NodoBinario recorrido = raiz;

        if (raiz == null) {
            raiz = new NodoBinario(nuevoLibro);
            return raiz.getDato();
        }

        while (recorrido != null) {
            Libro libroRecorrido = recorrido.getDato();
            int comparacionLibro = libroRecorrido.compareTo(nuevoLibro);
            if (comparacionLibro == 0) {
                return libroRecorrido;
            } else {
                if (comparacionLibro > 0) {
                    if (recorrido.getLigaIzquierda() == null) {
                        NodoBinario nuevoNodo = new NodoBinario(nuevoLibro);
                        recorrido.setLigaIzquierda(nuevoNodo);
                    } else {
                        recorrido = recorrido.getLigaIzquierda();
                    }
                } else {
                    if (recorrido.getLigaDerecha() == null) {
                        NodoBinario nuevoNodo = new NodoBinario(nuevoLibro);
                        recorrido.setLigaDerecha(nuevoNodo);
                    } else {
                        recorrido = recorrido.getLigaDerecha();
                    }
                }
            }
        }
        return null;
    }

    public Libro consultar(int idLibro) {
        Libro libroFic = new Libro(idLibro, null, null, null);
        return consultar(libroFic);
    }

    public Libro consultar(Libro libroParaComparar) {
        NodoBinario recorrido = raiz;

        while (recorrido != null) {
            Libro libroRecorrido = recorrido.getDato();
            int comparacionLibro = libroRecorrido.compareTo(libroParaComparar);
            if (comparacionLibro == 0) {
                return libroRecorrido;
            } else {
                if (comparacionLibro > 0) {
                    if (recorrido.getLigaIzquierda() == null) {
                        return null;
                    } else {
                        recorrido = recorrido.getLigaIzquierda();
                    }
                } else {
                    if (recorrido.getLigaDerecha() == null) {
                        return null;
                    } else {
                        recorrido = recorrido.getLigaDerecha();
                    }
                }
            }
        }
        return null;
    }

    public Libro destruir(int idLibro) {
        return null;
    }

    public Libro actualizar(Libro libro) {
        return null;
    }

    public String listar() {
        StringBuilder lista = new StringBuilder();
        inOrden(raiz, lista);
        return lista.toString();
    }

    private void inOrden(NodoBinario recorrido, StringBuilder lista) {

        if (recorrido != null) {
            inOrden(recorrido.getLigaIzquierda(), lista);
            lista.append(recorrido.getDato().toString()).append("\n");
            inOrden(recorrido.getLigaDerecha(), lista);

        }

    }

}
