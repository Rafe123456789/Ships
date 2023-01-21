package drake.rafe;

import java.util.ArrayList;

public class Ship {
	private int size;
	private boolean[] hit;
	private boolean isSunk = false;
	private int xCoord;
	private int yCoord;
	private boolean isSelected = false;;
	private int orientation = 0;
	
	Ship(int n, int x, int y) {
		size = n;
		hit = new boolean[n];
		xCoord = x;
		yCoord = y;
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
	public boolean getSunk() {
		return isSunk;
	}
	public void isHit(int whereHit) {
		hit[whereHit] = true;
	}
	public void updateX(int x) {
		xCoord = x;
	}
	public void whereShipY(int y, int segment) {
		yCoord = y;
	}
	public int getXCoord() {
		return xCoord;
	}
	public int getYCoord() {
		return yCoord;
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
		for (int i = 0; i < size; i++) {
			if (orientation == 0) {
				s += " it is currently at the coordinates: (" + Integer.toString(xCoord) + ", " + Integer.toString(yCoord+1) + "), ";
			} else if (orientation == 1) {
				s += " it is currently at the coordinates: (" + Integer.toString(xCoord+i) + ", " + Integer.toString(yCoord) + "), ";
			}
			
		}
		return s;
	}
	public boolean isVertical() {
		if (orientation == 0) {
			return true;
		}
		return false;
	}
}
