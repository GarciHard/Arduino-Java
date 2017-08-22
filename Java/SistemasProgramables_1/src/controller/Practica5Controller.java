package controller;

import conexion.ConexionArduino;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gui.Practica5;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Scanner;

/**
 * Hecho con <3 por:
 * @author GarciHard
 */

public class Practica5Controller implements ActionListener, KeyListener, SerialPortEventListener, WindowListener {

    private final ConexionArduino conexionObj = new ConexionArduino();
    private final Practica5 dialogLCD;
    
    public Practica5Controller(Practica5 dialogLCD) {
        this.dialogLCD = dialogLCD;
    }

    public void iniciarP5() {
        conexionObj.conexionArduino(this, true);
        conexionObj.enviarDatos("5");
        this.dialogLCD.addWindowListener(this);
        this.dialogLCD.getBtnEnviarDatos().addActionListener(this);
        this.dialogLCD.getTxtLCD().addKeyListener(this);
        this.dialogLCD.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.dialogLCD.getBtnEnviarDatos()) {
            conexionObj.enviarDatos("5");
            conexionObj.enviarDatos(this.dialogLCD.getTxtLCD().getText());
        }
    }

    @Override
    public void serialEvent(SerialPortEvent spe) {
        if (spe.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                Scanner sc = new Scanner(conexionObj.getInput());
                
            } catch (Exception e) {
                System.err.println("Practica5_Controller :" + e);
            }
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {}

    @Override
    public void windowClosed(WindowEvent e) {
        /*En caso de que se cierre la ventana
        sin presionar el botón OFF se cierra la conexión
        junto con la ventana xddddd*/
        conexionObj.enviarDatos("0");
        conexionObj.cerrarConexion();
    }

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            conexionObj.enviarDatos(this.dialogLCD.getTxtLCD().getText());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

}
