package drake.rafe;

import java.util.ArrayList;

public class Player {
	ArrayList<Ship> ships;
	Player() {
		ships = new ArrayList<>();
	}
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

}
