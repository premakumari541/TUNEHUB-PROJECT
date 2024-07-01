package com.example.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.tunehub.entities.PlayList;
import com.example.tunehub.entities.Users;
import com.example.tunehub.services.PlaylistService;
import com.example.tunehub.services.SongsService;
import com.example.tunehub.services.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	UsersService userv;

	@Autowired
	SongsService sserv;

	@Autowired
	PlaylistService pserv;

	@PostMapping("/register")
	public String addUsers(@ModelAttribute Users user) {

		boolean userstatus = userv.emailExists(user.getEmail());
		if (userstatus == false) {
			userv.addUsers(user);
			return "regiSuccess";
		} else {
			return "regiFail";
		}

	}

	@PostMapping("/login")
	public String validationUser(@RequestParam String email, @RequestParam String password, HttpSession session) {

		if (userv.validateUser(email, password) == true) {
			// for tracking the user we created a session and accessing it email
			session.setAttribute("email", email);

			if (userv.role(email).equals("admin")) {
				return "adminhome";
			} else {
				return "customerhome";
			}
		} else {
			return "loginFail";
		}

	}

	@GetMapping("/view-Playlists")
	public String viewPlaylist(HttpSession session, Model model) {
		String email = (String) session.getAttribute("email");
		Users user = userv.getUser(email);
		boolean userStatus = user.isPremium();
		if (userStatus == true) {

			List<PlayList> plist = pserv.findplayList();
			model.addAttribute("plist", plist);

			return "customerPlaylist";

		}

		else

		{
			return "makePayment";
		}

	}

	@PostMapping("/updatePassword")
	public String updatePassword(@RequestParam String email, @RequestParam String address,
			@RequestParam String password, Model model) {

//		String db_mail = (String) model.getAttribute(email);
//		if (db_mail.equals(email)) {

		boolean value = userv.UpdatePassword(email, address, password);
		if (value == true) {
			return "passwordUpdated";

		} else {
			return "forgetFailure";
		}
	}
}
