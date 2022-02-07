/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.binario.listaligada.normal.ejemplos.preguntas;

import arbol.binario.listaligada.normal.ArbolBinarioListaLigada;
import arbol.binario.listaligada.normal.NodoBinarioGenerico;
import java.util.Scanner;

/**
 *
 * @author ealej
 */
public class Principal {

    public static void main(String[] args) {

        ArbolBinarioListaLigada<Pregunta> maria;
        maria = new ArbolBinarioListaLigada<Pregunta>();

        NodoBinarioGenerico<Pregunta> a = new NodoBinarioGenerico<>(new Pregunta("Es un ave"));
        NodoBinarioGenerico<Pregunta> c = new NodoBinarioGenerico<>(new Pregunta("Es un terrestre"));
        NodoBinarioGenerico<Pregunta> d = new NodoBinarioGenerico<>(new Pregunta("Es un pajaro"));
        NodoBinarioGenerico<Pregunta> e = new NodoBinarioGenerico<>(new Pregunta("Es un pechiazul"));

        maria.setRaiz(a);
        a.setLi(d);
        a.setLd(c);

        d.setLi(e);

        //
        Scanner sc = new Scanner(System.in);

        System.out.println("Hola!!! soy tu asistente");
        NodoBinarioGenerico<Pregunta> pregunta = maria.getRaiz();

        while (parar) {
            System.out.println(pregunta);
            System.out.println("Digite SI o NO");
            boolean respuestaSi = leerRespuesta();
            if (respuestaSi) {
                if (pregunta.getLi() == null) {
                    System.out.println("Ayudame a aprender ingresa ¿Qué es?");
                    String str = sc.leerPregunta();
                    NodoBinarioGenerico<Pregunta> npregunta = new NodoBinarioGenerico<>(new Pregunta(str));
                    pregunta.getLi();
                    parar = false;
                }
                System.out.println(pregunta.getDato().getCadena());

            } else {
                if (pregunta.getLi() == null) {
                    System.out.println("Ayudame a aprender ingresa el siguiente nivel");
                    String str = sc.leerPregunta();
                    NodoBinarioGenerico<Pregunta> npregunta = new NodoBinarioGenerico<>(new Pregunta(str));
                    pregunta.getLi();
                    parar = false;
                } else {
                    pregunta = pregunta.getLi();
                }
            }
        }

        maria.recorrido1();

    }
}
