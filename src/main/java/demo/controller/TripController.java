package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.service.TripService;

@RestController
@RequestMapping("/trip")
public class TripController {

    @Autowired
    private TripService tripService;

    // Endpoint to get directions
    @GetMapping(value = "/get_directions", produces = "image/png")
    public byte[] getMap(
            @RequestParam String origin,
            @RequestParam String destination) {
        try {
            byte[] imageBytes = tripService.getStaticMap(origin);
            return imageBytes;
        } catch (Exception e) {
            throw new RuntimeException("error getting static map");
        }
    }

    @GetMapping(value = "/get_directions", produces = "image/png")
    public ResponseEntity<String> getDirections(
            @RequestParam String origin,
            @RequestParam String destination) {
        try {
            String directions = tripService.getDirections(origin, destination);
            return ResponseEntity.ok(directions);
        } catch (Exception e) {
            throw new RuntimeException("error getting directions");
        }
    }
    
}
