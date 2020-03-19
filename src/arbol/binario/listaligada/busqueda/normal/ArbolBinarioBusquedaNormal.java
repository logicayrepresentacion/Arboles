/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.binario.listaligada.busqueda.normal;

/**
 *
 * @author 57300
 */
public class ArbolBinarioBusquedaNormal {

    NodoBinarioBusqueda<Comparable> raiz;

    public ArbolBinarioBusquedaNormal() {
    }

    public NodoBinarioBusqueda Insertar(Comparable dato) {
        if (raiz == null) {
            raiz = new NodoBinarioBusqueda(dato);
            return raiz;
        } else {
            NodoBinarioBusqueda aux = raiz;
            while (aux != null) {
                if (dato.compareTo(aux.getDato()) == 0) {
                    // que el dato ya existe
                    return aux;
                } else if (dato.compareTo(aux.getDato()) < 0) { // el dato es menor, debo moverme por la izquierda
                    if (aux.getLi() != null) {
                        aux = (NodoBinarioBusqueda) aux.getLi();
                    } else {
                        NodoBinarioBusqueda n = new NodoBinarioBusqueda(dato);
                        aux.setLi(n);
                        return n;
                    }
                } else {  // el dato es mayor, debo moverme por la derecha
                    if (aux.getLi() != null) {
                        aux = (NodoBinarioBusqueda) aux.getLd();
                    } else {
                        NodoBinarioBusqueda n = new NodoBinarioBusqueda(dato);
                        aux.setLd(n);
                        return n;
                    }
                }
            }
        }
        return null;
    }

}
