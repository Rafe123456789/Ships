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

//REWRITE ALL THE METHODS WITH NEW PRACTICE OF CHECKING SINGULAR X AND Y AND GOING BASED ON ORIENTATION

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
					b.setText(String.valueOf((char) (o + 64)));
					b.setStyle("-fx-background-color: #1a8ae5; -fx-border-color: #000000; -fx-font-size: 20px");
					o++;
				}
				if (l == 3 && h > 10) {
					b.setText(String.valueOf((char) (y + 64)));
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
				if (h == 16 && l == 12) {
					b.setStyle("-fx-background-color: #FF4500; -fx-font-size:11");
					b.setText("lock in");
				}
				root.add(b, l, h);
				buttons.get(l).add(b);
			}

		}

		createShip(1, 2, 2, playerOne);
		createShip(1, 7, 2, playerOne);
		createShip(1, 12, 3, playerOne);
		createShip(12, 4, 3, playerOne);
		createShip(12, 11, 4, playerOne);
		
		Scene scene = new Scene(root, 700, 900);
		addButtonFunctionShip(playerOne, buttons);
		colorMap(buttons, playerOne);

		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
//updated
	public static void createShip(int x, int y, int size, Player player) {
		Ship s = new Ship(size, x, y);
		player.addShip(s);
	}
//updated
	public static void addButtonFunctionShip(Player player, ArrayList<ArrayList<Button>> buttons) {
		for (int w = 0; w < 13; w++) {
			for (int h = 0; h < 18; h++) {
					int u = w;
					int t = h;
					buttons.get(w).get(h).setOnAction(e -> {
						for(Ship s1 : player.getShips()) {
							if (s1.isSelected() && u > 3 && u < 11 && t > 10) {
								int x1 = s1.getXCoord();
								int y1 = s1.getYCoord();
								if (t < 11 + s1.getSize()) {
									s1.updateX(u);
									s1.updateY(t+s1.getSize()-1);
								} else {
									s1.updateX(u);
									s1.updateY(t);
								}
								for (Ship s2 : player.getShips()) {
									for (int i = 0; i < s1.getSize(); i++) {
										for (int q = 0; q < s2.getSize(); q++) {
											if (!s1.equals(s2) && s1.getXCoord() == s2.getXCoord() && s1.getYCoord()-i == s2.getYCoord()-q) {
												s1.updateX(x1);
												s1.updateY(y1);
											}
										}
									}
								}
								s1.updateSelected();
								colorMap(buttons, player);
							}
						}
					});
				
			}
		}
		
		for (int w = 0; w < 14; w++) {
			for (int h = 0; h < 18; h++) {
				for (Ship s : player.getShips()) {
					if (s.isVertical() && ((s.getXCoord() == w && s.getYCoord() == h) || (s.getXCoord() == w && s.getYCoord()-1 == h) || (s.getXCoord() == w && s.getYCoord()-2 == h && s.getSize() > 2) || (s.getXCoord() == w && s.getYCoord()-3 == h && s.getSize() > 3))) {
						buttons.get(w).get(h).setOnAction(e -> {
							
							if (s.isSelected()) {
								s.updateSelected();
								colorMap(buttons, player);
							} else {
								for (Ship u : player.getShips()) {
									if (u.isSelected()) {
										u.updateSelected();
									}
								}
								s.updateSelected();
								colorMap(buttons, player);
							}
						});
					} 
				}
			}
			
		}
		
	}

	public static void playerTurn(Player playerOne, Player playerTwo, ArrayList<ArrayList<Button>> buttons) {
		if (playerOne.ifLost()) {
			won(buttons);
		}

		playerTurn(playerTwo, playerOne, buttons);

	}

	public static void won(ArrayList<ArrayList<Button>> buttons) {
		for (ArrayList<Button> arr : buttons) {
			for (Button b : arr) {
				b.setStyle("-fx-background-color: #000000");
			}
		}
	}

	

	public static void colorMap(ArrayList<ArrayList<Button>> buttons, Player player) {
		int o = 1;
		int y = 1;
		int u = 1;
		int e = 1;
		for (int l = 0; l < 14; l++) {
			for (int h = 0; h < 18; h++) {
				Button b = buttons.get(l).get(h);
				b.setStyle("-fx-background-color: #0747a1");
				if ((h <= 7 || h >= 10) && l >= 3 && l <= 10) {
					b.setStyle("-fx-background-color: #1a8ae5; -fx-border-color: #000000");
				}
				if (l == 3 && ((h > 0 && h < 8))) {
					b.setText(String.valueOf((char) (o + 64)));
					b.setStyle("-fx-background-color: #1a8ae5; -fx-border-color: #000000; -fx-font-size: 20px");
					o++;
				}
				if (l == 3 && h > 10) {
					b.setText(String.valueOf((char) (y + 64)));
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
				if (h == 16 && l == 12) {
					b.setStyle("-fx-background-color: #FF4500; -fx-font-size:11");
					b.setText("lock in");
				}
			}
		}
		for (Ship s : player.getShips()) {
			for (int i = 0; i < s.getSize(); i++) {
				if (s.isVertical()) {
					if (s.isSelected()) {
						buttons.get(s.getXCoord()).get(s.getYCoord() - i).setStyle("-fx-background-color: #777B7E; -fx-border-color: #e5de00");
					} else {
						buttons.get(s.getXCoord()).get(s.getYCoord() - i).setStyle("-fx-background-color: #777B7E");
					}
				} else {
					if (s.isSelected()) {
						buttons.get(s.getXCoord()+i).get(s.getYCoord()).setStyle("-fx-background-color: #777B7E; -fx-border-color: #e5de00; -fx-border-color: #e5de00");
					} else {
						buttons.get(s.getXCoord()+i).get(s.getYCoord()).setStyle("-fx-background-color: #777B7E");
					}
				}
			}
		}
		addButtonFunctionShip(player, buttons);
	}
}
