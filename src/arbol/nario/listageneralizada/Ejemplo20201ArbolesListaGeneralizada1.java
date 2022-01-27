/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.nario.listageneralizada;

/**
 *
 * @author 57300
 */
public class Ejemplo20201ArbolesListaGeneralizada1 {

    public static void main(String[] args) {

        ArbolNarioListaGeneralizadaCaracteres anlg = new ArbolNarioListaGeneralizadaCaracteres('a');
        anlg.mostrarHilera();
        anlg.insertarNuevoHijo('a', 'b');
        System.out.println("");
        anlg.mostrarHilera();
    }
}
