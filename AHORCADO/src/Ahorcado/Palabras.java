package Ahorcado;

import Interfaz.InterfazGraficaUsuario;

import javax.swing.*;
import java.util.HashMap;
import java.util.Scanner;

public class Palabras {
    /**
     * tenemos los atributos del pro
     */
    private HashMap <Integer, String> palabrasParaAdivinar = new HashMap<>();

    private String letrasAsteriscos;
    private String [] contenidoLetras;
    private String [] asteriscosString;
    private Integer errores;
    private Integer aciertos;
    private Integer numeroRandom;
    private InterfazGraficaUsuario principal;

    /**
     * (1) el contructor agregar al mapa las palabras para adivinar
     */
    public Palabras(InterfazGraficaUsuario principal) {
        this.principal = principal;
        palabrasParaAdivinar.put(1, "software");
        palabrasParaAdivinar.put(2, "hardware");
        palabrasParaAdivinar.put(3, "eclipse");
        palabrasParaAdivinar.put(4, "python");
        palabrasParaAdivinar.put(5, "frontend");
        palabrasParaAdivinar.put(6, "backend");
        palabrasParaAdivinar.put(7, "linux");
        palabrasParaAdivinar.put(8, "servidor");
        palabrasParaAdivinar.put(9, "programador");
        errores = 0;
        aciertos = 0;
        numeroRandom();
    }
    /**
     * (2) metodo toma un valor aleatorio del HashMap
     * @return
     */
    public void numeroRandom (){
         Integer numero = (int) (Math.random()*palabrasParaAdivinar.size()+1);
         numeroRandom = numero;
    }
    /**
     * (3) dividimos la palabra en caracteres dentro de un arreglo
     * @param numeroRandom
     */
    public void convertirPalabras (Integer numeroRandom){
        contenidoLetras = palabrasParaAdivinar.get(numeroRandom).split("");
    }
    /**
     * (4) verifica la letra en el arreglo con la ingresada por el usuario.
     * @return
     */
    public boolean verificarLetra(String letraComparar) {

        boolean existe = false;

        for (int i = 0; i < contenidoLetras.length; i++)
        {
            if (contenidoLetras[i].equals(letraComparar)){
                asteriscosString [i] = letraComparar;
                existe = true;
                aciertos++;
            }
        }

        if (!existe) {
            errores ++;
        }
        return existe;
    }
    /**
     * (5) por medio de este metodo verificamos si el usuario tiene la victoria o si ha perdido en su defecto
     */
    public String convertirListaString(){

        String resultado = "";
        for (String letra : asteriscosString) {
            resultado += letra;
        }
        letrasAsteriscos = resultado;
        return letrasAsteriscos;
    }

    /**
     * (6) este metodo sirve para cambiar las palabras por caracteres
     */
    public void encriptarPalabras (){
        letrasAsteriscos = "";
        for (int i = 0; i < contenidoLetras.length; i++)
        {
            letrasAsteriscos += "*";
        }
        asteriscosString = letrasAsteriscos.split("");
    }

    public String getLetrasAsteriscos()
    {
        return letrasAsteriscos;
    }
    /**
     * (7) returna el valor del atributo de errores para poder visualizar el contenido
     * @return
     */
    public Integer getErrores() {
        return errores;
    }
    /**
     * (8) returna el valor del atributo de aciertos para visualizar el contenido
     * @return
     */
    public Integer getAciertos() {
        return aciertos;
    }

    public Integer getNumeroRandom() {
        return numeroRandom;
    }
}