package drake.rafe;

import java.util.ArrayList;
/**
 * Player class
 * MOdels player and holds player information
 * @author Rafe and Ethan
 *
 */
public class Player {
	private ArrayList<Ship> ships;
	private int[][] shots = new int[7][7]; 
	Player() {
		ships = new ArrayList<>();
	}
	/**
	 * Adds ship to player
	 * @param ship - the ship to be added
	 */
	public void addShip(Ship ship) {
		ships.add(ship);
	}
	public ArrayList<Ship> getShips() {
		return ships;
	}
	public boolean ifLost() {
		for (Ship s : ships) {
			if (!s.getSunk()) {
				return false;
			}
		}
		return true;
	}
	public int[][] getShots() {
		return shots;
	}
	public void shoot(boolean hit) {
		for (int i = 0; i < 7; i++) {
			for (int l = 0; l < 7; l++) {
				if (shots[i][l] == 1) {
					if (hit) {
						shots[i][l] = 2;
					} else {
						shots[i][l] = 3;
					}
				}
			}
		}
	}
	public void tempShot(int x, int y) {
		for (int i = 0; i < 7; i++) {
			for (int l = 0; l < 7; l++) {
				if (shots[i][l] == 1) {
					shots[i][l] = 0;
				}
			}
		}
		if (shots[x][y] != 2) {
			shots[x][y] = 1;
		}
	}
	public int getShot(int x, int y) {
		return shots[x][y];
	}
	

}
