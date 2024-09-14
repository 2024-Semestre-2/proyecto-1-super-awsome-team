/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author someone
 */
public class UI extends javax.swing.JFrame {

    /**
     * Creates new form UI
     */
    public UI() {
        initComponents();
        
        try {
            // Startup
            System.out.println("Default settings: ");
            this.config = new Config("config.txt");
            System.out.println(config.toString());
        } catch (Exception ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.kernel = new Kernel(this.config);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooserAsm = new javax.swing.JFileChooser();
        jFileChooserConfig = new javax.swing.JFileChooser();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItemOpenFile = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        javax.swing.JMenuItem jMenuItemConfig = new javax.swing.JMenuItem();

        jFileChooserAsm.setFileFilter(new proyecto1.AsmFilter());
        jFileChooserAsm.setMultiSelectionEnabled(true);

        jFileChooserConfig.setFileFilter(new proyecto1.TxtFilter());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu3.setText("File");

        jMenuItemOpenFile.setText("Open File");
        jMenuItemOpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOpenFileActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemOpenFile);

        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");

        jMenuItemConfig.setText("Config");
        jMenuItemConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConfigActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItemConfig);

        jMenuBar2.add(jMenu4);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 937, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 599, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemOpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOpenFileActionPerformed
      int returnVal = jFileChooserAsm.showOpenDialog(this);
      if (returnVal == JFileChooser.APPROVE_OPTION) {
        File[] files = jFileChooserAsm.getSelectedFiles();
        try {
            // Load to memory
            this.kernel.load(files);
            // Scheduler
            
            // Dispatcher
        }
        catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Dialog", JOptionPane.ERROR_MESSAGE);
        }
      } 
      else {
        System.out.println("File access cancelled by user.");
      }

    }//GEN-LAST:event_jMenuItemOpenFileActionPerformed

    /**
     * Metodo encargado de dar funcionalidad en display de configuraciones 
     * @param evt 
     */
    private void jMenuItemConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConfigActionPerformed
      System.out.println("\n...Loading new settings...");
      int returnVal = jFileChooserConfig.showOpenDialog(this);  
      if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = jFileChooserConfig.getSelectedFile();
        if (!file.getName().endsWith(".txt")) {
          JOptionPane.showMessageDialog(null, "ERROR: Invalid Format", "Inavlid Format", JOptionPane.ERROR_MESSAGE);
        }   
        else {
          try {
            this.config = new Config(file.getName());
            System.out.println("  -Update Memory size-\n");
            System.out.println(config);  
            this.kernel = new Kernel(config);          
          }        
          catch (Exception ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
          }                    
        }
      }
      else {
          System.out.println("File access cancelled by user.");
      }
    }//GEN-LAST:event_jMenuItemConfigActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI().setVisible(true);
            }
        });
    }
    
    private Kernel kernel;
    private Config config;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jFileChooserAsm;
    private javax.swing.JFileChooser jFileChooserConfig;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItemOpenFile;
    // End of variables declaration//GEN-END:variables
}
