/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.binario.listaligada.busqueda.avl.ejemplos.diccionario;

import arbol.binario.listaligada.busqueda.avl.ArbolAVL;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JTextArea;

/**
 *
 * @author Usuario
 */
public class Diccionario extends ArbolAVL {

    private int cantidad;
    private final JTextArea jTextAreaResultado;

    Diccionario(JTextArea jTextAreaResultado) throws IOException, Exception {
        this.cantidad = 0;
        this.jTextAreaResultado = jTextAreaResultado;
        load();
    }

    public void insertar(Comparable dato) throws Exception {
        if (super.buscar(dato) == null) {
            if( super.insertarDato(dato) == null){
                throw new Exception("Error al insertar la palabra " + dato);
            }
            cantidad++;
            jTextAreaResultado.setText((String) dato);
        }
    }

    public int getCantidad() {
        return cantidad;
    }

    public final void load() throws FileNotFoundException, IOException, Exception {
        BufferedReader in = new BufferedReader(new FileReader("Spanish.dic"));
        String linea;
        while ((linea = in.readLine()) != null) {
            linea = (linea.split("\\/"))[0];
            insertar(linea);
        }
    }

    
    public void buscar(String dato) {
        if ( super.buscar( (Comparable) dato) == null) {
            jTextAreaResultado.setText(" La palabra " + dato + " No se encuentra");
        } else {
            jTextAreaResultado.setText(" Urra!!! Palabra encontrada ");
        }
        
    }

}
