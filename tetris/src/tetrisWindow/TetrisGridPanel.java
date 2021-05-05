package tetrisWindow;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import tools.Tile;

@SuppressWarnings("serial")
public class TetrisGridPanel extends JPanel{
	private int width,length;
	private JPanel[][] gridPane;
	public TetrisGridPanel(int width,int length) {
		super();
		this.length = length;
		this.width = width;
		this.setBackground(Color.BLACK);
		this.setLayout(new GridLayout(length,width,1,1));
		gridPane = new JPanel[width][length];
		for(int y = length - 1; y >= 0;y--) {
			for(int x = 0;x < width;x++) {
				gridPane[x][y] = new JPanel();
				gridPane[x][y].setBackground(Color.black);
				this.add(gridPane[x][y]);
			}
		}
	}
	
	public void updateGame(Tile[][] grid) {
		for(int y = 0; y < length;y++) {
			for(int x = 0;x < width;x++) {
				switch(grid[x][y]) 
				{
				case I:
					gridPane[x][y].setBackground(new Color(128,255,255));
					break;
				case O:
					gridPane[x][y].setBackground(new Color(255,255,51));
					break;
				case T:
					gridPane[x][y].setBackground(new Color(187,51,255));
					break;
				case S:
					gridPane[x][y].setBackground(new Color(25,255,64));
					break;
				case z:
					gridPane[x][y].setBackground(new Color(255,0,0));
					break;
				case J:
					gridPane[x][y].setBackground(new Color(0,0,255));
					break;
				case L:
					gridPane[x][y].setBackground(new Color(255,179,25));
					break;
				case Empty:
					gridPane[x][y].setBackground(Color.black);
					break;
				}
			}
		}
	}
}
