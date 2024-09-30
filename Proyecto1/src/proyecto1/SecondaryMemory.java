/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

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
   * Almacena un archivo en memoria secundaria
   * @param filename Nombre del archivo
   * @param data Contenido del archivo
   */ 
  public void store(String filename, Object data) {
    if (fileIndex.size() >= maxFiles) {
        throw new IllegalStateException("Límite máximo de archivos alcanzado. No se pueden almacenar más de " + maxFiles + " archivos.");
    }

    int startingAddress = nextAddress; // Guardar la dirección inicial

    // Verificar si el archivo es una lista de instrucciones
    if (data instanceof List<?>) {
        List<?> fileContent = (List<?>) data;
        // Verificar que haya suficiente espacio disponible
        if (nextAddress + fileContent.size() - 1 >= memorySize) {
            throw new ArrayIndexOutOfBoundsException("No hay suficiente espacio en memoria secundaria.");
        }
        // Almacenar cada instrucción en las direcciones consecutivas, como en la memoria principal
        for (Object obj : fileContent) {
            this.memoryArray[this.nextAddress++] = obj;
        }
    } else {
        // Almacenar un solo objeto si no es una lista
        if (nextAddress >= memorySize) {
            throw new ArrayIndexOutOfBoundsException("Memoria llena, no se puede almacenar el archivo.");
        }
        this.memoryArray[this.nextAddress++] = data;
    }

    // Actualizar el índice de archivos con la dirección inicial, no con la final
    this.fileIndex.put(filename, startingAddress);
}

    
    
  /**
   * Imprime el contenido de la memoria secundaria
   * @param memoryArray Arreglo de memoria secundaria
   */
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

  /**
    * Elimina un archivo de la memoria secundaria
    * @param filename Nombre del archivo a eliminar
    */ 
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
  
  /**
    * Carga los archivos seleccionados a la memoria principal
    * @param mainMemory Memoria principal
    * @param selectedFiles Lista de archivos seleccionados
    */
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

  /**
   * Carga los archivos seleccionados a la memoria principal
   * @return Lista de archivos cargados a la memoria principal
   */
  public Map<String, Integer> getFileIndex() {
    return this.fileIndex; // Devuelve el índice de archivos almacenados
  }
  
  /**
    * Obtiene el contenido de la memoria secundaria
    * @return Contenido de la memoria secundaria
    */
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
  
  public List<Expression> getFileInstructions(String filename) {
    int address = fileIndex.get(filename); // Obtener la dirección inicial del archivo
    List<Expression> instructions = new ArrayList<>();

    // Recorremos la memoria desde la dirección inicial hasta que no haya más instrucciones
    while (memoryArray[address] != null && memoryArray[address] instanceof Expression) {
        instructions.add((Expression) memoryArray[address]);
        address++;
    }

    return instructions; // Retorna la lista de instrucciones
  }
  // Método público para obtener los nombres de los archivos en la memoria secundaria
    public List<String> getFileNames() {
        return new ArrayList<>(fileIndex.keySet()); // Retorna los nombres de los archivos almacenados en memoria secundaria
    }
  /**
   * Obtiene una lista de instrucciones de los archivos almacenados en memoria secundaria
   * @return Lista de instrucciones de los archivos almacenados
   */
  public List<String> getMemoryArrayDisplay() {
    List<String> displayList = new ArrayList<>();
    for (Map.Entry<String, Integer> entry : fileIndex.entrySet()) {
        String filename = entry.getKey();
        List<Expression> instructions = (List<Expression>) memoryArray[entry.getValue()]; // Recuperar las instrucciones
        
        displayList.add("File: " + filename); // Mostrar el nombre del archivo
        
        // Recorrer las instrucciones y agregarlas a la lista de visualización
        for (Expression instruction : instructions) {
            displayList.add("  Line: " + instruction.row + " | " + instruction.operation + " " + Arrays.toString(instruction.operands));
        }
    }
    return displayList;
  }

}
