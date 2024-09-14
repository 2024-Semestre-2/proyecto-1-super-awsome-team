/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author someone
 */

/**
 * Represents a secondary memory with a fixed size and virtual memory beginning,
 * including an index for files.
 */
public class SecondaryMemory {
    private Object[] memoryArray;
    private int nextAddress;
    private int memorySize;
    private int virtualSize;
    private Map<String, Integer> fileIndex; // Indice para nombres y direccion
    private final int maxFiles = 5; // Máximo de 5 archivos permitidos
    
    /**
    * Constructs a SecondaryMemory with the given size and virtual memory size.
    * 
    * @param size The size of the secondary memory.
    * @param virtualSize The starting address of the virtual memory.
    */
    public SecondaryMemory(int size, int virtualSize) {
        this.memorySize = size;
        this.virtualSize = virtualSize;
        this.nextAddress = 1; //virtualSize  Nota: Dudas sobre direccionamiento en base a la totalidad de la secundaria
        
        this.memoryArray = new Object[this.memorySize];
        this.fileIndex = new LinkedHashMap<>();

    }
 
    /**
     * Stores data in the memory at the next available address and updates the index.
     * 
     * @param filename The name of the file to be stored.
     * @param data The data to store.
     * @throws ArrayIndexOutOfBoundsException if trying to store data beyond memory size.
     */
    public void store(String filename, Object data) {
        if (fileIndex.size() >= maxFiles) {
            throw new IllegalStateException("Maximum file limit reached. Cannot store more than " + maxFiles + " files.");
        }
        if (fileIndex.containsKey(filename)) {
            System.out.println("File " + filename + " already exists. Overwriting...");
        }
        if (nextAddress >= memorySize) {
            throw new ArrayIndexOutOfBoundsException("Memory full, cannot store data.");
        }

        this.memoryArray[this.nextAddress-1] = data;
        this.fileIndex.put(filename, this.nextAddress);
        this.nextAddress++;
    }

    public void printMemoryContents() {
        System.out.println("Memory Contents:");
        for (int i = virtualSize; i < memorySize; i++) {
            System.out.println("Address " + i + ": " + this.memoryArray[i]);
        }
    }
    public void printFileIndex() {
        System.out.println("\n--ASM Files Index--");
        for (Map.Entry<String, Integer> entry : this.fileIndex.entrySet()) {
            System.out.println("File: " + entry.getKey() + ", Address: " + entry.getValue());
        }
    }
    public Object retrieve(String filename) {
      if (fileIndex.containsKey(filename)) {
        int address = fileIndex.get(filename);
        return memoryArray[address];
      } else {
        System.out.println("File " + filename + " not found.");
        return null;
    }
}

    /**
     * Gets the starting address of the virtual memory.
     * 
     * @return The starting address of the virtual memory.
     */
    public int memoryBeginning() {
        return this.virtualSize;
    }
}
