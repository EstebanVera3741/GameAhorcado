package JuegoAhorcado;

import Interfaz.InterfazGraficaUsuario;
import java.util.HashMap;
public class PalabrasJuegoDelAhorcado {

    private HashMap <Integer, String> palabrasParaAdivinar = new HashMap<>();
    private String [] arregloPalabraSpliteada;
    private String [] arregloPalabraEncriptada;
    private String palabraEncriptada;
    private String vizualizarPalabra;
    private Integer errores;
    private Integer aciertos;
    private Integer numeroRandom;
    private InterfazGraficaUsuario principal;


    public PalabrasJuegoDelAhorcado(InterfazGraficaUsuario principal) {
        this.principal = principal;
        palabrasParaAdivinar.put(1, "SOFTWARE");
        palabrasParaAdivinar.put(2, "HARDWARE");
        palabrasParaAdivinar.put(3, "ECLIPSE");
        palabrasParaAdivinar.put(4, "PYTHON");
        palabrasParaAdivinar.put(5, "FRONTEND");
        palabrasParaAdivinar.put(6, "BACKEND");
        palabrasParaAdivinar.put(7, "LINUX");
        palabrasParaAdivinar.put(8, "SERVER");
        palabrasParaAdivinar.put(9, "PROGRAMMER");
        errores = 0;
        aciertos = 0;
        generarNumeroRandom();
        convertirPalabraEnUnArregloDeString(numeroRandom);
        encriptarPalabraDelArregloDeString();
    }
    private void generarNumeroRandom(){
         Integer numero = (int) (Math.random()*palabrasParaAdivinar.size()+1);
         numeroRandom = numero;
    }
    private void convertirPalabraEnUnArregloDeString(Integer numeroRandom){
        arregloPalabraSpliteada = palabrasParaAdivinar.get(numeroRandom).split("");
        concatenarLaPalabraEncriptadaEnUnString();
    }
    private void concatenarLaPalabraEncriptadaEnUnString (){
        vizualizarPalabra = "";
        for (String letra : arregloPalabraSpliteada)
        {
            vizualizarPalabra += letra;
        }
    }
    private void encriptarPalabraDelArregloDeString(){
        String palabra = "";
        for (int i = 0; i < arregloPalabraSpliteada.length; i++)
        {
            palabra += "*";
        }
        arregloPalabraEncriptada = palabra.split("");
        concatenaLaPalabraEncriptadaDelArreglo();
    }
    private void concatenaLaPalabraEncriptadaDelArreglo(){
        String resultado = "";
        for (String letra : arregloPalabraEncriptada) {
            resultado += letra;
        }
        palabraEncriptada = resultado;
    }
    public boolean verificaExistenciaDeLaLetraEnElArreglo(String letraComparar) {
        boolean existe = false;
        for (int i = 0; i < arregloPalabraSpliteada.length; i++)
        {
            if(!verificarExistenciaDeLaLetraEnElArregloEncriptado(letraComparar)){
                if (arregloPalabraSpliteada[i].equals(letraComparar)){
                    arregloPalabraEncriptada[i] = letraComparar;
                    existe = true;
                    aciertos++;
                }
            }
        }
        if(!verificarExistenciaDeLaLetraEnElArregloEncriptado(letraComparar)){
            if (!existe) {
                errores ++;
            }
        }
        concatenaLetrasEnUnString();
        return existe;
    }
    private boolean verificarExistenciaDeLaLetraEnElArregloEncriptado (String letraComparar){
        boolean letraEncontrada = false;
        for (int i = 0; i < arregloPalabraEncriptada.length; i++)
        {
            if (arregloPalabraEncriptada[i].equals(letraComparar)){
                letraEncontrada = true;
            }
        }
        return letraEncontrada;
    }
    public void concatenaLetrasEnUnString(){
        String resultado = "";
        for (String letra : arregloPalabraEncriptada) {
            resultado += letra;
        }
        palabraEncriptada = resultado;
    }
    public boolean verificarCantidadErroresParaFinalizarJuego(){
        Integer cantidadErrores = 6;
        boolean limitePermitidoErrores = false;
        if(errores.equals(cantidadErrores)){
            limitePermitidoErrores = true;
        }
        return limitePermitidoErrores;
    }
    public boolean verificarCantidadAciertosParaFinalizarJuego(){
        boolean finalizarJuego = false;
        if(arregloPalabraSpliteada.length == aciertos){
            finalizarJuego = true;
        }
        return finalizarJuego;
    }
    public String getPalabraEncriptada()
    {
        return palabraEncriptada;
    }
    public Integer getErrores() {
        return errores;
    }
    public void setErrores(Integer errores){
        this.errores = errores;
    }

    public String getVizualizarPalabra(){return vizualizarPalabra;}
    public Integer getNumeroRandom() {
        return numeroRandom;
    }
}