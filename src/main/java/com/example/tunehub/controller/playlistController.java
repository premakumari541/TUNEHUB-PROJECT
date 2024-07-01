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
import com.example.tunehub.entities.Songs;
import com.example.tunehub.services.PlaylistService;
import com.example.tunehub.services.SongsService;

@Controller
public class playlistController {

	@Autowired
	PlaylistService pserv;

	@Autowired
	SongsService sserv;

	@GetMapping("/map-createplaylist")
	public String createplayList(Model model) {
		List<Songs> songslist = sserv.songsList();
		model.addAttribute("songslist", songslist);

		return "createplaylist";

	}

	@PostMapping("/addpalylist")
	public String palylistSuccess(@ModelAttribute PlayList playlist) {
		// adding playlist
		pserv.addPlayList(playlist);
		// updating song table
		List<Songs> songsList = playlist.getSongs();
		for (Songs song : songsList) {
			song.getPlaylist().add(playlist);
			sserv.updatesong(song);
		}
		return "palylistSuccess";

	}

	@GetMapping("/map-viewplaylist")
	public String viewPlayList(Model model) {
		List<PlayList> plist = pserv.findplayList();
		model.addAttribute("plist", plist);
		return "viewplaylist";

	}

	@PostMapping("/deletePalyList")
	public String deletePlaylist(@RequestParam int id) {

		pserv.deletePlayList(id);

		return "playlistDelete";

	}

}
