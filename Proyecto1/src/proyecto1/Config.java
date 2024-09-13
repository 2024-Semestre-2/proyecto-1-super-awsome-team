/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author someone
 */
public class Config {
    public int mainMemorySize;
    public int secondaryMemorySize;
    public int virtualMemorySize;
    public int userSegmentSize;
    public int osSegmentSize;
    
    public Config(int mainSize, int secondarySize, int virtualSize) {
        this.mainMemorySize = mainSize;
        this.secondaryMemorySize = secondarySize;
        this.virtualMemorySize = virtualSize;
        this.userSegmentSize = 100;
        this.osSegmentSize = 100;
    }
    
    public Config(String filePath) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); // Leer la primera línea
            if (line != null) {
                // Separar los valores de memoria
                String[] memorySizes = line.split(" ");
                if (memorySizes.length == 3) {
                    int mainMemorySize = Integer.parseInt(memorySizes[0]);  // Tamaño de la memoria principal
                    int secondaryMemorySize = Integer.parseInt(memorySizes[1]);  // Tamaño de la memoria principal
                    int virtualMemorySize = Integer.parseInt(memorySizes[2]);  // Tamaño de la memoria virtual
                    
                    this.mainMemorySize = mainMemorySize;
                    this.secondaryMemorySize = secondaryMemorySize;
                    this.virtualMemorySize = virtualMemorySize;
                    this.userSegmentSize = 100;
                    this.osSegmentSize = 100;
                } 
                else {
                    throw new IllegalArgumentException("Formato inválido. Se requieren dos números en la primera línea.");
                }
            }
        }
        catch (IOException | NumberFormatException e) {
            throw new Exception("Error al leer el archivo de configuración: " + e.getMessage());
        }
    }
    
    @Override
    public String toString(){
        return "Main Memory: " + this.mainMemorySize + "kb \nSecondary Memory: " + this.secondaryMemorySize + "kb \nVirtual Memory: " + this.virtualMemorySize + "kb \nUser Segment: " + this.userSegmentSize + "kb \nOS Segment: " + this.osSegmentSize + "kb";
    }
}
