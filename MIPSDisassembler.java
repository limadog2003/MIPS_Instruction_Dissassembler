package edu.bu.met.cs472.project1;

public class MIPSDisassembler 
	{

	public static void main(String[] args) 
		{
		/**This program is designed to take a set of MIPS assembly instructions and decode them in 
		 * the assembly language coding. The instructions are hard coded into the array below.  There
		 * are two classes that go with this main program: Iform.java and Rform.java.  They are designed 
		 * to translate part of the code based on how the instruction has been coded. The memory address
		 * has been included in the output, and any branch instructions include the target memory address 
		 * in the offset.  
		 * 
		 * 
		 * Created by @author Chris Henson for BU MET CS472 Project #1, and all design parameters are based on 
		 * the instructions given for this assignment.
		 */
				
		int opCode;
		int opCodeBitMask = 0xFC000000;
		int address = 0x7A060;
		
		int instructionArray [] = new int [11];
		
		instructionArray [0] = 0x022DA822;
		instructionArray [1] = 0x8EF30018;
		instructionArray [2] = 0x12A70004;
		instructionArray [3] = 0x02689820;
		instructionArray [4] = 0xAD930018;
		instructionArray [5] = 0x02697824;
		instructionArray [6] = 0xAD8FFFF4;
		instructionArray [7] = 0x018C6020;
		instructionArray [8] = 0x02A4A825;
		instructionArray [9] = 0x158FFFF6;
		instructionArray [10] = 0x8E59FFF0;
		
		//iterates through array
		for (int i =0; i < instructionArray.length; i++)
			{
			opCode = (instructionArray[i] & opCodeBitMask) >>> 26;
		
			if (opCode == 0)
				{
				int src1reg = Rform.calcSrc1(instructionArray[i]);
				int src2reg = Rform.calcSrc2(instructionArray[i]);
				int destreg = Rform.calcDest(instructionArray[i]);
				String function = Rform.calcFunct(instructionArray[i]);
				
				System.out.println(Integer.toHexString(address) + " " + function + " $" + destreg + ", $" + src1reg + ", $" + src2reg);
				}
			
			else 
				{
				String opCodeDisplay = Iform.calcOpCode(opCode);
				int src1reg = Iform.calcSrc1(instructionArray[i]);
				int src2reg = Iform.calcSrc2(instructionArray[i]);
				short offset = Iform.calcOffSet(instructionArray[i]);
				
				if (opCodeDisplay.equals("sw") || opCodeDisplay.equals("lw"))
					{
					System.out.println(Integer.toHexString(address) + " " + opCodeDisplay + " $" + src2reg + ", " + offset + "($" + src1reg + ") ");	
					}
				
				if (opCodeDisplay.equals("bne") || opCodeDisplay.equals("beq"))
					{
					int branchOffset = ((offset << 2) + address + 0x04);
						
					System.out.println(Integer.toHexString(address) + " " + opCodeDisplay + " $" + src1reg + ", $" + src2reg + ", " 
					+ "address " + Integer.toHexString(branchOffset));
					}
				}

			address += 0x4; //address iteration
			
			}//end of main for loop
		
		
		}//end of main

	}//end of class
