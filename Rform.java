package edu.bu.met.cs472.project1;

public class Rform 
	{
	/**This is the class companion to the MIPSDisassembler.java program.  This program takes 
	 * the instructions in R-form and converts them into the original instructions.  I have 
	 * hard coded in the opCode's for each instruction, as well as the bit mask codes for each
	 * section that is being disassembled.  The methods below calculate the registers, 
	 * destination registers, and function block for each instruction. The opCode is calculated in 
	 * the main program, so it is not found here.
	 * 
	 * 
	 * Created by @author Chris Henson for BU MET CS472 Project #1, and all design parameters are based on 
	 * the instructions given for this assignment.
	 * 
	 */
	
	
	static private final int add = 0x20;
	static private final int sub = 0x22;
	static private final int and = 0x24;
	static private final int or = 0x25;
	
	static final private int src1BitMask = 0x03E00000;
	static final private int src2BitMask = 0x001F0000;
	static final private int destRegBitMask = 0x0000F800;
	static final private int functionBitMask = 0x0000003F;
	
	//register 1 calculation
	public static int calcSrc1(int instruction)
		{
		int src1reg = (instruction & src1BitMask) >>> 21;
		return src1reg;
		}
	
	//register 2 calculation
	public static int calcSrc2 (int instruction)
		{
		int src2reg = (instruction & src2BitMask) >>> 16;
		return src2reg;
		}
	
	//destination register calculation
	public static int calcDest (int instruction)
		{
		int destreg = (instruction & destRegBitMask) >>> 11;
		return destreg;
		}
	
	//function block calculation
	public static String calcFunct (int instruction)
		{
		int function = instruction & functionBitMask;
		
		if (function == add) return "add";
		if (function == sub) return "sub";
		if (function == and) return "and";
		if (function == or) return "or";
		else return null;
		}
	
	
	}//end of class
