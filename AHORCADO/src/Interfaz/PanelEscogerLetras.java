package Interfaz;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelEscogerLetras extends JPanel implements ActionListener {

    private InterfazGraficaUsuario principal;
    public static final String BUSCAR_LETRA = "Search Letter";
    public static final String BUSCAR_PALABRA = "Search Word";
    private JTextField textField;
    private JButton btnBuscarLetra;
    private JButton btnBuscarPalabra;

    public PanelEscogerLetras(InterfazGraficaUsuario principal){

        TitledBorder borde = new TitledBorder( "" );
        borde.setTitleColor( Color.BLUE );
        setBorder( borde );

        this.principal = principal;

        setLayout( new GridLayout( 3, 2 ) );

        textField = new JTextField( );
        add( textField );

        btnBuscarLetra = new JButton( "SEARCH LETTER" );
        btnBuscarLetra.setActionCommand( BUSCAR_LETRA);
        btnBuscarLetra.addActionListener( this );
        add(btnBuscarLetra);

        btnBuscarPalabra = new JButton( "SEARCH WORD" );
        btnBuscarPalabra.setActionCommand( BUSCAR_PALABRA);
        btnBuscarPalabra.addActionListener( this );
        add(btnBuscarPalabra);


        JPanel panelLetras = new JPanel( );
        panelLetras.setLayout( new GridLayout( 2, 2, 10, 5 ) );
        add( panelLetras, BorderLayout.CENTER );

        JLabel labLetra = new JLabel();
        panelLetras.add( labLetra );
    }
    @Override
    public void actionPerformed (ActionEvent evento ){
        String accionClick = evento.getActionCommand();
        switch (accionClick){
            case BUSCAR_LETRA:
                principal.validarExistenciaDeLaLetraEnLaPalabraEncriptada();
                break;
            case BUSCAR_PALABRA:
                principal.validarPalabraCompleta();
                break;
        }
    }
    public String obtenerLetra( )
    {
        return textField.getText( ).toUpperCase();
    }
}
