package Interfaz;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;

public class PanelImagenesJuegoAhorcado extends JPanel {
    private InterfazGraficaUsuario principal;
    private JLabel imagenesAhorcado;

    public PanelImagenesJuegoAhorcado(InterfazGraficaUsuario principal )
    {
        TitledBorder borde = new TitledBorder("");
        borde.setTitleColor( Color.BLACK );
        setBorder( borde );

        this.principal = principal;
        setLayout( new BorderLayout() );

        imagenesAhorcado = new JLabel( );
        imagenesAhorcado.setBorder( new EmptyBorder( 0, 0, 0, 10 ) );
        add( imagenesAhorcado, BorderLayout.WEST );
        actualizarImagenAhorcado(principal.getPalabrasJuegoAhorcado().getErrores());
    }

    public void actualizarImagenAhorcado (Integer error){
        imagenesAhorcado.setIcon( new ImageIcon(
                new ImageIcon( "./AHORCADO/src/Imagenes/IMG_" + error + ".png").getImage( ).
                        getScaledInstance( 470, 300, Image.SCALE_DEFAULT )));
    }
}