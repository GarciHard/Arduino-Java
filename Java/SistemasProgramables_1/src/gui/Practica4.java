package gui;

import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;


/**
 * Hecho con <3 por:
 * @author GarciHard
 */

public class Practica4 extends javax.swing.JDialog {

    public Practica4(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        tgbOnOff = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        spnGradoServo = new javax.swing.JSpinner();
        btnMoverServo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        pnlBackground.setBackground(new java.awt.Color(39, 174, 96));
        pnlBackground.setLayout(new java.awt.BorderLayout());

        lblTitulo.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Servomotor");
        pnlBackground.add(lblTitulo, java.awt.BorderLayout.PAGE_START);

        tgbOnOff.setText("On / Off");
        pnlBackground.add(tgbOnOff, java.awt.BorderLayout.PAGE_END);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Grados servomotor :");
        pnlBackground.add(jLabel1, java.awt.BorderLayout.LINE_START);
        pnlBackground.add(spnGradoServo, java.awt.BorderLayout.CENTER);

        btnMoverServo.setText("Mover Servomotor");
        btnMoverServo.setToolTipText("");
        pnlBackground.add(btnMoverServo, java.awt.BorderLayout.LINE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBtnMoverServo() {
        return btnMoverServo;
    }
    
    public JSpinner getSpnGradoServo() {
        return spnGradoServo;
    }

    public JToggleButton getTgbOnOff() {
        return tgbOnOff;
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMoverServo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JSpinner spnGradoServo;
    private javax.swing.JToggleButton tgbOnOff;
    // End of variables declaration//GEN-END:variables

}
