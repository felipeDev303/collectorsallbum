package ipss.cl.collectorsallbum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ipss.cl.collectorsallbum.model.Lamina;

public interface LaminaRepository extends JpaRepository<Lamina, Long> {
    // Método para encontrar repetidas según requerimiento [cite: 41]
    List<Lamina> findByAlbumIdAndCantidadGreaterThan(Long albumId, Integer cantidad);
    
    // Método para encontrar faltantes [cite: 41]
    List<Lamina> findByAlbumIdAndCantidad(Long albumId, Integer cantidad);
}