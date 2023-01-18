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
				root.add(b, l, h);
				buttons.get(l).add(b);
			}
			
		}
		
		createShip(buttons, 1, 2, 2, ships);
		createShip(buttons, 1, 7, 2, ships);
		createShip(buttons, 1, 12, 3, ships);
		createShip(buttons, 12, 4, 3, ships);
		createShip(buttons, 12, 11, 4, ships);
		
		Scene scene = new Scene(root, 700, 900);
		
		for (Ship s : ships) {
			System.out.println(s);
		}
		addButtonFunctionShip(ships, buttons);
		
		stage.setScene(scene);
		stage.show();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	public static void createShip(ArrayList<ArrayList<Button>> buttons, int x, int y, int size, ArrayList<Ship> ships) {
		Ship s = new Ship(size);
		for (int i = 0; i < size; i++) {
			buttons.get(x).get(y+i).setStyle("-fx-background-color: #777B7E");
			s.whereShipX(x, 0+i);
			s.whereShipY(y+i, 0+i);
		}
		
		ships.add(s);
	}
	public static void addButtonFunctionShip(ArrayList<Ship> ships, ArrayList<ArrayList<Button>> buttons) {
		for (Ship s: ships) {
			for(int i = 0; i < s.getSize(); i++) {
				int u = i;
				buttons.get(s.getXCoord(i)).get(s.getYCoord(i)).setOnAction(e -> {
					if (s.isSelected()) {
						s.updateSelected();
						for (int v = 0; v < s.getSize(); v++) {
							buttons.get(s.getXCoord(v)).get(s.getYCoord(v)).setStyle("-fx-background-color: #777B7E");
						}
					} else {
						s.updateSelected();
						for (int v = 0; v < s.getSize(); v++) {
							buttons.get(s.getXCoord(v)).get(s.getYCoord(v)).setStyle("-fx-background-color: #777B7E; -fx-border-color: #e5de00");
						}
					}
					
				});
			}
		}
	}

}
