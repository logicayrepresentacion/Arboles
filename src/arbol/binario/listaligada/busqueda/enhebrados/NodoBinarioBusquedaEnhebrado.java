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
package arbol.binario.listaligada.busqueda.enhebrados;

import arbol.binario.listaligada.busqueda.normal.NodoBinarioBusqueda;

/**
 *
 * @author Alejandro Escobar
 * @param <T>
 */
public class NodoBinarioBusquedaEnhebrado<T extends Comparable> extends NodoBinarioBusqueda {

    private boolean bi;
    private boolean bd;

    public NodoBinarioBusquedaEnhebrado(T d) {
        super(d);
    }

    public boolean isBd() {
        return bd;
    }

    public boolean isBi() {
        return bi;
    }

    public void setBd(boolean bd) {
        this.bd = bd;
    }

    public void setBi(boolean bi) {
        this.bi = bi;
    }

    
    public NodoBinarioBusquedaEnhebrado getLdBE() {
        return (NodoBinarioBusquedaEnhebrado) super.getLd(); 
    }

    
    public NodoBinarioBusquedaEnhebrado getLiBE() {
        return (NodoBinarioBusquedaEnhebrado) super.getLi(); 
    }

    
    
}
