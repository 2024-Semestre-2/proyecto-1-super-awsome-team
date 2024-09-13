/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

import java.io.File;

/**
 *
 * @author someone
 */
public class TxtFilter extends javax.swing.filechooser.FileFilter {
    @Override
    public boolean accept(File file) {
        // Allow only files with ".asm" extension
        return file.isDirectory() || file.getAbsolutePath().endsWith(".txt");
    }
    
    @Override
    public String getDescription() {
        // This description will be displayed in the dialog,
        return "Text documents (*.txt)";
    }
}
