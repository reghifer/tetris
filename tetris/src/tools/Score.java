package tools;

import java.util.Comparator;

public class Score implements Comparator<Score> {
	private Pair<String,String> score;
	public Score(String pseudo,String val) {
		score = new Pair<String,String>(pseudo,val);
	}
	public String getPseudo() {
		return score.getKey();
	}
	public String getVal() {
		return score.getValue();
	}
	
	public int getIntVal() {
		return Integer.parseInt(getVal());
	}
	
	@Override
	public String toString() {
		String s = "Pseudo : " + score.getKey() + "\n";
		s += "score : " + score.getValue() + "\n";
		return s;
	}
	
	@Override
	public int compare(Score o1, Score o2) {
		if(o1.getIntVal() < o2.getIntVal()) {
			return -1;
		}else if(o1.getIntVal() > o2.getIntVal()) {
			return 1;
		}else return 0;
	}
}
