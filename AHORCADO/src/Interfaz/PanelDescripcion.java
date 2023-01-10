package Interfaz;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import Ahorcado.DescripcionPalabras;
import Ahorcado.Palabras;

import java.awt.*;

public class PanelDescripcion extends JPanel
{

    private InterfazGraficaUsuario principal;
    private DescripcionPalabras descripcionPalabras;
    private String imagenesDescripcion;


    public PanelDescripcion ( InterfazGraficaUsuario principal )
    {
        TitledBorder borde = new TitledBorder( " Descripcion " );
        borde.setTitleColor( Color.BLACK );
        setBorder( borde );

        this.principal = principal;
        descripcionPalabras = new DescripcionPalabras();
        setLayout( new BorderLayout() );


        JPanel panelDescripcion = new JPanel( );
        panelDescripcion.setLayout( new GridLayout( 2, 2, 0, 5 ) );
        add( panelDescripcion, BorderLayout.CENTER );


        actualizarDescripcion(principal.getPalabras().getNumeroRandom());


        JLabel labDescripcion = new JLabel( imagenesDescripcion );
        panelDescripcion.add( labDescripcion );



    }

    public void actualizarDescripcion (Integer numeroDescripcion){
        String descripcionImagenes = descripcionPalabras.visualizarDescripciones(numeroDescripcion);
        imagenesDescripcion = descripcionImagenes;
    }






}