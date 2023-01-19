package Interfaz;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;

public class PanelImagenesDescriptivas extends JPanel {

    private InterfazGraficaUsuario principal;
    private JLabel imagenesEnunciado;

    public PanelImagenesDescriptivas(InterfazGraficaUsuario principal){

        TitledBorder borde = new TitledBorder( "" );
        borde.setTitleColor( Color.BLACK );
        setBorder( borde );

        this.principal = principal;
        setLayout( new BorderLayout() );

        imagenesEnunciado = new JLabel( );
        imagenesEnunciado.setBorder( new EmptyBorder( 0, 0, 0, 10 ) );
        add( imagenesEnunciado, BorderLayout.EAST );

        actualizarImagenesEnunciado(principal.getPalabrasJuegoAhorcado().getNumeroRandom());
    }
    public void actualizarImagenesEnunciado (Integer numeroEnunciado){
        imagenesEnunciado.setIcon( new ImageIcon(
                new ImageIcon( "./AHORCADO/src/Imagenes/Enum_" + numeroEnunciado + ".jpeg").getImage( ).
                        getScaledInstance( 470, 300, Image.SCALE_DEFAULT )));
    }
}
