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
public class ArbolBinarioVector {

    char[] registros;

    public ArbolBinarioVector(int alturaK) {
        double cantidadRegistros = Math.pow(2, alturaK) - 1;
        registros = new char[(int) cantidadRegistros];
    }

    public ArbolBinarioVector(char[] registros) {
        this.registros = registros;
    }

    public int getGrado(char x) throws Exception {
        int i = 0;
        for (i = 0; i < registros.length; i++) {
            char registro = registros[i];
            if (registro == x) {
                break;
            }
        }
        if (i >= registros.length) {
            throw new Exception("El registro " + x + " no se encuentra en el arbol");
        }

        int posI = 2 * i;
        int posD = posI + 1;
        if (posI <= registros.length && posD <= registros.length) {
            int gI = (registros[posI] == (char) 0) ? 0 : 1;
            int gD = (registros[posD] == (char) 0) ? 0 : 1;
            return gI + gD;
        } else {
            return 0;
        }
    }

    public String getAncestros(char x) throws Exception {
        StringBuilder ancestros = new StringBuilder();

        int i = 0;
        for (i = 0; i < registros.length; i++) {
            char registro = registros[i];
            if (registro == x) {
                break;
            }
        }
        if (i >= registros.length) {
            throw new Exception("El registro " + x + " no se encuentra en el arbol");
        }

        if (i == 0) {
            return ancestros.toString();
        }

        int pos = i;
        while (pos >= 0) {
            pos = (i % 2 == 0) ? i - 1 : i;
            i = pos / 2;
            ancestros.append(registros[i]);
        }

        return ancestros.toString();
    }

}
