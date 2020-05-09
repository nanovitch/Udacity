package ca.udacity.oopInJava.chessGame;

public abstract class Piece {
	
	protected Position position;
	protected final int color; //0 for white and 1 for black
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
	
	public final void setPosition(Position position) {
		this.position = position;
	}
	
	public final void move(Position newPosition) {
		this.setPosition(newPosition);
	}
	
	//public abstract boolean isValideMove(Position newPosition, Board board);
	
	public boolean isMyMoveCorrect(Position dest, Board board) { 
		int srcRow = this.getPosition().getRawRow();
		int destRow = dest.getRawRow();
		int srcCol = this.getPosition().getRawCol();
		int destCol = dest.getRawCol();
		
		Piece pieceToEat = board.getThePieceOnBoard(dest);
		boolean isDiagonalMove, isVerticalMove, isHorizentalMove, isThePathClear;
		
		isDiagonalMove = (Math.abs(destCol - srcCol) == Math.abs(destRow - srcRow)); 
		isVerticalMove = (destCol == srcCol);
		isHorizentalMove = (destRow == srcRow);
		isThePathClear = board.isThisPathClear(this.getPosition(), dest);
		
		System.out.println("isDiagonalMove, isVerticalMove, isHorizentalMove, isThePathClear: " + isDiagonalMove + ", "+ isVerticalMove + ", "+ isHorizentalMove + ", "+ isThePathClear);
				
		if (this.name.equals("bishop")) return isDiagonalMove && isThePathClear;
		if (this.name.equals("rock")) return (isVerticalMove || isHorizentalMove) && isThePathClear;
		if (this.name.equals("queen")) return (isDiagonalMove || isVerticalMove || isHorizentalMove) && isThePathClear;
		if (this.name.equals("king")) return ( (Math.abs(destCol - srcCol) == 1 && isHorizentalMove) || (Math.abs(destRow - srcRow) == 1 && isVerticalMove) || (isDiagonalMove && Math.abs(destRow - srcRow) == 1)) && isThePathClear;
		if (this.name.equals("knight")) return ((Math.abs(destCol - srcCol) == 2 && Math.abs(destRow - srcRow) == 1) || (Math.abs(destCol - srcCol) == 1 && Math.abs(destRow - srcRow) == 2)) && isThePathClear;
		if (this.name.equals("pawn")) return ( ((isDiagonalMove && pieceToEat != null && pieceToEat.color != this.color) && (this.color == 0 && destRow - srcRow == -1 || this.color == 1 && destRow - srcRow == 1)) ||
												((isVerticalMove && pieceToEat == null) && (this.color == 0 && destRow - srcRow == -1 || this.color == 1 && destRow - srcRow == 1)) ||
												((((Pawn)this).isFirstMove && isVerticalMove && pieceToEat == null) && (this.color == 0 && destRow - srcRow == -2 || this.color == 1 && destRow - srcRow == 2))
											)
											&& isThePathClear;
		return false;
	}

}
