package Interfaz;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelDescripcionDeLaPalabraDelaAhorcado extends JPanel {
    private InterfazGraficaUsuario principal;
    private String descripcionPalabra;


    public PanelDescripcionDeLaPalabraDelaAhorcado(InterfazGraficaUsuario principal )
    {
        TitledBorder borde = new TitledBorder("");
        borde.setTitleColor( Color.BLACK );
        setBorder( borde );

        this.principal = principal;
        setLayout( new BorderLayout() );

        JPanel panelDescripcion = new JPanel( );
        panelDescripcion.setLayout( new GridLayout( 2, 2, 0, 5 ) );
        add( panelDescripcion, BorderLayout.CENTER );

        actualizarDescripcion(principal.getPalabrasJuegoAhorcado().getNumeroRandom());

        JLabel labDescripcion = new JLabel(descripcionPalabra, JLabel.CENTER);
        labDescripcion.setFont(new Font("Serif", Font.PLAIN, 18));
        panelDescripcion.add( labDescripcion );
    }

    public void actualizarDescripcion (Integer numeroDescripcion){
        descripcionPalabra = principal.getDescripcionPalabras()
                .visualizarDescripcionesDeLasPalabras(numeroDescripcion);
    }
}