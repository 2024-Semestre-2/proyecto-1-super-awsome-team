/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;


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
            this.config = new Config("config2.txt");
            System.out.println(config.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Dialog", JOptionPane.ERROR_MESSAGE);
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
        Start = new javax.swing.JButton();
        Step = new javax.swing.JButton();
        Clean = new javax.swing.JButton();
        Statistics = new javax.swing.JButton();
        jLabelRegister = new javax.swing.JLabel();
        jLabelAC = new javax.swing.JLabel();
        jTextFieldAC = new javax.swing.JTextField();
        jLabelAX = new javax.swing.JLabel();
        jTextFieldAX = new javax.swing.JTextField();
        jLabelBX = new javax.swing.JLabel();
        jTextFieldBX = new javax.swing.JTextField();
        jLabelCX = new javax.swing.JLabel();
        jTextFieldCX = new javax.swing.JTextField();
        jLabelDX = new javax.swing.JLabel();
        jTextFieldDX = new javax.swing.JTextField();
        jLabelIR = new javax.swing.JLabel();
        jTextFieldIR = new javax.swing.JTextField();
        jLabelPC = new javax.swing.JLabel();
        jTextFieldPC = new javax.swing.JTextField();
        jLabelSP = new javax.swing.JLabel();
        jTextFieldSP = new javax.swing.JTextField();
        jLabelZ = new javax.swing.JLabel();
        jTextFieldZ = new javax.swing.JTextField();
        jLabelMemory = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListMemory = new javax.swing.JList<>();
        jLabelMemory2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListMemory2 = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItemOpenFile = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        javax.swing.JMenuItem jMenuItemConfig = new javax.swing.JMenuItem();

        jFileChooserAsm.setFileFilter(new proyecto1.AsmFilter());
        jFileChooserAsm.setMultiSelectionEnabled(true);

        jFileChooserConfig.setFileFilter(new proyecto1.TxtFilter());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Start.setText("Start");
        Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartActionPerformed(evt);
            }
        });

        Step.setText("Step by Step");

        Clean.setText("Clean");
        Clean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CleanActionPerformed(evt);
            }
        });

        Statistics.setText("Statistics");
        Statistics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatisticsActionPerformed(evt);
            }
        });

        jLabelRegister.setText("Registers");

        jLabelAC.setText("AC");

        jTextFieldAC.setEditable(false);

        jLabelAX.setText("AX");

        jTextFieldAX.setEditable(false);

        jLabelBX.setText("BX");

        jTextFieldBX.setEditable(false);

        jLabelCX.setText("CX");

        jTextFieldCX.setEditable(false);

        jLabelDX.setText("DX");

        jTextFieldDX.setEditable(false);

        jLabelIR.setText("IR");

        jTextFieldIR.setEditable(false);

        jLabelPC.setText("PC");

        jTextFieldPC.setEditable(false);

        jLabelSP.setText("SP");

        jTextFieldSP.setEditable(false);

        jLabelZ.setText("Z");

        jTextFieldZ.setEditable(false);

        jLabelMemory.setText("Memory");

        jScrollPane1.setViewportView(jListMemory);

        jLabelMemory2.setText("Sec Memory");

        jScrollPane2.setViewportView(jListMemory2);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Start)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Step)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Clean)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Statistics))
                            .addComponent(jScrollPane3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelRegister)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelAC)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldAC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelAX)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldAX, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelBX)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldBX, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelCX)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldCX, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelDX)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldDX, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelPC)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldPC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelSP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldSP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelZ)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldZ, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelIR)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldIR, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelMemory)
                                .addGap(538, 538, 538)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelMemory2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelRegister)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelAC)
                            .addComponent(jTextFieldAC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelAX)
                            .addComponent(jTextFieldAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelBX)
                            .addComponent(jTextFieldBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCX)
                            .addComponent(jTextFieldCX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDX)
                            .addComponent(jTextFieldDX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPC)
                            .addComponent(jTextFieldPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSP)
                            .addComponent(jTextFieldSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelZ)
                            .addComponent(jTextFieldZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelIR)
                            .addComponent(jTextFieldIR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Start)
                            .addComponent(Step)
                            .addComponent(Clean)
                            .addComponent(Statistics))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMemory)
                    .addComponent(jLabelMemory2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemOpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOpenFileActionPerformed
       int returnVal = jFileChooserAsm.showOpenDialog(this);
      if (returnVal == JFileChooser.APPROVE_OPTION) {
        File[] files = jFileChooserAsm.getSelectedFiles();
        try {           
            // Load to secondary memory
            this.kernel.load(files);
            
            // Select file  Section 
            int response = JOptionPane.showConfirmDialog(this,"¿Desea continuar con el procesamiento de los archivos cargados?", 
            "Confirmación", JOptionPane.YES_NO_OPTION);  
            
            if (response == JOptionPane.YES_OPTION) {
                System.out.println("Cargando");
                
              for(int i = 1; i < this.kernel.sizeIndex(); i++) {
                  
                //System.out.println("\ni:"+ i+ "cap " + this.kernel.sizeIndex());
                List<Expression> firstFileContent = kernel.getSecondaryMemory().getFirstFileContent();
                if (firstFileContent != null) {
                  // Load to memory   
                  this.kernel.loadToMemory(firstFileContent);
                  
                  // Scheduler
                  Pair pair = this.kernel.scheduler();
              
                  // Dispatcher
                  PCB pcb = this.kernel.distpacher(pair);
                
                  // Inicio del proceso
                  //pcb.updateState("ready");  // Registramos la hora de inicio
                  // Execution
                  this.kernel.initExecution(pcb);
                  ActionListener aL = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        if (!pcb.reachedEnd()) {
                            kernel.nextExecution(pcb);
                        } else {
                            // Registrar el tiempo de finalización
                            pcb.updateState("terminated");
                            System.out.println("State Terminated");
                            
                     
                            
                            
                            kernel.liberaMemor(pcb.programCodeIndex(),pcb.getProgramCodeSize()); // Liberar memoria principal
                            kernel.liberaMemor(pcb.getStackSegmentIndex(),pcb.getSegmentStackSize()); // liberar stack
                      
                            kernel.removeSecundaryMemo();  // Eliminar archivo de la memoria secundaria
                           
                            
                            controller.stop();
                            
                            // Imprimir los tiempos de inicio, fin y duración
                            System.out.println("Tiempo de ejecución del proceso:");
                            System.out.println("Hora de inicio: " + pcb.getFormattedStartTime());
                            System.out.println("Hora de finalización: " + pcb.getFormattedEndTime());
                            System.out.println("Duración total: " + pcb.getElapsedMinutes() + " minutos y " + pcb.getElapsedSeconds() % 60 + " segundos");
                       
                        }
                        jTextFieldAC.setText(String.valueOf(kernel.ac()));
                        jTextFieldAX.setText(String.valueOf(kernel.ax()));
                        jTextFieldBX.setText(String.valueOf(kernel.bx()));
                        jTextFieldCX.setText(String.valueOf(kernel.cx()));
                        jTextFieldDX.setText(String.valueOf(kernel.dx()));
                        jTextFieldPC.setText(String.valueOf(kernel.pc()));
                        jTextFieldSP.setText(String.valueOf(kernel.sp()));
                        jTextFieldZ.setText(String.valueOf(kernel.z()));
                        jTextFieldIR.setText(kernel.ir().operation);
                            
                        DefaultListModel<String> listModel = new DefaultListModel<>();
                        listModel.addAll(kernel.getMemoryArray());
                        jListMemory.setModel( listModel );   
                        
                        List<String> secMemoryArray = kernel.getSecMemoryArray();
                        //System.out.println("Contenido de la memoria secundaria (como String): " + secMemoryArray);
                        
                        DefaultListModel<String> listModel2 = new DefaultListModel<>();                     
                        listModel2.addAll(kernel.getSecMemoryArray());         
     

                        // Establecer el modelo en el JList para que cada expresión se muestre una por una
                        jListMemory2.setModel(listModel2);
                    }                     
                  };               
                  this.controller = new Timer(1110, aL);//create the timer which calls the actionperformed method for every 1000 millisecond(1 second=1000 millisecond)
                  this.controller.setRepeats(true);
                  this.controller.start();
                }
              }    

            } else {
                JOptionPane.showMessageDialog(this, "Puede cargar más archivos antes de proceder.", 
                "Cargar más archivos",JOptionPane.INFORMATION_MESSAGE);
            }
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
            System.out.println(config.toString());
            
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

    private void StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StartActionPerformed

    private void CleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CleanActionPerformed
        this.kernel = new Kernel(this.config);
        jTextFieldAC.setText("");
        jTextFieldAX.setText("");
        jTextFieldBX.setText("");
        jTextFieldCX.setText("");
        jTextFieldDX.setText("");
        jTextFieldPC.setText("");
        jTextFieldSP.setText("");
        jTextFieldZ.setText("");
        jTextFieldIR.setText("");
        this.controller.stop();
        
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addAll(kernel.getMemoryArray());
                            
        DefaultListModel<String> listModel2 = new DefaultListModel<>();
        listModel.addAll(kernel.getSecMemoryArray());
                            
        jListMemory.setModel( listModel );
        jListMemory2.setModel( listModel2 );
    }//GEN-LAST:event_CleanActionPerformed

    private void StatisticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StatisticsActionPerformed
        // Obtener la lista de todos los PCBs
       List<PCB> pcbList = kernel.getPCBList();  // Asegúrate de tener este método en tu clase Kernel

       if (!pcbList.isEmpty()) {
           StringBuilder message = new StringBuilder();

           // Iterar sobre la lista de PCBs y obtener las estadísticas de cada uno
           for (PCB pcb : pcbList) {
               String startTime = pcb.getFormattedStartTime();
               String endTime = pcb.getFormattedEndTime();
               long minutes = pcb.getElapsedMinutes();
               long seconds = pcb.getElapsedSeconds() % 60;

               // Construir el mensaje para cada proceso
               message.append(String.format("Proceso ID: %d\nHora de inicio: %s\nHora de finalización: %s\nDuración: %d minutos y %d segundos\n\n",
                                             pcb.id(), startTime, endTime, minutes, seconds));
           }

           // Mostrar las estadísticas en un cuadro de diálogo
           JOptionPane.showMessageDialog(null, message.toString(), "Estadísticas de los procesos", JOptionPane.INFORMATION_MESSAGE);
       } else {
           JOptionPane.showMessageDialog(null, "No hay procesos ejecutados", "Estadísticas", JOptionPane.WARNING_MESSAGE);
       }
    }//GEN-LAST:event_StatisticsActionPerformed

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
    private Timer controller;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Clean;
    public javax.swing.JButton Start;
    public javax.swing.JButton Statistics;
    public javax.swing.JButton Step;
    private javax.swing.JFileChooser jFileChooserAsm;
    private javax.swing.JFileChooser jFileChooserConfig;
    private javax.swing.JLabel jLabelAC;
    private javax.swing.JLabel jLabelAX;
    private javax.swing.JLabel jLabelBX;
    private javax.swing.JLabel jLabelCX;
    private javax.swing.JLabel jLabelDX;
    private javax.swing.JLabel jLabelIR;
    private javax.swing.JLabel jLabelMemory;
    private javax.swing.JLabel jLabelMemory2;
    private javax.swing.JLabel jLabelPC;
    private javax.swing.JLabel jLabelRegister;
    private javax.swing.JLabel jLabelSP;
    private javax.swing.JLabel jLabelZ;
    private javax.swing.JList<String> jListMemory;
    private javax.swing.JList<String> jListMemory2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItemOpenFile;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldAC;
    private javax.swing.JTextField jTextFieldAX;
    private javax.swing.JTextField jTextFieldBX;
    private javax.swing.JTextField jTextFieldCX;
    private javax.swing.JTextField jTextFieldDX;
    private javax.swing.JTextField jTextFieldIR;
    private javax.swing.JTextField jTextFieldPC;
    private javax.swing.JTextField jTextFieldSP;
    private javax.swing.JTextField jTextFieldZ;
    // End of variables declaration//GEN-END:variables
}
