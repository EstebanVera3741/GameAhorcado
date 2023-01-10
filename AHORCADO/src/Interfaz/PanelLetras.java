package Interfaz;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelLetras extends JPanel {

    private InterfazGraficaUsuario principal;
    private JLabel labLetra;
    private JPanel panelLetras;

    private JTextField txtMarca;

    public PanelLetras (InterfazGraficaUsuario principal){

        TitledBorder borde = new TitledBorder( " Intentos buscar letra " );
        borde.setTitleColor( Color.BLACK );
        setBorder( borde );

        this.principal = principal;

        setLayout( new BorderLayout() );

        panelLetras = new JPanel( );
        panelLetras.setLayout( new GridLayout( 4, 10, 0, 0 ) );
        add( panelLetras, BorderLayout.WEST );

        txtMarca = new JTextField(principal.getPalabras().getLetrasAsteriscos());
        txtMarca.setEditable( false );
        panelLetras.add( txtMarca );

    }
    public void actualizarLetras (String palabra){
        txtMarca.setText(palabra);
    }



}
