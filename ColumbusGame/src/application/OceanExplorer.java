package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class OceanExplorer extends Application {
	boolean[][] islandMap;
	Pane root;
	final int dimensions = 10;
	final int islandCount = 10;
	final int scalingFactor = 50;
	Image shipImage;
	ImageView shipImageView;
	OceanMap oceanMap;
	Scene scene;
	Ship ship;
	// javafx.scene.image.Image islandImage;
	// ImageView islandImageView;

	private void startSailing() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				switch (ke.getCode()) {
				case RIGHT:
					ship.goEast();
					break;
				case LEFT:
					ship.goWest();
					break;
				case UP:
					ship.goNorth();
					break;
				case DOWN:
					ship.goSouth();
					break;
				default:
					break;
				}
				shipImageView.setX(ship.getShipLocation().x * scalingFactor);
				shipImageView.setY(ship.getShipLocation().y * scalingFactor);
			}
		});
	}

	private void drawMap() {
		for (int x = 0; x < dimensions; x++) {
			for (int y = 0; y < dimensions; y++) {
				Rectangle rect = new Rectangle(x * scalingFactor, y * scalingFactor, scalingFactor, scalingFactor);
				rect.setStroke(Color.BLACK); // We want the black outline
				rect.setFill(Color.PALETURQUOISE); // I like this color better than BLUE
				this.root.getChildren().add(rect); // Add to the node tree in the pane
			}
		}
	}

	private void loadShipImage() {
		this.shipImage = new Image("ship.png", 50, 50, true, true);

		// Now instantiate and load the image View. Actually this probably needs to be
		// a class level variable so you would already have defined ImageView
		// shipImageview
		this.shipImageView = new ImageView(shipImage);

		// Assuming that you’ve already set the ship’s starting coordinates in Ship and
		// have
		// created a getter method.
		this.shipImageView.setX(oceanMap.getShipLocation().x * scalingFactor);
		this.shipImageView.setY(oceanMap.getShipLocation().y * scalingFactor);

		// Don’t forget to add the ImageView to the Pane!
		this.root.getChildren().add(shipImageView);
	}

	

	@Override
	public void start(Stage mapStage) throws Exception {
		
		try{
			oceanMap = new OceanMap(dimensions, islandCount);
			//islandMap = oceanMap.getMap();

			root = new AnchorPane();
			drawMap();

			ship = new Ship(oceanMap);
			loadShipImage();

			// loadIslandsImage();

			scene = new Scene(root, 500, 500);
			scene.setFill(Color.BLUE);
			mapStage.setTitle("Christopher Columbus sails the blue ocean");
			mapStage.setScene(scene);
			mapStage.show();
			startSailing();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		launch(args);
	}

}




/**package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}**/
