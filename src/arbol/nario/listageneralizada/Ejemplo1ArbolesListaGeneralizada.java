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
package arbol.nario.listageneralizada;

/**
 *
 * @author alejandroescobar
 */
public class Ejemplo1ArbolesListaGeneralizada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //String hilera = "(a(b(c,d(e)),f,g(h,i(j,k(l)),m,n)))";
        //String hilera = "(a)";
        //String hilera = "(a(b))";
        //String hilera = "(a(b,c))";
        String hilera = "(a(b(d),c(e)))";
        System.out.println(hilera);
        ArbolNarioListaGeneralizadaCaracteres arbolLG = new ArbolNarioListaGeneralizadaCaracteres(hilera);
        arbolLG.mostrarHilera();

    }

}
