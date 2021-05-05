package tools;

public class Coord extends Pair<Integer,Integer>{

	public Coord(Integer key, Integer value) {
		super(key, value);
	}
	public void down() {
		value = value - 1;
	}
	public void up() {
		value = value + 1;
	}
	public void left() {
		key = key - 1;
	}
	public void right() {
		key = key + 1;
	}
}
