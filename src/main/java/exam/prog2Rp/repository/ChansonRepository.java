package exam.prog2Rp.repository;

import exam.prog2Rp.model.Chanson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ChansonRepository extends JpaRepository<Chanson,Long> {
    List<Chanson> findByParolesContaining(String motCle);
}
