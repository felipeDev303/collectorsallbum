package ipss.cl.collectorsallbum.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "El nombre del álbum es obligatorio")
    private String nombre; 
    
    @NotNull(message = "La fecha de lanzamiento no puede ser nula")
    private LocalDate fechaLanzamiento;
    
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private List<Lamina> laminas;
}