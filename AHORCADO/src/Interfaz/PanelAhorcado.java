package Interfaz;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import Ahorcado.Palabras;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;

public class PanelAhorcado extends JPanel
{

    private InterfazGraficaUsuario principal;
    private JLabel imagenesAhorcado;

    public PanelAhorcado ( InterfazGraficaUsuario principal )
    {
        TitledBorder borde = new TitledBorder( " Ahorcado " );
        borde.setTitleColor( Color.BLACK );
        setBorder( borde );

        this.principal = principal;
        setLayout( new BorderLayout() );

        imagenesAhorcado = new JLabel( );
        imagenesAhorcado.setBorder( new EmptyBorder( 0, 0, 0, 10 ) );
        add( imagenesAhorcado, BorderLayout.WEST );
        actualizarImagenAhorcado(principal.getPalabras().getErrores());
    }

    public void actualizarImagenAhorcado (Integer error){
        imagenesAhorcado.setIcon( new ImageIcon(
                new ImageIcon( "./AHORCADO/src/Imagenes/IMG_" + error + ".png").getImage( ).
                        getScaledInstance( 470, 300, Image.SCALE_DEFAULT )));
    }




}