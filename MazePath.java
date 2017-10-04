//  PROGRAMMER:  Sebastien Dolce  211-0449
//  CLASS:       COP 3337   th 6:30
//  INSTRUCTOR:  Norman Pestaina  ECS 364
// ASSIGNMENT:  DUE sunday 07/07/13
// CERTIFICATION: I certify that this work is my own and that
//                none of it is the work of any other person.

import java.util.ArrayList;
public class MazePath
{
	//A sequence of Positions of orthogonally adjacent accessible
	//	squares from a maze.
	private ArrayList<Position> path;
	
	//Constructor
	public MazePath()
	{
		this.path = new ArrayList<Position>();
	}
	
	//Accessor
	//Returns copies of the Positions on this MazePath (in the same order)
	public Position[] getPath()
	{
            Position[] pos= new Position[path.size()];
            path.toArray(pos);
		return pos;
	}
	
	//Accessor
	//Return a copy of the last stored Position of a MazePath
	public Position getLastStep()
	{
        
            
		return path.get(path.size()-1);
	}
	
	//Mutator
	//Extend a path by adding another Position to the end of a path
	//The added Position must not duplicate any already in the path
	//The added position must be orthogonally adjacent to the last
	public void extend(Position step)
	{
            boolean same=false;
            for(int i =0;i<path.size();i++)
            {
                if (step==path.get(i))
                    same=true;
            }
             
            if (step.isAdjacentTo(path.get(path.size()-1))&& same==false)
                path.add(step);
	}
	
	//Mutator
	//Remove and return the last Position on a path
	public Position backUp()
	{
            Position p=path.get(path.size()-1);
            path.remove(path.size()-1);
		return p;
	}
	
	//Return a printable image of a path
	//The coordinates are (1-based) as the user would describe them
	public String toString()
	{
            String strimg="";
            for (Position p:path)
            {
                strimg="row: "+p.getRow()+"/tcolumn"+p.getColumn()+"/n";
            }
                
		return strimg;
	}
}