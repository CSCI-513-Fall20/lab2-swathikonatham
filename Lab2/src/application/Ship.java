package application;

import java.awt.Point;

public class Ship {
	private Point shipLocation;
	OceanMap oceanMap;
    Ship(OceanMap oceanMap){
        this.oceanMap = oceanMap;
        this.shipLocation = oceanMap.getShipLocation();
    }

	public void goEast() {
		// TODO Auto-generated method stub
		
	}

	public void goWest() {
		// TODO Auto-generated method stub
		
	}

	public void goNorth() {
		// TODO Auto-generated method stub
		
	}

	public void goSouth() {
		// TODO Auto-generated method stub
		
	}

	public Point getShipLocation() {
		// TODO Auto-generated method stub
		return shipLocation;
	}

}
