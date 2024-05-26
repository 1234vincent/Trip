package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import demo.service.TripService;
import demo.service.Userservice;

@RestController
@RequestMapping("/trip")
public class TripController {
    private static final Logger logger = LoggerFactory.getLogger(TripController.class);
    @Autowired
    private TripService tripService;
    @Autowired
    private Userservice userService;

    // get static map
    @GetMapping(value = "/get_static_map", produces = "image/png")
    public byte[] getMap(
            @RequestParam String origin) {
        try {
            byte[] imageBytes = tripService.getStaticMap(origin);
            return imageBytes;
        } catch (Exception e) {
            throw new RuntimeException("error getting static map");
        }
    }

    // get street view 传两个参数，一个位置，一个view的方向
    @GetMapping(value = "/get_street_view", produces = "image/png")
    public byte[] getStreetView(
            @RequestParam String location,
            @RequestParam int heading) {
        try {
            byte[] imageBytes = tripService.getStreetView(location, heading);
            return imageBytes;
        } catch (Exception e) {
            throw new RuntimeException("error getting street view");
        }
    }

    // get place 
    @GetMapping(value = "/get_place")
    public String getPlace(
            @RequestParam String location) {
        try {
            String id = tripService.getPlaceId(location);
            String place = tripService.getPlaceDetails(id);
            return place;
        } catch (Exception e) {
            throw new RuntimeException("error getting place");
        }
    }

    // get directions
    @GetMapping(value = "/get_directions")
    public ResponseEntity<String> getDirections(
            @RequestParam String origin,
            @RequestParam String destination,
            @RequestParam(required = false, defaultValue = "driving") String mode,
            @RequestParam int userId) {
        try {
            logger.info("Getting directions for userId: {}, origin: {}, destination: {}, mode: {}", userId, origin, destination, mode);
            String directions = tripService.getDirections(origin, destination, mode);
//            userService.Save_Directions(origin, destination, userId);
            return ResponseEntity.ok(directions);
        } catch (Exception e) {
            logger.error("Error getting directions", e);
            throw new RuntimeException("Error getting directions", e);
        }
    }

}

