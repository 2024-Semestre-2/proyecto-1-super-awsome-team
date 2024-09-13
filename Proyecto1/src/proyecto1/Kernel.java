/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *
 * @author someone
 */
public class Kernel {
    private MainMemory memory;
    private SecondaryMemory sMemory;
    private CPU cpu;
    private int processCounter;
    
    public Kernel(Config config) {
        this.cpu = new CPU();
        this.memory = new MainMemory(config.mainMemorySize, config.userSegmentSize, config.osSegmentSize);
        this.sMemory = new SecondaryMemory(config.secondaryMemorySize, config.virtualMemorySize);
        this.processCounter = 0;
    }
    
    public void load(File[] files) {
        System.out.println(this.memory.malloc(5));
        for (int i = 0; i < files.length; i++) {
            //this.sMemory.store(files[i]);
            AsmLoader loader = new AsmLoader();
            List<Expression> list = loader.loadFile(files[i].getAbsolutePath());
            
            // Memory allocation
            int codeAddress = this.memory.malloc(list.size());
            int stackAddress = this.memory.malloc(5);
            
            this.memory.loadInstructionsAt(codeAddress, list.size(), list);
            
            // Process creation
            new PCB(this.processCounter, codeAddress, list.size());
        }
    }
    
    public void loadMemory(List<Expression> instructions) {
        for (int i = 0; i < instructions.size(); i++) {
            this.memory.loadInstruction(null, instructions.get(i).operation, instructions.get(i).operands);
        }
    }
    
    public List<String> getMemoryArray() {
        return this.memory.getMemoryArray();
    }
    
    public Instruction peekInstruction() {
        return this.cpu.peekInstruction(memory);
    }
    
    public void execute() {
        this.cpu.execute(this.cpu.fetchInstruction(memory));
        this.newProcess();
    }
    
    public int ax() {
        return this.cpu.ax();
    }
    
    public int bx() {
        return this.cpu.bx();
    }
    
    public int cx() {
        return this.cpu.cx();
    }
    
    public int dx() {
        return this.cpu.dx();
    }
    
    public int ac() {
        return this.cpu.ac();
    }
    
    public String ir() {
        return this.cpu.ir().operation;
    }
    
    public int pc() {
        return this.cpu.pc();
    }
    
    public void newProcess() {
        //this.memory.loadProcess(new PCB(this.processCounter, this.ax(), this.bx(), this.cx(), this.dx(), this.ac(), this.pc(), this.cpu.ir(), 1));
        this.processCounter++;
    }
    
    public void updateProcess() {
        this.memory.updateProcess("ready");
    }
}
