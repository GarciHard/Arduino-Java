package controller;

import conexion.ConexionArduino;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gui.Practica1;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Scanner;

/**
 * Hecho con <3 por:
 * @author GarciHard
 */

public class Practica1Controller implements ItemListener, SerialPortEventListener, WindowListener {
    
    private final ConexionArduino conexionObj = new ConexionArduino();
    private final Practica1 dialogSensor;
    
    public Practica1Controller(Practica1 dialogSensor) {
        this.dialogSensor = dialogSensor;
    }
    
    public void iniciarP1() {
        conexionObj.conexionArduino(this, true);
        this.dialogSensor.addWindowListener(this);
        this.dialogSensor.getTgbOnOff().addItemListener(this);
        this.dialogSensor.setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED)
            conexionObj.enviarDatos("1");
        else {
            conexionObj.enviarDatos("0");
            this.dialogSensor.getLblEstado().setText("");
        }
    }

    @Override
    public void serialEvent(SerialPortEvent spe) {
        if (spe.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                Scanner sc = new Scanner(conexionObj.getInput());
                System.out.println("SALIDA SERIAL MOVIMIENTO :" + sc.nextLine());
//                if (sc.nextLine().startsWith("m")) {
//                    if (sc.nextLine().charAt(1) == 'M') {
//                        this.dialogSensor.getLblEstado().setBackground(new Color(39, 174, 96));
//                        this.dialogSensor.getLblEstado().setText("Movimiento Detectado");
//                    } else if (sc.nextLine().charAt(1) == 'N') {
//                        this.dialogSensor.getLblEstado().setBackground(new Color(192, 57, 43));
//                        this.dialogSensor.getLblEstado().setText("No se detecta movimiento");
//                    }
//                }
                switch (sc.nextLine()) {
                    case "Movimiento" : 
                        this.dialogSensor.getLblEstado().setBackground(new Color(39, 174, 96));
                        this.dialogSensor.getLblEstado().setText("Movimiento Detectado");
                        break;
                    case "No Movimiento" : 
                        this.dialogSensor.getLblEstado().setBackground(new Color(192, 57, 43));
                        this.dialogSensor.getLblEstado().setText("No se detecta movimiento");
                        break;
                }
            } catch (Exception e) {
                System.err.println("Practica1_Controller :" + e);
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
        //conexionObj.enviarDatos("0");
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
