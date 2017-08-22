package gui;

import javax.swing.JButton;
import javax.swing.JSpinner;


/**
 * Hecho con <3 por:
 * @author GarciHard
 */

public class Practica6 extends javax.swing.JDialog {

    public Practica6(java.awt.Frame parent, boolean modal) {
        super(parent, false);
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        spnStepMotor = new javax.swing.JSpinner();
        btnStepMotor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Motor a pasos");
        jPanel1.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jLabel2.setText("Pasos motor :");
        jPanel1.add(jLabel2, java.awt.BorderLayout.LINE_START);
        jPanel1.add(spnStepMotor, java.awt.BorderLayout.CENTER);

        btnStepMotor.setText("Mover motor a pasos");
        jPanel1.add(btnStepMotor, java.awt.BorderLayout.LINE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public JSpinner getSpnStepMotor () {
        return spnStepMotor;
    }
    public JButton getBtnStepMotor () {
        return btnStepMotor;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStepMotor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner spnStepMotor;
    // End of variables declaration//GEN-END:variables

}
