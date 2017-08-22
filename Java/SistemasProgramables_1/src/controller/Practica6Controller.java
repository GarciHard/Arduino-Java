package controller;

import conexion.ConexionArduino;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gui.Practica6;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Scanner;

/**
 * Hecho con <3 por:
 * @author GarciHard
 */

public class Practica6Controller implements ActionListener, SerialPortEventListener, WindowListener {

    private final ConexionArduino conexionObj = new ConexionArduino();
    private final Practica6 stepMotor;
    
    public Practica6Controller(Practica6 stepMotor) {
        this.stepMotor = stepMotor;
    }

    public void iniciarP6() {
        conexionObj.conexionArduino(this, true);
        this.stepMotor.getBtnStepMotor().addActionListener(this);
        this.stepMotor.addWindowListener(this);
        this.stepMotor.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int grados = (int) this.stepMotor.getSpnStepMotor().getValue();
        conexionObj.enviarDatos("6 " + String.valueOf(grados));
    }

    @Override
    public void serialEvent(SerialPortEvent spe) {
        if (spe.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                Scanner sc = new Scanner(conexionObj.getInput());
                
            } catch (Exception e) {
                System.err.println("Practica6_Controller :" + e);
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
