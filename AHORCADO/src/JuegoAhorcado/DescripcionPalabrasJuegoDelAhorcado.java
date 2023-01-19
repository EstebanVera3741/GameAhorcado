package JuegoAhorcado;

import java.util.HashMap;

public class DescripcionPalabrasJuegoDelAhorcado {
    private HashMap<Integer, String> descripcionDeLasPalabras = new HashMap<>();

    public DescripcionPalabrasJuegoDelAhorcado() {
        descripcionDeLasPalabras.put(1, "Todos los componentes intangibles de un sistema Informático.");
        descripcionDeLasPalabras.put(2, "Todos los componentes físicos, tangibles de un sistema informático.");
        descripcionDeLasPalabras.put(3, "Es una plataforma de software con un conjunto de herramientas de programación para desarrollar Aplicaciones.");
        descripcionDeLasPalabras.put(4, "Es un lenguaje de alto nivel de programación que se utiliza para desarrollar aplicaciones de todo tipo.");
        descripcionDeLasPalabras.put(5, "Consiste en la conversión de datos en una interfaz gráfica.");
        descripcionDeLasPalabras.put(6, "Es la estructuración del sitio y la programación de sus funcionalidades principales.");
        descripcionDeLasPalabras.put(7, "Es un sistema operativo");
        descripcionDeLasPalabras.put(8, "Conjunto de computadoras capaz de atender las peticiones de un cliente y devolverle una respuesta.");
        descripcionDeLasPalabras.put(9, "es aquella profesion que se encarga de realizar aplicaciones con lenguajes de programacion");
    }
    public String visualizarDescripcionesDeLasPalabras(Integer numeroDescripcion){
        return descripcionDeLasPalabras.get(numeroDescripcion);
    }
}
