package com.ticket.view;

import com.ticket.view.TicketsCreate;
import com.ticket.view.TicketsEdit;

public class LoadingScreen extends javax.swing.JFrame {

    public LoadingScreen() {
        initComponents();
        
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/images/TicketIconTest.png")).getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpFundo = new javax.swing.JPanel();
        jpbLoading = new javax.swing.JProgressBar();
        lblLoading = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpFundo.setPreferredSize(new java.awt.Dimension(640, 320));

        jpbLoading.setForeground(new java.awt.Color(51, 51, 51));
        jpbLoading.setToolTipText("");
        jpbLoading.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jpbLoading.setStringPainted(true);

        javax.swing.GroupLayout jpFundoLayout = new javax.swing.GroupLayout(jpFundo);
        jpFundo.setLayout(jpFundoLayout);
        jpFundoLayout.setHorizontalGroup(
            jpFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpFundoLayout.createSequentialGroup()
                .addContainerGap(245, Short.MAX_VALUE)
                .addComponent(jpbLoading, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(232, 232, 232))
            .addGroup(jpFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpFundoLayout.createSequentialGroup()
                    .addGap(331, 331, 331)
                    .addComponent(lblLoading, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(332, Short.MAX_VALUE)))
        );
        jpFundoLayout.setVerticalGroup(
            jpFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFundoLayout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(jpbLoading, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(271, Short.MAX_VALUE))
            .addGroup(jpFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpFundoLayout.createSequentialGroup()
                    .addGap(246, 246, 246)
                    .addComponent(lblLoading)
                    .addContainerGap(263, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpFundo, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpFundo, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TicketsScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicketsScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicketsScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicketsScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        TicketsCreate creationModal = new TicketsCreate();
        TicketsEdit editionModal = new TicketsEdit();
        TicketsView viewModal = new TicketsView();
        LoadingScreen loading = new LoadingScreen();
        loading.setVisible(true);

        try {
            for (int i = 0; i <= 100; i += 3) {
                Thread.sleep(70);
                loading.jpbLoading.setValue(i);
                //loading.lblLoading.setText(Integer.toString(i) + "%");
            }
            loading.dispose();

            TicketsScreen inicial = new TicketsScreen(creationModal, editionModal, viewModal);
            inicial.setVisible(true);

        } catch (InterruptedException ex) {
            //Logger.getLogger(LoadingScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jpFundo;
    private javax.swing.JProgressBar jpbLoading;
    private javax.swing.JLabel lblLoading;
    // End of variables declaration//GEN-END:variables
}
