package ca.udacity.oopInJava.chessGame;

import java.util.HashMap;

public class Position {
	
	private final int rawRow;
	private final int rawCol;
	private final String positionAsString;
	
	private HashMap<String, Integer> convertCol = new HashMap<String, Integer>() {{put("a", 0); put("b", 1); put("c", 2); put("d", 3); put("e", 4); put("f", 5); put("g", 6); put("h", 7);}};
	
	private final int MAX_ROW = 8;
	private final int MAX_COL = 8;
	private final int MIN_ROW = 1;
	private final int MIN_COL = 1;
	
	Position(String s){
		
		// debug
		assert(s.length()==2):"INVALID POSITION STRING";
		// debug end
		
		String col = s.substring(0,  1);
		int row = Character.getNumericValue(s.charAt(1));
		
		// debug
		assert(convertCol.containsKey(col) && row >= MIN_ROW && row <= MAX_ROW):"INVALID POSITION STRING";
		// debug end
		
		positionAsString = s;
		this.rawRow = MAX_ROW-row;
		this.rawCol = convertCol.get(col);
	}
	
	Position(int rawRow, int rawCol){
		// debug
		assert(rawRow>=MIN_ROW-1 && rawRow<MAX_ROW && rawCol>=MIN_COL-1 && rawCol<MAX_COL):"INVALID POSITION ARGUMENTS";
		// debug end
		
		this.rawRow = rawRow;
		this.rawCol = rawCol;
		
		String key = "";
		for (String k: convertCol.keySet()) 
			if (convertCol.get(k) == this.rawCol) key = k;
		
		// debug
		assert(convertCol.containsKey(key)):"INVALID KEY";
		// debug end
		
		this.positionAsString = key + this.rawRow;
	}
	
	public final String getPositionAsString() {
		return this.positionAsString;
	}
	
	public final int getRawRow() {
		return this.rawRow;
	}
	
	public final int getRawCol() {
		return this.rawCol;
	}
	
	public final boolean isInBoardMove(){
		return (this.rawRow >= MIN_ROW-1 && this.rawCol >= MIN_COL-1 && this.rawRow < MAX_ROW && this.rawCol < MAX_COL);
	}
	
	public char kindOfMove(Position dest) { //'D': diagonal move, 'V': vertical move, 'H': horizental move, 'C': knight move, 'K': king move, , 'E': error
		int srcRow = this.getRawRow();
		int destRow = dest.getRawRow();
		int srcCol = this.getRawCol();
		int destCol = dest.getRawCol();
		char result = 'E'; // error
		
		if ((Math.abs(destCol - srcCol) == 2 && Math.abs(destRow - srcRow) == 1) || (Math.abs(destCol - srcCol) == 1 && Math.abs(destRow - srcRow) == 2)) result = 'C';
		if (Math.abs(destCol - srcCol) == Math.abs(destRow - srcRow)) result = 'D';
		if (destCol == srcCol) result = 'V';
		if (destRow == srcRow) result = 'H';
		
		//if ( (Math.abs(destCol - srcCol) == 1 && (destRow == srcRow)) || (Math.abs(destRow - srcRow) == 1 && (destCol == srcCol)) || (Math.abs(destCol - srcCol) == 1 && Math.abs(destRow - srcRow) == 1)) return 'K';
		
		return result;
	}
	
	
	

}
