package drake.rafe;


import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


//Buttons are 50, 50
//14 button width, 18 button height
public class ShipDriver extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		GridPane root = new GridPane();
		ArrayList<ArrayList<Button>> buttons = new ArrayList<>();
		ArrayList<Ship> ships = new ArrayList<>();
		for (int i = 0; i < 18; i++) {
			ArrayList<Button> arr = new ArrayList<>();
			buttons.add(arr);
		}
		Player playerOne = new Player();
		Player playerTwo = new Player();
		int o = 1;
		int y = 1;
		int u = 1;
		int e = 1;
		for (int l = 0; l < 14; l++) {
			for (int h = 0; h < 18; h++) {
				Button b = new Button();
				b.setPrefSize(50, 50);
				b.setStyle("-fx-background-color: #0747a1");
				if ((h <= 7 || h >= 10) && l >= 3 && l <= 10) {
					b.setStyle("-fx-background-color: #1a8ae5; -fx-border-color: #000000");
				}
				if (l == 3 && ((h > 0 && h < 8))) { 
					b.setText(String.valueOf((char)(o + 64)));
					b.setStyle("-fx-background-color: #1a8ae5; -fx-border-color: #000000; -fx-font-size: 20px");
					o++;
				}
				if (l == 3 && h > 10) {
					b.setText(String.valueOf((char)(y + 64)));
					b.setStyle("-fx-background-color: #1a8ae5; -fx-border-color: #000000; -fx-font-size: 20px");
					y++;
				}
				if (h == 0 && (l > 3 && l <= 10)) {
					b.setText(Integer.toString(u));
					b.setStyle("-fx-background-color: #1a8ae5; -fx-border-color: #000000; -fx-font-size: 20px");
					u++;
				}
				if (h == 10 && (l > 3 && l <= 10)) {
					b.setText(Integer.toString(e));
					b.setStyle("-fx-background-color: #1a8ae5; -fx-border-color: #000000; -fx-font-size: 20px");
					e++;
				}
				if(h == 16 && l ==12) {
					b.setStyle("-fx-background-color: #FF4500; -fx-font-size:11");
					b.setText("lock in");		
				}
				root.add(b, l, h);
				buttons.get(l).add(b);
			}
			
		}
		
		createShip(buttons, 1, 2, 2, playerOne);
		createShip(buttons, 1, 7, 2, playerOne);
		createShip(buttons, 1, 12, 3, playerOne);
		createShip(buttons, 12, 4, 3, playerOne);
		createShip(buttons, 12, 11, 4, playerOne);
		createShip(buttons, 1, 2, 2, playerTwo);
		createShip(buttons, 1, 7, 2, playerTwo);
		createShip(buttons, 1, 12, 3, playerTwo);
		createShip(buttons, 12, 4, 3, playerTwo);
		createShip(buttons, 12, 11, 4, playerTwo);
		Scene scene = new Scene(root, 700, 900);
		addButtonFunctionShip(playerOne, buttons);
		placeShips(buttons, playerOne);
		
		
		stage.setScene(scene);
		stage.show();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	public static void createShip(ArrayList<ArrayList<Button>> buttons, int x, int y, int size, Player player) {
		Ship s = new Ship(size);
		for (int i = 0; i < size; i++) {
			buttons.get(x).get(y+i).setStyle("-fx-background-color: #777B7E");
			s.whereShipX(x, 0+i);
			s.whereShipY(y+i, 0+i);
		}
		
		player.addShip(s);
	}
	public static void addButtonFunctionShip(Player playerOne, ArrayList<ArrayList<Button>> buttons) {
		for (Ship s: playerOne.getShips()) {
			for(int i = 0; i < s.getSize(); i++) {
				int u = i;
				buttons.get(s.getXCoord(i)).get(s.getYCoord(i)).setOnAction(e -> {
					if (s.isSelected()) {
						s.updateSelected();
						for (int v = 0; v < s.getSize(); v++) {
							buttons.get(s.getXCoord(v)).get(s.getYCoord(v)).setStyle("-fx-background-color: #777B7E");
						}
					} else {
						for (Ship y : playerOne.getShips()) {
							if (y.isSelected()) {
								y.updateSelected();
								for (int v = 0; v < y.getSize(); v++) {
									buttons.get(y.getXCoord(v)).get(y.getYCoord(v)).setStyle("-fx-background-color: #777B7E");
								}
							}
						}
						s.updateSelected();
						for (int v = 0; v < s.getSize(); v++) {
							buttons.get(s.getXCoord(v)).get(s.getYCoord(v)).setStyle("-fx-background-color: #777B7E; -fx-border-color: #e5de00");
						}
					}
					
				});
			}
		}
	}
	public static void playerTurn(Player playerOne, Player playerTwo, ArrayList<ArrayList<Button>> buttons) {
		if (playerOne.ifLost()) {
			won(buttons);
		}
		int o = 1;
		int y = 1;
		int u = 1;
		int e = 1;
		for (int l = 0; l < 14; l++) {
			for (int h = 0; h < 18; h++) {
				Button b = buttons.get(l).get(h);
				if ((h <= 7 || h >= 10) && l >= 3 && l <= 10) {
					b.setStyle("-fx-background-color: #1a8ae5; -fx-border-color: #000000");
				}
				if (l == 3 && ((h > 0 && h < 8))) { 
					b.setText(String.valueOf((char)(o + 64)));
					b.setStyle("-fx-background-color: #1a8ae5; -fx-border-color: #000000; -fx-font-size: 20px");
					o++;
				}
				if (l == 3 && h > 10) {
					b.setText(String.valueOf((char)(y + 64)));
					b.setStyle("-fx-background-color: #1a8ae5; -fx-border-color: #000000; -fx-font-size: 20px");
					y++;
				}
				if (h == 0 && (l > 3 && l <= 10)) {
					b.setText(Integer.toString(u));
					b.setStyle("-fx-background-color: #1a8ae5; -fx-border-color: #000000; -fx-font-size: 20px");
					u++;
				}
				if (h == 10 && (l > 3 && l <= 10)) {
					b.setText(Integer.toString(e));
					b.setStyle("-fx-background-color: #1a8ae5; -fx-border-color: #000000; -fx-font-size: 20px");
					e++;
				}
				if(h == 16 && l ==12) {
					b.setStyle("-fx-background-color: #FF4500; -fx-font-size:11");
					b.setText("lock in");		
				}
			}
		}
		for (Ship s: playerOne.getShips()) {
			for(int i = 0; i < s.getSize(); i++) {
				buttons.get(s.getXCoord(i)).get(s.getYCoord(i)).setStyle("-fx-background-color: #777B7E");
			}
		}
		
		playerTurn(playerTwo, playerOne, buttons);
		
	}
	public static void won(ArrayList<ArrayList<Button>> buttons) {
		for(ArrayList<Button> arr : buttons) {
			for (Button b : arr) {
				b.setStyle("-fx-background-color: #000000");
			}
		}
	}
	public static void placeShips(ArrayList<ArrayList<Button>> buttons, Player player) {
		for (int i = 4; i < 11; i++) {
			for (int y = 11; y <= 17; y++) {
				int w = i;
				int z = y;
				buttons.get(i).get(y).setOnAction(e -> {
					for (Ship s : player.getShips()) {
						if (s.isSelected()) {
							if (s.isVertical()) {
								for (int l = 0; l < s.getSize(); l++) {
									buttons.get(w-l).get(z).setStyle("-fx-background-color: #777B7E");
								}
							}
						}
					}
				});
			}
		}
	}

}
