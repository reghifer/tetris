  package tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SaveHandler {
	public static final int NB_SCORE=5;
	private static ArrayList<Score> highScore;
	
	public static void initialize() {
		highScore = new ArrayList<Score>();
		String link = System.getProperty("user.dir") + "/src/savePackage/save.txt";
		try (BufferedReader br = new BufferedReader(new FileReader(link))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] t = line.split(",");
				highScore.add(new Score(t[0],t[1]));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		while(highScore.size() < NB_SCORE) {
			highScore.add(new Score("	","000000000"));
		}
		Score comp = new Score("score","comparator");
		highScore.sort(comp);
	}
	
	public static void update(Score newScore) {
		if(newScore.getIntVal() < highScore.get(0).getIntVal()) {
			return;
		}
		highScore.remove(0);
		highScore.add(newScore);
		try {
			String link = System.getProperty("user.dir") + "/src/savePackage/save.txt";
			FileWriter fileStream = new FileWriter(link);
			BufferedWriter out = new BufferedWriter(fileStream);
			for(Score s : highScore) {
				out.write(s.getPseudo() + "," + s.getVal() + "\n");
			}
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Score comp = new Score("score","comparator");
		highScore.sort(comp);
	}
	
	public static ArrayList<Score> getHighScore(){
		return new ArrayList<Score>(highScore);
	}
}
