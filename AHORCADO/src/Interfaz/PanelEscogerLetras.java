package Interfaz;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelEscogerLetras extends JPanel implements ActionListener {

    private InterfazGraficaUsuario principal;
    public static final String BUSCAR_LETRA = "Buscar Letra";
    private JTextField textField;
    private JButton btnBuscarLinea;

    public PanelEscogerLetras(InterfazGraficaUsuario principal){

        TitledBorder borde = new TitledBorder( "Búsquedas" );
        borde.setTitleColor( Color.BLUE );
        setBorder( borde );

        this.principal = principal;

        setLayout( new GridLayout( 3, 2 ) );

        textField = new JTextField( );
        add( textField );

        btnBuscarLinea = new JButton( "Buscar Letra" );
        btnBuscarLinea.setActionCommand( BUSCAR_LETRA);
        btnBuscarLinea.addActionListener( this );
        add( btnBuscarLinea );


        JPanel panelLetras = new JPanel( );
        panelLetras.setLayout( new GridLayout( 4, 1, 0, 0 ) );
        add( panelLetras, BorderLayout.CENTER );


        JLabel labLetra = new JLabel();
        panelLetras.add( labLetra );


    }

    @Override
    public void actionPerformed (ActionEvent evento ){
        String accionClick =evento.getActionCommand();
        switch (accionClick){
            case BUSCAR_LETRA:
                principal.buscarPorLetra();
        }


    }
    public String obtenerLetra( )
    {
        return textField.getText( );
    }



}
