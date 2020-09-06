package application;

import java.awt.Point;
import java.util.Random;

public class OceanMap {

    private boolean[][] oceanGrid;
    private  int islandCount;
    private int dimensions;
    private Point shipLocation;

    OceanMap(int dimensions, int islandCount){
        this.oceanGrid = Grid(dimensions, islandCount);
        this.islandCount = islandCount;
        this.dimensions = dimensions;
        placeIslands();
        this.shipLocation = placeShip();
    }

    private static boolean[][] Grid(int rows, int columns) {
        boolean[][] grid = new boolean[rows][columns];

        for (int row=0 ; row < rows; row++) {
            for (int column=0; column < columns; column++){
                grid[row][column] = false;
            }
        }
        return grid;
    }

    // place islands onto map
    private void placeIslands(){
        int i = 0;
        Random random = new Random();
        while(i < islandCount){
            int x = random.nextInt(this.dimensions);
            int y = random.nextInt(this.dimensions);
            if(!this.oceanGrid[x][y]){
                this.oceanGrid[x][y] = true;
                i++;
            }
        }
    }

    private Point placeShip(){
        boolean isShipPlaced = false;
        Random random = new Random();
        int x = 0;
        int y = 0;
        while(!isShipPlaced){
            x = random.nextInt(this.dimensions);
            y = random.nextInt(this.dimensions);
            if(!this.oceanGrid[x][y]){
                isShipPlaced = true;
            }
        }
        return new Point(x,y);
    }

    public void updateShipLocationInGrid(int x, int y){
        int prevX = this.getShipLocation().x;
        int prevY = this.getShipLocation().y;

        this.oceanGrid[prevX][prevY] = false;
        this.oceanGrid[x][y] = true;
    }

    public boolean isOcean(int x, int y){
        if (!this.oceanGrid[x][y]){
            return true;
        }
        return false;
    }

    public boolean isIsland(int x, int y){
        if (getShipLocation().x == x && getShipLocation().y == y) {
            return false;
        }
        if (this.oceanGrid[x][y]){
            return true;
        }
        return false;
    }


    public boolean[][] getMap() {
        return this.oceanGrid;
    }

    public Point getShipLocation() {
        return shipLocation;
    }

    public int getDimensions() {
        return dimensions;
    }

    public int getIslandCount() {
        return islandCount;
    }
}
