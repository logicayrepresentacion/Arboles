/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.binario.listaligada.busqueda.ejemplos.palabras;

public class Palabra implements Comparable<Palabra> {

    private String cadena;
    private int contador = 0;

    public Palabra(String palabra) {
        this.cadena = palabra;
    }

    public String getPalabra() {
        return cadena;
    }

    public void setPalabra(String palabra) {
        this.cadena = palabra;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public void aumentar() {
        this.contador++;
    }


    @Override
    public String toString() {
        return cadena + ":" + contador;
    }

    @Override
    public int compareTo(Palabra o) {
        Palabra t = (Palabra) o;
        String pb = t.getPalabra();
        return cadena.compareToIgnoreCase(pb);
    }

}
