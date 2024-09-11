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
    int memoryAddress;
    
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
    
    public PCB(/*int memoryAddress, */int id, String state, int ax, int bx, int cx, int dx, int ac, int pc, Instruction ir, int priority) {
        //this.memoryAddress = memoryAddress;
        this.ID = id;
        this.state = state;
        this.AX = ax;
        this.BX = bx;
        this.CX = cx;
        this.DX = dx;
        this.AC = ac;
        this.IR = ir;
        this.priority = priority;
    }
    
    public void setMemoryAddress(int memoryAddress) {
        this.memoryAddress = memoryAddress;
    }
    
    public void updateState(String state) {
        this.state = state;
    }
    
    @Override
    public String toString(){
        return "Address: "+this.memoryAddress+" Proccess ID: "+this.ID+" Priority: "+this.priority+" State: "+this.state+" AC: "+this.AC+" AX: "+this.AX+" BX: "+this.BX+" CX: "+this.CX+" DX: "+this.DX+" IR: "+this.IR.operation;
    }
}
