/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.binario.listaligada.busqueda.avl.ejemplos.palabras;


import arbol.binario.listaligada.busqueda.avl.ArbolAVL;
import arbol.binario.listaligada.busqueda.avl.NodoAVL;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author alejandroescobar
 */
class IndicePalabrasAAVL extends ArbolAVL {

    public void imprimirCantidades() {
        Queue<NodoAVL> queue = new LinkedList<>();
        System.out.println("Comienzo recorrido1");
        NodoAVL raizlocal = getRoot();
        if (raizlocal != null) {
            queue.add(raizlocal);
            NodoAVL a;
            while (!queue.isEmpty()) {
                a = queue.poll();
                Palabra p = (Palabra) a.getDato();
                System.out.println(p);
                if (a.getLi()!= null) {
                    queue.add((NodoAVL) a.getLi());
                }
                if (a.getLd()!= null) {
                    queue.add((NodoAVL) a.getLd());
                }
            }
        }
    }

    @Override
    public NodoAVL insertarDato(Comparable dato) {
        NodoAVL i = super.insertarDato(dato);
        if (i != null) {
            Palabra p = (Palabra) (i.getDato());
            int c = p.getContador();
            p.setContador(c + 1);
        }
        return i;
    }

}
