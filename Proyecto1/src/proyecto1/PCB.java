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
    private Instruction IR;
    
    private int priority;
    
    public PCB(int id, int programCodeIndex, int programCodeSize) {
        this.ID = id;
        this.state = "new";
        
        this.programCodeIndex = programCodeIndex;
        this.programCodeSize = programCodeSize;
        this.elapsedTime = Duration.ZERO; // Inicializa el tiempo empleado en 0
    }
    
    public PCB(/*int memoryAddress, */int id, int ax, int bx, int cx, int dx, int ac, int pc, Instruction ir, int priority) {
        //this.memoryAddress = memoryAddress;
        this.ID = id;
        this.state = "new";
        this.AX = ax;
        this.BX = bx;
        this.CX = cx;
        this.DX = dx;
        this.AC = ac;
        this.IR = ir;
        this.priority = priority;
    }
    
    public void setStack(int stackSegmentIndex, int stackSegmentSize) {
        this.stackSegmentIndex = stackSegmentIndex;
        this.stackSegmentSize = stackSegmentSize;
    }
    

    // Actualiza el estado y registra el tiempo de inicio si el proceso empieza a ejecutarse
    public void updateState(String state) {
      if (Objects.equals(this.state, "ready") && Objects.equals(state, "running")) {
        this.startTime = Instant.now(); // Registra el tiempo de inicio
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
    
    @Override
    public String toString(){
        return " Proccess ID: "+this.ID+" Priority: "+this.priority+" State: "+this.state+" AC: "+this.AC+" AX: "+this.AX+" BX: "+this.BX+" CX: "+this.CX+" DX: "+this.DX+" IR: "+this.IR.operation + " Elapsed Time: " + getElapsedTimeMillis() + " ms";
    }
}
