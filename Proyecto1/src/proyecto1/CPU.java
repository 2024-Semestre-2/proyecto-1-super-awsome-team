/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

import java.util.Arrays;
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
    private int SP;
    private boolean Z;
    private Instruction IR;
    
    public CPU() {
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
    
    public void execute(Instruction instruction, int stackBase, MainMemory memory){
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
            case "CMP":
                this.Z = this.getValue(instruction.operands[0]) == this.getValue(instruction.operands[1]);
                break;
            case "JMP":
                this.PC += Integer.valueOf(instruction.operands[0]);
                break;
            case "JE":
                if (this.Z) {
                    this.PC += Integer.valueOf(instruction.operands[0]);
                }
                break;
            case "JNE":
                if (!this.Z) {
                    this.PC += Integer.valueOf(instruction.operands[0]);
                }
                break;
            case "PUSH":
                try {
                    this.SP = memory.pushToStack(this.SP, stackBase, this.getValue(instruction.operands[0]));
                } catch (IllegalArgumentException e) {
                    throw e;
                }
                break;
            case "POP":
                try {
                    setValue(instruction.operands[0], memory.popFromStack(this.SP, stackBase));
                    this.SP++;
                } catch (IllegalArgumentException e) {
                    throw e;
                }
            case "PARAM":
                try {
                    for (int i = 0; i < instruction.operands.length; i++) {
                        this.SP = memory.pushToStack(this.SP, stackBase, Integer.valueOf(instruction.operands[i]));
                    }
                } catch (IllegalArgumentException e) {
                    throw e;
                }
                
                break;
            default:
                throw new IllegalArgumentException("Invalid operation: " + instruction.operation);
        }
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
