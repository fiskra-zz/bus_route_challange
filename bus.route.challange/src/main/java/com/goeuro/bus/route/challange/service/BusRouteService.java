package com.goeuro.bus.route.challange.service;

import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;
import java.util.stream.IntStream;

import com.goeuro.bus.route.challange.data.BusRouteLoader;
import com.goeuro.bus.route.challange.model.ResponseError;
import com.goeuro.bus.route.challange.model.MessageType;
/**
 * This class represents any methods related to bus route tasks like searching.
 * 
 * @author feride
 *
 */
public class BusRouteService {
	
	private static final Logger logger = Logger.getLogger(BusRouteService.class.getName());
	
	public static boolean checkRoute(int depStationId, int arrStationId){
		return findRouteOnList(Integer.toString(depStationId), Integer.toString(arrStationId));
	}  
	
	private static boolean findRouteOnList(String depStationId, String arrStationId){
		logger.info("Searching operation started...");
		
		
		if(BusRouteLoader.getInstance().size() == 0){
				throw new RuntimeException("There is a problem occured on our service");
			
		}else{
			int indexDepStation = -1, indexArrStation = -1;
			OptionalInt optDepStation = null, optArrStation = null;
			
			try {
				for (Map.Entry<Integer, CopyOnWriteArrayList<String>> entry : BusRouteLoader.getInstance().entrySet()) {
					List<String> myList = entry.getValue();
					optDepStation = IntStream.range(0, myList.size())
						     .filter(i -> depStationId.equals(myList.get(i)))
						     .findFirst();
					indexDepStation = optDepStation.isPresent() ? optDepStation.getAsInt() : -1;
					
					optArrStation = IntStream.range(indexDepStation != -1 ? indexDepStation : 0, myList.size())
						     .filter(i -> arrStationId.equals(myList.get(i)))
						     .findFirst();
					
					indexArrStation = optArrStation.isPresent() ? optArrStation.getAsInt() : -1;
					
					if(indexArrStation>indexDepStation && (indexArrStation != -1 && indexDepStation != -1))
						return true;
						
				}
				
			} catch (RuntimeException e) {
				logger.severe("Problem occured searching operations: "+ e);
				throw new RuntimeException(e);
			}
		
			return false;
		}
	}

}
