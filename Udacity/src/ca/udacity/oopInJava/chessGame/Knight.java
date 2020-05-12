package ca.udacity.oopInJava.chessGame;

public class Knight extends Piece {
	
	Knight(Position position, int color){
		super("knight", position, color);
	}
	
	public boolean isValideMove(final Position dest, final Board board) { 
		
		boolean isMovePrecMeet = this.isMovePrecMeet(dest, board);
		
		// debug
			System.out.println("isMovePreconditionsMeet: " + isMovePrecMeet);
		// debug
				
		if (!isMovePrecMeet) return false;
		
		int srcRow = this.getPosition().getRawRow();
		int destRow = dest.getRawRow();
		int srcCol = this.getPosition().getRawCol();
		int destCol = dest.getRawCol();
		boolean isValidKnightMove;
		
		isValidKnightMove = ((Math.abs(destCol - srcCol) == 2 && Math.abs(destRow - srcRow) == 1) || (Math.abs(destCol - srcCol) == 1 && Math.abs(destRow - srcRow) == 2));
		
		
		// debug
			System.out.println("isValidKnightMove: " + isValidKnightMove);
		// debug
		
		return  isValidKnightMove;
		
	}
	
}
