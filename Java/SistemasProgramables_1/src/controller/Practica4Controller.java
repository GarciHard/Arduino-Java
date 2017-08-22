package controller;

import conexion.ConexionArduino;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gui.Practica4;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Scanner;

/**
 * Hecho con <3 por:
 * @author GarciHard
 */

public class Practica4Controller implements ActionListener, ItemListener, SerialPortEventListener, WindowListener {

    private final ConexionArduino conexionObj = new ConexionArduino();
    private final Practica4 dialogServo;
    
    public Practica4Controller(Practica4 dialogServo) {
        this.dialogServo = dialogServo;
    }

    public void iniciarP4() {
        conexionObj.conexionArduino(this, true);
        this.dialogServo.getBtnMoverServo().addActionListener(this);
        this.dialogServo.addWindowListener(this);
        this.dialogServo.getTgbOnOff().addItemListener(this);
        this.dialogServo.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int grados = (int) this.dialogServo.getSpnGradoServo().getValue();
        conexionObj.enviarDatos("4 " + String.valueOf(grados));
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            conexionObj.enviarDatos("4");
        } else {
            conexionObj.enviarDatos("0");
        }
    }

    @Override
    public void serialEvent(SerialPortEvent spe) {
        if (spe.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                Scanner sc = new Scanner(conexionObj.getInput());
                
            } catch (Exception e) {
                System.err.println("Practica4_Controller :" + e);
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
