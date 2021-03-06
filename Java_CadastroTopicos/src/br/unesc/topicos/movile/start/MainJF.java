package br.unesc.topicos.movile.start;

import br.unesc.topicos.movile.view.ClienteJIF;
import br.unesc.topicos.movile.view.EmpreiteiraJIF;
import br.unesc.topicos.movile.view.SobreJIF;
import br.unesc.topicos.movile.view.ImovelJIF;
import javax.swing.JInternalFrame;

public class MainJF extends javax.swing.JFrame {
    
    public MainJF() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        menuOpcoes = new javax.swing.JMenu();
        menuOpcoesCadastroClientes = new javax.swing.JMenuItem();
        menuOpcoesCadastroImoveis = new javax.swing.JMenuItem();
        menuOpcoesCadastroEmpreiteiras = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuOpcoesSair = new javax.swing.JMenuItem();
        menuAjuda = new javax.swing.JMenu();
        menuAjudaSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Movile 2.1");
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setName("MainWindow"); // NOI18N
        setSize(new java.awt.Dimension(1280, 720));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        desktopPane.setBackground(new java.awt.Color(232, 232, 232));

        menuOpcoes.setText("Opções");

        menuOpcoesCadastroClientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        menuOpcoesCadastroClientes.setText("Cadastro de Clientes");
        menuOpcoesCadastroClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOpcoesCadastroClientesActionPerformed(evt);
            }
        });
        menuOpcoes.add(menuOpcoesCadastroClientes);

        menuOpcoesCadastroImoveis.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        menuOpcoesCadastroImoveis.setText("Cadastro de Imóveis");
        menuOpcoesCadastroImoveis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOpcoesCadastroImoveisActionPerformed(evt);
            }
        });
        menuOpcoes.add(menuOpcoesCadastroImoveis);

        menuOpcoesCadastroEmpreiteiras.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        menuOpcoesCadastroEmpreiteiras.setText("Cadastro de Empreiteiras");
        menuOpcoesCadastroEmpreiteiras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOpcoesCadastroEmpreiteirasActionPerformed(evt);
            }
        });
        menuOpcoes.add(menuOpcoesCadastroEmpreiteiras);
        menuOpcoes.add(jSeparator1);

        menuOpcoesSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        menuOpcoesSair.setText("Sair");
        menuOpcoesSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOpcoesSairActionPerformed(evt);
            }
        });
        menuOpcoes.add(menuOpcoesSair);

        menuBar.add(menuOpcoes);

        menuAjuda.setText("Ajuda");

        menuAjudaSobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        menuAjudaSobre.setText("Sobre");
        menuAjudaSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAjudaSobreActionPerformed(evt);
            }
        });
        menuAjuda.add(menuAjudaSobre);

        menuBar.add(menuAjuda);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuAjudaSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAjudaSobreActionPerformed
        JInternalFrame internalSobre = new SobreJIF();
        desktopPane.add(internalSobre);
        internalSobre.setVisible(true);
    }//GEN-LAST:event_menuAjudaSobreActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setLocationRelativeTo(null);
    }//GEN-LAST:event_formWindowOpened

    private void menuOpcoesCadastroImoveisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOpcoesCadastroImoveisActionPerformed
        JInternalFrame internalCadastroImoveis = new ImovelJIF();
        desktopPane.add(internalCadastroImoveis);
        internalCadastroImoveis.setVisible(true);
    }//GEN-LAST:event_menuOpcoesCadastroImoveisActionPerformed

    private void menuOpcoesSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOpcoesSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuOpcoesSairActionPerformed

    private void menuOpcoesCadastroClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOpcoesCadastroClientesActionPerformed
        JInternalFrame internalCadastroClientes = new ClienteJIF();
        desktopPane.add(internalCadastroClientes);
        internalCadastroClientes.setVisible(true);
    }//GEN-LAST:event_menuOpcoesCadastroClientesActionPerformed

    private void menuOpcoesCadastroEmpreiteirasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOpcoesCadastroEmpreiteirasActionPerformed
        // TODO add your handling code here:
        JInternalFrame internalCadastroEmpreiteiras = new EmpreiteiraJIF();
        desktopPane.add(internalCadastroEmpreiteiras);
        internalCadastroEmpreiteiras.setVisible(true);
    }//GEN-LAST:event_menuOpcoesCadastroEmpreiteirasActionPerformed


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenuItem menuAjudaSobre;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuOpcoes;
    private javax.swing.JMenuItem menuOpcoesCadastroClientes;
    private javax.swing.JMenuItem menuOpcoesCadastroEmpreiteiras;
    private javax.swing.JMenuItem menuOpcoesCadastroImoveis;
    private javax.swing.JMenuItem menuOpcoesSair;
    // End of variables declaration//GEN-END:variables

}
