package com.example.tunehub.services;

import java.util.List;


import com.example.tunehub.entities.Songs;

public interface SongsService {

	public String addSongs(Songs songs);
	public boolean songExists(String name);
	List<Songs>songsList();
	public void updatesong(Songs song);
	
}
