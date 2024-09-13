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
public class MainMemory {
    private Object[] memoryArray; // Using Object to hold both instructions and data
    private int nextUserSegmentAddress; // User segment for instructions
    private int nextOsSegmentAddress; // Segment for data
    private int userSegmentSize;
    private int osSegmentSize;
    private int memorySize;
    
    public MainMemory(int size, int user, int os) {
        this.memorySize = size;
        this.userSegmentSize = user;
        this.osSegmentSize = os;
        
        this.nextUserSegmentAddress = 0;
        this.nextOsSegmentAddress = userSegmentSize;
        this.memoryArray = new Object[this.memorySize];
    }
    
    public int malloc(int size) {
        if (this.nextUserSegmentAddress + size > userSegmentSize) {
            throw new IllegalArgumentException("Attempt to access OS segment or out-of-bounds memory address, not enough space in user memory");
        }
        int address = nextUserSegmentAddress;
        this.nextUserSegmentAddress += size;
        
        return address;
    }
    
    public void loadInstructionsAt(int address, int size, List<Expression> instructions) {
        if (size < instructions.size()) {
            throw new IllegalArgumentException("Attempt to access out-of-bounds memory address");
        }
        if (address + size > userSegmentSize) {
            throw new IllegalArgumentException("Attempt to access OS segment or out-of-bounds memory address, not enough space in user memory");
        }
        
        for (int i = 0; i < instructions.size(); i++) {
            Instruction instruction = new Instruction(null, instructions.get(i).operation, instructions.get(i).operands);
            instruction.setAddress(address+i);
            memoryArray[address+i] = instruction;
        }
    }
    
    public void loadInstruction(String opcode, String operation, String[] operands) {
        if (this.nextUserSegmentAddress > userSegmentSize) {
            throw new IllegalArgumentException("Attempt to access OS segment or out-of-bounds memory address, not enough space in user memory");
        }
        memoryArray[this.nextUserSegmentAddress] = new Instruction(opcode, operation, operands, this.nextUserSegmentAddress);
        this.nextUserSegmentAddress++;
    }
    
    public Instruction getInstruction(int address) {
        if (address > userSegmentSize) { 
            throw new IllegalArgumentException("Attempt to access OS segment or out-of-bounds memory address");
        } else {
            return (Instruction) this.memoryArray[address];
        }
    }
    
    /*public void loadProcess(PCB process) {
        if (this.nextOsSegmentAddress > osSegmentSize) {
            throw new IllegalArgumentException("Out-of-bounds memory address, not enough space in OS memory");
        }
        process.setMemoryAddress(this.nextOsSegmentAddress);
        memoryArray[this.nextOsSegmentAddress] = process;
        this.nextOsSegmentAddress++;
    }*/
    
    public void updateProcess(String state) {
        if (memoryArray[this.nextOsSegmentAddress-1] != null) {
            ((PCB) memoryArray[this.nextOsSegmentAddress-1]).updateState(state);
        }
    }
    
    public List<String> getMemoryArray() {
        return Arrays.asList(this.memoryArray).stream().map(object -> Objects.toString(object, null)).collect(Collectors.toList());
    }
    
    public int instructionAddresSize() {
        return this.userSegmentSize;
    }
}
