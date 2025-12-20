package ipss.cl.collectorsallbum.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Lamina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "El nombre de la lámina es obligatorio")
    private String nombre;
    
    @NotNull(message = "El número de lámina es obligatorio")
    private Integer numero;
    
    private String tipo; 
    private String imagenUrl;
    
    private boolean esRepetida;
    
    @NotNull
    private Integer cantidad = 0; 

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;
}