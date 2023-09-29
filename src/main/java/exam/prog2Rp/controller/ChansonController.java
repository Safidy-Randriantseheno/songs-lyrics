package exam.prog2Rp.controller;

import exam.prog2Rp.model.Chanson;
import exam.prog2Rp.service.ChansonService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chansons")
@AllArgsConstructor
public class ChansonController {
    private final ChansonService chansonService;

    @GetMapping("/{id}")
    public Chanson getChanson(@PathVariable Long id) {
        return chansonService.findById(id);
    }

    @GetMapping("/toutes")
    public List<Chanson> getAllChansons() {
        return chansonService.findAll();
    }

    @GetMapping("/rechercher")
    public List<Chanson> rechercherParMotCle(@RequestParam String motCle) {
        return chansonService.rechercherParMotCle(motCle);
    }
    @PostMapping("/")
    public Chanson addChanson(@RequestBody Chanson chanson) {
        return chansonService.save(chanson);
    }
    @PutMapping("/{id}")
    public Chanson updateChanson(@PathVariable Long id, @RequestBody Chanson updatedChanson) {
        Optional<Chanson> existingChansonOptional = Optional.ofNullable(chansonService.findById(id));

        if (existingChansonOptional.isPresent()) {
            Chanson existingChanson = existingChansonOptional.get();

            existingChanson.setTitre(updatedChanson.getTitre());
            existingChanson.setArtiste(updatedChanson.getArtiste());
            existingChanson.setParoles(updatedChanson.getParoles());
            Chanson updatedChansonInDB = chansonService.update(existingChanson);

            return updatedChansonInDB;
        } else {
            // Si la chanson avec l'ID donné n'existe pas, vous pouvez renvoyer une réponse d'erreur appropriée
            throw new EntityNotFoundException("Chanson with ID " + id + " not found");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteChanson(@PathVariable Long id) {
        chansonService.deleteById(id);
    }

}