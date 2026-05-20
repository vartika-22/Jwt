package com.example.sb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@GetMapping("/employees")
	public String getEmployees() {
		String data = "{\r\n"
				+ "    \"Employee Data\": [\r\n"
				+ "        {\r\n"
				+ "            \"name\": \"Tom\",\r\n"
				+ "            \"age\": 27,\r\n"
				+ "            \"department\": \"Development\"\r\n"
				+ "        },{\r\n"
				+ "            \"name\": \"John\",\r\n"
				+ "            \"age\": 29,\r\n"
				+ "            \"department\": \"Testing\"\r\n"
				+ "        }\r\n"
				+ "    ]\r\n"
				+ "}";
		return data;
	}

}
