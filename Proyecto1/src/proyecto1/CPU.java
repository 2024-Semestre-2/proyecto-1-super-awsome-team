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
                    switch(instruction.operands[0]) {
                        case "AX":
                            if (isNumeric(instruction.operands[1])) {
                                this.AX = Integer.valueOf(instruction.operands[1]);
                            } else {
                                this.AX = this.getValue(instruction.operands[1]);
                            }
                            break;
                        case "BX":
                            if (isNumeric(instruction.operands[1])) {
                                this.BX = Integer.valueOf(instruction.operands[1]);
                            } else {
                                this.BX = this.getValue(instruction.operands[1]);
                            }
                            break;
                        case "CX":
                            if (isNumeric(instruction.operands[1])) {
                                this.CX = Integer.valueOf(instruction.operands[1]);
                            } else {
                                this.CX = this.getValue(instruction.operands[1]);
                            }
                            break;
                        case "DX":
                            if (isNumeric(instruction.operands[1])) {
                                this.DX = Integer.valueOf(instruction.operands[1]);
                            } else {
                                this.DX = this.getValue(instruction.operands[1]);
                            }
                            break;
                    }
                } catch (NumberFormatException e) {
                    throw e;
                }
                break;
            case "ADD":
                switch(instruction.operands[0]) {
                    case "AX":
                        this.AC += this.AX;
                        break;
                    case "BX":
                        this.AC += this.BX;
                        break;
                    case "CX":
                        this.AC += this.CX;
                        break;
                    case "DX":
                        this.AC += this.DX;
                        break;
                }
                break;
            case "SUB":
                switch(instruction.operands[0]) {
                    case "AX":
                        this.AC -= this.AX;
                        break;
                    case "BX":
                        this.AC -= this.BX;
                        break;
                    case "CX":
                        this.AC -= this.CX;
                        break;
                    case "DX":
                        this.AC -= this.DX;
                        break;
                }
                break;
            case "STORE":
                switch(instruction.operands[0]) {
                    case "AX":
                        this.AX = this.AC ;
                        break;
                    case "BX":
                        this.BX = this.AC ;
                        break;
                    case "CX":
                        this.CX = this.AC ;
                        break;
                    case "DX":
                        this.DX = this.AC ;
                        break;
                }
                break;
            case "LOAD":
                switch(instruction.operands[0]) {
                    case "AX":
                        this.AC = this.AX;
                        break;
                    case "BX":
                        this.AC = this.BX;
                        break;
                    case "CX":
                        this.AC = this.CX;
                        break;
                    case "DX":
                        this.AC = this.DX;
                        break;
                }
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
    
}
