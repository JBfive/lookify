package com.jym.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jym.lookify.models.Song;
import com.jym.lookify.repositories.SongRepository;

@Service
public class SongService {
	private final SongRepository songRepo;
	
	public SongService(SongRepository songRepo) {
		this.songRepo = songRepo;
	}
	public List<Song> allSongs() { 
		return songRepo.findAll();
	}
//	
//	public List<Song> ratedSongs(){
//		return songRepo.findAndOrderByRatingDesc();
//	}
	public Song createSong(Song song) {
		return (Song) songRepo.save(song);
	}
	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRepo.findById(id);
		if(optionalSong.isPresent()) {
			return optionalSong.get();
		} else {
			return null;
		}
	}
	public List<Song> getSongs(String artist){
		return songRepo.findByArtistContaining(artist);
		
	}
//	public List<Song> ratedSongs(){
//		return songRepo.findAllAndOrderByRating();
//	}
	public Song updateSong(Long id, String name, String artist, Integer rating) {
		Song song = findSong(id);
		song.setName(name);
		song.setArtist(artist);
		song.setRating(rating);
		return (Song) songRepo.save(song);
	}
	public void deleteSong(Long id) {
		songRepo.deleteById(id);
	}
}
