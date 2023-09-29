package exam.prog2Rp.controller;

import exam.prog2Rp.model.Song;
import exam.prog2Rp.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("/")
    public List<Song> getAllSongs() {
        return songService.findAll();
    }

    @GetMapping("/{id}")
    public Song getSongById(@PathVariable Long id) {
        return songService.findById(id).orElse(null);
    }
    @GetMapping("/findKeyword")
    public List<Song> rechercherParMotCle(@RequestParam String keyword) {
        return songService.findByKeyword(keyword);
    }

    @PostMapping("/")
    public Song addSong(@RequestBody Song song) {
        return songService.save(song);
    }

    @PutMapping("/{id}")
    public Song updateSong(@PathVariable Long id, @RequestBody Song song) {
        // Implémentez la logique de mise à jour ici
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteSong(@PathVariable Long id) {
        songService.deleteById(id);
    }
}
