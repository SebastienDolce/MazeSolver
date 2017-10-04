//  PROGRAMMER:  Sebastien Dolce  211-0449
//  CLASS:       COP 3337   th 6:30
//  INSTRUCTOR:  Norman Pestaina  ECS 364
// ASSIGNMENT:  DUE sunday 07/07/13
// CERTIFICATION: I certify that this work is my own and that
//                none of it is the work of any other person.

import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class MazeClient
{
	public static void main(String[] args) throws IOException
	{
		boolean quitting = false;
		do
		{
			String fileName = JOptionPane.showInputDialog(null,
			                  	"Enter name of Maze data file or CANCEL to quit");
			
			if (fileName == null)
				quitting = true;
			else
			{
				try
				{
					Maze maze = new Maze( new Scanner( new FileReader(fileName) ) );
					System.out.println();
					System.out.println(maze);
					System.out.println("\n" + (maze.solve() ? maze + "SUCCESS" : maze + "FAILURE"));
				}
				catch(FileNotFoundException exc)
				{
					System.out.println(exc.getMessage());
				}
			}
		} while (!quitting);
	}
}