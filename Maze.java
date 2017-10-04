//  PROGRAMMER:  Sebastien Dolce  211-0449
//  CLASS:       COP 3337   th 6:30
//  INSTRUCTOR:  Norman Pestaina  ECS 364
// ASSIGNMENT:  DUE sunday 07/07/13
// CERTIFICATION: I certify that this work is my own and that
//                none of it is the work of any other person.

import java.util.Scanner;
public class Maze
{
	//Instance Variables
	private MazeGrid grid;
	private MazePath path;
        private Position start;
	
	//Constructor
	//Pre-condition: source has been initialized to scan a maze input file	
	public Maze(Scanner source)
	{
            String s="";
            Scanner filescan = source;
            while (filescan.hasNext())
            {
            s=filescan.nextLine();
            
            }
            Scanner filescan2 = new Scanner(s);
            start=new Position(filescan2.nextInt(),filescan2.nextInt());
            grid= new MazeGrid(source);
            path= new MazePath();
            //path.extend(start);
            grid.setState(start, SquareState.SELECTED);
	}
	
	//Return true if there is a path beginning at the start Position
	//	and ending at any boundary Position of the grid.
	public boolean solve()
	{
            Position[] pos=path.getLastStep().neighbors();
            if (grid.isOnBoundary(path.getLastStep())&&grid.isOpen(path.getLastStep()))
		return true;
            if (path.getLastStep()==start)
                return false;
            for (int i=0;i<4;i++)
            {
                if (pos[i]!=path.getLastStep() && grid.isOpen(pos[i]))
                    path.extend(pos[i]);
            }
            if (grid.isBlocked(path.getLastStep())||grid.isRejected(path.getLastStep()))
            {
                path.backUp();
                solve();
            }
            return false;
            
	}
}