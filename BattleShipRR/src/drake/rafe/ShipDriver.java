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
		HBox root1 = new HBox();
		GridPane root = new GridPane();
		ArrayList<ArrayList<Button>> buttons = new ArrayList<>();
		for (int i = 0; i < 18; i++) {
			ArrayList<Button> arr = new ArrayList<>();
			buttons.add(arr);
		}
		for (int l = 0; l < 18; l++) {
			for (int w = 0; w < 18; w++) {
				Button b = new Button();
				b.setPrefSize(50, 50);
				root.add(b, l, w);
				buttons.get(l).add(b);
			}
			
		}
		
	
		root1.getChildren().add(root);
		
		Scene scene = new Scene(root1, 700, 900);
		
		
		
		stage.setScene(scene);
		stage.show();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
