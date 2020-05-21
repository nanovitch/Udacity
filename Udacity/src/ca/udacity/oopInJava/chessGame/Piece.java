package ca.udacity.oopInJava.chessGame;

public abstract class Piece {
	
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
	
	// Before checking the piece move validity, we have to check these preconditions:
	// 1. The destination position in in board limits.
	// 2. The path between the source and final position is clear (no other piece between) expect for "knight"
	// 3. The destination case is either empty or its contained piece color is different from the moved piece one
	public boolean isMovePreconditionsMeet(final Position dest, final Board board) { 
		Piece pieceToEat = board.getThePieceOnBoard(dest);
		boolean isInBoardMove = dest.isInBoardMove();
		// the path is always clear for the knight because it can jump over other pieces
		boolean isThisPathClear = (this.name=="knight") ? true : board.isThisPathClear(this.getPosition(), dest);
		boolean isDestCaseEmpty = (pieceToEat == null);
		
		boolean preCondition = isInBoardMove && isThisPathClear && (isDestCaseEmpty || pieceToEat.getColor() != this.getColor());
		
		// debug
		String color = (isDestCaseEmpty)?"N.A":Integer.toString(pieceToEat.getColor());
		System.out.println("isInBoardMove, isThisPathClear, pieceToEat, pieceToEat's color: " + isInBoardMove + ", "+ isThisPathClear + ", "+ pieceToEat + ", "+ color);
		// debug end
		
		return preCondition;
	}
	
	public abstract boolean isValideMove(Position newPosition, Board board);
	
}
