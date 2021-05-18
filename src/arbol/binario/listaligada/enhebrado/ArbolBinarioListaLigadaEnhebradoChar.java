/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.binario.listaligada.enhebrado;

/**
 *
 * @author 57300
 */
public class ArbolBinarioListaLigadaEnhebradoChar {

    NodoBinarioEnhebradoChar cabeza;

    public ArbolBinarioListaLigadaEnhebradoChar() {
        cabeza = new NodoBinarioEnhebradoChar((char) 0);
    }

    public void inorden() {
        if (cabeza != null) {
            NodoBinarioEnhebradoChar p = siguiente(cabeza);
            while (cabeza != p && p != null) {
                System.out.println(p.getDato());
                p = siguiente(p);
            }
        }
    }

    public NodoBinarioEnhebradoChar siguiente(NodoBinarioEnhebradoChar m) {
        NodoBinarioEnhebradoChar siguiente = m.getLd();
        if (m.isBd()) {
            while (siguiente.isBi()) {
                siguiente = siguiente.getLi();
            }
        }
        return siguiente;
    }

}
