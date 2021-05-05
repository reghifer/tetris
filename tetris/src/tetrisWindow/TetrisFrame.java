package tetrisWindow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import modelTetris.ModelTetris;
import tools.*;

@SuppressWarnings("serial")
public class TetrisFrame extends JFrame{
	private ModelTetris model;
	private TetrisGridPanel grid;
	private JPanel[][] nextPieceGrid;
	private JLabel highScorevalueLbl, scorevalueLbl;
	private JButton menuBtn;
	private MenuPanel menuPnl;
	private MusicPanel musicPnl;
	private ScorePanel scorePnl;
	private JLayeredPane windowPanel;
	private GameOverPanel gameOverPanel;
	
	public TetrisFrame(ModelTetris model) {
		super();
		this.model = model;
		
		windowPanel = new JLayeredPane();
		windowPanel.setPreferredSize(new Dimension(375,515));
		windowPanel.setOpaque(true);
		JPanel gamePanel = new JPanel();
		gamePanel.setLayout(new BorderLayout());
		grid = new TetrisGridPanel(model.width,model.length);
		gamePanel.add(grid,BorderLayout.CENTER);
		
		JPanel right = new JPanel(new BorderLayout());
		
		menuBtn = new JButton("menu");
		menuBtn.setBackground(Color.black);
		menuBtn.setForeground(Color.white);
		menuBtn.setPreferredSize(new Dimension(90,20));
		right.add(menuBtn,BorderLayout.NORTH);
		
		JPanel rightinfo = new JPanel(new GridLayout(6,1));
		
		JLabel nextPiece = new JLabel("Next Piece :");
		nextPiece.setPreferredSize(new Dimension(90,40));
		rightinfo.add(nextPiece);
		
		JPanel nextPiecePanel = new JPanel();
		nextPiecePanel.setLayout(new GridLayout(5,5));
		nextPieceGrid = new JPanel[5][5];
		for (int y = 0;y < 5;y++) {
			for (int x = 0;x < 5;x++) {
				nextPieceGrid[x][y] = new JPanel();
				nextPieceGrid[x][y].setBackground(Color.black);
				nextPiecePanel.add(nextPieceGrid[x][y]);
			}
		}
		nextPiecePanel.setPreferredSize(new Dimension(90,90));
		rightinfo.add(nextPiecePanel);
		
		JPanel scorePanel = new JPanel();
		scorePanel.setLayout(new GridLayout(4,1));
		JLabel highScoreLabel = new JLabel("high score : ");
		scorePanel.add(highScoreLabel);
		Score s = SaveHandler.getHighScore().get(SaveHandler.NB_SCORE - 1);
		highScorevalueLbl = new JLabel(s.getVal());
		scorePanel.add(highScorevalueLbl);
		JLabel scoreLabel = new JLabel("current score : ");
		scorePanel.add(scoreLabel);
		scorevalueLbl = new JLabel("000000000");
		scorePanel.add(scorevalueLbl);
		scorePanel.setPreferredSize(new Dimension(90,200));
		rightinfo.add(scorePanel);
		right.add(rightinfo, BorderLayout.CENTER);
		
		gamePanel.add(right,BorderLayout.EAST);
		gamePanel.setBounds(1,4,375,515);
		windowPanel.add(gamePanel, Integer.valueOf(1));
		
		scorePnl = new ScorePanel();
		windowPanel.add(scorePnl, Integer.valueOf(2));
		scorePnl.setVisible(false);
		
		menuPnl = new MenuPanel();
		windowPanel.add(menuPnl, Integer.valueOf(2));
		menuPnl.setVisible(false);
		
		musicPnl = new MusicPanel();
		windowPanel.add(musicPnl, Integer.valueOf(3));
		musicPnl.setVisible(false);
		
		gameOverPanel = new GameOverPanel();
		windowPanel.add(gameOverPanel, Integer.valueOf(3));
		gameOverPanel.setVisible(false);
		
		this.add(windowPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(393,555);
		this.setResizable(false);
		this.setTitle("tetris");
		this.setVisible(true);
	}

	public void update() {
		String sScore = Integer.toString(model.points);
		while(sScore.length() < 9) {
			sScore = "0" + sScore;
		}
		scorevalueLbl.setText(sScore);
		if(model.points > Integer.parseInt(highScorevalueLbl.getText())) {
			highScorevalueLbl.setText(sScore);
		}
		grid.updateGame(model.grid);
		updateNextPiece();
	}
	
	public void updateHighScore() {
		Score s = SaveHandler.getHighScore().get(SaveHandler.NB_SCORE - 1);
		highScorevalueLbl.setText(s.getVal());
	}
	
	
	
	public JButton getMenuBtn() {
		return menuBtn;
	}


	public MenuPanel getMenuPnl() {
		return menuPnl;
	}


	public MusicPanel getMusicPnl() {
		return musicPnl;
	}


	public ScorePanel getScorePnl() {
		return scorePnl;
	}

	public JLayeredPane getWindowPanel() {
		return windowPanel;
	}
	
	
	public GameOverPanel getGameOverPanel() {
		return gameOverPanel;
	}

	private void updateNextPiece() {
		for (int y = 0;y < 5;y++) {
			for (int x = 0;x < 5;x++) {
				nextPieceGrid[x][y].setBackground(Color.black);
			}
		}
		switch(model.nextPiece.type){
		case I:
			nextPieceGrid[0][2].setBackground(new Color(128,255,255));
			nextPieceGrid[1][2].setBackground(new Color(128,255,255));
			nextPieceGrid[2][2].setBackground(new Color(128,255,255));
			nextPieceGrid[3][2].setBackground(new Color(128,255,255));
			break;
		case O:
			nextPieceGrid[2][2].setBackground(new Color(255,255,51));
			nextPieceGrid[3][2].setBackground(new Color(255,255,51));
			nextPieceGrid[2][3].setBackground(new Color(255,255,51));
			nextPieceGrid[3][3].setBackground(new Color(255,255,51));
			break;
		case T:
			nextPieceGrid[2][2].setBackground(new Color(187,51,255));
			nextPieceGrid[1][2].setBackground(new Color(187,51,255));
			nextPieceGrid[2][3].setBackground(new Color(187,51,255));
			nextPieceGrid[3][2].setBackground(new Color(187,51,255));
			break;
		case S:
			nextPieceGrid[2][2].setBackground(new Color(25,255,64));
			nextPieceGrid[1][3].setBackground(new Color(25,255,64));
			nextPieceGrid[2][3].setBackground(new Color(25,255,64));
			nextPieceGrid[3][2].setBackground(new Color(25,255,64));
			break;
		case z:
			nextPieceGrid[1][2].setBackground(new Color(255,0,0));
			nextPieceGrid[2][2].setBackground(new Color(255,0,0));
			nextPieceGrid[2][3].setBackground(new Color(255,0,0));
			nextPieceGrid[3][3].setBackground(new Color(255,0,0));
			break;
		case J:
			nextPieceGrid[1][2].setBackground(new Color(0,0,255));
			nextPieceGrid[2][2].setBackground(new Color(0,0,255));
			nextPieceGrid[3][2].setBackground(new Color(0,0,255));
			nextPieceGrid[3][3].setBackground(new Color(0,0,255));
			break;
		case L:
			nextPieceGrid[1][2].setBackground(new Color(255,179,25));
			nextPieceGrid[2][2].setBackground(new Color(255,179,25));
			nextPieceGrid[3][2].setBackground(new Color(255,179,25));
			nextPieceGrid[1][3].setBackground(new Color(255,179,25));
			break;
		default:
			break;
		}
	}
}
