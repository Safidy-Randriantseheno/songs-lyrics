package exam.prog2Rp.service;

import exam.prog2Rp.model.Chanson;
import exam.prog2Rp.repository.ChansonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ChansonService {
    private final ChansonRepository chansonRepository;


    public List<Chanson> rechercherParMotCle(String motCle) {
        return chansonRepository.findByParolesContaining(motCle);
    }

    public Chanson findById(Long id) {
        return chansonRepository.findById(id).orElse(null);
    }

    public List<Chanson> findAll() {
        return chansonRepository.findAll();
    }

    public Chanson save(Chanson chanson) {
        return chansonRepository.save(chanson);
    }
    public void deleteById(Long id) {
        chansonRepository.deleteById(id);
    }

    public Chanson update(Chanson chanson) {
       return chansonRepository.save(chanson);
    }
}
