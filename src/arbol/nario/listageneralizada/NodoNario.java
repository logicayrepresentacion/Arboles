package arbol.nario.listageneralizada;

/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




/**
 *
 * @author alejandroescobar
 */
public class NodoNario {

    private int sw;
    private Object dato;
    private NodoNario liga;

    public NodoNario( Object d ) {
        dato = d;
    }

    NodoNario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getSw() {
        return sw;
    }

    public void setSw(int sw) {
        this.sw = sw;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public NodoNario getLiga() {
        return liga;
    }

    public void setLiga(NodoNario liga) {
        this.liga = liga;
    }

}
