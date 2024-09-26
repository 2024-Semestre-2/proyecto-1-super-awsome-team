/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
        this.nextAddress = virtualSize; 
        
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
   * 
   * @param filenames, lista de nombres a buscar 
   * @return Lista de archivos disponibles para ser cargados a memoria principal 
   */    
  public List<String> selectFiles(List<String> filenames) {
    List<String> selectedFiles = new ArrayList<>();  
    // Recorremos los nombres proporcionados
    for (String filename : filenames) {
        if (fileIndex.containsKey(filename)) {
            selectedFiles.add(filename);
        } else {
            System.out.println("El archivo " + filename + " no existe en memoria secundaria.");
        }
    }
    // Retorna la lista de archivos seleccionados que sí existen en la memoria secundaria
    return selectedFiles;
  }


  public void removeFile(String filename) {
    // Verificar si el archivo existe en el índice
    if (fileIndex.containsKey(filename)) {
        // Obtener la dirección de memoria del archivo
        int address = fileIndex.get(filename);
        
        // Eliminar el archivo del índice
        fileIndex.remove(filename);
        
        // Liberar el espacio de memoria donde estaba el archivo
        memoryArray[address] = null;
        
        // Ajustar las direcciones de los archivos que están después del archivo eliminado
        // para evitar fragmentación.
        for (int i = address + 1; i < nextAddress; i++) {
            memoryArray[i - 1] = memoryArray[i]; // Mover archivo a la dirección anterior
            memoryArray[i] = null; // Limpiar la dirección actual
        }
        
        // Actualizar la siguiente dirección disponible
        nextAddress--;
        
        System.out.println("Archivo " + filename + " eliminado exitosamente.");
    } else {
        System.out.println("El archivo " + filename + " no existe.");
    }
  }
  
  public void loadSelectedFilesToMemory(MainMemory mainMemory, List<String> selectedFiles) {
    for (String filename : selectedFiles) {
        // Recuperar el archivo desde la memoria secundaria
        Object fileContent = retrieve(filename);
        
        if (fileContent instanceof List<?>) {
            // Convertimos el contenido del archivo a una lista de expresiones (instrucciones ASM)
            List<Expression> instructions = (List<Expression>) fileContent;

            // Asignación de memoria en memoria principal
            int codeAddress = mainMemory.malloc(instructions.size());
            int stackAddress = mainMemory.malloc(5);
            
            // Cargar instrucciones a la memoria principal
            mainMemory.loadInstructionsAt(codeAddress, instructions.size(), instructions);
            
            // Obtener el siguiente ID de proceso de la memoria principal
            int processId = mainMemory.getNextProcessId();

            // Crear PCB para el proceso
            PCB newPCB = new PCB(processId, codeAddress, instructions.size());
            newPCB.setStack(stackAddress, 5);
            
            // Cargar proceso en la memoria principal
            mainMemory.loadProcess(newPCB);

            System.out.println("El archivo " + filename + " ha sido cargado exitosamente a la memoria principal.");
        } else {
            System.out.println("Error al recuperar el archivo " + filename + ". No es un archivo ASM válido.");
        }
    }
  }
  public Map<String, Integer> getFileIndex() {
    return this.fileIndex; // Devuelve el índice de archivos almacenados
  }
  public Object[] getMemoryArray() {
    return this.memoryArray; // Devuelve todo el array de la memoria secundaria
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
