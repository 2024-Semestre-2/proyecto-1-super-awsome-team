/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 *
 * @author someone
 */
public class SecondaryMemory {
    private Object[] memoryArray;
    private int nextAddress;
    private int memorySize;
    private int virtualSize;
    
    public SecondaryMemory(int size, int virtualSize) {
        this.memorySize = size;
        this.virtualSize = virtualSize;
        this.nextAddress = virtualSize;
        
        this.memoryArray = new Object[this.memorySize];
    }
    
    public void store(Object data) {
        this.memoryArray[this.nextAddress] = data;
        this.nextAddress++;
    }
    
    public int memoryBeginning() {
        return this.virtualSize;
    }
}
