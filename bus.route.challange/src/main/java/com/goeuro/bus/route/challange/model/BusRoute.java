package com.goeuro.bus.route.challange.model;

import java.util.concurrent.CopyOnWriteArrayList;
/**
 * This class represents bus route model which has unique route id
 * and the station list of corresponding route.
 * 
 * @author feride
 *
 */

public class BusRoute {
	
	private int routeId;
    private CopyOnWriteArrayList<String> stationIds = new CopyOnWriteArrayList<>();

    public BusRoute(String line) {
    	StringBuffer stringBuffer = new StringBuffer(line);
        int i = stringBuffer.indexOf(" ");
        if (i < 1) {
            throw new IllegalArgumentException();
        }
        routeId = Integer.valueOf(stringBuffer.substring(0, i));
        for (String string : stringBuffer.substring(i + 1).split(" ")) {
        	stationIds.add(string);
		}
    }
    
    public BusRoute(int routeId, CopyOnWriteArrayList<String> stationIds){
    	this.routeId = routeId;
    	this.stationIds = stationIds;
    }
    

    public int getRouteId() {
        return routeId;
    }

    public CopyOnWriteArrayList<String> getStationIds() {
        return stationIds;
    }
	
}
