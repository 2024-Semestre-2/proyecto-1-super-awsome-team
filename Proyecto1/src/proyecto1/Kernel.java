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
    
    public Pair scheduler() {
        List<Pair> table = this.memory.getPcbTable();
        Pair result = null;
        
        for (int i = 0; i < table.size(); i++) {
            Pair address = table.get(i);
            
            PCB pcb = this.memory.getProcess(address.memoryAddress);
            System.out.println(pcb.id() + " " + pcb.state());
            
            if (pcb.state() == "new") {
                result = address;
            }
            else if (pcb.state() == "terminated") {
                // Remove from table and add it to zombie list
                this.memory.removeFromTable(address);
            }
        }
        
        return result;
    }
    
    public PCB distpacher(Pair pair) {
        PCB pcb = this.memory.getProcess(pair.memoryAddress);
        pcb.updateState("running");
        
        return pcb;
    }
    
    public void load(File[] files) {                                
        for (File file : files) { //(int i = 0; i < files.length; i++)
                       
            AsmLoader loader = new AsmLoader();
            List<Expression> list = loader.loadFile(file.getAbsolutePath());
            
            // Store file data in secondary memory and update index.
            this.sMemory.store(file.getName(), list);
            // nota: guardemos primero en disco y luego creamos una funcion que selecciona que archivo o archivos son los que se van a leer y luego eso lo guardamos a memoria

        }
        this.sMemory.printFileIndex();
    }
    
    public void loadToMemory(File file) {
        AsmLoader loader = new AsmLoader();
        List<Expression> list = loader.loadFile(file.getAbsolutePath());
        
        // ================= New Process creation =================
        // Memory allocation
        int codeAddress = this.memory.malloc(list.size());
        int stackAddress = this.memory.malloc(5);
                  
        // Load Memory
        this.memory.loadInstructionsAt(codeAddress, list.size(), list);
            
        // Process creation
        PCB newPCB = new PCB(this.processCounter, codeAddress, list.size());
        newPCB.setStack(stackAddress, 5);
        
        // Store on memory
        this.memory.loadProcess(newPCB);
            
        this.processCounter++;
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
    
    public void execute(PCB pcb) {
        // Load registers from pcb
        this.cpu.updateRegisters(pcb.ax(), pcb.bx(), pcb.cx(), pcb.dx(), pcb.ac(), pcb.pc(), pcb.sp(), pcb.z(), pcb.ir());
        
        while (!pcb.reachedEnd()) {
            // Fetch
            Instruction ins = this.cpu.fetchInstruction(memory);
            System.out.println(ins.toString());
            // Decode, Execute
            this.cpu.execute(ins, pcb.getBaseStack(), memory);
            // Update PCB
            pcb.updateRegisters(this.ax(), this.bx(), this.cx(), this.dx(), this.ac(), this.pc(), this. sp(), this.z(),this.ir());
            System.out.println(pcb.toString());
        }
        
        pcb.updateState("terminated");
        System.out.println(pcb.toString());
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
    
    public boolean z() {
        return this.cpu.z();
    }
    
    public Instruction ir() {
        return this.cpu.ir();
    }
    
    public int pc() {
        return this.cpu.pc();
    }
    public int sp() {
        return this.cpu.sp();
    }
    
    public void newProcess() {
        //this.memory.loadProcess(new PCB(this.processCounter, this.ax(), this.bx(), this.cx(), this.dx(), this.ac(), this.pc(), this.cpu.ir(), 1));
        this.processCounter++;
    }
    
    public int proccesOn() {
      return this.processCounter; 
    }
    
    public void updateProcess() {
        this.memory.updateProcess("ready");
    }
}
