package tetrisWindow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GameOverPanel extends JPanel{
	private JButton saveBtn;
	private JLabel scoreLbl;
	private JTextField pseudoTxt;
	
	public GameOverPanel() {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.gray);
		
		this.add(new JLabel("   "),BorderLayout.NORTH);
		this.add(new JLabel("   "),BorderLayout.SOUTH);
		this.add(new JLabel("     "),BorderLayout.EAST);
		this.add(new JLabel("     "),BorderLayout.WEST);
		
		JPanel menu = new JPanel();
		menu.setBackground(Color.black);
		menu.setLayout(new GridLayout(7,1,0,5));
		
		JLabel menuTitle = new JLabel("Game over");
		menuTitle.setFont(new Font("Bauhaus 93",Font.BOLD,45));
		menuTitle.setForeground(Color.white);
		menuTitle.setHorizontalAlignment(JLabel.CENTER);
		menu.add(menuTitle);
		
		JLabel typeScoreLbl = new JLabel("your score:");
		typeScoreLbl.setFont(new Font("Bauhaus 93",Font.BOLD,25));
		typeScoreLbl.setForeground(Color.white);
		typeScoreLbl.setHorizontalAlignment(JLabel.CENTER);
		menu.add(menuTitle);
		
		scoreLbl = new JLabel("000000000");
		scoreLbl.setFont(new Font("Bauhaus 93",Font.BOLD,25));
		scoreLbl.setForeground(Color.white);
		scoreLbl.setHorizontalAlignment(JLabel.CENTER);
		menu.add(scoreLbl);
		
		JLabel typePseudoLbl = new JLabel("type your pseudo :");
		typePseudoLbl.setFont(new Font("Bauhaus 93",Font.BOLD,25));
		typePseudoLbl.setForeground(Color.white);
		typePseudoLbl.setHorizontalAlignment(JLabel.CENTER);
		menu.add(typePseudoLbl);
		
		pseudoTxt = new JTextField();
		pseudoTxt.setFont(new Font("Bauhaus 93",Font.BOLD,25));
		pseudoTxt.setForeground(Color.white);
		pseudoTxt.setBackground(Color.BLACK);
		pseudoTxt.setHorizontalAlignment(JLabel.CENTER);
		menu.add(pseudoTxt);
		
		saveBtn = new JButton("save");
		saveBtn.setBackground(Color.black);
		saveBtn.setFont(new Font("Bauhaus 93",Font.BOLD,20));
		saveBtn.setForeground(Color.white);
		menu.add(saveBtn);
		
		this.add(menu,BorderLayout.CENTER);
		this.setBounds(13,40,350,400);
	}
	
	public void setScore(int score) {
		String s = "" + score;
		while(s.length() < 9)s = "0" + s;
		scoreLbl.setText(s);
	}
	public JButton getSaveBtn() {
		return saveBtn;
	}

	public JLabel getScoreLbl() {
		return scoreLbl;
	}

	public JTextField getPseudoTxt() {
		return pseudoTxt;
	}
	
	
}
