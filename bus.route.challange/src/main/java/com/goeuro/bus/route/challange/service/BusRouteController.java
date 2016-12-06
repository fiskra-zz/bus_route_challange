package com.goeuro.bus.route.challange.service;

import java.util.logging.Logger;

import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goeuro.bus.route.challange.model.Direction;
/**
 * This class is a controller to provide handling HTTP requests
 * <code>containerCustomizer</code> sets the custom port
 * 
 * @author feride
 *
 */
@Controller
@RequestMapping("/api")
public class BusRouteController {
	
	private static final Logger logger = Logger.getLogger(BusRouteController.class.getName());
	
	@Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return (container -> {
            container.setPort(8088);
        });
    }
	
	@RequestMapping(value = "/direct", 
			params = { "dep_sid", "arr_sid" }, 
			method = RequestMethod.GET)
	@ResponseBody
	public Direction getBusRoute(@RequestParam("dep_sid") int depStationId, @RequestParam("arr_sid") int arrStationId){
		logger.info("Request: dep_sid: " + depStationId + "- arr_sid: "+ arrStationId);
		return new Direction(depStationId, arrStationId, BusRouteService.checkRoute(depStationId, arrStationId));
	}

}
