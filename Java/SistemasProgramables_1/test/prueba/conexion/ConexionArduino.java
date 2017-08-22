package prueba.conexion;

import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.TooManyListenersException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hecho con <3 por:
 * @author GarciHard
 */

public class ConexionArduino {

    SerialPort puertoSerial;
    private final String nombrePuerto = "/dev/cu.usb"; //Puerto de conexion, en osx puede ser modem1421 o modem1411
    private static final int TIME_OUT = 2000; //Espera en milisegundo para que el puerto se abra.
    private static final int DATA_RATE = 9600; //Bits por segundo para la transmision de datos.
    private OutputStream output;
    private BufferedReader input;
    
    public void conexionArduino(SerialPortEventListener portListener, boolean availableData) {

        CommPortIdentifier puertoID = null;
        Enumeration puertoEnum = CommPortIdentifier.getPortIdentifiers();

        //Busca una instancia del puerto serial, buscara la asignada en nombrePuerto.
        while (puertoEnum.hasMoreElements()) {
            CommPortIdentifier actualPuertoID = (CommPortIdentifier) puertoEnum.nextElement();
            if (actualPuertoID.getName().startsWith(nombrePuerto)) {
                puertoID = actualPuertoID;
                break;
            }
        }
        if (puertoID == null) {
            puertoSerial = null;
        } else {
            // abre el puerto serial.
            try {
                puertoSerial = (SerialPort) puertoID.open(this.getClass().getName(), TIME_OUT);
                Thread.sleep(1000);
                //asignar parametros puerto.
                puertoSerial.setSerialPortParams(DATA_RATE,
                        SerialPort.DATABITS_8,
                        SerialPort.STOPBITS_1,
                        SerialPort.PARITY_NONE);
                
                //abre flujo de datos
                input = new BufferedReader(new InputStreamReader(puertoSerial.getInputStream()));
                output = puertoSerial.getOutputStream();

                //agrega un listener
                puertoSerial.addEventListener(portListener);
                puertoSerial.notifyOnDataAvailable(availableData);

            } catch (PortInUseException | UnsupportedCommOperationException | IOException | TooManyListenersException | InterruptedException e) {
                System.err.println("ConexionArduino : " + e);
            }
        }
    }

    /**
     * Se debe ejecutar cuando se termine de usar el puerto. Va a prevenir el
     * port locking en plataformas como Linux y OS X
     */
    public synchronized void cerrarConexion() {
        if (puertoSerial != null) {
            puertoSerial.removeEventListener();
            puertoSerial.close();
        }
    }
    
    public void enviarDatos(String entrada) {
        try {
            output.write(entrada.getBytes());
        } catch (Exception e) {
            System.err.println("ConexionArduinoEnviarDatos : " + e);
        }
    }

    public BufferedReader getInput() {
        return input;
    }
}