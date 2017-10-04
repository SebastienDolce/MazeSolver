//  PROGRAMMER:  Sebastien Dolce  211-0449
//  CLASS:       COP 3337   th 6:30
//  INSTRUCTOR:  Norman Pestaina  ECS 364
// ASSIGNMENT:  DUE sunday 07/07/13
// CERTIFICATION: I certify that this work is my own and that
//                none of it is the work of any other person.

public enum SquareState
{
	OPEN(' '), BLOCKED('#'), SELECTED('+'), REJECTED('X');
	
	private char symbol;
	
	private SquareState(char symbol)
	{
		this.symbol = symbol;
	}
	
	public char getSymbol()
	{
		return this.symbol;
	}
}