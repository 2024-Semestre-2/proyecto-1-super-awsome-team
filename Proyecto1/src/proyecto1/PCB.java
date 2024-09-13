/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

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
    
    public void updateState(String state) {
        this.state = state;
    }
    
    @Override
    public String toString(){
        return " Proccess ID: "+this.ID+" Priority: "+this.priority+" State: "+this.state+" AC: "+this.AC+" AX: "+this.AX+" BX: "+this.BX+" CX: "+this.CX+" DX: "+this.DX+" IR: "+this.IR.operation;
    }
}
