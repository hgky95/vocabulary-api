package com.english.dictionary.controller;

import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.FileUrlResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "http://localhost:8089")
@RequestMapping("api/dictionary")
public class DictionaryController {

	private static final String URI = "https://api.dictionaryapi.dev/api/v2/entries/en/";
	private static final Pattern PATTERN = Pattern.compile("(\\/sounds)(.\\d*\\/)(.*)");
	private static final String EMPTY = "";

	@RequestMapping(method = RequestMethod.GET)
	public String getWord(@RequestParam("word") String word) {
		RestTemplate restTemplate = new RestTemplate();
		String destinationURI = URI + word;
		ResponseEntity<String> result = restTemplate.getForEntity(destinationURI, String.class);
		return result.getBody();
	}

	@RequestMapping(value = "/audio", method = RequestMethod.GET)
	public ResponseEntity<?> downloadAudio(@RequestParam("audioUrl") String audioUrl, HttpServletResponse response) {
		audioUrl = "https://" + audioUrl;
		try {
			HttpHeaders headers = new HttpHeaders();
			response.setContentType("audio/mpeg");
			String header = buildHeader(audioUrl);
			response.setHeader("Content-Disposition", header);
			URL url = new URL(audioUrl);
			return new ResponseEntity<Resource>(new FileUrlResource(url), headers, HttpStatus.OK);
		} catch (IOException ex) {
			throw new RuntimeException("IOError writing file to output stream");
		}
	}

	private static String buildHeader(String url) {
		Matcher matcher = PATTERN.matcher(url);
		if (matcher.find()) {
			String fileName = matcher.group(3);
			return String.format("attachment; filename=\"%s\"", fileName);
		}
		return EMPTY;
	}

}
