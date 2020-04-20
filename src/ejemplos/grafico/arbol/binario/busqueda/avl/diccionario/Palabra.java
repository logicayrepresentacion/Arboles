/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos.grafico.arbol.binario.busqueda.avl.diccionario;

/**
 *
 * @author 57300
 */
public class Palabra implements Comparable<Palabra> {

    private String cadena;
    private String significado;

    public String getCadena() {
        return cadena;
    }

    public String getPalabra() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public String getSignificado() {
        return significado;
    }

    public void setSignificado(String significado) {
        this.significado = significado;
    }

    public Palabra(String cadena, String significado) {
        this.cadena = cadena;
        this.significado = significado;
    }

    @Override
    public int compareTo(Palabra o) {
        Palabra t = (Palabra) o;
        String pb = t.getPalabra();
        return cadena.compareToIgnoreCase(pb);
    }

    @Override
    public String toString() {
        return getPalabra();
    }

}
