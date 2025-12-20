package ipss.cl.collectorsallbum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ipss.cl.collectorsallbum.model.Lamina;

public interface LaminaRepository extends JpaRepository<Lamina, Long> {
    
    List<Lamina> findByAlbumIdAndCantidadGreaterThan(Long albumId, Integer cantidad);
    List<Lamina> findByAlbumIdAndCantidad(Long albumId, Integer cantidad);
}