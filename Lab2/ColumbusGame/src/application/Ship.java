/* CSCI-513: Lab-2
 * Team - Swathi Reddy Konatham (Z1864290)
 *        Ankita Ratnaparkhi (Z1907718)
 * ClassName - Ship
 * Description - Class to move ship to eligible desired locations on Ocean
 * */


package application;

import java.awt.Point;

public class Ship {
	private Point currentLoc;
	OceanMap oceanMap;
	//constructor
    Ship(OceanMap oceanMap){
        this.oceanMap = oceanMap;
        this.currentLoc = oceanMap.getShipLocation();
    }
    
    /* Method Name - goSouth
	 * Input Parameters - None
	 * Return Type - Void
	 * Description - This method is used to navigate in south direction.
	 * */
    public void goSouth(){
        int xCell = currentLoc.x;
        int yCell = currentLoc.y;
        if(yCell < oceanMap.getDimensions()-1 && oceanMap.isOcean(xCell, yCell+1)){
            oceanMap.updateShipLocationInGrid(xCell, yCell+1);
            currentLoc.y++;
        }
    }
    
    
    /* Method Name - goNorth
	 * Input Parameters - None
	 * Return Type - Void
	 * Description - This method is used to navigate in north direction.
	 * */
    public void goNorth(){
        int xCell = currentLoc.x;
        int yCell = currentLoc.y;
        if(yCell > 0 && oceanMap.isOcean(xCell, yCell-1)){
            oceanMap.updateShipLocationInGrid(xCell, yCell-1);
            currentLoc.y--;
        }
    }
    
    /* Method Name - goWest
	 * Input Parameters - None
	 * Return Type - Void
	 * Description - This method is used to navigate in west direction.
	 * */
    public void goWest(){
        int xCell = currentLoc.x;
        int yCell = currentLoc.y;
        if(xCell > 0 && oceanMap.isOcean(xCell-1, yCell)){
            oceanMap.updateShipLocationInGrid(xCell-1, yCell);
            currentLoc.x--;
        }
    }

    /* Method Name - goEast
	 * Input Parameters - None
	 * Return Type - Void
	 * Description - This method is used to navigate in east direction.
	 * */
    public void goEast(){
        int xCell = currentLoc.x;
        int yCell = currentLoc.y;
        if(xCell < oceanMap.getDimensions()-1 && oceanMap.isOcean(xCell+1, yCell)){
            oceanMap.updateShipLocationInGrid(xCell+1, yCell);
            currentLoc.x++;
        }
    }    

    /* Method Name - getShipLocation
	 * Input Parameters - None
	 * Return Type - Void
	 * Description - This method is used to get the current ship location.
	 * */
	public Point getShipLocation() {
		return currentLoc;
	}

}
