package controller;

import conexion.ConexionArduino;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gui.Practica3;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Scanner;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * Hecho con <3 por:
 * @author GarciHard
 */

public class Practica3Controller implements ActionListener, SerialPortEventListener, WindowListener {

    private final ConexionArduino conexionObj = new ConexionArduino();
    private final Practica3 dialogLumen;
    private XYSeries serie = new XYSeries("Lumenes");
    private JFreeChart chart;
    
    public Practica3Controller(Practica3 dialogLumen) {
        this.dialogLumen = dialogLumen;
    }

    public void iniciarP3() {
        conexionObj.conexionArduino(this, true);
        this.dialogLumen.addWindowListener(this);
        this.dialogLumen.getTgbOnOff().addActionListener(this);
        this.dialogLumen.getBtnGraficaLuxes().addActionListener(this);
        this.dialogLumen.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.dialogLumen.getTgbOnOff().isSelected()) {
            conexionObj.enviarDatos("3");
        } else {
            conexionObj.enviarDatos("0");
        }
        if (e.getSource() == this.dialogLumen.getBtnGraficaLuxes()) {
            ChartFrame panel = new ChartFrame("GraficaLuxes", chart);
            panel.setVisible(true);
        }
    }
    
    int i = 0;
    @Override
    public void serialEvent(SerialPortEvent spe) {
        if (spe.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                Scanner sc = new Scanner(conexionObj.getInput());
                this.dialogLumen.getLblLumenes().setText("Cantidad de lumenes : " + sc.nextLine());
                
                serie.addOrUpdate(i++, Integer.parseInt(sc.nextLine()) * 100 / 150);
                XYSeriesCollection dataset = new XYSeriesCollection();
                dataset.addSeries(serie);

                chart = ChartFactory.createXYLineChart(
                        "GraficaLuxes", // Título
                        "(x)", // Etiqueta Coordenada X
                        "(y)", // Etiqueta Coordenada Y
                        dataset, // Datos
                        PlotOrientation.VERTICAL,
                        true, // Muestra el nombre de la barra xd
                        false,
                        false
                );
                
            } catch (Exception e) {
                System.err.println("Practica3_Controller :" + e);
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
