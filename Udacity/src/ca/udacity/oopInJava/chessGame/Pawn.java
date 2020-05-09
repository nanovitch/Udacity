package ca.udacity.oopInJava.chessGame;

public class Pawn extends Piece {
	
	public boolean isFirstMove = true;
	
	Pawn(Position position, int color){
		super("pawn", position, color);
	}

}
