/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.binario.listaligada.busqueda.normal.ejemplos.indicepalabras;

/**
 *
 * @author Usuario
 */
public class SuperBuscador {
    public static void main(String[] args) throws Exception {
        IndicePalabrasEspecial indicePalabrasEspecial = new IndicePalabrasEspecial();
        
        
        
        indicePalabrasEspecial.insertar(new Palabra("Alejandro"), 10);
        indicePalabrasEspecial.insertar(new Palabra("Alejandro"), 500);
        indicePalabrasEspecial.insertar(new Palabra("Alejandro"), 300);
        
        System.out.println(" 1 " + indicePalabrasEspecial.buscar(new Palabra("Pedro")));
        System.out.println(" 2 " + indicePalabrasEspecial.buscar(new Palabra("alejandro")));
        
    }
}
