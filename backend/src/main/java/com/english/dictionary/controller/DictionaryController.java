package com.english.dictionary.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DictionaryController {

	private static final String URI = "https://api.dictionaryapi.dev/api/v2/entries/en/";
	
	@CrossOrigin
	@GetMapping("/dictionary/{word}")
    public String getWord(@PathVariable String word) {
		RestTemplate restTemplate = new RestTemplate();
		String destinationURI = URI + word;
		ResponseEntity<String> result = restTemplate.getForEntity(destinationURI, String.class);
        return result.getBody();
    }
	
	@CrossOrigin
	@GetMapping("/audio/{url}")
	public String downloadAudio(@PathVariable String audioUrl) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> result = restTemplate.getForEntity(audioUrl, String.class);
        return result.getBody();
	}
	
	
}
