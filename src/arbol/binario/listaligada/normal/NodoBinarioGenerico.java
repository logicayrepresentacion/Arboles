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

/**
 *
 * @author Alejandro
 * @param <T>
 */
public class NodoBinarioGenerico<T> {

    protected final T dato;
    private NodoBinarioGenerico<T> li;
    private NodoBinarioGenerico<T> ld;
    // En casos avanzados
    private int ancho;

    public NodoBinarioGenerico(T dato) {
        this.dato = dato;
    }

    public T getDato() {
        return dato;
    }

    public NodoBinarioGenerico<T> getLi() {
        return li;
    }

    public void setLi(NodoBinarioGenerico<T> li) {
        this.li = li;
    }

    public NodoBinarioGenerico<T> getLd() {
        return ld;
    }

    public void setLd(NodoBinarioGenerico<T> ld) {
        this.ld = ld;
    }

    public int getAncho() {
        return ancho;
    }

    /**
     * Este método es util para realizar grafica
     *
     * @return
     */
    public int recalcularAncho() {
        System.out.println("recalcular ancho");
        ancho = 1;
        if (this.getLi() != null) {
            ancho = ancho + this.getLi().recalcularAncho();
        }
        if (this.getLd() != null) {
            ancho = ancho + this.getLd().recalcularAncho();
        }
        return ancho;
    }

    @Override
    public String toString() {
        return dato.toString();
    }

}
