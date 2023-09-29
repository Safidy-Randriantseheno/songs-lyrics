package exam.prog2Rp.controller;

import exam.prog2Rp.model.Chanson;
import exam.prog2Rp.service.ChansonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}