/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

import static proyecto1.AsmLoader.isNumeric;

/**
 *
 * @author someone
 */
public class CPU {
    private int AX;
    private int BX;
    private int CX;
    private int DX;
    private int AC;
    private int PC;
    private Instruction IR;
    
    public CPU() {
        this.AX = 0;
        this.BX = 0;
        this.CX = 0;
        this.DX = 0;
        this.AC = 0;
        this.PC = 0;
        this.IR = null;
    }
    
    public Instruction fetchInstruction(MainMemory memory) {
        try {
            this.PC++;
            this.IR = memory.getInstruction(this.PC-1);
            return this.IR;
        } catch (IllegalArgumentException e) {
            this.PC--;
            throw e;
        }
    }
    
    public Instruction peekInstruction(MainMemory memory) {
        try {
            return memory.getInstruction(this.PC);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
    
    public void execute(Instruction instruction){
        switch (instruction.operation) {
            case "MOV":
                try {
                    if (isNumeric(instruction.operands[1])) {
                        setValue(instruction.operands[0], Integer.valueOf(instruction.operands[1]));
                    } else {
                        setValue(instruction.operands[0], this.getValue(instruction.operands[1]));
                    }
                } catch (NumberFormatException e) {
                    throw e;
                }
                break;
            case "ADD":
                this.AC += this.getValue(instruction.operands[0]);
                break;
            case "SUB":
                this.AC -= this.getValue(instruction.operands[0]);
                break;
            case "STORE":
                setValue(instruction.operands[0], this.AC);
                break;
            case "LOAD":
                this.AC = this.getValue(instruction.operands[0]);
                break;
            case "INC":
                if (instruction.operands.length > 0) {
                    this.AC += this.getValue(instruction.operands[0]);
                } 
                else {
                    this.AC += 1;
                }
                break;
            case "DEC":
                if (instruction.operands.length > 0) {
                    this.AC -= this.getValue(instruction.operands[0]);
                } 
                else {
                    this.AC -= 1;
                }
                break;
            case "SWAP":
                int temp1 = this.getValue(instruction.operands[0]);
                
                setValue(instruction.operands[0], this.getValue(instruction.operands[1]));
                setValue(instruction.operands[1], temp1);
                break;
            default:
                throw new IllegalArgumentException("Invalid operation: " + instruction.operation);
        }
    }
    
    public void updateRegisters(int ax, int bx, int cx, int dx, int ac, int pc, Instruction ir) {
        this.AX = ax;
        this.BX = bx;
        this.CX = cx;
        this.DX = dx;
        this.AC = ac;
        this.IR = ir;
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
    
    public Instruction ir() {
        return this.IR;
    }
    
    public int pc() {
        return this.PC;
    }
    
    private int getValue(String register) {
        int sol = 0;
        switch (register) {
            case "AX":
                sol = this.AX;
                break;
            case "BX":
                sol = this.BX;
                break;
            case "CX":
                sol = this.CX;
                break;
            case "DX":
                sol = this.DX;
                break;
        }
        return sol;
    }
    
    private int setValue(String register, int value) {
        int sol = 0;
        switch (register) {
            case "AX":
                this.AX = value ;
                break;
            case "BX":
                this.BX = value ;
                break;
            case "CX":
                this.CX = value ;
                break;
            case "DX":
                this.DX = value ;
                break;
        }
        return sol;
    }
    
}
