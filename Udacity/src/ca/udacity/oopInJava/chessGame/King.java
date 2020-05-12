package ca.udacity.oopInJava.chessGame;

public class King extends Piece {
	
	King(Position position, int color){
		super("king", position, color);
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
		boolean isDiagonalMove, isVerticalMove, isHorizentalMove, isValidKingMove;
				
		isDiagonalMove = (Math.abs(destCol - srcCol) == Math.abs(destRow - srcRow)); 
		isVerticalMove = (destCol == srcCol);
		isHorizentalMove = (destRow == srcRow);
		
		
		isValidKingMove = ( (Math.abs(destCol - srcCol) == 1 && isHorizentalMove) || (Math.abs(destRow - srcRow) == 1 && isVerticalMove) || (isDiagonalMove && Math.abs(destRow - srcRow) == 1));
		
		// debug
		System.out.println("isValidKingMove: " + isValidKingMove);
		// debug
		
		return isValidKingMove;
	}
}
