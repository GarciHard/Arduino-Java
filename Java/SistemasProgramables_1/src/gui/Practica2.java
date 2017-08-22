package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 * Hecho con <3 por:
 * @author GarciHard
 */

public class Practica2 extends javax.swing.JDialog {

    public Practica2(java.awt.Frame parent, boolean modal) {
        super(parent, false);
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        pnlColor = new javax.swing.JPanel();
        lblMensaje = new javax.swing.JLabel();
        tgbOnOff = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        pnlBackground.setLayout(new java.awt.BorderLayout());

        lblTitulo.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Colores");
        pnlBackground.add(lblTitulo, java.awt.BorderLayout.PAGE_START);

        pnlColor.setBorder(javax.swing.BorderFactory.createTitledBorder("Panel de color"));
        pnlColor.setForeground(new java.awt.Color(255, 255, 255));

        lblMensaje.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        lblMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlColorLayout = new javax.swing.GroupLayout(pnlColor);
        pnlColor.setLayout(pnlColorLayout);
        pnlColorLayout.setHorizontalGroup(
            pnlColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlColorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlColorLayout.setVerticalGroup(
            pnlColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlColorLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlBackground.add(pnlColor, java.awt.BorderLayout.CENTER);

        tgbOnOff.setText("On / Off");
        tgbOnOff.setToolTipText("");
        pnlBackground.add(tgbOnOff, java.awt.BorderLayout.SOUTH);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public JPanel getPnlColor() {
        return pnlColor;
    }

    public JToggleButton getTgbOnOff() {
        return tgbOnOff;
    }

    public JLabel getLblMensaje() {
        return lblMensaje;
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlColor;
    private javax.swing.JToggleButton tgbOnOff;
    // End of variables declaration//GEN-END:variables

}
