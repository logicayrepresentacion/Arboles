/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.binario.listaligada.busqueda.ejemplos.palabras;

/**
 *
 * @author Alejandro
 */
public class ContarPalabras {

    public static void main(String[] args) {

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
        
        
        
        IndicePalabrasABB abb = new IndicePalabrasABB();
        Palabra p = new Palabra("alejandro");
        abb.insertar(p);

        p = new Palabra("alejandro");
        abb.insertar(p);
        

        p = new Palabra("alejandro");
        abb.insertar(p);
        
        abb.imprimirCantidades();
        //abb.recorrido1();
        //abb.recorrido2();
    }
}
