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
		VBox ship2 = new VBox();
		Button a = new Button();
		Button b = new Button();
		ship2.getChildren().addAll(a,b);
		
		VBox ship3a = new VBox();
		Button a1 = new Button();
		Button b1 = new Button();
		Button c1 = new Button();
		ship3a.getChildren().addAll(a1,b1,c1);
		
		VBox ship3b = new VBox();
		Button a2 = new Button();
		Button b2 = new Button();
		Button c2 = new Button();
		ship3b.getChildren().addAll(a2,b2,c2);
		
		VBox ship3c = new VBox();
		Button a3 = new Button();
		Button b3 = new Button();
		Button c3 = new Button();
		ship3c.getChildren().addAll(a3,b3,c3);
		
		VBox space4a = new VBox();
		Button a4 = new Button();
		Button b4 = new Button();
		Button c4 = new Button();
		Button d4 = new Button();
		space4a.getChildren().addAll(a4,b4,c4,d4);
		
		VBox space4b = new VBox();
		Button a5 = new Button();
		Button b5 = new Button();
		Button c5 = new Button();
		Button d5 = new Button();
		space4b.getChildren().addAll(a5,b5,c5,d5);
		
		VBox space5 = new VBox();
		Button a6 = new Button();
		Button b6 = new Button();
		Button c6 = new Button();
		Button d6 = new Button();
		Button e6 = new Button();
		space4b.getChildren().addAll(a6,b6,c6,d6,e6);
		
		
		
		
		
		stage.setScene(scene);
		stage.show();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
