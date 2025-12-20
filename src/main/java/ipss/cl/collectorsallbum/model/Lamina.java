package ipss.cl.collectorsallbum.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Lamina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "El nombre de la lámina no puede estar vacío")
    private String nombre;
    
    @NotNull(message = "El número de la lámina no puede ser nulo")
    @Min(value = 1, message = "El número de la lámina debe ser mayor a 0")
    private Integer numero;
    
    private String tipo;
    private String imagenUrl;
    
    @NotNull(message = "La cantidad no puede ser nula")
    @Min(value = 0, message = "La cantidad no puede ser negativa")
    private Integer cantidad; 

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;
}