package exam.prog2Rp.controller;

import exam.prog2Rp.model.Artist;
import exam.prog2Rp.service.ArtistService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artists")
@AllArgsConstructor
public class ArtisteController {

    private final ArtistService artistService;

    @GetMapping("/")
    public List<Artist> getAllArtists() {
        return artistService.findAll();
    }

    @GetMapping("/{id}")
    public Artist getArtistById(@PathVariable Long id) {
        return artistService.findById(id).orElse(null);
    }

    @PostMapping("/")
    public Artist addArtist(@RequestBody Artist artist) {
        return artistService.save(artist);
    }

    @PutMapping("/{id}")
    public Artist updateArtist(@PathVariable Long id, @RequestBody Artist artist) {
        // Implémentez la logique de mise à jour ici
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteArtist(@PathVariable Long id) {
        artistService.deleteById(id);
    }
}
