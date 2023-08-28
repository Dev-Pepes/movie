package movie.server.domain.domains.movie;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Entity
@Getter
@Table(name = "tbl_movie")
@NoArgsConstructor
public class Movie {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private String movieName;
  
}
