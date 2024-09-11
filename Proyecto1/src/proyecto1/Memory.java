/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *
 * @author someone
 */
public class Memory {
    private Object[] memoryArray; // Using Object to hold both instructions and data
    private int nextInstructionAddress; // User segment for instructions
    private int nextDataAddress; // Segment for data
    private int instructionAddresSize = 50;
    private int dataAddressSize = 100;
    private int memorySize;
    
    public Memory(int size, int user, int os) {
        this.memorySize = size;
        this.instructionAddresSize = user;
        this.dataAddressSize = user + os;
        
        this.nextInstructionAddress = 0;
        this.nextDataAddress = instructionAddresSize;
        this.memoryArray = new Object[this.memorySize];
    }
    
    public void loadInstruction(String opcode, String operation, String[] operands) {
        if (this.nextInstructionAddress > instructionAddresSize) {
            throw new IllegalArgumentException("Attempt to access OS segment or out-of-bounds memory address, not enough space in user memory");
        }
        memoryArray[this.nextInstructionAddress] = new Instruction(opcode, operation, operands, this.nextInstructionAddress);
        this.nextInstructionAddress++;
    }
    
    public Instruction getInstruction(int address) {
        if (address > instructionAddresSize) { 
            throw new IllegalArgumentException("Attempt to access OS segment or out-of-bounds memory address");
        } else {
            return (Instruction) this.memoryArray[address];
        }
    }
    
    public void loadProcess(PCB process) {
        if (this.nextDataAddress > dataAddressSize) {
            throw new IllegalArgumentException("Out-of-bounds memory address, not enough space in OS memory");
        }
        process.setMemoryAddress(this.nextDataAddress);
        memoryArray[this.nextDataAddress] = process;
        this.nextDataAddress++;
    }
    
    public void updateProcess(String state) {
        if (memoryArray[this.nextDataAddress-1] != null) {
            ((PCB) memoryArray[this.nextDataAddress-1]).updateState(state);
        }
    }
    
    public List<String> getMemoryArray() {
        return Arrays.asList(this.memoryArray).stream().map(object -> Objects.toString(object, null)).collect(Collectors.toList());
    }
    
    public int instructionAddresSize() {
        return this.instructionAddresSize;
    }
}
