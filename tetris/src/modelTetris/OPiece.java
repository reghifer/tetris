package modelTetris;

import tools.Coord;
import tools.Tile;

public class OPiece extends Piece{

	public OPiece(ModelTetris grid) {
		super(grid, Tile.O);
	}

	@Override
	public void place() {
		this.center = new Coord(4,22);
		this.block1 = new Coord(4,21);
		this.block2 = new Coord(4,22);
		this.block3 = new Coord(5,21);
		this.block4 = new Coord(5,22);
		this.grid.drawCurrPiece();
	}

	@Override
	public void fall() {
		boolean canFall = false;
		canFall = grid.canGoHere(new Coord(block1.getKey(),block1.getValue() - 1));
		canFall = canFall && grid.canGoHere(new Coord(block3.getKey(),block3.getValue() - 1));
		if(canFall) {
			grid.eraseCurrPiece();
			center.down();
			block1.down();
			block2.down();
			block3.down();
			block4.down();
			grid.drawCurrPiece();
		}else {
			grid.updateGame();
		}
		
	}

	@Override
	public void left() {
		boolean canLeft = false;
		canLeft = grid.canGoHere(new Coord(block2.getKey() - 1,block2.getValue()));
		canLeft = canLeft && grid.canGoHere(new Coord(block1.getKey() - 1,block1.getValue()));
		if(canLeft) {
			grid.eraseCurrPiece();
			center.left();
			block1.left();
			block2.left();
			block3.left();
			block4.left();
			grid.drawCurrPiece();
		}
	}

	@Override
	public void right() {
		boolean canRight = false;
		canRight = grid.canGoHere(new Coord(block3.getKey() + 1,block3.getValue()));
		canRight = canRight && grid.canGoHere(new Coord(block4.getKey() + 1,block4.getValue()));
		if(canRight) {
			grid.eraseCurrPiece();
			center.right();
			block1.right();
			block2.right();
			block3.right();
			block4.right();
			grid.drawCurrPiece();
		}
		
	}

	@Override
	protected boolean leftPos() {
		return false;
	}

	@Override
	protected boolean rightPos() {
		return false;
	}

	@Override
	protected boolean topPos() {
		return false;
	}

	@Override
	protected boolean downPos() {
		return false;
	}

}
