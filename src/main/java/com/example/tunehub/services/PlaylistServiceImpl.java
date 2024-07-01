package com.example.tunehub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tunehub.entities.PlayList;
import com.example.tunehub.repositories.PlaylistRepository;

@Service
public class PlaylistServiceImpl implements PlaylistService {
	@Autowired
	PlaylistRepository prepo;

	@Override
	public void addPlayList(PlayList playlist) {
		prepo.save(playlist);

	}

	@Override
	public List<PlayList> findplayList() {

		return prepo.findAll();
	}

	@Override
	public String deletePlayList(int id) {

		prepo.deleteById(id);
		return "playList deleted";

	}

}
