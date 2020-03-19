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
package arbol.binario.listaligada.busqueda.normal.ejemplos.palabras;

import arbol.binario.listaligada.busqueda.normal.ArbolBinarioBusquedaGenerico;

/**
 *
 * @author Alejandro
 */
public class BuscarPalabraSinIndice {

    public static void main(String[] args) throws Exception {

        String cadena = "El hombre es una cosa vana, variable y ondeante...\n"
                + "\n"
                + "MONTAIGNE\n"
                + "\n"
                + "Hay días en que somos tan móviles, tan móviles,\n"
                + "como las leves briznas al viento y al azar.\n"
                + "Tal vez bajo otro cielo la Gloria nos sonríe.\n"
                + "La vida es clara, undívaga, y abierta como un mar.\n"
                + "\n"
                + "Y hay días en que somos tan fértiles, tan fértiles,\n"
                + "como en abril el campo, que tiembla de pasión:\n"
                + "bajo el influjo próvido de espirituales lluvias,\n"
                + "el alma está brotando florestas de ilusión.\n"
                + "\n"
                + "Y hay días en que somos tan sórdidos, tan sórdidos,\n"
                + "como la entraña obscura de oscuro pedernal:\n"
                + "la noche nos sorprende, con sus profusas lámparas,\n"
                + "en rútiles monedas tasando el Bien y el Mal.\n"
                + "\n"
                + "Y hay días en que somos tan plácidos, tan plácidos...\n"
                + "(¡niñez en el crepúsculo! ¡Lagunas de zafir!)\n"
                + "que un verso, un trino, un monte, un pájaro que cruza,\n"
                + "y hasta las propias penas nos hacen sonreír.\n"
                + "\n"
                + "Y hay días en que somos tan lúbricos, tan lúbricos,\n"
                + "que nos depara en vano su carne la mujer:\n"
                + "tras de ceñir un talle y acariciar un seno,\n"
                + "la redondez de un fruto nos vuelve a estremecer.\n"
                + "\n"
                + "Y hay días en que somos tan lúgubres, tan lúgubres,\n"
                + "como en las noches lúgubres el llanto del pinar.\n"
                + "El alma gime entonces bajo el dolor del mundo,\n"
                + "y acaso ni Dios mismo nos puede consolar.\n"
                + "\n"
                + "Mas hay también ¡Oh Tierra! un día... un día... un día...\n"
                + "en que levamos anclas para jamás volver...\n"
                + "Un día en que discurren vientos ineluctables\n"
                + "¡un día en que ya nadie nos puede retener!";
        String[] cadenas = cadena.split(" ");
        
        ArbolBinarioBusquedaGenerico abb = new ArbolBinarioBusquedaGenerico();

    
        /**
         * Insertar en el arbol todas las palabras
         */
        for( String cad : cadenas){
            abb.insertar( cad );
        }
        
        // Hasta acá se creo el arbol
        
        long timea = System.currentTimeMillis();
        System.out.println("Date " + timea);
        
        
        
        
        System.out.println(" " + abb.buscar( "puede" ).getDato() );
        
        long timeb = System.currentTimeMillis();
        System.out.println("Date " + timeb);
        System.out.println("Tiempo " + (timeb - timea));
        
    }
}
