/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 *
 * @author someone
 */
public class Process {
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
}
