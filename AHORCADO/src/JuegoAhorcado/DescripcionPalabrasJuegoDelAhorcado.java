package JuegoAhorcado;

import java.util.HashMap;

public class DescripcionPalabrasJuegoDelAhorcado {
    private HashMap<Integer, String> descripcionDeLasPalabras = new HashMap<>();

    public DescripcionPalabrasJuegoDelAhorcado() {
        descripcionDeLasPalabras.put(1, "All intangible components of a computer system.");
        descripcionDeLasPalabras.put(2, "All physical, tangible components of a computer system.");
        descripcionDeLasPalabras.put(3, "It is a software platform with a set of programming tools for developing applications..");
        descripcionDeLasPalabras.put(4, "It is a high-level programming language that is used to develop applications of all kinds..");
        descripcionDeLasPalabras.put(5, "It consists of data conversion in a graphical interface.");
        descripcionDeLasPalabras.put(6, "It is the structuring of the site and the programming of its main functionalities.");
        descripcionDeLasPalabras.put(7, "It's an operating system");
        descripcionDeLasPalabras.put(8, "A set of computers capable of responding to requests from a client and returning a response..");
        descripcionDeLasPalabras.put(9, "It is that profession that is in charge of making applications with programming languages.");
    }
    public String visualizarDescripcionesDeLasPalabras(Integer numeroDescripcion){
        return descripcionDeLasPalabras.get(numeroDescripcion);
    }
}
