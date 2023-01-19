package Interfaz;

import JuegoAhorcado.DescripcionPalabrasJuegoDelAhorcado;
import JuegoAhorcado.PalabrasJuegoDelAhorcado;
import javax.swing.*;
import java.awt.*;

public class InterfazGraficaUsuario extends JFrame {
    public static final String RUTA_IMAGEN = "./AHORCADO/src/Imagenes/LOGO.png" ;
    private PalabrasJuegoDelAhorcado palabrasJuegoAhorcado;
    private DescripcionPalabrasJuegoDelAhorcado descripcionPalabras;
    private PanelImagenesJuegoAhorcado panelAhorcado;
    private PanelImagenesDescriptivas panelEnunciado;
    private PanelDescripcionDeLaPalabraDelaAhorcado panelDescripcion;
    private PanelLetra panelLetras;
    private PanelEscogerLetras panelEscogerLetra;
    private Integer contador;


    public InterfazGraficaUsuario(){
        setTitle( " BIENVENIDO JUEGO EL AHORCADO " );
        setSize( 1000, 730 );
        setResizable( false );
        setLocationRelativeTo( null );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        contador = 0;

        setLayout( new BorderLayout( ) );
        palabrasJuegoAhorcado = new PalabrasJuegoDelAhorcado(this);
        descripcionPalabras = new DescripcionPalabrasJuegoDelAhorcado();

        JLabel labImagen = new JLabel( );
        labImagen.setIcon( new ImageIcon( RUTA_IMAGEN ) );
        labImagen.setIcon( new ImageIcon( new ImageIcon( RUTA_IMAGEN ).getImage( ).
                getScaledInstance( 1000, 200, Image.SCALE_DEFAULT )  ));
        add( labImagen, BorderLayout.NORTH );

        JPanel panelCentro = new JPanel( );
        panelCentro.setLayout( new BorderLayout( ) );
        add( panelCentro, BorderLayout.CENTER );

            panelAhorcado = new PanelImagenesJuegoAhorcado( this );
            panelCentro.add( panelAhorcado, BorderLayout.WEST );

            panelEnunciado = new PanelImagenesDescriptivas(this);
            panelCentro.add( panelEnunciado, BorderLayout.EAST);

            panelDescripcion = new PanelDescripcionDeLaPalabraDelaAhorcado(this);
            panelCentro.add( panelDescripcion, BorderLayout.SOUTH);

        JPanel panelSur = new JPanel( );
        panelSur.setLayout( new BorderLayout( ) );
        add( panelSur, BorderLayout.SOUTH);

            panelLetras = new PanelLetra(this);
            panelSur.add(panelLetras, BorderLayout.WEST);

            panelEscogerLetra = new PanelEscogerLetras(this);
            panelSur.add(panelEscogerLetra, BorderLayout.CENTER );
    }
    public void validarExistenciaDeLaLetraEnLaPalabraEncriptada(){
        String letra = panelEscogerLetra.obtenerLetra();
        if (letra.isEmpty()){
            JOptionPane.showMessageDialog(this, "INGRESE UNA LETRA");
        }
        else{
            boolean existe = palabrasJuegoAhorcado.verificaExistenciaDeLaLetraEnElArreglo(letra);
            if (existe){
                panelLetras.actualizarLetras(palabrasJuegoAhorcado.getPalabraEncriptada());
                if (palabrasJuegoAhorcado.verificarCantidadAciertosParaFinalizarJuego()){
                    JOptionPane.showMessageDialog(this,
                            "FELICIDADES TERMINASTE EL JUEGO");
                }
            }
            else{
                panelAhorcado.actualizarImagenAhorcado(palabrasJuegoAhorcado.getErrores());
                if (palabrasJuegoAhorcado.verificarCantidadErroresParaFinalizarJuego()){
                    JOptionPane.showMessageDialog(this, "HAS PERDIDO LA PALABRA ES:   "
                    + palabrasJuegoAhorcado.getVizualizarPalabra());
                }
            }
        }
    }
    public void validarPalabraCompleta(){
        String palabra = panelEscogerLetra.obtenerLetra();
        if (palabra.isEmpty()){
            JOptionPane.showMessageDialog(this, "INGRESE LA PALABRA");
        }
        else {
            if (palabrasJuegoAhorcado.getVizualizarPalabra().equals(palabra)){
                JOptionPane.showMessageDialog(this,
                        "FELICIDADES TERMINASTE EL JUEGO\n" + "LA PALABRA ES:  "
                                + palabrasJuegoAhorcado.getVizualizarPalabra());
            }
            else {
                palabrasJuegoAhorcado.setErrores(contador += 2);
                panelAhorcado.actualizarImagenAhorcado(palabrasJuegoAhorcado.getErrores());
                if (palabrasJuegoAhorcado.verificarCantidadErroresParaFinalizarJuego()){
                    JOptionPane.showMessageDialog(this, "HAS PERDIDO LA PALABRA ES:   "
                            + palabrasJuegoAhorcado.getVizualizarPalabra());
                }
            }
        }
    }
    public PalabrasJuegoDelAhorcado getPalabrasJuegoAhorcado()
    {
        return palabrasJuegoAhorcado;
    }
    public DescripcionPalabrasJuegoDelAhorcado getDescripcionPalabras(){
        return descripcionPalabras;
    }
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
                    "SE HA PRESENTADO UN ERROR VUELVE A INTENTARLO", JOptionPane.ERROR_MESSAGE );
        }
    }
}