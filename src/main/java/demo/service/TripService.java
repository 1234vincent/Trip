package demo.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import demo.model.User;


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

    public String getDirections(String origin, String destination, String mode) {
        String url = UriComponentsBuilder.fromHttpUrl("https://maps.googleapis.com/maps/api/directions/json")
                .queryParam("origin", origin)
                .queryParam("destination", destination)
                .queryParam("mode", mode)
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


    public String findPlaceFromText(String location) {
        String baseUrl = "https://maps.googleapis.com/maps/api/place/findplacefromtext/json";
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("input", location)
                .queryParam("inputtype", "textquery")
                .queryParam("fields", "place_id,name,formatted_address")
                .queryParam("key", apiKey)
                .toUriString();

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }

    public String getPlaceDetails(String placeId) {
        String baseUrl = "https://maps.googleapis.com/maps/api/place/details/json";
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("place_id", placeId)
                .queryParam("fields", "name,formatted_address,formatted_phone_number,website,rating,review")
                .queryParam("key", apiKey)
                .toUriString();

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class PlaceResponse {
        public Candidate[] candidates;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Candidate {
        public String place_id;
    }

    public String getPlaceId(String query) {
        String baseUrl = "https://maps.googleapis.com/maps/api/place/findplacefromtext/json";
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("input", query)
                .queryParam("inputtype", "textquery")
                .queryParam("fields", "place_id")
                .queryParam("key", apiKey)
                .toUriString();

        RestTemplate restTemplate = new RestTemplate();
        PlaceResponse response = restTemplate.getForObject(url, PlaceResponse.class);
        if (response != null && response.candidates != null && response.candidates.length > 0) {
            return response.candidates[0].place_id;
        } else {
            throw new RuntimeException("No place found or error getting place id");
        }
    }


}
