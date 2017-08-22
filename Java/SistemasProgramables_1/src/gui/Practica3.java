package gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToggleButton;


/**
 * Hecho con <3 por:
 * @author GarciHard
 */

public class Practica3 extends javax.swing.JDialog {

    public Practica3(java.awt.Frame parent, boolean modal) {
        super(parent, false);
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new javax.swing.JPanel();
        lblLumenes = new javax.swing.JLabel();
        tgbOnOff = new javax.swing.JToggleButton();
        btnGraficaLuxes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        pnlBackground.setBackground(new java.awt.Color(39, 174, 96));
        pnlBackground.setLayout(new java.awt.BorderLayout());

        lblLumenes.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lblLumenes.setForeground(new java.awt.Color(255, 255, 255));
        lblLumenes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlBackground.add(lblLumenes, java.awt.BorderLayout.CENTER);

        tgbOnOff.setText("On / Off");
        pnlBackground.add(tgbOnOff, java.awt.BorderLayout.PAGE_START);

        btnGraficaLuxes.setText("Obtener Grafica");
        pnlBackground.add(btnGraficaLuxes, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public JLabel getLblLumenes() {
        return lblLumenes;
    }

    public JToggleButton getTgbOnOff() {
        return tgbOnOff;
    }
    
    public JButton getBtnGraficaLuxes() {
        return btnGraficaLuxes;
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGraficaLuxes;
    private javax.swing.JLabel lblLumenes;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JToggleButton tgbOnOff;
    // End of variables declaration//GEN-END:variables

}
