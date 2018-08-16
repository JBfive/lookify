package com.jym.lookify.controllers;

import java.util.Comparator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jym.lookify.models.Song;
import com.jym.lookify.services.SongService;


@Controller
public class SongsController {
private final SongService songService;
	
	public SongsController(SongService songService) {
		this.songService = songService;
	}
	@RequestMapping("/dashboard")
	public String dashboard(@ModelAttribute("song") Song song, Model model) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "/dashboard.jsp";
	}
	@RequestMapping("/")
	public String index() {
		return "/index.jsp";
	}
	@RequestMapping(value="/dashboard", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "/new.jsp";
		} else {
			songService.createSong(song);
			return "redirect:/dashboard";
		}
	}
	@RequestMapping("/songs/{id}")
	public String show(Model model, @PathVariable("id") Long id) {
		Song song = songService.findSong(id);
		model.addAttribute("song", song);
		return "/show.jsp";
	}
	@RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/songs";
	}
	@RequestMapping("/songs/delete/{id}")
	public String destroyLink(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/songs";
	}
	@RequestMapping("/search/{artist}")
	public String list(@PathVariable("artist") String artist, @ModelAttribute("song") Song song, Model model) {
		List<Song> songs = songService.getSongs(artist);
		model.addAttribute("songs", songs);
		return "/list.jsp";
	}
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String artist(@RequestParam(value="artist") String artist) {
		return "redirect:/search/".concat(artist);
	}
	@RequestMapping("/songs/new")
    public String newSong(@ModelAttribute("song") Song song) {
        return "/new.jsp";
    }
	@RequestMapping("/search/topTen")
	public String topTen(@ModelAttribute("song") Song song, Model model) {
		List<Song> songs = songService.allSongs();
		songs.sort(Comparator.comparingInt(Song::getRating).reversed());
		model.addAttribute("songs", songs);
		return "/search.jsp"; 
	}
    
	
//	@RequestMapping("/songs/edit/{id}")
//	public String edit(@PathVariable("id") Long id, Model model) {
//		Song song = songService.findSong(id);
//		model.addAttribute("song", song);
//		return "/edit.jsp";
//	}
//	@RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
//	public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
//		if(result.hasErrors()) {
//			return "edit.jsp";
//		} else {
//			Long id = language.getId();
//			String name = language.getName();
//			String creator = language.getCreator();
//			Double version = language.getVersion();
//			languageService.updateLanguage(id, name, creator, version);
//			return "redirect:/languages";
//		}
//	}
}
