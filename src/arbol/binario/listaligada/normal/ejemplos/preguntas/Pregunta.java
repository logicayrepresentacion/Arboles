/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.binario.listaligada.normal.ejemplos.preguntas;

/**
 *
 * @author ealej
 */
public class Pregunta {

    private final String cadena;

    public Pregunta(String cadena) {
        this.cadena = cadena;
    }

    public String getCadena() {
        return cadena;
    }

    @Override
    public String toString() {
        return "Te pregunto ¿" + cadena + "?"; //To change body of generated methods, choose Tools | Templates.
    }
}
