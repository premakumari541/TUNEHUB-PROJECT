package com.example.tunehub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tunehub.entities.PlayList;

public interface PlaylistRepository  extends JpaRepository<PlayList,Integer>{

}
