/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos.grafico.arbol.binario.busqueda.biblioteca;

/**
 *
 * @author ealej
 */
public class NodoBinario {

    private NodoBinario ligaIzquierda;
    private Libro dato;
    private NodoBinario ligaDerecha;

    NodoBinario(Libro dato) {
        this.dato = dato;
    }

    /**
     * @return the ligaIzquierda
     */
    public NodoBinario getLigaIzquierda() {
        return ligaIzquierda;
    }

    /**
     * @param ligaIzquierda the ligaIzquierda to set
     */
    public void setLigaIzquierda(NodoBinario ligaIzquierda) {
        this.ligaIzquierda = ligaIzquierda;
    }

    /**
     * @return the dato
     */
    public Libro getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(Libro dato) {
        this.dato = dato;
    }

    /**
     * @return the ligaDerecha
     */
    public NodoBinario getLigaDerecha() {
        return ligaDerecha;
    }

    /**
     * @param ligaDerecha the ligaDerecha to set
     */
    public void setLigaDerecha(NodoBinario ligaDerecha) {
        this.ligaDerecha = ligaDerecha;
    }

    @Override
    public String toString() {
        return this.dato.toString(); //To change body of generated methods, choose Tools | Templates.
    }

}
