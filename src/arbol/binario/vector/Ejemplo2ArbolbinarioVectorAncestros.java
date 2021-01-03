/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.binario.vector;

/**
 *
 * @author 57300
 */
public class Ejemplo2ArbolbinarioVectorAncestros {

    public static void main(String[] args) {
        char[] registros = {'a', 'b', 'i', 'c', 'd', 'j', 'k', 'e', 'f', 'g', 'h', 'l', 'm', 'n', 'o'};
        ArbolBinarioVector arbolBinarioVector = new ArbolBinarioVector(registros);
        try {
            System.out.println("Grado de 'a' es: " + arbolBinarioVector.getGrado('a'));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("Grado de 'd' es: " + arbolBinarioVector.getGrado('d'));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("Grado de 'm' es: " + arbolBinarioVector.getGrado('m'));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("Grado de 'z' es: " + arbolBinarioVector.getGrado('z'));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("ancestros de 'l' es: " + arbolBinarioVector.getAncestros('l'));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
