//  PROGRAMMER:  Sebastien Dolce  211-0449
//  CLASS:       COP 3337   th 6:30
//  INSTRUCTOR:  Norman Pestaina  ECS 364
// ASSIGNMENT:  DUE sunday 07/07/13
// CERTIFICATION: I certify that this work is my own and that
//                none of it is the work of any other person.

import java.util.Scanner;
import java.util.ArrayList;
public class MazeGrid
{
	//Instance Variables
	private int maxRow;	//Highest index of any row in the maze grid
	private int maxCol;	//Highest index of any column in the maze grid
	
	private SquareState[][] grid;

	//Constructor
	//Pre-condition: source has been initialized to scan a maze input file
	//Post-condition: the grid has been initialized with all OPEN or BLOCKED
	//	squares to reflect the description given in the maze input file
	public MazeGrid(Scanner source)
	{
                
            		
		Scanner filescan = source;
		maxRow= filescan.nextInt();
                maxCol= filescan.nextInt();
                //int x=Integer.parseInt(input.substring(0, 1));
                //int y=Integer.parseInt(input.substring(1));
                grid=new SquareState[maxRow][maxCol];
                
		while (filescan.hasNext())
		{
                    for (int i=0;i<maxRow-1;i++)
                    {
                        String input= filescan.nextLine();
                        Scanner filescan2=new Scanner(input);
                        while (filescan2.hasNext())
                        {
                            int z=filescan2.nextInt();
                            grid[i][z]=SquareState.OPEN;
                        }
                    }
                    Position startPosition = new Position(filescan.nextInt(),
                            filescan.nextInt());
                    
                }
                filescan.close();
	}
	
	//Accessors: allow the state of an indicated square to be queried
	public boolean isOpen(Position square)
	{
            if (grid[square.getRow()][square.getColumn()]==SquareState.OPEN)
            {
		return true;
            }
            else
                return false;
	}

	public boolean isBlocked(Position square)
	{
		if (grid[square.getRow()][square.getColumn()]==SquareState.BLOCKED)
            {
		return true;
            }
            else
                return false;
	}
	
	public boolean isSelected(Position square)
	{
		if (grid[square.getRow()][square.getColumn()]==SquareState.SELECTED)
            {
		return true;
            }
            else
                return false;
	}
	
	public boolean isRejected(Position square)
	{
		if (grid[square.getRow()][square.getColumn()]==SquareState.REJECTED)
            {
		return true;
            }
            else
                return false;
	}
	
	//Accessor
	//Return true iff a given Position is a legitimate Position in the maze grid
	public boolean isInBounds(Position square)
	{
            
		if (grid[square.getRow()][square.getColumn()]==SquareState.OPEN
                        &&square.getRow() <= maxRow &&square.getColumn()<=maxCol
                        &&square.getRow()>0&&square.getColumn()>0)
            {
		return true;
            }
            else
                return false;
	}
	
	//Accessor
	//Return true iff a given Position is on the boundary of the maze grid
	public boolean isOnBoundary(Position square)
	{
            if (square.getRow() == maxRow ||square.getColumn()==maxCol)
            {
                return true;
            } 
            else
		return false;
	}
	
	//Mutator
	//Change the state of a square at a given Position in the maze grid			
	public void setState(Position square, SquareState state)
	{
            //if (grid[square.getRow()][square.getColumn()]==SquareState.OPEN)
                grid[square.getRow()][square.getColumn()]=state;
	}
}