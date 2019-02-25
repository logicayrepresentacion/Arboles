/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.binario.listaligada.enhebrados;


/**
 *
 * @author Alejandro Escobar
 */
public class ArboleBinarioEnhebrado {

    NodoBinarioBusquedaEnhebrado cabeza;

    public NodoBinarioBusquedaEnhebrado getCabeza() {
        return cabeza;
    }

    
    public static NodoBinarioBusquedaEnhebrado parseABLL2ABE( NodoBinarioBusquedaEnhebrado raiz){
        // Acá la logica del problema 5 de los ejercicios platenados en la guia
        return new NodoBinarioBusquedaEnhebrado("c");
    }
    
    
    public NodoBinarioBusquedaEnhebrado siguiente(NodoBinarioBusquedaEnhebrado x) {
        NodoBinarioBusquedaEnhebrado siguiente = x.getLdBE();
        if (x.isBd() == true) {
            while (siguiente.isBi() == true) {
                siguiente = siguiente.getLiBE();
            }
        }
        return siguiente;
    }

    /**
    public void insertar(char dato) {
        NodoBE<Character> aux = cabeza;
        char b = 0;
        while (condicionparada(aux)) {
            if (aux.getDato() > dato) {
                if (aux.isBi() == true) {
                    aux = aux.getlI();
                } else {
                    b = 'i';
                    break;
                }
            } else {
                if (aux.isBd() == true) {
                    aux = aux.getlD();
                }
                {
                    b = 'd';
                    break;
                }
            }
        }

        NodoBE newnodo = new NodoBE(dato);
        if (b == 'i') {
            aux.setBi(true);
        } 
    }*/

    public void imprimirHojas(NodoBinarioBusquedaEnhebrado r) {
        NodoBinarioBusquedaEnhebrado p = siguiente(r);
        int c = 0;
        while (p != r) {
            if (p.isBi() == false && p.isBd() == false) {
                System.out.println(p.getDato());
                c++;
            }
            p = siguiente(p);
        }
        System.out.println("Cantidad de hojas " + c);
    }

    private boolean condicionparada(NodoBinarioBusquedaEnhebrado aux) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
