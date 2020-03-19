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
public class NodoBinarioEnhebradoChar {

    protected final char dato;
    private NodoBinarioEnhebradoChar li;
    private NodoBinarioEnhebradoChar ld;
    private boolean bi;
    private boolean bd;

    public NodoBinarioEnhebradoChar(char dato) {
        this.dato = dato;
    }

    public boolean isBi() {
        return bi;
    }

    public void setBi(boolean bi) {
        this.bi = bi;
    }

    public boolean isBd() {
        return bd;
    }

    public void setBd(boolean bd) {
        this.bd = bd;
    }

    public NodoBinarioEnhebradoChar getLi() {
        return li;
    }

    public void setLi(NodoBinarioEnhebradoChar li) {
        this.li = li;
    }

    public NodoBinarioEnhebradoChar getLd() {
        return ld;
    }

    public void setLd(NodoBinarioEnhebradoChar ld) {
        this.ld = ld;
    }

    public char getDato() {
        return dato;
    }

}
