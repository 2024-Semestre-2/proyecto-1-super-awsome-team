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
    
    public SecondaryMemory(int size) {
        this.memorySize = size;
        this.memoryArray = new Object[this.memorySize];
    }
    
    public void store(Object data) {
        this.memoryArray[this.nextAddress] = data;
    }
}
