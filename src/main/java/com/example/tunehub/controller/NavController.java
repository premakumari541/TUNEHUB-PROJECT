package com.example.tunehub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {

	@GetMapping("/map-register")
	public String registerMapping() {
		return "register";
	}

	@GetMapping("/map-login")
	public String loginMapping() {
		return "login";
	}

	@GetMapping("/map-addsongs")
	public String addsongMapping() {
		return "Addsongs";
	}

	@GetMapping("/samplepay")
	public String samplePay() {
		return "makePayment";
	}

	@GetMapping("/tunehub")
	public String tunehub() {
		return "index";
	}

	@GetMapping("/home")
	public String homePage() {
		return "home";
	}

	@GetMapping("/forget")
	public String forget() {
		return "ForgetPasswordform";
	}

	@GetMapping("/map-deletePList")
	String deleteplist() {
		return "deletePlaylistform";
	}
}
