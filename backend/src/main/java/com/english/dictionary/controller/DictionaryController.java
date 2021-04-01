package com.english.dictionary.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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
	
	//@CrossOrigin(origins = "http://localhost:8082")
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
				
			URL url = new URL(audioUrl);
		      org.apache.commons.io.IOUtils.copy(url.openStream(), response.getOutputStream());
		      response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		      response.flushBuffer();
		      return ResponseEntity.ok().build();
		    } catch (IOException ex) {
		      throw new RuntimeException("IOError writing file to output stream");
		    }

	}
	
	/*
	 * @RequestMapping(value = "/audio", method = RequestMethod.GET) public void
	 * downloadAudio(@RequestParam("audioUrl") String audioUrl, HttpServletResponse
	 * response) { try {
	 * 
	 * URL url = new URL(audioUrl);
	 * org.apache.commons.io.IOUtils.copy(url.openStream(),
	 * response.getOutputStream()); response.setContentType(new MediaType("audio",
	 * "mpeg").getType()); response.flushBuffer(); } catch (IOException ex) { throw
	 * new RuntimeException("IOError writing file to output stream"); }
	 * 
	 * }
	 */
	
	//@CrossOrigin(origins = "http://localhost:8082")
//	@GetMapping("/audio")
//	public ResponseEntity<byte[]> downloadAudio(@RequestParam(value = "audioUrl") String audioUrl) throws IOException {
//		try {
//			download(audioUrl, "tmp/file.mp3");
//			File file = new File("tmp/file.mp3");
//			byte[] bytes = Files.readAllBytes(Paths.get("tmp/file.mp3"));
//			
//			return ResponseEntity.ok()
//	                .contentType(MediaType.APPLICATION_OCTET_STREAM)
//	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
//	                .body(bytes);
//            
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//		return null;
//	}
//	
	private static void download(String url, String pathFile) throws MalformedURLException, IOException {
		FileUtils.copyURLToFile(new URL(url), new File(pathFile));
	}
	
	private static void downloadUsingNIO(String urlStr, String file) throws IOException {
        URL url = new URL(urlStr);
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream(file);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        fos.close();
        rbc.close();
    }
	
	
}
