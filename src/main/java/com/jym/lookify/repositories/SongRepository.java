package com.jym.lookify.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jym.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
	List<Song> findAll();
	
	List<Song> findByArtistContaining(String artist);
//
//	List<Song> findAllAndOrderByRating();
	
//	List<Song> findByNameOrderByRatingDesc();
	
//	List<Song> findByArtist(String artist);
}
