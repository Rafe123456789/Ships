package drake.rafe;

import java.util.ArrayList;

public class Ship {
	private int size;
	private boolean[] hit;
	private boolean isSunk = false;
	private int[] XCoord;
	private int[] YCoord;
	private boolean isSelected = false;;
	
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
	public int getXCoord(int location) {
		return XCoord[location];
	}
	public int getYCoord(int location) {
		return YCoord[location];
	}
	public int getSize() {
		return size;
	}
	public void updateSelected() {
		isSelected = (isSelected) ? false : true;
	}
	public boolean isSelected() {
		return isSelected;
	}
	@Override
	public String toString() {
		String s = "This ship is size: " + size;
		for (int i = 0; i < XCoord.length; i++) {
			s += " it is currently at the coordinates: (" + Integer.toString(XCoord[i]) + ", " + Integer.toString(YCoord[i]) + "), ";
		}
		return s;
	}
}
