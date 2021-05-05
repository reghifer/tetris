package modelTetris;

import tools.*;

public class TPiece extends Piece{

	public TPiece(ModelTetris grid) {
		super(grid, Tile.T);
	}

	@Override
	public void place() {
		this.center = new Coord(5,22);
		this.block1 = new Coord(5,22);
		this.block2 = new Coord(4,22);
		this.block3 = new Coord(6,22);
		this.block4 = new Coord(5,21);
	}

	@Override
	public void fall() {
		boolean canFall = false;
		switch(this.rot) {
		case down:
		case top:
			canFall = grid.canGoHere(new Coord(block2.getKey(),block2.getValue() - 1));
			canFall = canFall && grid.canGoHere(new Coord(block3.getKey(),block3.getValue() - 1));
			canFall = canFall && grid.canGoHere(new Coord(block4.getKey(),block4.getValue() - 1));
			break;
		case left:
		case right:
			canFall = grid.canGoHere(new Coord(block3.getKey(),block3.getValue() - 1));
			canFall = canFall && grid.canGoHere(new Coord(block4.getKey(),block4.getValue() - 1));
			break;
		}
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
		switch(this.rot) {
		case left:
			canLeft = grid.canGoHere(new Coord(block2.getKey() - 1,block2.getValue()));
			canLeft = canLeft && grid.canGoHere(new Coord(block3.getKey() - 1,block3.getValue()));
			canLeft = canLeft && grid.canGoHere(new Coord(block4.getKey() - 1,block4.getValue()));
			break;
		case right:
			canLeft = grid.canGoHere(new Coord(block2.getKey() - 1,block2.getValue()));
			canLeft = canLeft && grid.canGoHere(new Coord(block1.getKey() - 1,block1.getValue()));
			canLeft = canLeft && grid.canGoHere(new Coord(block4.getKey() - 1,block4.getValue()));
			break;
		case down:
			canLeft = grid.canGoHere(new Coord(block2.getKey() - 1,block2.getValue()));
			canLeft = canLeft && grid.canGoHere(new Coord(block4.getKey() - 1,block4.getValue()));
			break;
		case top:
			canLeft = grid.canGoHere(new Coord(block2.getKey() - 1,block2.getValue()));
			canLeft = canLeft && grid.canGoHere(new Coord(block1.getKey() - 1,block1.getValue()));	
			break;
		}
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
		switch(this.rot) {
		case left:
			canRight = grid.canGoHere(new Coord(block2.getKey() + 1,block2.getValue()));
			canRight = canRight && grid.canGoHere(new Coord(block1.getKey() + 1,block1.getValue()));
			canRight = canRight && grid.canGoHere(new Coord(block4.getKey() + 1,block4.getValue()));
			break;
		case right:
			canRight = grid.canGoHere(new Coord(block2.getKey() + 1,block2.getValue()));
			canRight = canRight && grid.canGoHere(new Coord(block3.getKey() + 1,block3.getValue()));
			canRight = canRight && grid.canGoHere(new Coord(block4.getKey() + 1,block4.getValue()));
			break;
		case down:
			canRight = grid.canGoHere(new Coord(block3.getKey() + 1,block3.getValue()));
			canRight = canRight && grid.canGoHere(new Coord(block4.getKey() + 1,block4.getValue()));
			break;
		case top:
			canRight = grid.canGoHere(new Coord(block3.getKey() + 1,block3.getValue()));
			canRight = canRight && grid.canGoHere(new Coord(block1.getKey() + 1,block1.getValue()));	
			break;
		}
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
		grid.eraseCurrPiece();
		boolean canGo = grid.canGoHere(new Coord(center.getKey(),center.getValue() - 1));
		canGo = canGo && grid.canGoHere(new Coord(center.getKey(),center.getValue()));
		canGo = canGo && grid.canGoHere(new Coord(center.getKey() - 1,center.getValue()));
		canGo = canGo && grid.canGoHere(new Coord(center.getKey(),center.getValue() + 1));
		if(canGo) {
			block1.setKey(center.getKey());
			block1.setValue(center.getValue());
			block2.setKey(center.getKey());
			block2.setValue(center.getValue() + 1);
			block3.setKey(center.getKey() - 1);
			block3.setValue(center.getValue());
			block4.setKey(center.getKey());
			block4.setValue(center.getValue() - 1);
		}
		grid.drawCurrPiece();
		return canGo;
	}

	@Override
	protected boolean rightPos() {
		grid.eraseCurrPiece();
		boolean canGo;
		canGo = grid.canGoHere(new Coord(center.getKey(),center.getValue() - 1));
		canGo = canGo && grid.canGoHere(new Coord(center.getKey(),center.getValue()));
		canGo = canGo && grid.canGoHere(new Coord(center.getKey() + 1,center.getValue()));
		canGo = canGo && grid.canGoHere(new Coord(center.getKey(),center.getValue() + 1));
		if(canGo) {
			block1.setKey(center.getKey());
			block1.setValue(center.getValue());
			block2.setKey(center.getKey());
			block2.setValue(center.getValue() + 1);
			block3.setKey(center.getKey() + 1);
			block3.setValue(center.getValue());
			block4.setKey(center.getKey());
			block4.setValue(center.getValue() - 1);
		}
		grid.drawCurrPiece();
		return canGo;
	}

	@Override
	protected boolean topPos() {
		grid.eraseCurrPiece();
		boolean canGo = grid.canGoHere(new Coord(center.getKey() - 1,center.getValue()));
		canGo = canGo && grid.canGoHere(new Coord(center.getKey(),center.getValue()));
		canGo = canGo && grid.canGoHere(new Coord(center.getKey() + 1,center.getValue()));
		canGo = canGo && grid.canGoHere(new Coord(center.getKey(),center.getValue() + 1));
		if(canGo) {
			block1.setKey(center.getKey());
			block1.setValue(center.getValue() + 1);
			block2.setKey(center.getKey() - 1);
			block2.setValue(center.getValue());
			block3.setKey(center.getKey() + 1);
			block3.setValue(center.getValue());
			block4.setKey(center.getKey());
			block4.setValue(center.getValue());
		}
		grid.drawCurrPiece();
		return canGo;
	}

	@Override
	protected boolean downPos() {
		grid.eraseCurrPiece();
		boolean canGo = grid.canGoHere(new Coord(center.getKey() - 1,center.getValue()));
		canGo = canGo && grid.canGoHere(new Coord(center.getKey(),center.getValue()));
		canGo = canGo && grid.canGoHere(new Coord(center.getKey() + 1,center.getValue()));
		canGo = canGo && grid.canGoHere(new Coord(center.getKey(),center.getValue() - 1));
		if(canGo) {
			block1.setKey(center.getKey());
			block1.setValue(center.getValue());
			block2.setKey(center.getKey() - 1);
			block2.setValue(center.getValue());
			block3.setKey(center.getKey() + 1);
			block3.setValue(center.getValue());
			block4.setKey(center.getKey());
			block4.setValue(center.getValue() - 1);
		}
		grid.drawCurrPiece();
		return canGo;
	}

}
