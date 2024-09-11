/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author someone
 */
public class AsmLoader {
    public List<Expression> loadFile(String filepath) {
        List<Expression> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                count ++;
                try {
                    Expression instruction = parseLine(count, line);
                    if (instruction != null) {
                        list.add(instruction);
                    }
                } catch (IllegalArgumentException e) {
                    throw e;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        
        return list;
    }
    
    private Expression parseLine(int row, String line) {
        // Remove all leading/trailing whitespaces
        line = line.trim();
        line = line.replace(",","");
        
        // Check for empty lines or comments and skip them
        if (line.isEmpty() || line.startsWith("//")) {
            return null;
        }
        
        // Split the line into its components 
        String[] parts = line.split(" ");
        if (parts.length < 2) {
            throw new IllegalArgumentException("Invalid instruction format: " + line + " on line: " + row);
        }
        
        String address = null;
        String operation;
        String[] operands;
        
        // If the first part is numeric, it's the memory address
        if (parts[0].matches("\\d+")) {
            address = parts[0];
            operation = parts[1];
            //operands = parts.length > 2 ? parts[2] : null;
            operands = Arrays.copyOfRange(parts, 2, parts.length);
        } else {
            operation = parts[0];
            //operands = parts.length > 1 ? parts[1] : null;
            operands = Arrays.copyOfRange(parts, 1, parts.length);
        }
        
        validateProcessInstruction(row, address, operation, operands);
        
        return new Expression(row, address, operation, operands);
    }
    
    private void validateProcessInstruction(int row, String address, String operation, String[] operands) {
        // Validate the operation
        switch (operation.toUpperCase()) {
            case "LOAD":
            case "STORE":
            case "MOV":
            case "SUB":
            case "ADD":
                break;
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation + " on line: " + row);
        }
        
        // Validate de operands
        if (operands != null) {
            if (operands.length != expectedNumberOfOperands(operation)) {
                throw new IllegalArgumentException("Invalid number of operands for " + operation + ": " + Arrays.toString(operands) + " on line: " + row);
            }
        }
        
        // If all validations pass, proceed to load the instruction into memory
    }
    
    private int expectedNumberOfOperands(String operation) {
        switch (operation.toUpperCase()) {
            case "MOV":
                return 2;
            case "ADD":
            case "SUB":
            case "LOAD":
            case "STORE":
                return 1;
            default:
                return 0;
        }
    }
}
