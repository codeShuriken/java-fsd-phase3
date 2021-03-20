package com.example.UserFeedback.controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.UserFeedback.entities.Feedback;

@Controller
public class TestFormController {
	@GetMapping("/")
	public String testPage() {
		return "index";
	}
	
	@GetMapping("/testPOSTForm")
	public String testPOSTForm(@RequestParam(name = "userName") String userName, @RequestParam(name="comment") String comment,
			@RequestParam(name="rating") int rating, ModelMap model) {
		StringBuilder sb = null;
		if (userName.isBlank() || comment.isBlank() || rating < 0 || rating > 10)return "error-form";
		try {
			URL url = new URL("http://localhost:8090/feedback");
	        HttpURLConnection http = (HttpURLConnection)url.openConnection();
	        http.setRequestMethod("POST");
	        http.setDoOutput(true);
	        
	        String data = "{\"userName\":\"" + userName + "\",\"comment\":\"" + comment +  "\",\"rating\":" + rating + "}";
	        
	        byte[] out = data.getBytes(StandardCharsets.UTF_8);
            int length = out.length;

            http.setFixedLengthStreamingMode(length);
            http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            http.connect();
            OutputStream os = http.getOutputStream();
            os.write(out);
            
            //Read Result
          	BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
			String line = null;
			sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();
          
		}catch (Exception e) {
			System.err.println(e);
		}
         
		model.addAttribute("newFeedback", sb.toString());
		return sb == null ? "error-form" : "success-form";
	}
}
