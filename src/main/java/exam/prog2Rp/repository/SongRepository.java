package exam.prog2Rp.repository;


import exam.prog2Rp.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> findByParolesContaining(String keyword);
}
