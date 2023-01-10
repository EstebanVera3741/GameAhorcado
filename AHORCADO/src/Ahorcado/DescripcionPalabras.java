package Ahorcado;

import java.util.HashMap;

public class DescripcionPalabras {

    private HashMap<Integer, String> palabras = new HashMap<>();


    public DescripcionPalabras() {
        palabras.put(1, "Todos los componentes intangibles de un sistema Informático.");
        palabras.put(2, "Todos los componentes físicos, tangibles de un sistema informático.");
        palabras.put(3, "Es una plataforma de software con un conjunto de herramientas de programación para desarrollar Aplicaciones.");
        palabras.put(4, "Es un lenguaje de alto nivel de programación que se utiliza para desarrollar aplicaciones de todo tipo.");
        palabras.put(5, "Consiste en la conversión de datos en una interfaz gráfica.");
        palabras.put(6, "Es la estructuración del sitio y la programación de sus funcionalidades principales.");
        palabras.put(7, "Es un sistema operativo");
        palabras.put(8, "Conjunto de computadoras capaz de atender las peticiones de un cliente y devolverle una respuesta.");
        palabras.put(9, "es aquella profesion que se encarga de realizar aplicaciones con lenguajes de programacion");
    }

    public String visualizarDescripciones (Integer numeroDescripcion){
        return palabras.get(numeroDescripcion);
    }


}
