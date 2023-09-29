package exam.prog2Rp.service;


import exam.prog2Rp.model.Song;
import exam.prog2Rp.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    private final SongRepository songRepository;

    @Autowired
    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> findAll() {
        return songRepository.findAll();
    }

    public Optional<Song> findById(Long id) {
        return songRepository.findById(id);
    }

    public Song save(Song song) {
        return songRepository.save(song);
    }

    public void deleteById(Long id) {
        songRepository.deleteById(id);
    }

    public List<Song> findByKeyword(String keyword) {
        return songRepository.findByParolesContaining(keyword);
    }
}
