/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.binario.listaligada.ejemplos;

import arbol.binario.listaligada.ArbolBinarioListaLigada;
import arbol.binario.listaligada.busqueda.NodoBinarioBusqueda;

/**
 *
 * @author Alejandro
 */
public class EjemploArbolBinarioConPersona {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        class Persona implements Comparable<Object> {

            String nombre;

            public Persona(String nombre) {
                this.nombre = nombre;
            }

            @Override
            public String toString() {
                return "Mi nombre " + nombre;
            }

            @Override
            public int compareTo(Object t1) {
                Persona t = (Persona) t1;
                String pb = t.nombre;
                return nombre.compareToIgnoreCase(pb);
            }
        }

        NodoBinarioBusqueda raiz = new NodoBinarioBusqueda(new Persona("Alejandro"));
        NodoBinarioBusqueda b = new NodoBinarioBusqueda(new Persona("Maria"));
        NodoBinarioBusqueda c = new NodoBinarioBusqueda(new Persona("Pedro"));

        raiz.setLi(b);

        raiz.setLd(c);
        NodoBinarioBusqueda d = new NodoBinarioBusqueda(5655);
        NodoBinarioBusqueda e = new NodoBinarioBusqueda(45654);

        b.setLi(d);

        b.setLd(e);
        ArbolBinarioListaLigada ab = new ArbolBinarioListaLigada();

        ab.setRaiz(raiz);

        ab.recorrido1();

        ab.recorrido2();

    }

}
