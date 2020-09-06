/* CSCI-513: Lab-2
 * Team - Swathi Reddy Konatham (Z1864290)
 *        Ankita Ratnaparkhi (Z1907718)
 * ClassName - OceanMap
 * Description - Class to create ocean and islands
 * */

package application;

import java.awt.Point;
import java.util.Random;

public class OceanMap {
	//variables declaration
    private boolean[][] oceanGrid;
    private  int islandDimensions;
    private int gridDimensions;
    private Point shipLocation;

    //constructor 
    OceanMap(int gridDimensions, int islandDimensions){
        this.oceanGrid = Grid(gridDimensions, islandDimensions);
        this.islandDimensions = islandDimensions;
        this.gridDimensions = gridDimensions;
        placeIslands();
        this.shipLocation = placeShip();
    }

    /* Method Name - Grid
	 * Input Parameters - int rows, int columns
	 * Return Type - boolean[][]
	 * Description - This method is used to create a grid.
	 * */
    private static boolean[][] Grid(int rows, int columns) {
        boolean[][] grid = new boolean[rows][columns];

        for (int i=0 ; i < rows; i++) {
            for (int j=0; j < columns; j++){
                grid[i][j] = false;
            }
        }
        return grid;
    }
    
    /* Method Name - getDimensions
	 * Input Parameters - None
	 * Return Type - int
	 * Description - This method is used to get the dimensions.
	 * */
    public int getDimensions() {
        return gridDimensions;
    }
    
    /* Method Name - getShipLocation
	 * Input Parameters - None
	 * Return Type - Point
	 * Description - This method is used to get the ship location.
	 * */
    public Point getShipLocation() {
        return shipLocation;
    }   

    /* Method Name - placeIslands
	 * Input Parameters - None
	 * Return Type - Void
	 * Description - This method is used to place islands in the grid.
	 * */
    private void placeIslands(){
        int i = 0;
        Random random = new Random();
        while(i < islandDimensions){
            int x = random.nextInt(this.gridDimensions);
            int y = random.nextInt(this.gridDimensions);
            if(!this.oceanGrid[x][y]){
                this.oceanGrid[x][y] = true;
                i++;
            }
        }
    }

    /* Method Name - placeShip
	 * Input Parameters - None
	 * Return Type - Point
	 * Description - This method is used to place ship in the grid.
	 * */
    private Point placeShip(){
    	int x = 0;
    	int y = 0;
        boolean checkShip = false;
        Random random = new Random();
        while(!checkShip){
            x = random.nextInt(this.gridDimensions);
            y = random.nextInt(this.gridDimensions);
            if(!this.oceanGrid[x][y]){
                checkShip = true;
            }
        }
        return new Point(x,y);
    }

    /* Method Name - updateShipLocationInGrid
	 * Input Parameters - int xCell, int yCell
	 * Return Type - Void
	 * Description - This method is used to the ship location in the grid.
	 * */
    public void updateShipLocationInGrid(int xCell, int yCell){
        this.oceanGrid[this.getShipLocation().x][this.getShipLocation().y] = false;
        this.oceanGrid[xCell][yCell] = true;
    }
    
    /* Method Name - isIsland
	 * Input Parameters - int xCell, int yCell
	 * Return Type - boolean
	 * Description - This method is used to check if the cell is island.
	 * */
    public boolean isIsland(int xCell, int yCell){
        if (getShipLocation().x == xCell && getShipLocation().y == yCell) {
            return false;
        }
        if (this.oceanGrid[xCell][yCell]){
            return true;
        }
        return false;
    }

    /* Method Name - isOcean
	 * Input Parameters - int xCell, int yCell
	 * Return Type - boolean
	 * Description - This method is used to check if the cell is ocean.
	 * */
    public boolean isOcean(int xCell, int yCell){
        if (this.oceanGrid[xCell][yCell]){
            return false;
        }
        return true;
    }

    /* Method Name - getMap
	 * Input Parameters - None
	 * Return Type - boolean[][]
	 * Description - This method is used to get the ocean map.
	 * */
    public boolean[][] getMap() {
        return this.oceanGrid;
    }

    
}
