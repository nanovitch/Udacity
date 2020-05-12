package ca.udacity.oopInJava.chessGame;

public class Bishop extends Piece {
	
	Bishop(Position position, int color){
		super("bishop", position, color);
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
		boolean isDiagonalMove, isValidBishopMove;
				
		isDiagonalMove = (Math.abs(destCol - srcCol) == Math.abs(destRow - srcRow)); 
				
		isValidBishopMove = isDiagonalMove;
		
		
		// debug
		System.out.println("isValidBishopMove: " + isValidBishopMove);
		// debug
		
		return isValidBishopMove;
		
	}
	
}
