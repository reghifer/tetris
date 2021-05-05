package modelTetris;

import java.util.Random;

import tools.*;

public abstract class Piece {
	protected ModelTetris grid;
	protected Coord center,block1,block2,block3,block4;
	protected Rotation rot;
	public Tile type;
	public Piece(ModelTetris grid, Tile type) {
		this.grid = grid;
		this.type = type;
		rot = Rotation.down;
	}
	
	public void rotateLeft() {
		switch(this.rot) {
		case down:
			if(leftPos()) this.rot = Rotation.left;
			break;
		case top:
			if(rightPos()) this.rot = Rotation.right;
			break;
		case left:
			if(topPos()) this.rot = Rotation.top;
			break;
		case right:
			if(downPos()) this.rot = Rotation.down;
			break;
		}
	}
	
	public void rotateRight() {
		switch(this.rot) {
		case down:
			if(rightPos()) this.rot = Rotation.right;
			break;
		case top:
			if(leftPos()) this.rot = Rotation.left;
			break;
		case left:
			if(downPos()) this.rot = Rotation.down;
			break;
		case right:
			if(topPos()) this.rot = Rotation.top;
			break;
		}
	}
	
	public abstract void place();
	public abstract void fall();
	public abstract void left();
	public abstract void right();
	protected abstract boolean leftPos();
	protected abstract boolean rightPos();
	protected abstract boolean topPos();
	protected abstract boolean downPos();
	public Coord getBlock1() {
		return new Coord(block1.getKey(),block1.getValue());
	}
	public Coord getBlock2() {
		return new Coord(block2.getKey(),block2.getValue());
	}
	public Coord getBlock3() {
		return new Coord(block3.getKey(),block3.getValue());
	}
	public Coord getBlock4() {
		return new Coord(block4.getKey(),block4.getValue());
	}
	public static Piece pieceFactory(ModelTetris grid, Tile t) {
		Random random = new Random();
        while(true) {
            int number = random.nextInt(7);
	        switch(number){
	        case 0 :
	        	if(t!=Tile.I)
	        	return new IPiece(grid);
	        	break;
	        case 1 :
	        	if(t!=Tile.O)
	        	return new OPiece(grid);
	        	break;
	        case 2 :
	        	if(t!=Tile.T)
	        	return new TPiece(grid);
	        case 3 :
	        	if(t!=Tile.S)
	        	return new SPiece(grid);
	        	break;
	        case 4 :
	        	if(t!=Tile.z)
	        	return new ZPiece(grid);
	        	break;
	        case 5 :
	        	if(t!=Tile.J)
	        	return new JPiece(grid);
	        	break;
	        case 6 :
	        	if(t!=Tile.L)
	        	return new LPiece(grid);
	        	break;
	        default:
	        	return null;
	        }
        }
	}
	
}
