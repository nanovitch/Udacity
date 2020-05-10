package ca.udacity.oopInJava.chessGame;

public class Main {
	
	static public enum color { WHITE, BLACK };
	static public enum ChessPlayer { WHITE, BLACK };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Board chessBoard = new Board();
		chessBoard.boardSetup();
		chessBoard.showBoard();
		
		/*
		// Pawn test
		chessBoard.play(new Position("e2"), new Position("e4"));
		chessBoard.showBoard();
		chessBoard.play(new Position("e7"), new Position("e5"));
		chessBoard.showBoard();
		chessBoard.play(new Position("e4"), new Position("e5"));
		chessBoard.showBoard();
		chessBoard.play(new Position("e4"), new Position("e3"));
		chessBoard.showBoard();
		chessBoard.play(new Position("e4"), new Position("d4"));
		chessBoard.showBoard();
		chessBoard.play(new Position("e4"), new Position("f4"));
		chessBoard.showBoard();
		chessBoard.play(new Position("d7"), new Position("d5"));
		chessBoard.showBoard();
		chessBoard.play(new Position("e4"), new Position("d5"));
		chessBoard.showBoard();
		chessBoard.play(new Position("f7"), new Position("f6"));
		chessBoard.showBoard();
		chessBoard.play(new Position("f6"), new Position("e5"));
		chessBoard.showBoard();
		chessBoard.play(new Position("c7"), new Position("c6"));
		chessBoard.showBoard();
		chessBoard.play(new Position("c6"), new Position("d5"));
		chessBoard.showBoard();
		chessBoard.play(new Position("d5"), new Position("d6"));
		chessBoard.showBoard();
		chessBoard.play(new Position("d5"), new Position("d4"));
		chessBoard.showBoard();
		*/
		
		/*
		// Bishop test
		chessBoard.play(new Position("e2"), new Position("e4"));
		chessBoard.showBoard();
		chessBoard.play(new Position("f1"), new Position("b5"));
		chessBoard.showBoard();
		chessBoard.play(new Position("c7"), new Position("c6"));
		chessBoard.showBoard();
		chessBoard.play(new Position("b5"), new Position("c6"));
		chessBoard.showBoard();
		chessBoard.play(new Position("c6"), new Position("a4"));
		chessBoard.showBoard();
		chessBoard.play(new Position("a4"), new Position("b3"));
		chessBoard.showBoard();
		chessBoard.play(new Position("b3"), new Position("c4"));
		chessBoard.showBoard();
		chessBoard.play(new Position("c4"), new Position("f1"));
		chessBoard.showBoard();
		*/
		
		/*
		// Rock test
		chessBoard.play(new Position("h2"), new Position("h4"));
		chessBoard.showBoard();
		chessBoard.play(new Position("c7"), new Position("c5"));
		chessBoard.showBoard();
		chessBoard.play(new Position("h1"), new Position("h3"));
		chessBoard.showBoard();
		chessBoard.play(new Position("c5"), new Position("c4"));
		chessBoard.showBoard();
		chessBoard.play(new Position("h3"), new Position("a3"));
		chessBoard.showBoard();
		chessBoard.play(new Position("c4"), new Position("c3"));
		chessBoard.showBoard();
		chessBoard.play(new Position("a3"), new Position("c3"));
		chessBoard.showBoard();
		chessBoard.play(new Position("d7"), new Position("d6"));
		chessBoard.showBoard();
		chessBoard.play(new Position("c3"), new Position("h3"));
		chessBoard.showBoard();
		chessBoard.play(new Position("d6"), new Position("d5"));
		chessBoard.showBoard();
		chessBoard.play(new Position("h3"), new Position("h1"));
		chessBoard.showBoard();
		*/
		
		// Knight test
		chessBoard.play(new Position("e2"), new Position("e3"));
		chessBoard.showBoard();
		chessBoard.play(new Position("e7"), new Position("e6"));
		chessBoard.showBoard();
		chessBoard.play(new Position("g1"), new Position("e2"));
		chessBoard.showBoard();
		chessBoard.play(new Position("e6"), new Position("e5"));
		chessBoard.showBoard();
		chessBoard.play(new Position("e2"), new Position("g3"));
		chessBoard.showBoard();
		chessBoard.play(new Position("g8"), new Position("e7"));
		chessBoard.showBoard();
		chessBoard.play(new Position("b1"), new Position("a3"));
		chessBoard.showBoard();
		chessBoard.play(new Position("e5"), new Position("e4"));
		chessBoard.showBoard();
		chessBoard.play(new Position("g3"), new Position("e4"));
		chessBoard.showBoard();
		chessBoard.play(new Position("e7"), new Position("g8"));
		chessBoard.showBoard();
		chessBoard.play(new Position("a3"), new Position("b1"));
		chessBoard.showBoard();
		
		// Queen test
		
		// King test
		
	}

}
