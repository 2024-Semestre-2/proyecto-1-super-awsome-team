/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 *
 * @author someone
 */
public class Config {
    public int mainMemorySize;
    public int secondaryMemorySize;
    public int virtualMemorySize;
    
    public Config(int mainSize, int secondarySize, int virtualSize) {
        this.mainMemorySize = mainSize;
        this.secondaryMemorySize = secondarySize;
        this.virtualMemorySize = virtualSize;
    }
    
    @Override
    public String toString(){
        return "Main Memory: " + this.mainMemorySize + "kb, Secondary Memory: " + this.secondaryMemorySize + "kb, Virtual Memory: " + this.virtualMemorySize + "kb";
    }
}
