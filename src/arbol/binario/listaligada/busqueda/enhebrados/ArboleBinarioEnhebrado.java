/*
 * Copyright 2019 Carlos Alejandro Escobar Marulanda ealejandro101@gmail.com
 * Permission is hereby granted, free of charge, to any person 
 * obtaining a copy of this software and associated documentation 
 * files (the "Software"), to deal in the Software without 
 * restriction, including without limitation the rights to use, 
 * copy, modify, merge, publish, distribute, sublicense, and/or 
 * sell copies of the Software, and to permit persons to whom the 
 * Software is furnished to do so, subject to the following 
 * conditions:
 * The above copyright notice and this permission notice shall 
 * be included in all copies or substantial portions of the 
 * Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, 
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES 
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND 
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 *  WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR 
 * OTHER DEALINGS IN THE SOFTWARE.
 */
package arbol.binario.listaligada.busqueda.enhebrados;


/**
 *
 * @author Alejandro Escobar
 */
public class ArboleBinarioEnhebrado {

    NodoBinarioBusquedaEnhebrado cabeza;

    public NodoBinarioBusquedaEnhebrado getCabeza() {
        return cabeza;
    }

    
    public static NodoBinarioBusquedaEnhebrado parseArbolBinarioBusquedaListaLLigada2ArbolBinarioBusquedaE( NodoBinarioBusquedaEnhebrado raiz){
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
