package drake.rafe;

public class Ship {
	private int size;
	private boolean[] hit;
	private boolean isSunk = false;
	
	Ship(int n) {
		size = n;
		hit = new boolean[n];
	}
	public void ifIsSunk() {
		for (boolean i : hit) {
			if (i == false) {
				isSunk = false;
				break;
			} else {
				isSunk = true;
			}
		}
	}
	public void isHit(int whereHit) {
		hit[whereHit] = true;
	}
}
