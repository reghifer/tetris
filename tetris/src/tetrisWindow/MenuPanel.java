package tetrisWindow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MenuPanel extends JPanel{
	
	private JButton backToGameBtn, musicBtn, quitBtn;
	public MenuPanel() {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.gray);
		
		this.add(new JLabel("   "),BorderLayout.NORTH);
		this.add(new JLabel("   "),BorderLayout.SOUTH);
		this.add(new JLabel("     "),BorderLayout.EAST);
		this.add(new JLabel("     "),BorderLayout.WEST);
		
		JPanel menu = new JPanel();
		menu.setBackground(Color.black);
		menu.setLayout(new GridLayout(7,1,0,5));
		
		JLabel menuTitle = new JLabel("Menu");
		menuTitle.setFont(new Font("Bauhaus 93",Font.BOLD,45));
		menuTitle.setForeground(Color.white);
		menuTitle.setHorizontalAlignment(JLabel.CENTER);
		menu.add(menuTitle);
		
		backToGameBtn = new JButton("back");
		backToGameBtn.setBackground(Color.black);
		backToGameBtn.setFont(new Font("Bauhaus 93",Font.BOLD,20));
		backToGameBtn.setForeground(Color.white);
		menu.add(backToGameBtn);
		
		musicBtn = new JButton("set music");
		musicBtn.setBackground(Color.black);
		musicBtn.setFont(new Font("Bauhaus 93",Font.BOLD,20));
		musicBtn.setForeground(Color.white);
		menu.add(musicBtn);
		
		quitBtn = new JButton("quit");
		quitBtn.setBackground(Color.black);
		quitBtn.setFont(new Font("Bauhaus 93",Font.BOLD,20));
		quitBtn.setForeground(Color.white);
		menu.add(quitBtn);
		
		this.add(menu,BorderLayout.CENTER);
		this.setBounds(13,40,350,400);
	}
	
	public JButton getBackToGameBtn() {
		return backToGameBtn;
	}
	public JButton getMusicBtn() {
		return musicBtn;
	}
	public JButton getQuitBtn() {
		return quitBtn;
	}

	
	
}
