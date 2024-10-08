/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

import java.time.Duration;
import java.time.Instant;
import java.util.Objects;

/**
 *
 * @author someone
 */
public class PCB {
    private int ID;
    int memoryAddress;
    
    private int programCodeIndex;
    private int programCodeSize;
    
    private int dataSegmentIndex;
    private int dataSegmentSize;
    
    // The stack is a region of memory that stores temporary variables created by each function (or method) call.
    // last-in, first-out: the last piece of data added is the first one to be removed.
    // Not shared
    private int stackSegmentIndex;
    private int stackSegmentSize;
    
    // Times
    private Instant startTime;    // Tiempo de inicio
    private Duration elapsedTime; // Tiempo empleado en ejecución
    
    // Process State
    private String state;  // new, ready, running, waiting or terminated
    
    private int AX;
    private int BX;
    private int CX;
    private int DX;
    private int AC;
    private int PC;
    private int SP;
    private boolean Z;
    private Instruction IR;
    
    private int nextPCB;
    
    private int priority;
    
    public PCB(int id, int programCodeIndex, int programCodeSize) {
        this.ID = id;
        this.state = "new";
        
        this.programCodeIndex = programCodeIndex;
        this.programCodeSize = programCodeSize;
        this.elapsedTime = Duration.ZERO; // Inicializa el tiempo empleado en 0
        this.nextPCB = 0;
        
        this.AX = 0;
        this.BX = 0;
        this.CX = 0;
        this.DX = 0;
        this.AC = 0;
        this.PC = 0;
        this.SP = 0;
        this.Z = false;
        this.IR = null;
    }
    
    public void updateRegisters(int ax, int bx, int cx, int dx, int ac, int pc, int sp, boolean z, Instruction ir) {
        this.AX = ax;
        this.BX = bx;
        this.CX = cx;
        this.DX = dx;
        this.AC = ac;
        this.PC = pc;
        this.SP = sp;
        this.Z = z;
        this.IR = ir;
    }
    
    public void setStack(int stackSegmentIndex, int stackSegmentSize) {
        this.stackSegmentIndex = stackSegmentIndex;
        this.stackSegmentSize = stackSegmentSize;
        this.SP = stackSegmentIndex + stackSegmentSize;
    }
    
    public void setNext(int next) {
        this.nextPCB = next;
    }
    
    public void setMemoryAddress(int memoryAddress) {
        this.memoryAddress = memoryAddress;
    }
    
    public boolean reachedEnd() {
        return this.PC == this.programCodeIndex + this.programCodeSize;
    }

    // Actualiza el estado y registra el tiempo de inicio si el proceso empieza a ejecutarse
    public void updateState(String state) {
      if (Objects.equals(this.state, "ready") && Objects.equals(state, "running")) {
        this.startTime = Instant.now(); // Registra el tiempo de inicio
        this.PC = this.programCodeSize;
      } 
      else if (Objects.equals(this.state, "running") && !Objects.equals(state, "running")) {
        // Si el proceso deja de estar en ejecución, calcula el tiempo transcurrido
        if (this.startTime != null) {
          Duration timeSpent = Duration.between(this.startTime, Instant.now());
          this.elapsedTime = this.elapsedTime.plus(timeSpent); // Acumula el tiempo empleado
        }
      }
      this.state = state;
    }
    
    // Retorna el tiempo empleado en ejecución en milisegundos
    public long getElapsedTimeMillis() {
      return this.elapsedTime.toMillis();
    }
    
    public int getBaseStack() {
        return this.stackSegmentIndex;
    }
    
    public int id() {
        return this.ID;
    }
    
    public String state() {
        return this.state;
    }
    
    public int programCodeIndex() {
        return this.programCodeIndex;
    }
    
    public int ax() {
        return this.AX;
    }
    
    public int bx() {
        return this.BX;
    }
    
    public int cx() {
        return this.CX;
    }
    
    public int dx() {
        return this.DX;
    }
    
    public int ac() {
        return this.AC;
    }
    
    public boolean z() {
        return this.Z;
    }
    
    public Instruction ir() {
        return this.IR;
    }
    
    public int pc() {
        return this.PC;
    }
    
    public int sp() {
        return this.SP;
    }
    
    @Override
    public String toString(){
        return " Proccess ID: "+this.ID+" Priority: "+this.priority+" State: "+this.state+" AC: "+this.AC+" AX: "+this.AX+" BX: "+this.BX+" CX: "+this.CX+" DX: "+this.DX+" Z: "+this.Z+" PC: "+ this.PC +" IR: "+this.IR.operation + " Elapsed Time: " + getElapsedTimeMillis() + " ms";
    }
}
