package controllerTetris;

import modelTetris.ModelTetris;
import tetrisWindow.TetrisFrame;

public class Game {
	public static void main(String[] args) {
		ModelTetris md = new ModelTetris(0.6f);
		TetrisFrame tf = new TetrisFrame(md);
		GameController gc = new GameController(md,tf);
		gc.instanciateGameEvents();
	}
}
