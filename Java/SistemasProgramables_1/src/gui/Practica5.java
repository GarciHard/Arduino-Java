package gui;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 * Hecho con <3 por:
 * @author GarciHard
 */

public class Practica5 extends javax.swing.JDialog {

    public Practica5(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtLCD = new javax.swing.JTextField();
        btnEnviarDatos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlBackground.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Texto LCD");
        pnlBackground.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        txtLCD.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingrese texto a desplegar en LCD"));
        pnlBackground.add(txtLCD, java.awt.BorderLayout.CENTER);

        btnEnviarDatos.setText("Enviar datos");
        pnlBackground.add(btnEnviarDatos, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBtnEnviarDatos() {
        return btnEnviarDatos;
    }

    public JTextField getTxtLCD() {
        return txtLCD;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviarDatos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JTextField txtLCD;
    // End of variables declaration//GEN-END:variables

}
