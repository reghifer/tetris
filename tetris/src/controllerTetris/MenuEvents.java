package controllerTetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import tetrisWindow.GameOverPanel;
import tetrisWindow.MenuPanel;
import tetrisWindow.MusicPanel;
import tetrisWindow.ScorePanel;
import tetrisWindow.TetrisFrame;
import tools.MusicDisplayer;
import tools.SaveHandler;
import tools.Score;

public class MenuEvents {
	public static void initialiseMenu(TetrisFrame frame,Timer timer) {
		GameOverPanel gameOverPanel = frame.getGameOverPanel();
		gameOverPanel.getSaveBtn().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String pseudo = gameOverPanel.getPseudoTxt().getText();
				String score = gameOverPanel.getScoreLbl().getText();
				if(!pseudo.equals("")) {
					SaveHandler.update(new Score(pseudo,score));
					frame.getGameOverPanel().setVisible(false);
					frame.getScorePnl().updateScore();
					frame.getScorePnl().setVisible(true);
				}
				
			}
		});
		
		ScorePanel scorePnl = frame.getScorePnl();
		scorePnl.getQuitBtn().addActionListener(e->{System.exit(0);});
		scorePnl.getStartButton().addActionListener(e->{
			scorePnl.setVisible(false);
			timer.start();
			frame.updateHighScore();
		});
		scorePnl.getMusicBtn().addActionListener(e->{
			frame.getMusicPnl().setVisible(true);
		});
		
		MenuPanel menuPanel = frame.getMenuPnl();
		menuPanel.getQuitBtn().addActionListener(e->{System.exit(0);});
		menuPanel.getMusicBtn().addActionListener(e->{
			frame.getMusicPnl().setVisible(true);
		});
		
		MusicPanel musicPanel = frame.getMusicPnl();
		musicPanel.getBackToMenuBtn().addActionListener(e->{musicPanel.setVisible(false);});
		musicPanel.getSliderVolume().addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				musicPanel.SetVolumeText();
				float volume = musicPanel.getSliderVolume().getValue()/100.0f;
				MusicDisplayer.setVolume(volume);
			}
			
		});
		musicPanel.getPlayBtn().addActionListener(e->{
			String music = musicPanel.getSelectedMusic();
			float volume = musicPanel.getSliderVolume().getValue()/100.0f;
			MusicDisplayer.displayMusic(music, volume);
		});
		musicPanel.getStopBtn().addActionListener(e->{
			MusicDisplayer.stopMusic();
		});
	}
}
