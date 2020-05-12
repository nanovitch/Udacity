package ca.udacity.oopInJava.chessGame;

public class Board {
	
	private final Piece[][] board;
	
	Board(){
		// Setup an empty board
		this.board = new Piece[8][8];
	}
	
	protected void boardSetup() {
		
			// white pieces <=> color = 0
			board[7][0]= new Rock(new Position("a1"), 0); board[7][7]= new Rock(new Position("h1"), 0);
			board[7][1]= new Knight(new Position("b1"), 0); board[7][6]= new Knight(new Position("g1"), 0);
			board[7][2]= new Bishop(new Position("c1"), 0); board[7][5]= new Bishop(new Position("f1"), 0);
			board[7][3]= new Queen(new Position("d1"), 0); 
			board[7][4]= new King(new Position("e1"), 0);
			board[6][0]= new Pawn(new Position("a2"), 0); board[6][7]= new Pawn(new Position("h2"), 0);
			board[6][1]= new Pawn(new Position("b2"), 0); board[6][6]= new Pawn(new Position("g2"), 0);
			board[6][2]= new Pawn(new Position("c2"), 0); board[6][5]= new Pawn(new Position("f2"), 0);
			board[6][3]= new Pawn(new Position("d2"), 0); board[6][4]= new Pawn(new Position("e2"), 0);
			// black pieces <=> color =1
			board[0][0]= new Rock(new Position("a8"), 1); board[0][7]= new Rock(new Position("h8"), 1);
			board[0][1]= new Knight(new Position("b8"), 1); board[0][6]= new Knight(new Position("g8"), 1);
			board[0][2]= new Bishop(new Position("c8"), 1); board[0][5]= new Bishop(new Position("f8"), 1);
			board[0][3]= new Queen(new Position("d8"), 1); 
			board[0][4]= new King(new Position("e8"), 1);
			board[1][0]= new Pawn(new Position("a7"), 1); board[1][7]= new Pawn(new Position("h7"), 1);
			board[1][1]= new Pawn(new Position("b7"), 1); board[1][6]= new Pawn(new Position("g7"), 1);
			board[1][2]= new Pawn(new Position("c7"), 1); board[1][5]= new Pawn(new Position("f7"), 1);
			board[1][3]= new Pawn(new Position("d7"), 1); board[1][4]= new Pawn(new Position("e7"), 1);
		
	}
	
	public Piece getThePieceOnBoard(final Position position) {
		return board[position.getRawRow()][position.getRawCol()];
	}
	
	public void setThePieceOnBoard(final Position position, final Piece piece) {
		board[position.getRawRow()][position.getRawCol()] = piece;
	}
		
	public boolean play(final Position source, final Position dest) {
		
		Piece pieceToMove = board[source.getRawRow()][source.getRawCol()];
		
		if (pieceToMove == null) return false;
		
		// debug
		System.out.println("BOARD: " + pieceToMove.getName() + " " + + pieceToMove.getColor());
		System.out.println("Source: " + pieceToMove.getPosition().getPositionAsString());
		System.out.println("Dest: " + dest.getPositionAsString());
		// debug end
		
		// updating pieces on board
		if (pieceToMove.isValideMove(dest, this)) {
			this.setThePieceOnBoard(dest, pieceToMove);
			pieceToMove.setPosition(dest);
			this.setThePieceOnBoard(source, null);
			return true;
		}
		return false;
	}
	
	public void showBoard() {
		char[][] boardImage = new char[8][8];
		
		for (int r = 0; r < 8; r++)
			for (int c = 0; c < 8; c++) {
				if(board[r][c] == null) boardImage[r][c] = ' ';
				else if(board[r][c].getName().equals("rock")) boardImage[r][c] = 'R';
				else if(board[r][c].getName().equals("knight")) boardImage[r][c] = 'C';
				else if(board[r][c].getName().equals("bishop")) boardImage[r][c] = 'B';
				else if(board[r][c].getName().equals("queen")) boardImage[r][c] = 'Q';
				else if(board[r][c].getName().equals("king")) boardImage[r][c] = 'K';
				else if(board[r][c].getName().equals("pawn")) boardImage[r][c] = 'P';
			}
		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) System.out.print(boardImage[r][c]);
			System.out.println();
		}
	}
	
	//'D': diagonal move, 'V': vertical move, 'H': horizental move
	public boolean isThisPathClear(final Position source, final Position dest) {
		
		char moveDirection = source.moveDirection(dest); // is it a vertical, horizontal or diagonal move
		
		// debug
		System.out.println("Move direction: " + moveDirection);
		System.out.println("Source position: " + source.getPositionAsString());
		System.out.println("Dest position: " + dest.getPositionAsString());
		// debug end
		
		boolean result = true;
		int row, col, minRow, maxRow, minCol, maxCol;
		switch(moveDirection) {
		case 'D': 
			minRow = source.getRawRow();
			maxRow = dest.getRawRow();
			if (maxRow < minRow) {
				minRow = maxRow;
				maxRow = source.getRawRow();
			}
			minCol = source.getRawCol();
			maxCol = dest.getRawCol();
			if (maxCol < minCol) {
				minCol = maxCol;
				maxCol = source.getRawCol();
			}
			
			// debug
			System.out.println("minRow, minCol, maxRow, maxCol: " + minRow + ", " + minCol + ", " + maxRow + ", " + maxCol);
			// debug end
			
			for(int i = minRow+1, j = minCol+1; i < maxRow && j < maxCol; i++, j++)
				if (this.getThePieceOnBoard(new Position(i, j)) != null) result = false;
			break;
			
		case 'H': 
			row = source.getRawRow();
			minCol = source.getRawCol();
			maxCol = dest.getRawCol();
			if (maxCol < minCol) {
				minCol = maxCol;
				maxCol = source.getRawCol();
			}
			
			// debug
				System.out.println("row, minCol, maxCol: " + row + ", " + minCol + ", " +maxCol);
			// debug end
						
			for(int i = minCol+1; i < maxCol; i++)
				if (this.getThePieceOnBoard(new Position(row, i)) != null) result = false;
			break;
			
		case 'V': 
			col = source.getRawCol();
			minRow = source.getRawRow();
			maxRow = dest.getRawRow();
			if (maxRow < minRow) {
				minRow = maxRow;
				maxRow = source.getRawRow();
			}
			
			// debug
			System.out.println("col, minRow, maxRow: " + col + ", " + minRow + ", " +maxRow);
			// debug end
			
			for(int i = minRow+1; i < maxRow; i++)
				if (this.getThePieceOnBoard(new Position(i, col)) != null) result = false;
			break;
		default:
			result = false;
		}
		
		return result;
	}

}
