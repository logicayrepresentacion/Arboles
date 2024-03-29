/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos.grafico.arbol.binario.busqueda.biblioteca.grafico;

import ejemplos.grafico.arbol.binario.busqueda.biblioteca.Libro;
import ejemplos.grafico.arbol.binario.busqueda.biblioteca.NodoBinario;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Stack;

/**
 *
 * @author ealej
 */
public class IndiceLibrosArbolBinarioGrafico extends javax.swing.JPanel {

    private NodoBinario raiz;

    public NodoBinario getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoBinario raiz) {
        this.raiz = raiz;
    }

    @Override
    public String toString() {
        StringBuilder hilera = new StringBuilder();
        hilera.append("(");

        this.parseHilera(hilera, raiz);
        hilera.append(")");

        return hilera.toString();
    }

    /**
     * Recursivo
     *
     * @return
     */
    private void parseHilera(StringBuilder hilera, NodoBinario r) {

        if (r != null) {
            hilera.append(r.toString());
            if (r.getLigaIzquierda() != null || r.getLigaDerecha() != null) {
                hilera.append("(");
                parseHilera(hilera, r.getLigaIzquierda());
                hilera.append(",");
                parseHilera(hilera, r.getLigaDerecha());
                hilera.append(")");
            }
        }

    }

    /**
     * Creates new form ArbolBinarioGrafico
     */
    public IndiceLibrosArbolBinarioGrafico() {
        initComponents();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        graficarR((Graphics2D) g, raiz);
    }

    private void graficarR(Graphics2D g, NodoBinario r) {
        int x = 20;
        int y = 20;
        if (r != null) {
            g.drawString(r.getDato().toString(), x, y);
            if (r.getLigaIzquierda() != null || r.getLigaDerecha() != null) {
                g.drawString("-", x, y);
                graficarR(g, r.getLigaIzquierda());
                graficarR(g, r.getLigaDerecha());
            }
        }
    }

    public String getCantidad() {
        return this.getInorden();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public String getInorden() {
        StringBuilder cadena = new StringBuilder();
        Stack<NodoBinario> migas = new Stack<>();
        NodoBinario r = this.raiz;
        migas.add(r);
        r = r.getLigaIzquierda();
        while (!migas.isEmpty() || r != null) {
            if (r != null) {
                migas.add(r);
                r = r.getLigaIzquierda();
            } else {
                r = migas.pop();
                cadena.append(r.getDato());
                r = r.getLigaDerecha();
            }

        }
        return cadena.toString();
    }

    public NodoBinario insertar(Libro dato) throws Exception {
        if (raiz == null) {
            raiz = new NodoBinario(dato);
            return raiz;
        } else {
            NodoBinario aux = raiz;
            while (aux != null) {
                if (dato.compareTo(aux.getDato()) == 0) {
                    return aux;
                } else if (dato.compareTo(aux.getDato()) < 0) { // el dato es menor, debo moverme por la izquierda
                    if (aux.getLigaIzquierda() != null) {
                        aux = aux.getLigaIzquierda();
                    } else {
                        NodoBinario n = new NodoBinario(dato);
                        aux.setLigaIzquierda(n);
                        return n;
                    }
                } else {  // el dato es mayor, debo moverme por la derecha
                    if (aux.getLigaDerecha() != null) {
                        aux = aux.getLigaDerecha();
                    } else {
                        NodoBinario n = new NodoBinario(dato);
                        aux.setLigaDerecha(n);
                        return n;
                    }
                }
            }
        }
        throw new Exception("Esto no debería ser posible,llego al final sin encontrar donde guardar el libro");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
