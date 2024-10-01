/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 *
 * @author someone
 */
public class Expression {
    int row;
    String address;
    String operation;
    String[] operands;
    
    public Expression(int row, String address, String operation, String[] operands) {
        this.row = row;
        this.address = address;
        this.operation = operation;
        this.operands = operands;
    }
    
    public String toString() {
        return "Línea: " + row + ", Dirección: " + address + ", Operación: " + operation + ", Operandos: " + String.join(", ", operands);
    }
}
