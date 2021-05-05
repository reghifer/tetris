package modelTetris;

import tools.Coord;
import tools.SaveHandler;
import tools.Tile;

public class ModelTetris {;
	public final  float STARTING_SPEED;
	public final int width = 10,length = 20;
	public Piece currPiece, nextPiece;
	public int points;
	public float fallSpeed, hold;
	public Tile[][] grid;
	
	public ModelTetris(float fallSpeed) {
		SaveHandler.initialize();
		points = 0;
		grid = new Tile[this.width][this.length + 5];
		for(int y = 0;y < this.length + 5;y++) {
			for(int x = 0;x < this.width;x++) {
				grid[x][y] = Tile.Empty;
			}
		}
		STARTING_SPEED = fallSpeed;
		this.fallSpeed = STARTING_SPEED;
		hold = 1.0f;
		currPiece = Piece.pieceFactory(this,Tile.Empty);
		currPiece.place();
		nextPiece = Piece.pieceFactory(this,currPiece.type);
	}
	
	public void resetGame() {
		fallSpeed = STARTING_SPEED;
		points = 0;
		grid = new Tile[this.width][this.length + 5];
		for(int y = 0;y < this.length + 5;y++) {
			for(int x = 0;x < this.width;x++) {
				grid[x][y] = Tile.Empty;
			}
		}
		currPiece = Piece.pieceFactory(this,Tile.Empty);
		currPiece.place();
		nextPiece = Piece.pieceFactory(this,currPiece.type);
	}
	
	public boolean loose() {
		boolean returned = false;
		eraseCurrPiece();
		for(int y  = length;y < length + 5;y++) {
			for(int x = 0;x < width;x++) {
				if(grid[x][y] != Tile.Empty) {
					returned = true;
				}
			}
		}
		drawCurrPiece();
		return returned;
		
	}
	
	void updateGame() {
		int nbLines = 0;
		int y = 0;
		while(y < length) {
			boolean isFull = true;
			for(int x = 0;x < width;x++) {
				if(grid[x][y] == Tile.Empty) {
					isFull = false;
				}
			}
			if(isFull) {
				deleteLine(y);
				y--;
				nbLines++;
			}
			y++;
		}
		points += nbLines * nbLines * 100; 
		fallSpeed = fallSpeed - 0.005f;
		currPiece = nextPiece;
		currPiece.place();
		nextPiece = Piece.pieceFactory(this,currPiece.type);
	}
	
	boolean canGoHere(Coord tile) {
		if(tile.getValue() < 0) return false;
		if(tile.getKey() < 0 || tile.getKey() >= this.width)return false;
		return grid[tile.getKey()][tile.getValue()] == Tile.Empty;
	}
	
	void eraseCurrPiece() {
		grid[currPiece.getBlock1().getKey()][currPiece.getBlock1().getValue()] = Tile.Empty;
		grid[currPiece.getBlock2().getKey()][currPiece.getBlock2().getValue()] = Tile.Empty;
		grid[currPiece.getBlock3().getKey()][currPiece.getBlock3().getValue()] = Tile.Empty;
		grid[currPiece.getBlock4().getKey()][currPiece.getBlock4().getValue()] = Tile.Empty;
	}
	
	void drawCurrPiece() {
		grid[currPiece.getBlock1().getKey()][currPiece.getBlock1().getValue()] = currPiece.type;
		grid[currPiece.getBlock2().getKey()][currPiece.getBlock2().getValue()] = currPiece.type;
		grid[currPiece.getBlock3().getKey()][currPiece.getBlock3().getValue()] = currPiece.type;
		grid[currPiece.getBlock4().getKey()][currPiece.getBlock4().getValue()] = currPiece.type;
	}
	
	private void deleteLine(int line) {
		for(int y = line;y < length ;y++) {
			for(int x = 0;x < width ;x++) {
				grid[x][y] = grid[x][y+1];
			}
		}
	}
}
