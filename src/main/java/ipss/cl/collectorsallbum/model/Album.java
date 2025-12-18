package ipss.cl.collectorsallbum.model;

import java.time.LocalDate;
import java.util.List; // Importación necesaria

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data 
@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre; 
    private LocalDate fechaLanzamiento;
    
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private List<Lamina> laminas;
}