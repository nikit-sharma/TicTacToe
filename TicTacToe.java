package My_Games;

import java.util.Scanner;

class Board
{
	String boardMatrix[][]=new String[7][7];
	//Constructor to make the board
	Board()
	{
		for(int row=0;row <7;row++)
		{
			for(int col=0;col<7;col++)
			{
				if(row==0 || row==6)
				{
					boardMatrix[row][col]="-";
				}
				else if(col==0 || col==6)
				{
					boardMatrix[row][col]="|";
				}
				else if(row==2 || row == 4)
				{
					boardMatrix[row][col]="*";
				}
				else if(row==2 || row == 4 || col==2 || col==4)
				{
					boardMatrix[row][col]="*";
				}
				else
					boardMatrix[row][col]=" ";
			}
		}	
	}
	
	// function to print the board
	
	void printBoard()
	{
		for(int i=0;i<7;i++)
		{
			for(int j=0;j<7;j++)
			{
				System.out.print(boardMatrix[i][j]);
			}
			System.out.println();
		}
	}
	
	//function to switch between players
	int c=0;
	void makePlayersPlay()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter name of Player 1 ");
		String player1=sc.next();
		System.out.println("Enter name of Player 2 ");
		String player2=sc.next();
		boolean flag=false;
		
		for(int i=0;i<9;i++)
		{
			
			if(i%2==0)
			{
				System.out.println("Player "+player1+"'s turn");
				System.out.println("Enter the place you choose");
				int position=sc.nextInt();
				fillBoard(1,"X",position);
				boolean status=(checkRow("X") || checkCol("X") || checkDiagnal("X"));
				if(status==true)
				{
					System.out.println("_____________________________________");
					System.out.println("CONGRATULATIONS!! "+player1+" has won");
					System.out.println("_____________________________________");
					flag=true;
					break;
				}
			}
			else
				{
					System.out.println("Player "+player2+"'s turn");
					System.out.println("Enter the place you choose");
					int position=sc.nextInt();
					fillBoard(2,"O",position);
					boolean status=(checkRow("O") || checkCol("O") || checkDiagnal("O"));
					
					if(status==true)
					{
						System.out.println("_____________________________________________");
						System.out.println("CONGRATULATIONS!! Player "+player2+"  has won");
						System.out.println("_____________________________________________");
						flag=true;
						break;
					}
				}
			
		}
		
		if(c==0)
		{
			System.out.println("_________________");
			System.out.println("MATCH DRAW...!!!");
			System.out.println("_________________");
		}
		
	}
	
	//check Rows
	
	public boolean checkRow(String toCheck)
	{
		if(boardMatrix[1][1]==toCheck && boardMatrix[1][3]==toCheck && boardMatrix[1][5]==toCheck )
		{
			c++;
			return true;
		}
		else if(boardMatrix[3][1]==toCheck && boardMatrix[3][3]==toCheck && boardMatrix[3][5]==toCheck)
		{
			c++;
			return true;
		}
		else if(boardMatrix[5][1]== toCheck && boardMatrix[5][3]== toCheck && boardMatrix[5][5]== toCheck)
		{
			c++;
			return true;
		}
		else
			return false;
	}
	
	//Check Cols
	public boolean checkCol(String toCheck)
	{
		if(boardMatrix[1][1]==toCheck && boardMatrix[3][1]==toCheck && boardMatrix[5][1]==toCheck)
		{
			c++;
			return true;
		}
		else if(boardMatrix[1][3]==toCheck && boardMatrix[3][3]==toCheck && boardMatrix[5][3]==toCheck)
		{
			c++;
			return true;
		}
		else if(boardMatrix[1][5]==toCheck && boardMatrix[3][5]==toCheck && boardMatrix[5][5]==toCheck)
		{
			c++;
			return true;
		}
		else
			return false;
	}
	
	//check diagnals
	
	boolean checkDiagnal(String toCheck)
	{
		if(boardMatrix[1][1]==toCheck && boardMatrix[3][3]==toCheck && boardMatrix[5][5]==toCheck)
		{
			c++;
			return true;
		}
		else if(boardMatrix[1][5]==toCheck && boardMatrix[3][3]==toCheck && boardMatrix[5][1]==toCheck )
		{
			c++;
			return true;
		}
		else
			return false;
	}
	
	//function to fill the board 
	
	void fillBoard(int player,String set,int position)
	{
		switch(position)
	    {
	    case 1: 
	    		  boardMatrix[1][1]=set;
	    	break;
	    case 2:
	    		  boardMatrix[1][3]=set;
	    	break;
	    case 3:
	    		  boardMatrix[1][5]=set;
	    	break;
	    case 4:
	    		  boardMatrix[3][1]=set;
	    	break;
	    case 5:
	    		  boardMatrix[3][3]=set;
	    	break;
	    case 6:
	    		  boardMatrix[3][5]=set;
	    	break;
	    case 7:
	    		  boardMatrix[5][1]=set;
	    	break;
	    case 8:
	    		  boardMatrix[5][3]=set;
	    	break;
	    case 9:
	    		  boardMatrix[5][5]=set;
	    	break;
	    default:
	    	System.out.println("PLEASE ENTER VALID SPACE");
	    	break;
	    	
	    }
	    printBoard();
	}
	
	
	
	
	
}
public class TicTacToe {

	public static void main(String[] args) {
		
		Board board= new Board();
		board.printBoard();
		board.makePlayersPlay();
		
        
	}

}
