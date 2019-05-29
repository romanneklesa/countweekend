package com.javasampleapproach.html5datetime.controller;

import java.io.IOException;

import com.javasampleapproach.html5datetime.service.WeekendService;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/logtime")
public class RestWebController {

	@Autowired
	WeekendService service;

	@PostMapping(value="/save")
	public String postCustomer(@RequestBody String jsonString) throws IOException, ParseException {

		Object obj = new JSONParser().parse(jsonString); // Object obj = new JSONParser().parse(new FileReader("JSONExample.json"));
// Кастим obj в JSONObject
		JSONObject jo = (JSONObject) obj;
// Достаём firstName and lastName
		String startTime = (String) jo.get(Integer.parseInt("startTime"));
		String endTime = (String) jo.get(Integer.parseInt("endTime"));

		return "Succes";
	}


}
