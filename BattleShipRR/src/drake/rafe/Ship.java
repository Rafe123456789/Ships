package drake.rafe;

import java.util.ArrayList;

public class Ship {
	private int size;
	private boolean[] hit;
	private boolean isSunk = false;
	private int[] XCoord;
	private int[] YCoord;
	
	Ship(int n) {
		size = n;
		hit = new boolean[n];
		XCoord = new int[n];
		YCoord = new int[n];
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
	public void whereShipX(int x, int segment) {
		XCoord[segment] = x;
	}
	public void whereShipY(int y, int segment) {
		YCoord[segment] = y;
	}
}
