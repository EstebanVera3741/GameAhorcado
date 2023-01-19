package Interfaz;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelLetra extends JPanel {

    private InterfazGraficaUsuario principal;
    private JPanel panelLetras;
    private JTextField txtPalabraEncriptada;

    public PanelLetra(InterfazGraficaUsuario principal){

        TitledBorder borde = new TitledBorder( "" );
        borde.setTitleColor( Color.BLACK );
        setBorder( borde );

        this.principal = principal;

        setLayout( new BorderLayout() );

        panelLetras = new JPanel( );
        panelLetras.setLayout( new GridLayout( 2, 2, 10, 5 ) );
        add( panelLetras, BorderLayout.WEST );

        txtPalabraEncriptada = new JTextField(principal.getPalabrasJuegoAhorcado().getPalabraEncriptada());
        txtPalabraEncriptada.setFont(new Font("Serif", Font.PLAIN, 50));
        txtPalabraEncriptada.setEditable( false );
        txtPalabraEncriptada.setColumns(10);
        panelLetras.add(txtPalabraEncriptada);
    }
    public void actualizarLetras (String palabra){
        txtPalabraEncriptada.setText(palabra);
    }

}
