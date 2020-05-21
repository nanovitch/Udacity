package ca.udacity.oopInJava.chessGame;

public class Rock extends Piece {
	
	Rock(Position position, int color){
		super("rock", position, color);
	}
	
	public boolean isValideMove(final Position dest, final Board board) { 
		
		boolean isMovePrecMeet = this.isMovePreconditionsMeet(dest, board);
		
		// debug
			System.out.println("isMovePreconditionsMeet: " + isMovePrecMeet);
		// debug
				
		if (!isMovePrecMeet) return false;
		
		int srcRow = this.getPosition().getRawRow();
		int destRow = dest.getRawRow();
		int srcCol = this.getPosition().getRawCol();
		int destCol = dest.getRawCol();
		boolean isVerticalMove, isHorizentalMove, isValidRockMove;
		
		isVerticalMove = (destCol == srcCol);
		isHorizentalMove = (destRow == srcRow);
				
		isValidRockMove = (isVerticalMove || isHorizentalMove);
				
		// debug
		System.out.println("isValidRockMove: " + isValidRockMove);
		// debug
		
		return isValidRockMove ;
		
	}
}
