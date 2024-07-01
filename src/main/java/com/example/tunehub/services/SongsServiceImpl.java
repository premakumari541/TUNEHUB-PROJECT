package com.example.tunehub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tunehub.entities.Songs;
import com.example.tunehub.repositories.SongsRepository;
@Service
public class SongsServiceImpl implements SongsService{
   @Autowired
	SongsRepository srepo;
	@Override
	public String addSongs(Songs songs) {
		srepo.save(songs);
		return "Song added";
	}
	@Override
	public boolean songExists(String name) {
		if(srepo.findByName(name)==null) {
			return false;
		}
		else {
			return true;
		}
		
	}
	@Override
	public List<Songs> songsList() {
		List<Songs> songlist=srepo.findAll();
		return songlist;
	}
	@Override
	public void updatesong(Songs song) {
		srepo.save(song);
		
	}

}
