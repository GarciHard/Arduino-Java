package controller;

import gui.MenuPracticas;
import gui.Practica1;
import gui.Practica2;
import gui.Practica3;
import gui.Practica4;
import gui.Practica5;
import gui.Practica6;
import gui.Practica7;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Hecho con <3 por:
 * @author GarciHard
 */

public class MenuController implements ActionListener {
    
    private final MenuPracticas menuPracticas;
    
    public MenuController (MenuPracticas menuPracticas) {
        this.menuPracticas = menuPracticas;
    }  
    
    public void iniciarApp() {
        this.menuPracticas.getBtnP1().addActionListener(this);
        this.menuPracticas.getBtnP2().addActionListener(this);
        this.menuPracticas.getBtnP3().addActionListener(this);
        this.menuPracticas.getBtnP4().addActionListener(this);
        this.menuPracticas.getBtnP5().addActionListener(this);
        this.menuPracticas.getBtnP6().addActionListener(this);
        this.menuPracticas.getBtnP7().addActionListener(this);
        this.menuPracticas.setVisible(true);
    } 
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Practica1":
                new Practica1Controller(new Practica1(this.menuPracticas, true)).iniciarP1();
                break;
            case "Practica2":
                new Practica2Controller(new Practica2(this.menuPracticas, true)).iniciarP2();
                break;
            case "Practica3":
                new Practica3Controller(new Practica3(this.menuPracticas, true)).iniciarP3();
                break;
            case "Practica4":
                new Practica4Controller(new Practica4(this.menuPracticas, true)).iniciarP4();
                break;
            case "Practica5":
                new Practica5Controller(new Practica5(this.menuPracticas, true)).iniciarP5();
                break;
            case "Practica6":
                new Practica6Controller(new Practica6(this.menuPracticas, true)).iniciarP6();
                break;
            case "Practica7":
                new Practica7Controller(new Practica7(this.menuPracticas, true)).iniciarP7();
                break;
        }
    }
}
