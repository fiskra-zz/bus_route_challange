package com.goeuro.bus.route.challange.model;

/**
 * This class represents to check a direction/route from departure
 * to arrival station
 * 
 * @author feride
 *
 */
public class Direction {
	
	private final int depStationId;
	
	private final int arrStationId;
	
	private final boolean directBusRoute;
	
	public Direction(int depStationId, int arrStationId,boolean directBusRoute) {
		this.depStationId = depStationId;
		this.arrStationId = arrStationId;
		this.directBusRoute =directBusRoute;
	}

	public int getDepStationId() {
		return depStationId;
	}

	public int getArrStationId() {
		return arrStationId;
	}

	public boolean isDirectBusRoute() {
		return directBusRoute;
	}


}
