package ipss.cl.collectorsallbum.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Lamina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private Integer numero;
    private String tipo; 
    private String imagenUrl; 
    
    private boolean esRepetida;
    private Integer cantidad; 

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;
}