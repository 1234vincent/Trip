package demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class TripService {

    @Value("${google.maps.api-key}") 
    private String apiKey;
    public byte[] getStaticMap(String origin) {
        
        String url = UriComponentsBuilder.fromHttpUrl("https://maps.googleapis.com/maps/api/staticmap")
        .queryParam("center", origin)
        .queryParam("zoom", "12")
        .queryParam("size", "600x300")
        .queryParam("maptype", "roadmap")
        .queryParam("markers", "color:blue|label:S|" + origin)
        .queryParam("key", apiKey)
        .toUriString();
    
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, byte[].class);
    }

    public String getDirections(String origin, String destination) {
        String url = UriComponentsBuilder.fromHttpUrl("https://maps.googleapis.com/maps/api/directions/json")
                .queryParam("origin", origin)
                .queryParam("destination", destination)
                .queryParam("key", apiKey)
                .toUriString();
    
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }

    public byte[] getStreetView(String location, int heading) {
        String url = UriComponentsBuilder.fromHttpUrl("https://maps.googleapis.com/maps/api/streetview")
                .queryParam("location", location)
                .queryParam("size", "600x300")
                .queryParam("heading", heading)
                .queryParam("key", apiKey)
                .toUriString();
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, byte[].class);
    }
    
}
