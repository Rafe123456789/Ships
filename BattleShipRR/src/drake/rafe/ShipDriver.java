package drake.rafe;


import javafx.application.Application;
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

public class ShipDriver extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		VBox root = new VBox();
		
		// hello
		GridPane topGrid = new GridPane();
		
		for (int i = 0; i < 10; i++) {
			for (int l = 0; l < 10; l++) {
				Button b = new Button();
			
				b.setPrefSize(40, 40);
				System.out.println();
				topGrid.add(b, i, l);
			}
		}
		
		root.getChildren().add(topGrid);
		
		GridPane botGrid = new GridPane();
		
		for (int i = 0; i < 10; i++) {
			for (int l = 0; l < 10; l++) {
				Button b = new Button();
				b.setPrefSize(40, 40);
				System.out.println();
				botGrid.add(b, i, l);
			}
		}
		Rectangle tx = new Rectangle(400, 100);
		root.getChildren().add(tx);
		root.getChildren().add(botGrid);
		root.setLayoutX(150);
		System.out.println(root.getLayoutX());
		Scene scene = new Scene(root, 700, 900);
		
		//Make ships
		VBox space2 = new VBox();
		Button a = new Button();
		Button b = new Button();
		space2.getChildren().addAll(a,b);
		
		VBox space3a = new VBox();
		Button a1 = new Button();
		Button b1 = new Button();
		Button c1 = new Button();
		space3a.getChildren().addAll(a1,b1,c1);
		
		VBox space3b = new VBox();
		Button a2 = new Button();
		Button b2 = new Button();
		Button c2 = new Button();
		space3b.getChildren().addAll(a2,b2,c2);
		
		VBox space3c = new VBox();
		Button a3 = new Button();
		Button b3 = new Button();
		Button c3 = new Button();
		space3c.getChildren().addAll(a3,b3,c3);
		
		VBox space4a = new VBox();
		Button a4 = new Button();
		Button b4 = new Button();
		Button c4 = new Button();
		Button d4 = new Button();
		space4a.getChildren().addAll(a1,b1,c1,d4);
		
		
		
		
		stage.setScene(scene);
		stage.show();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
