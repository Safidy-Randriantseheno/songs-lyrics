package exam.prog2Rp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "chanson")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Chanson{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String artiste;
    @Column(columnDefinition = "TEXT")
    private String paroles;

}
