package main;

import controller.MenuController;
import gui.MenuPracticas;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Hecho con <3 por:
 * @author GarciHard
 */

public class PracticasMain {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(PracticasMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        new MenuController(new MenuPracticas()).iniciarApp();
    }
}
