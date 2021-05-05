package controllerTetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import modelTetris.ModelTetris;
import modelTetris.Piece;
import tetrisWindow.TetrisFrame;

public class GameController {
	private ModelTetris model;
	private TetrisFrame frame;
	private Boolean inMenu;
	private Timer timer;
	
	public GameController(ModelTetris model, TetrisFrame frame) {
		this.model = model;
		this.frame = frame;
		inMenu = false;
		this.frame.setFocusable(true);
		
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.currPiece.fall();
				frame.update();
				if(model.loose()) {
					timer.stop();
					frame.getGameOverPanel().setScore(model.points);
					model.resetGame();
					frame.update();
					frame.getGameOverPanel().setVisible(true);
				}
			}
		};
		
		timer = new Timer((int) (1000*model.fallSpeed),al);
		frame.getScorePnl().setVisible(true);
	}
	
	public void instanciateGameEvents() {
		frame.getMenuBtn().addActionListener(e->{
			inMenu = true;
			timer.stop();
			frame.getMenuPnl().setVisible(inMenu);
		});
		
		frame.getMenuPnl().getBackToGameBtn().addActionListener(e->{
			inMenu = false;
			frame.getMenuPnl().setVisible(inMenu);
			timer.restart();
		});
		frame.addKeyListener(new KeyListener(){
			@Override
			public void keyPressed(KeyEvent e) {
				if(!inMenu) {
					int KeyCode=e.getKeyCode();
					switch(KeyCode)
					 {
					     case KeyEvent.VK_X:
					     case KeyEvent.VK_UP:
					     case KeyEvent.VK_NUMPAD1:
					     case KeyEvent.VK_NUMPAD5:
					     case KeyEvent.VK_NUMPAD9:
					    	//rotation clockwise
					    	 model.currPiece.rotateRight();
					         break;
					     case KeyEvent.VK_SHIFT:
					     case KeyEvent.VK_C:
					     case KeyEvent.VK_NUMPAD0:
					    	//hold
					    	 model.hold = 2.0f;
					    	 timer.setDelay((int) (1000 * model.fallSpeed * model.hold));
					        break;
					     case KeyEvent.VK_CONTROL:
					     case KeyEvent.VK_Z:
					     case KeyEvent.VK_NUMPAD3:
					     case KeyEvent.VK_NUMPAD7:
						    //rotation counterclockwise
					    	 model.currPiece.rotateLeft();
					         break;
					     case KeyEvent.VK_ESCAPE:
					     case KeyEvent.VK_F1:
					    	 //pause
					    	 timer.stop();
					    	 inMenu = true;
					    	 frame.getMenuPnl().setVisible(true);
					         break;
					     case KeyEvent.VK_LEFT:
					     case KeyEvent.VK_NUMPAD4:
					    	 //left shift
					    	 model.currPiece.left();
					    	 break;
					     case KeyEvent.VK_RIGHT:
					     case KeyEvent.VK_NUMPAD6:
					    	//right shift
					    	 model.currPiece.right();
					    	 break;
					     case KeyEvent.VK_SPACE:
					     case KeyEvent.VK_NUMPAD8:
					    	 //hard drop
					    	 Piece p = model.currPiece;
					    	 while(model.currPiece == p) {
					    		 p.fall();
					    	 }
					    	 break;
					     case KeyEvent.VK_DOWN:
					     case KeyEvent.VK_NUMPAD2:
					    	model.currPiece.fall();
						    break;
					 }
					frame.update();
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				int KeyCode=e.getKeyCode();
				switch(KeyCode) {
				case KeyEvent.VK_SHIFT:
			    case KeyEvent.VK_C:
			    case KeyEvent.VK_NUMPAD0:
			    	//hold
			    	 model.hold = 1.0f;
			    	 timer.setDelay((int) (1000 * model.fallSpeed * model.hold));
			    	 break;
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {}
		});
		MenuEvents.initialiseMenu(frame,timer);
	}
	
}

