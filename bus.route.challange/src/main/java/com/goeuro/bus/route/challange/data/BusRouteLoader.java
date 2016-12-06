package com.goeuro.bus.route.challange.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.goeuro.bus.route.challange.Application;
import com.goeuro.bus.route.challange.model.BusRoute;

/**
 * This class loads the data from provided file path. 
 * 
 * @author feride
 *
 */
public class BusRouteLoader {
	
	private static final Logger logger = Logger.getLogger(Application.class.getName());
	
	private static Map<Integer, CopyOnWriteArrayList<String>> busRouteList = new ConcurrentHashMap<Integer, CopyOnWriteArrayList<String>>();
	
	private BusRouteLoader(){
		
	}
	
	public static void loadRouteList(String filePath){
		
		try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
			busRouteList = stream
			        .skip(1)
			        .map(BusRoute::new)
			        .collect(Collectors.toMap(BusRoute::getRouteId, BusRoute::getStationIds));
			
		} catch (IOException e) {
			e.printStackTrace();
			logger.severe("Problem occured reading file: "+ e);
		}
		
	}
	
	public static Map<Integer, CopyOnWriteArrayList<String>> getInstance(){
		return busRouteList;
	}
	
	
}


