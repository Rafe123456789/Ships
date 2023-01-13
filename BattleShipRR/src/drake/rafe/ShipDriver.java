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
		HBox root = new HBox();
		VBox root1 = new VBox();
		VBox root2 = new VBox();
		VBox root3 = new VBox();
		root1.setPrefWidth(150);
		root.getChildren().addAll(root1, root2, root3);
		
		// hello
		GridPane topGrid = new GridPane();
		
		for (int i = 0; i < 10; i++) {
			for (int l = 0; l < 10; l++) {
				Button b = new Button();
				b.setStyle("-fx-background-color: #00bfff");
				b.setPrefSize(40, 40);
				System.out.println();
				topGrid.add(b, i, l);
			}
		}
		
		root2.getChildren().add(topGrid);
		
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
		root2.getChildren().add(tx);
		root2.getChildren().add(botGrid);
		root2.setLayoutX(150);
		
		Scene scene = new Scene(root, 700, 900);
		
		stage.setScene(scene);
		stage.show();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
