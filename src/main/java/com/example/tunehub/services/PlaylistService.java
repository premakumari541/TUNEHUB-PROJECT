package com.example.tunehub.services;

import java.util.List;

import com.example.tunehub.entities.PlayList;

public interface PlaylistService {
	public void addPlayList(PlayList playlist);

	public List<PlayList> findplayList();

	public String deletePlayList(int id);
}
