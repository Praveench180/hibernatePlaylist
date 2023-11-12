/*
 * 
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 *
 */

package com.example.song.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.song.model.Song;

import com.example.song.service.SongJpaService;

@RestController
public class SongController {
    @Autowired
    private SongJpaService songservice;

    @GetMapping("/songs")
    public ArrayList<Song> getSongs() {
        return songservice.getSongs();
    }

    @GetMapping("/songs/{songId}")
    public Song getSongById(@PathVariable("songId") int songId) {
        return songservice.getSongbyId(songId);
    }

    @PostMapping("/songs")
    public Song addSong(@RequestBody Song song) {
        return songservice.addSong(song);
    }

    @PutMapping("/songs/{songId}")
    public Song updateSong(@PathVariable("songId") int songId, @RequestBody Song song) {
        return songservice.updateSong(songId, song);
    }

    @DeleteMapping("/songs/{songId}")
    public void dele(@PathVariable("songId") int songId) {
        songservice.deleteSong(songId);
    }
}