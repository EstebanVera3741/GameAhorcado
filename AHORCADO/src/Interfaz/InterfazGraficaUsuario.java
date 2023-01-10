package Interfaz;

import Ahorcado.Palabras;

import javax.swing.*;
import java.awt.*;

public class InterfazGraficaUsuario extends JFrame {



    public static final String RUTA_IMAGEN = "./AHORCADO/src/Imagenes/LOGO.png" ;
    private Palabras palabras;
    private PanelAhorcado panelAhorcado;
    private PanelEnunciado panelEnunciado;
    private PanelDescripcion panelDescripcion;
    private PanelLetras panelLetras;
    private PanelEscogerLetras panelEscogerLetra;


    public InterfazGraficaUsuario(){


        setTitle( " EL AHORCADO " );
        setSize( 1000, 760 );
        setResizable( false );
        setLocationRelativeTo( null );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        setLayout( new BorderLayout( ) );
        palabras = new Palabras(this);


        JLabel labImagen = new JLabel( );
        labImagen.setIcon( new ImageIcon( RUTA_IMAGEN ) );
        labImagen.setIcon( new ImageIcon( new ImageIcon( RUTA_IMAGEN ).getImage( ).
                getScaledInstance( 1000, 250, Image.SCALE_DEFAULT )  ));
        add( labImagen, BorderLayout.NORTH );
        obtenerArreglo();

        JPanel panelCentro = new JPanel( );
        panelCentro.setLayout( new BorderLayout( ) );
        add( panelCentro, BorderLayout.CENTER );

            panelAhorcado = new PanelAhorcado( this );
            panelCentro.add( panelAhorcado, BorderLayout.WEST );

            panelEnunciado = new PanelEnunciado(this);
            panelCentro.add( panelEnunciado, BorderLayout.EAST);


            panelDescripcion = new PanelDescripcion(this);
            panelCentro.add( panelDescripcion, BorderLayout.SOUTH);


        JPanel panelSur = new JPanel( );
        panelSur.setLayout( new BorderLayout( ) );
        add( panelSur, BorderLayout.SOUTH);

            panelLetras = new PanelLetras(this);
            panelSur.add(panelLetras, BorderLayout.WEST);

            panelEscogerLetra = new PanelEscogerLetras(this);
            panelSur.add(panelEscogerLetra, BorderLayout.CENTER );


    }
    public void buscarPorLetra (){
        String letra = panelEscogerLetra.obtenerLetra();
        if (letra.isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese una letra");
        }
        else{
            boolean existe = palabras.verificarLetra(letra);
            String palabra = palabras.convertirListaString();
            if (existe){
                panelLetras.actualizarLetras(palabra);
                if (palabras.getAciertos().equals(palabras.getLetrasAsteriscos().length())){
                    JOptionPane.showMessageDialog(this, "VICTORIA");
                }
            }
            else{
                panelAhorcado.actualizarImagenAhorcado(palabras.getErrores());
                if(palabras.getErrores() == 6){
                    JOptionPane.showMessageDialog(this, "AHORCADO");
                }
            }
        }

    }


    public void obtenerArreglo(){
        palabras.convertirPalabras(palabras.getNumeroRandom());
        palabras.encriptarPalabras();

    }

    public Palabras getPalabras()
    {
        return palabras;
    }






    /**
     * (1) este metodo inicializa la interfaz instanciando la ventana de la InterfazGraficaUsuario
     * @param args
     */
    public static void main( String [ ] args )
    {
        try {
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );

            InterfazGraficaUsuario interfazGraficaUsuario = new InterfazGraficaUsuario( );
            interfazGraficaUsuario.setVisible( true );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( null, e.getMessage( ),
                    "Vuelve Intentarlo", JOptionPane.ERROR_MESSAGE );
        }
    }


}