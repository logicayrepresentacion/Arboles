
package arbol.binario.listaligada;

/**
 *
 * @author Alejandro
 * @param <T>
 */
public class NodoBinario<T> {

    protected final T dato;
    private NodoBinario<T> li;
    private NodoBinario<T> ld;

    public NodoBinario(T dato) {
        this.dato = dato;
    }


    public T getDato() {
        return dato;
    }

    public NodoBinario<T> getLi() {
        return li;
    }

    public void setLi(NodoBinario<T> li) {
        this.li = li;
    }

    public NodoBinario<T> getLd() {
        return ld;
    }

    public void setLd(NodoBinario<T> ld) {
        this.ld = ld;
    }


    @Override
    public String toString() {
        return dato.toString();
    }
    
    

}
