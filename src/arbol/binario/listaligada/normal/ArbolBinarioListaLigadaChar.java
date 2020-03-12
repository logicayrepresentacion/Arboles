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
package arbol.binario.listaligada.normal;

import java.util.Stack;

/**
 *
 * @author alejandroescobar
 */
public final class ArbolBinarioListaLigadaChar {

    protected NodoBinarioChar raiz;

    public ArbolBinarioListaLigadaChar() {
    }

    public ArbolBinarioListaLigadaChar(NodoBinarioChar raiz) {
        this.setRaiz(raiz);
    }

    public void setRaiz(NodoBinarioChar raiz) {
        this.raiz = raiz;
    }

    public NodoBinarioChar getRaiz() {
        return raiz;
    }

    public static void inorden(NodoBinarioChar r) {
        if (r != null) {
            inorden(r.getLi());
            System.out.print(r.getDato());
            inorden(r.getLd());
        }
    }

    public static NodoBinarioChar convertirHilera(String hilera) {

        char[] c = hilera.toCharArray();

        NodoBinarioChar raiz, pr, u;
        pr = new NodoBinarioChar(c[1]);
        raiz = pr;
        u = raiz;
        int i = 3;
        int longitudCadena = c.length;
        int numeroParada = longitudCadena - 2;
        Stack<NodoBinarioChar> migasDerecha = new Stack();
        while (i < numeroParada) {
            if (c[i] == ',') { // Posibilidad finalizo la izquierda
                i++;
                NodoBinarioChar x = new NodoBinarioChar(c[i]);
                u.setLd(x);
                if (c[i + 1] == ')') {
                    i = i + 2;
                    if (!migasDerecha.empty()) {
                        u = migasDerecha.pop();
                    }
                } else {
                    u = x;
                    i = i + 2;
                }
            } else { // Posibilidad átomo, tiene liga izquierda
                NodoBinarioChar x = new NodoBinarioChar(c[i]);
                u.setLi(x);
                if (c[i + 1] == ',') { //No tiene hijos
                    i = i + 2;
                    if (c[i] == ')') {
                        u = migasDerecha.pop();
                        i++;
                    } else {
                        NodoBinarioChar y = new NodoBinarioChar(c[i]);
                        u.setLd(y);
                        u = y;
                        i = i + 2;
                    }
                } else if (c[i + 1] == '(') { // Tiene hijos
                    migasDerecha.add(u);
                    u = x;
                    i = i + 2;
                } else if (c[i + 1] == ')') { // Finaliza hijo derecho

                } else {  // átomo

                }
            }
        }
        return raiz;
    }

}
