package controller;

import conexion.ConexionArduino;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gui.Practica2;
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

public class Practica2Controller implements ItemListener, SerialPortEventListener, WindowListener {

    private final ConexionArduino conexionObj = new ConexionArduino();
    private final Practica2 dialogColores;
    
    public Practica2Controller(Practica2 dialogColores) {
        this.dialogColores = dialogColores;
    }

    public void iniciarP2() {
        conexionObj.conexionArduino(this, true);
        this.dialogColores.addWindowListener(this);
        this.dialogColores.getTgbOnOff().addItemListener(this);
        this.dialogColores.setVisible(true);
    }
        
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED)
            conexionObj.enviarDatos("2");
        else 
            conexionObj.enviarDatos("0");
    }

    @Override
    public void serialEvent(SerialPortEvent spe) {
        if (spe.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                Scanner sc = new Scanner(conexionObj.getInput());
                switch (sc.nextLine()) {
                    case "Blanco":
                        this.dialogColores.getPnlColor().setBackground(new Color(255, 255, 255));
                        this.dialogColores.getLblMensaje().setVisible(false);
                        break;
                    case "Rojo":
                        this.dialogColores.getPnlColor().setBackground(new Color(228, 9, 29));
                        this.dialogColores.getLblMensaje().setVisible(false);
                        break;
                    case "Verde":
                        this.dialogColores.getPnlColor().setBackground(new Color(39, 174, 96));
                        this.dialogColores.getLblMensaje().setVisible(false);
                        break;
                    case "Azul":
                        this.dialogColores.getPnlColor().setBackground(new Color(41, 128, 185));
                        this.dialogColores.getLblMensaje().setVisible(false);
                        break;
                    case "Amarillo":
                        this.dialogColores.getPnlColor().setBackground(new Color(241, 196, 15));
                        this.dialogColores.getLblMensaje().setVisible(false);
                        break;
                    case "Negro":
                        this.dialogColores.getPnlColor().setBackground(new Color(0, 0, 0));
                        this.dialogColores.getLblMensaje().setVisible(false);
                        break;
                    default:
                        this.dialogColores.getLblMensaje().setText("NO SE IDENTIFICA EL COLOR");
                        this.dialogColores.getLblMensaje().setVisible(true);
                        break;
                }

//                if (sc.nextLine().startsWith("c")) {
//                    switch (sc.nextLine().charAt(1)) {
//                        case 'B':
//                            this.dialogColores.getPnlColor().setBackground(new Color(255, 255, 255));
//                            this.dialogColores.getLblMensaje().setVisible(false);
//                            break;
//                        case 'R':
//                            this.dialogColores.getPnlColor().setBackground(new Color(228, 9, 29));
//                            this.dialogColores.getLblMensaje().setVisible(false);
//                            break;
//                        case 'V':
//                            this.dialogColores.getPnlColor().setBackground(new Color(39, 174, 96));
//                            this.dialogColores.getLblMensaje().setVisible(false);
//                            break;
//                        case 'A':
//                            this.dialogColores.getPnlColor().setBackground(new Color(41, 128, 185));
//                            this.dialogColores.getLblMensaje().setVisible(false);
//                            break;
//                        case 'Y':
//                            this.dialogColores.getPnlColor().setBackground(new Color(241, 196, 15));
//                            this.dialogColores.getLblMensaje().setVisible(false);
//                            break;
//                        case 'N':
//                            this.dialogColores.getPnlColor().setBackground(new Color(0, 0, 0));
//                            this.dialogColores.getLblMensaje().setVisible(false);
//                            break;
//                        default:
//                            this.dialogColores.getLblMensaje().setText("NO SE IDENTIFICA EL COLOR");
//                            this.dialogColores.getLblMensaje().setVisible(true);
//                            break;
//                    }
//                }
            } catch (Exception e) {
                System.err.println("Practica2_Controller :" + e);
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
