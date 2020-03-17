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


import arbol.binario.listaligada.normal.ArbolBinarioListaLigada;
import arbol.binario.listaligada.normal.NodoBinarioGenerico;

/**
 *
 * @author alejandroescobar
 */
public class EjemploReconstruccionConCaracter {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        //String inorden = "gehicbfdajklnmop";
        //String preorden = "abceghidflkjmnop";
        
        String inorden = "gehicrbfdajklnmop";
                          
        String preorden = "abceghirdflkjmnop"; 
                
        
        Character[] inordenCH  = convertirChar2Character( inorden );
        Character[] preordenCH = convertirChar2Character( preorden );
        
        ArbolBinarioListaLigada abll = new ArbolBinarioListaLigada();
        NodoBinarioGenerico raiz = abll.construyeArbolCadenaPREyIN( preordenCH, inordenCH);
        
        abll.setRaiz(raiz);
        ArbolBinarioListaLigada.inorden(raiz);
    }

    private static Character[] convertirChar2Character(String cadena) {
        Character[] nuevoCH = new Character[ cadena.length()]; 
        for (int i = 0; i < cadena.length(); i++) {
            Character c = cadena.charAt(i);
            nuevoCH[i] = c;
        }
        return nuevoCH;
    }
    
}
