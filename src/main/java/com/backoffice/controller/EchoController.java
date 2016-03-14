package com.backoffice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EchoController {

	@RequestMapping("/")
	public String getIndex(){
		return "index";
	}
}
