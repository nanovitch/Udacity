package ca.udacity.oopInJava.chessGame;

public abstract class Piece {
	
	private final String packageName = this.getClass().getPackage().getName(); //used to detect which kind of Piece is in "isMyMoveCorrect" method
	
	private Position position;
	private final int color; //0 for white and 1 for black
	private final String name;
	
	Piece(String name, Position position, int color){
		this.name = name;
		this.position = position;
		this.color = color;
	}
	
	public final String getName() {
		return this.name;
	}
	
	public final int getColor() {
		return this.color;
	}
	
	public final Position getPosition() {
		return this.position;
	}
	
	public final void setPosition(final Position position) {
		this.position = position;
	}
	
	public final void move(final Position newPosition) {
		this.setPosition(newPosition);
	}
	
	//public abstract boolean isValideMove(Position newPosition, Board board);
	
	public boolean isMyMoveCorrect(final Position dest, final Board board) { 
		int srcRow = this.getPosition().getRawRow();
		int destRow = dest.getRawRow();
		int srcCol = this.getPosition().getRawCol();
		int destCol = dest.getRawCol();
		
		Piece pieceToEat = board.getThePieceOnBoard(dest);
		boolean isDiagonalMove, isVerticalMove, isHorizentalMove, isValidKingMove, isValidQueenMove, isValidRockMove, isValidKnightMove, isValidBishopMove, isValidPawnMove, isThePathClear;
		
		isDiagonalMove = (Math.abs(destCol - srcCol) == Math.abs(destRow - srcRow)); 
		isVerticalMove = (destCol == srcCol);
		isHorizentalMove = (destRow == srcRow);
		isThePathClear = board.isThisPathClear(this.getPosition(), dest);
		
		isValidBishopMove = isDiagonalMove && isThePathClear;
		isValidRockMove = (isVerticalMove || isHorizentalMove)&& isThePathClear;
		isValidQueenMove = (isDiagonalMove || isVerticalMove || isHorizentalMove) && isThePathClear;
		isValidKnightMove = ((Math.abs(destCol - srcCol) == 2 && Math.abs(destRow - srcRow) == 1) || (Math.abs(destCol - srcCol) == 1 && Math.abs(destRow - srcRow) == 2)) && isThePathClear;
		isValidKingMove = ( (Math.abs(destCol - srcCol) == 1 && isHorizentalMove) || (Math.abs(destRow - srcRow) == 1 && isVerticalMove) || (isDiagonalMove && Math.abs(destRow - srcRow) == 1)) && isThePathClear;
		// need to known if is a Pawn to be able to cast this actual instance to Pawn in isPawnMove expression so we can call Pawn specific method "isFirstMove".
		boolean isPawn = (this.getClass().getCanonicalName().equals(packageName + ".Pawn"));
		isValidPawnMove = ( ((isDiagonalMove && pieceToEat != null && pieceToEat.color != this.color) && (this.color == 0 && destRow - srcRow == -1 || this.color == 1 && destRow - srcRow == 1)) ||
						((isVerticalMove && pieceToEat == null) && (this.color == 0 && destRow - srcRow == -1 || this.color == 1 && destRow - srcRow == 1)) ||
						(( isPawn && ((Pawn)this).isFirstMove && isVerticalMove && pieceToEat == null) && (this.color == 0 && destRow - srcRow == -2 || this.color == 1 && destRow - srcRow == 2))
					)	&& isThePathClear;
		
		// debug
		System.out.println("isValidKingMove, isValidQueenMove, isValidRockMove, isValidKnightMove, isValidBishopMove, isValidPawnMove: " + 
				isValidKingMove + ", "+ isValidQueenMove + ", "+ isValidRockMove + ", "+ isValidKnightMove + ", "+ isValidBishopMove + ", "+ isValidPawnMove);
		// debug
		
		if (this.name.equals("bishop")) return isValidBishopMove;
		if (this.name.equals("rock")) return isValidRockMove ;
		if (this.name.equals("queen")) return  isValidQueenMove;
		if (this.name.equals("king")) return  isValidKingMove;
		if (this.name.equals("knight")) return  isValidKnightMove;
		if (this.name.equals("pawn")) return isValidPawnMove;
		return false;
	}

}
