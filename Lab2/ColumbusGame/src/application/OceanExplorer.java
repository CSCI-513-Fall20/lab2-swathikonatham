/* CSCI-513: Lab-2
 * Team - Swathi Reddy Konatham (Z1864290)
 *        Ankita Ratnaparkhi (Z1907718)
 * ClassName - OceanExplorer
 * Description - Main class for Columbus ship game
 * */

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
	//variables declaration
	Pane root;
	final int dimensions = 10;
	final int islandDimensions = 10;
	final int scalingFactor = 50;
	Image shipImage;
	ImageView shipImageView;
	OceanMap oceanMap;
	Scene scene;
	Ship ship;
	

	/* Method Name - startSailing
	 * Input Parameters - None
	 * Return Type - Void
	 * Description - This method is used to sail the ship in different directions.
	 * */
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
				//set the ship image in desired location
				shipImageView.setX(ship.getShipLocation().x * scalingFactor);
				shipImageView.setY(ship.getShipLocation().y * scalingFactor);
			}
		});
	}

	/* Method Name - drawMap
	 * Input Parameters - None
	 * Return Type - Void
	 * Description - This method is used to draw a grid of 10X10 rectangles to represent an ocean
	 * */
	private void drawMap() {
		for (int x = 0; x < dimensions; x++) {
			for (int y = 0; y < dimensions; y++) {
				//draw rectangles for map grid
				Rectangle rect = new Rectangle(x * scalingFactor, y * scalingFactor, scalingFactor, scalingFactor);
				rect.setStroke(Color.BLACK);
				rect.setFill(Color.PALETURQUOISE);
				this.root.getChildren().add(rect);
			}
		}
	}

	/* Method Name - loadShipImage
	 * Input Parameters - None
	 * Return Type - Void
	 * Description - This method is used to load ship image.
	 * */
	private void loadShipImage() {
		this.shipImage = new Image("ship.png", 50, 50, true, true);
		this.shipImageView = new ImageView(shipImage);
		//set ship on location
		this.shipImageView.setX(oceanMap.getShipLocation().x * scalingFactor);
		this.shipImageView.setY(oceanMap.getShipLocation().y * scalingFactor);
		this.root.getChildren().add(shipImageView);
	}
	
	/* Method Name - loadShipImage
	 * Input Parameters - None
	 * Return Type - Void
	 * Description - This method is used to load ship image.
	 * */
	private void loadIslands() {		
        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < dimensions; j++) {
                if (oceanMap.isIsland(i, j)) {
                	//create 10 random green rectangles for islands and place them on grid
                	Rectangle rect = new Rectangle(i * scalingFactor, j * scalingFactor, scalingFactor, scalingFactor);
    				rect.setStroke(Color.BLACK);
    				rect.setFill(Color.GREEN); 
    				this.root.getChildren().add(rect);
					
                }
            }
        }

    }

	/* Method Name - start
	 * Input Parameters - Stage
	 * Return Type - Void
	 * Description - This method is overridden to set the Stage and Scene
	 * */
	@Override
	public void start(Stage oceanStage) throws Exception {

		try {
			oceanMap = new OceanMap(dimensions, islandDimensions);

			root = new AnchorPane();
			drawMap();

			ship = new Ship(oceanMap);
			loadShipImage();
			loadIslands();

			//declare a scene and set the stage.
			scene = new Scene(root, 500, 500);
			scene.setFill(Color.BLUE);
			oceanStage.setTitle("Christopher Columbus Sails the Ocean Blue!");
			oceanStage.setScene(scene);
			oceanStage.show();
			startSailing();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	/* Method Name - main
	 * Input Parameters - None
	 * Return Type - Void
	 * Description - This is the main method.
	 * */
	public static void main(String[] args) {
		launch(args);
	}

}

