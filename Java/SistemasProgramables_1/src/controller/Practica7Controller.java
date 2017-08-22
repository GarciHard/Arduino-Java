package controller;

import conexion.ConexionArduino;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gui.Practica7;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Scanner;

/**
 * Hecho con <3 por:
 * @author GarciHard
 */

public class Practica7Controller implements ItemListener, SerialPortEventListener, WindowListener {

    private final ConexionArduino conexionObj = new ConexionArduino();
    private final Practica7 termistor;
    
    public Practica7Controller(Practica7 termistor) {
        this.termistor = termistor;
    }

    public void iniciarP7() {
        conexionObj.conexionArduino(this, true);
        this.termistor.getTgb1().addItemListener(this);
        this.termistor.addWindowListener(this);
        this.termistor.setVisible(true);
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            conexionObj.enviarDatos("7");
        } else {
            conexionObj.enviarDatos("0");
        }
    }
    

    @Override
    public void serialEvent(SerialPortEvent spe) {
        if (spe.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                Scanner sc = new Scanner(conexionObj.getInput());
                this.termistor.getLbl1().setText(sc.nextLine());
                
            } catch (Exception e) {
                System.err.println("Practica7_Controller :" + e);
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

}
