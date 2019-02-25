/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
