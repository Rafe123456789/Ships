package drake.rafe;

import java.util.ArrayList;
/**
 * Ship class
 * Models ship and holds battleship information
 * @author Rafe and Ethan
 * 
 */
public class Ship {
	private int size;
	private boolean[] hit;
	private boolean isSunk = false;
	private int xCoord;
	private int yCoord;
	private boolean originalPos = true;
	private boolean isSelected = false;;
	private int orientation = 0;
	
	Ship(int n, int x, int y) {
		size = n;
		hit = new boolean[n];
		xCoord = x;
		yCoord = y;
	}
	/**
	 * Checks if the is sunk
	 */
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
	/**
	 * updates the x cord of ship
	 * @param x - the x level of ship
	 */
	public void updateX(int x) {
		originalPos = false;
		xCoord = x;
	}
	/**
	 * updates the y cord of the ship
	 * @param y - the y level of the ship
	 */
	public void updateY(int y) {
		originalPos = false;
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
				s += " it is currently at the coordinates: (" + Integer.toString(xCoord) + ", " + Integer.toString(yCoord-i) + "), ";
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
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Ship) {
			Ship s1 = (Ship) obj;
			if (s1.getSize() == size && s1.getXCoord() == xCoord && s1.getYCoord() == yCoord) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isOriginal() {
		if (originalPos) {
			return true;
		}
		return false;
	}
}
