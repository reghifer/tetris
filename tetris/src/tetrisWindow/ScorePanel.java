package tetrisWindow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tools.SaveHandler;
import tools.Score;

@SuppressWarnings("serial")
public class ScorePanel extends JPanel{
	
	private JButton startButton,musicBtn,quitBtn;
	private JLabel[][] ScoreLbls;
	
	public ScorePanel() {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.gray);
		
		this.add(new JLabel("   "),BorderLayout.NORTH);
		this.add(new JLabel("   "),BorderLayout.SOUTH);
		this.add(new JLabel("     "),BorderLayout.EAST);
		this.add(new JLabel("     "),BorderLayout.WEST);
		
		JPanel menu = new JPanel();
		menu.setBackground(Color.black);
		menu.setLayout(new BorderLayout());
		
		JLabel menuTitle = new JLabel("Score");
		menuTitle.setFont(new Font("Bauhaus 93",Font.BOLD,45));
		menuTitle.setForeground(Color.white);
		menuTitle.setHorizontalAlignment(JLabel.CENTER);
		menu.add(menuTitle,BorderLayout.NORTH);
		
		JPanel scoreGridPnl = new JPanel(new GridLayout(5,2,5,5));
		scoreGridPnl.setBackground(Color.BLACK);
		ArrayList<Score> listeScore = SaveHandler.getHighScore();
		ScoreLbls = new JLabel[5][2];
		int x = 0, y = 0;
		for(int s = listeScore.size() - 1; s >= 0;s--) {
			JLabel pseudoLbl = new JLabel();
			pseudoLbl.setFont(new Font("Bauhaus 93",Font.BOLD,20));
			pseudoLbl.setForeground(Color.white);
			pseudoLbl.setHorizontalAlignment(JLabel.CENTER);
			pseudoLbl.setText(listeScore.get(s).getPseudo());
			scoreGridPnl.add(pseudoLbl);
			ScoreLbls[y][x] = pseudoLbl;
			x++;
			
			JLabel scoreLbl = new JLabel();
			scoreLbl.setFont(new Font("Bauhaus 93",Font.BOLD,20));
			scoreLbl.setForeground(Color.white);
			scoreLbl.setHorizontalAlignment(JLabel.CENTER);
			scoreLbl.setText(listeScore.get(s).getVal());
			scoreGridPnl.add(scoreLbl);
			ScoreLbls[y][x] = scoreLbl;
			x--;
			y++;
		}
		menu.add(scoreGridPnl,BorderLayout.CENTER);
		
		JPanel buttonPnl = new JPanel(new GridLayout(3,1,5,0));
		
		startButton = new JButton("play");
		startButton.setBackground(Color.black);
		startButton.setFont(new Font("Bauhaus 93",Font.BOLD,20));
		startButton.setForeground(Color.white);
		buttonPnl.add(startButton);
		
		musicBtn = new JButton("set music");
		musicBtn.setBackground(Color.black);
		musicBtn.setFont(new Font("Bauhaus 93",Font.BOLD,20));
		musicBtn.setForeground(Color.white);
		buttonPnl.add(musicBtn);
		
		quitBtn = new JButton("quit");
		quitBtn.setBackground(Color.black);
		quitBtn.setFont(new Font("Bauhaus 93",Font.BOLD,20));
		quitBtn.setForeground(Color.white);
		buttonPnl.add(quitBtn);
		
		menu.add(buttonPnl, BorderLayout.SOUTH);
		
		this.add(menu,BorderLayout.CENTER);
		this.setBounds(13,40,350,400);
	}
	
	
	public JButton getStartButton() {
		return startButton;
	}


	public JButton getMusicBtn() {
		return musicBtn;
	}


	public JButton getQuitBtn() {
		return quitBtn;
	}


	public void updateScore() {
		ArrayList<Score> listeScore = SaveHandler.getHighScore();
		int x = 0, y = 0;
		for(int s = listeScore.size() - 1; s >= 0;s--) {
			ScoreLbls[y][x].setText(listeScore.get(s).getPseudo());
			x++;
			ScoreLbls[y][x].setText(listeScore.get(s).getVal());
			x--;
			y++;
		}
	}
}
