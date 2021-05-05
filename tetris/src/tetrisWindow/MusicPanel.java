package tetrisWindow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

@SuppressWarnings("serial")
public class MusicPanel extends JPanel{
	private JButton backToMenuBtn, playBtn, stopBtn;
	private JSlider sliderVolume;
	private JLabel soundpercent;
	private JComboBox<String> musicSelector;
	public MusicPanel() {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.gray);
		
		this.add(new JLabel("   "),BorderLayout.NORTH);
		this.add(new JLabel("   "),BorderLayout.SOUTH);
		this.add(new JLabel("     "),BorderLayout.EAST);
		this.add(new JLabel("     "),BorderLayout.WEST);
		
		JPanel menu = new JPanel();
		menu.setBackground(Color.black);
		menu.setLayout(new GridLayout(7,1,0,5));
		
		JLabel menuTitle = new JLabel("Music");
		menuTitle.setFont(new Font("Bauhaus 93",Font.BOLD,45));
		menuTitle.setForeground(Color.white);
		menuTitle.setHorizontalAlignment(JLabel.CENTER);
		menu.add(menuTitle);
		
		JLabel sliderSoundLbl = new JLabel();
		sliderSoundLbl.setLayout(new BorderLayout());
		JLabel soundlbl = new JLabel("Sound :");
		soundlbl.setForeground(Color.white);
		soundlbl.setFont(new Font("Bauhaus 93",Font.BOLD,20));
		sliderSoundLbl.add(soundlbl,BorderLayout.WEST);
		sliderVolume = new JSlider(30,100,60);
		sliderVolume.setBackground(Color.BLACK);
		sliderSoundLbl.add(sliderVolume,BorderLayout.CENTER);
		soundpercent = new JLabel("50%");
		soundpercent.setForeground(Color.white);
		soundpercent.setFont(new Font("Bauhaus 93",Font.BOLD,20));
		sliderSoundLbl.add(soundpercent,BorderLayout.EAST);
		menu.add(sliderSoundLbl);
		
		backToMenuBtn = new JButton("back");
		backToMenuBtn.setBackground(Color.black);
		backToMenuBtn.setFont(new Font("Bauhaus 93",Font.BOLD,20));
		backToMenuBtn.setForeground(Color.white);
		menu.add(backToMenuBtn);
		
		String link = System.getProperty("user.dir") + "/src/musicPackage";
		File directoryPath = new File(link);
	    String[] contents = directoryPath.list();
	    
		musicSelector = new JComboBox<String>();
		musicSelector.setBackground(Color.black);
		musicSelector.setFont(new Font("Bauhaus 93",Font.BOLD,20));
		musicSelector.setForeground(Color.white);
		for(String item : contents) {
			musicSelector.addItem(item);
		}
		menu.add(musicSelector);

		playBtn = new JButton("play");
		playBtn.setBackground(Color.black);
		playBtn.setFont(new Font("Bauhaus 93",Font.BOLD,20));
		playBtn.setForeground(Color.white);
		menu.add(playBtn);
		
		stopBtn = new JButton("stop");
		stopBtn.setBackground(Color.black);
		stopBtn.setFont(new Font("Bauhaus 93",Font.BOLD,20));
		stopBtn.setForeground(Color.white);
		menu.add(stopBtn);
		
		this.add(menu,BorderLayout.CENTER);
		this.setBounds(13,40,350,400);
	}
	public JButton getBackToMenuBtn() {
		return backToMenuBtn;
	}
	public JButton getPlayBtn() {
		return playBtn;
	}
	public JButton getStopBtn() {
		return stopBtn;
	}
	public JSlider getSliderVolume() {
		return sliderVolume;
	}
	public void SetVolumeText() {
		int val = sliderVolume.getValue();
		soundpercent.setText(val + "%");
	}
	public String getSelectedMusic() {
		return (String)musicSelector.getSelectedItem();
	}
}
