package ca.udacity.oopInJava.chessGame;

public class Queen extends Piece {
	
	Queen(Position position, int color){
		super("queen", position, color);
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
		boolean isDiagonalMove, isVerticalMove, isHorizentalMove, isValidQueenMove;
		
		isDiagonalMove = (Math.abs(destCol - srcCol) == Math.abs(destRow - srcRow)); 
		isVerticalMove = (destCol == srcCol);
		isHorizentalMove = (destRow == srcRow);
				
		isValidQueenMove = (isDiagonalMove || isVerticalMove || isHorizentalMove);
				
		// debug
		System.out.println("isValidQueenMove: " + isValidQueenMove);
		// debug
		
		return  isValidQueenMove;
		
	}
	
}
