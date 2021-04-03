package com.english.dictionary.controller;

import java.io.IOException;
import java.net.URL;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.FileUrlResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "http://localhost:8082")
public class DictionaryController {

	private static final String URI = "https://api.dictionaryapi.dev/api/v2/entries/en/";

	@GetMapping("/dictionary/{word}")
	public String getWord(@PathVariable String word) {
		RestTemplate restTemplate = new RestTemplate();
		String destinationURI = URI + word;
		ResponseEntity<String> result = restTemplate.getForEntity(destinationURI, String.class);
		return result.getBody();
	}

	@RequestMapping(value = "/audio", method = RequestMethod.GET)
	public ResponseEntity<?> downloadAudio(@RequestParam("audioUrl") String audioUrl, HttpServletResponse response) {
		try {
			HttpHeaders headers = new HttpHeaders();
			response.setContentType("audio/mpeg");
			response.setHeader("Content-Disposition", "attachment; filename=\"word.mp3\"");
			URL url = new URL(audioUrl);
			return new ResponseEntity<Resource>(new FileUrlResource(url), headers, HttpStatus.OK);
		} catch (IOException ex) {
			throw new RuntimeException("IOError writing file to output stream");
		}
	}
	

}
