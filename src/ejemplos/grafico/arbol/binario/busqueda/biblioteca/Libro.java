/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos.grafico.arbol.binario.busqueda.biblioteca;

/**
 *
 * @author ealej
 */
public class Libro implements Comparable<Libro> {

    private int id;
    private String nombre;
    private String autor;
    private String ubicacion;

    public Libro(int id, String nombre, String autor, String ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.ubicacion = ubicacion;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the ubicacion
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * @param ubicacion the ubicacion to set
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Retorna 0 si los id son iguales, un valor menor que 0 si id del libro es
     * menor que el id del argumento y un valor mayor que 0 si el id es mayor
     * que id del libro del argumento
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Libro o) {
//        if (this.id == o.getId()) {
//            return 0;
//        } else if (this.id > o.getId()) {
//            return 1;
//        } else {
//            return -1;
//        }
    
        return this.id - o.getId();

    }

    @Override
    public String toString() {
        return "Id:" + id + "|Nombre:" + this.nombre;
    }

}
