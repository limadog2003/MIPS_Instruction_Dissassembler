package edu.bu.met.cs472.project1;

public class Iform 
	{
	/**This is the class companion to the MIPSDisassembler.java program.  This program takes 
	 * the instructions in I-form and converts them into the original instructions.  I have 
	 * hard coded in the opCode's for each instruction, as well as the bit mask codes for each
	 * section that is being disassembled.  The methods below calculate the opcodes, registers, 
	 * and offsets for each instruction.
	 * 
	 * Created by @author Chris Henson for BU MET CS472 Project #1, and all design parameters are based on 
	 * the instructions given for this assignment.
	 * 
	 */
	static final private int slt = 0x2A;
	static final private int lw = 0x23;
	static final private int sw = 0x2B;
	static final private int beq = 0x4;
	static final private int bne = 0x5;
	
	
	static final private int src1BitMask = 0x03E00000;
	static final private int src2BitMask = 0x001F0000;
	static final private int iFormBitMask = 0xFFFF;
	
	//opCode calculation
	public static String calcOpCode (int opCode)
		{
		if (opCode == slt) return "slt";
		if (opCode == lw) return "lw";
		if (opCode == sw) return "sw";
		if (opCode == beq) return "beq";
		if (opCode == bne) return "bne";
		else return null;
		}
	
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

	//offset calculation
	public static short calcOffSet (int instruction)
		{
		short iForm =(short) (instruction & iFormBitMask);
		return iForm;
		}
			
	}
