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
package arbol.binario.listaligada.busqueda.normal.ejemplos.indicepalabras;

import arbol.binario.listaligada.busqueda.normal.ArbolBinarioBusquedaGenerico;

public class Palabra implements Comparable<Palabra> {

    private String cadena;
    private int contador = 0;
    private final ArbolBinarioBusquedaGenerico arbolPosiciones;

    public Palabra(String palabra) {
        this.cadena = palabra;
        arbolPosiciones = new ArbolBinarioBusquedaGenerico();
    }

    public String getPalabra() {
        return cadena;
    }

    public void setPalabra(String palabra) {
        this.cadena = palabra;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public void aumentar() {
        this.contador++;
    }
    
    public void insertarPosicion( int pos ) throws Exception{
        arbolPosiciones.insertar(pos);
    }


    @Override
    public String toString() {
        ArbolBinarioBusquedaGenerico.inorden( arbolPosiciones.getRaiz() );
        return  cadena + ":" + contador + " ";
    }

    @Override
    public int compareTo(Palabra o) {
        Palabra t = (Palabra) o;
        String pb = t.getPalabra();
        return cadena.compareToIgnoreCase(pb);
    }

}
