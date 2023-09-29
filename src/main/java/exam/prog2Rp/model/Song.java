package exam.prog2Rp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "song")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private double duration;
    private String albumName;
    private int releaseYear;

    @Column(columnDefinition = "TEXT")
    private String paroles;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;
}
