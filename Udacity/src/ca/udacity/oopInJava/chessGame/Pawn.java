package ca.udacity.oopInJava.chessGame;

public class Pawn extends Piece {
	
	private boolean isMyFirstMove = true;
	
	Pawn(Position position, int color){
		super("pawn", position, color);
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
		int myColor = this.getColor();
		Piece pieceToEat = board.getThePieceOnBoard(dest);
				
		boolean isDiagonalMove, isVerticalMove, isValidPawnMove;
		
		isDiagonalMove = (Math.abs(destCol - srcCol) == Math.abs(destRow - srcRow)); 
		isVerticalMove = (destCol == srcCol);
		
		isValidPawnMove = ( ((isDiagonalMove && pieceToEat != null && pieceToEat.getColor() != myColor) && (myColor == 0 && destRow - srcRow == -1 || myColor == 1 && destRow - srcRow == 1)) ||
						((isVerticalMove && pieceToEat == null) && (myColor == 0 && destRow - srcRow == -1 || myColor == 1 && destRow - srcRow == 1)) ||
						((  this.isMyFirstMove && isVerticalMove && pieceToEat == null) && (myColor == 0 && destRow - srcRow == -2 || myColor == 1 && destRow - srcRow == 2))
					);
		
		// debug
		System.out.println("isValidPawnMove: " + isValidPawnMove);
		// debug
		
		if (this.isMyFirstMove) this.isMyFirstMove = false;
		
		return isValidPawnMove;
		
	}

}
