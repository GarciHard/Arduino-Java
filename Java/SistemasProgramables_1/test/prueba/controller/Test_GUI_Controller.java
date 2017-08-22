package prueba.controller;

import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import prueba.Test_GUI;
import prueba.conexion.ConexionArduino;


/**
 * Hecho con <3 por:
 * @author GarciHard
 */

public class Test_GUI_Controller implements ActionListener, SerialPortEventListener {
    
    private final Test_GUI frame;
    private final ConexionArduino conexionObj = new ConexionArduino();
    
    public Test_GUI_Controller (Test_GUI frame) {
        this.frame = frame;
    }
    
    public void iniciarTest_GUI () {
        conexionObj.conexionArduino(this, true);
        this.frame.getBtn1().addActionListener(this);
        this.frame.getBtn2().addActionListener(this);
        this.frame.setVisible(true);
    }

    @Override
    public void serialEvent(SerialPortEvent spe) {
        if (spe.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                Scanner sc = new Scanner(conexionObj.getInput());
                System.out.println("SALIDA SERIAL MOVIMIENTO :" + sc.nextLine());
                if (sc.nextLine().startsWith("m")) {
                    if (sc.nextLine().charAt(1) == 'M') {
                        this.frame.getLbl1().setBackground(new Color(39, 174, 96));
                        this.frame.getLbl1().setText("Movimiento Detectado");
                    } else if (sc.nextLine().charAt(1) == 'N') {
                        this.frame.getLbl1().setBackground(new Color(192, 57, 43));
                        this.frame.getLbl1().setText("No se detecta movimiento");
                    }
                } if (sc.nextLine().startsWith("c")) {
                    switch (sc.nextLine().charAt(1)) {
                        case 'B':
                            this.frame.getPnl1().setBackground(new Color(255, 255, 255));
                            break;
                        case 'R':
                            this.frame.getPnl1().setBackground(new Color(228, 9, 29));
                            break;
                        case 'V':
                            this.frame.getPnl1().setBackground(new Color(39, 174, 96));
                            break;
                        case 'A':
                            this.frame.getPnl1().setBackground(new Color(41, 128, 185));
                            break;
                        case 'Y':
                            this.frame.getPnl1().setBackground(new Color(241, 196, 15));
                            break;
                        case 'N':
                            this.frame.getPnl1().setBackground(new Color(0, 0, 0));
                            break;
                        default:
                            this.frame.getLbl2().setText("NO SE IDENTIFICA EL COLOR");
                            break;
                    }
                }
            } catch (Exception e) {
                System.err.println("TEST_GUI_CONTROLLER :" + e);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.frame.getBtn1()) {
            Thread hilo = new Thread(new Runnable() {
                @Override
                public void run() {
                    conexionObj.enviarDatos("1");
                }
            });
            hilo.start();
        }
        if (e.getSource() == this.frame.getBtn2()) {
            Thread hilo = new Thread(new Runnable() {
                @Override
                public void run() {
                    conexionObj.enviarDatos("2");
                }
            });
            hilo.start();
        }
        
    }
    
    public static void main(String[] args) {
        new Test_GUI_Controller(new Test_GUI()).iniciarTest_GUI();
    }
    
}
