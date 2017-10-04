//  PROGRAMMER:  Sebastien Dolce  211-0449
//  CLASS:       COP 3337   th 6:30
//  INSTRUCTOR:  Norman Pestaina  ECS 364
// ASSIGNMENT:  DUE sunday 07/07/13
// CERTIFICATION: I certify that this work is my own and that
//                none of it is the work of any other person.b

public class Position
{
   
   private int row;
   private int col;
   public Position(int rows,int cols)
   {
       row=rows;
       col=cols;
   }
   public int getRow()
   {
       return row;
   }
   public int getColumn()
   {
       return col;
   }
   public void setRow(int rows)
   {
       row=rows;
   }
   public void setColumn(int cols)
   {
       col=cols;
   }
   //Return true if this Position is orthogonally adjacent to the
   // parameter Position other, return false otherwise.
   public boolean isAdjacentTo(Position other)
   {
       if (this.row==other.getRow())
       {
           if (this.col+1==other.getColumn() || this.col-1==other.getColumn())
                return true;
           else 
               return false;
       }
       else if (this.col==other.getColumn())
       {
           if (this.row+1==other.getRow() || this.row-1==other.getRow())
               return true;
           else
               return false;
       }
       else
               return false;
   }
   
   //Return an array containing each of the 4 Positions that are
   // orthogonally adjacent to this Position.
   public Position[] neighbors()
   {
      Position[] pos= new Position[4];
      pos[0]=new Position(this.getRow()-1,this.getColumn());
      pos[1]=new Position(this.getRow(),this.getColumn()+1);
      pos[2]=new Position(this.getRow()+1,this.getColumn());
      pos[3]=new Position(this.getRow(),this.getColumn()-1);
      return pos;
   }
}