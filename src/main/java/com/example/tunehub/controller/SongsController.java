package com.example.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.tunehub.entities.Songs;
import com.example.tunehub.entities.Users;
import com.example.tunehub.services.SongsService;
import com.example.tunehub.services.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class SongsController {
	@Autowired
	SongsService sserv;

	@Autowired
	UsersService userv;

	@PostMapping("/addsongs")
	public String addSongs(@ModelAttribute Songs songs) {
		if (sserv.songExists(songs.getName()) == false) {

			sserv.addSongs(songs);
			return "AddSongSuccess";
		} else {

			return "AddSongFail";
		}

	}

	@GetMapping("/map-viewsongs")
	public String viewSongs(Model model) {

		List<Songs> songlist = sserv.songsList();
		model.addAttribute("songslist", songlist);

		return "SongsList";

	}

	@GetMapping("/viewsongs")
	public String viewCusomerSongs(HttpSession session, Model model) {
		String email = (String) session.getAttribute("email");
		Users user = userv.getUser(email);

		boolean primestatus = user.isPremium();
		if (primestatus == true) {
			List<Songs> songlist = sserv.songsList();
			model.addAttribute("songslist", songlist);
			// System.out.println(songlist);
			return "customerSongList";
		} else {
			return "makePayment";
		}

	}

}
