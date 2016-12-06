package com.goeuro.bus.route.challange;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.goeuro.bus.route.challange.data.BusRouteLoader;

@SpringBootApplication
public class Application 
{

	private static final Logger logger = Logger.getLogger(Application.class.getName());
		
	public static void main( String[] args )
    {
        SpringApplication.run(Application.class, args);
        
        logger.info("Application started. Route list loading...");
        BusRouteLoader.loadRouteList(args[0]);
        
        logger.info("Route list loaded");
        
    }
}
