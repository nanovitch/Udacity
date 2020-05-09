package ca.udacity.oopInJava.chessGame;

public class Knight extends Piece {
	
	Knight(Position position, int color){
		super("knight", position, color);
	}
	
	// to correct
	/*public boolean isValideMove(Position newPosition, Board board){
		
		// debug
		System.out.println("KNIGHT");
		System.out.println("Src: " + this.getPosition().getPositionAsString());
		System.out.println("Dest: " + newPosition.getPositionAsString());
		// debug end
		
		// stop if the move is outside board or if there is an obstacle on the diagonal path
		char kindOfMove = this.getPosition().kindOfMove(newPosition);
		Piece pieceToEat = board.getThePieceOnBoard(newPosition);
		
		// debug
		System.out.println("Move inside board: " + newPosition.isInBoardMove());
		System.out.println("Path to dest clear: : " + board.isThisPathClear(this.getPosition(), newPosition));
		System.out.println("pieceToEat: " + pieceToEat);
		if (pieceToEat != null) System.out.println("pieceToEat.color: " + pieceToEat.color);
		// debug end
		
		return ( (newPosition.isInBoardMove()) && (kindOfMove == 'C') && (pieceToEat == null || pieceToEat.color != this.color) );
	}*/

}
