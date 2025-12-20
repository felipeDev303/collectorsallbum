package ipss.cl.collectorsallbum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ipss.cl.collectorsallbum.model.Album;
import ipss.cl.collectorsallbum.model.Lamina;
import ipss.cl.collectorsallbum.repository.AlbumRepository;
import ipss.cl.collectorsallbum.repository.LaminaRepository;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private LaminaRepository laminaRepository;

    // Operación CRUD: Crear o Actualizar Álbum [cite: 36]
    public Album guardarAlbum(Album album) {
        return albumRepository.save(album);
    }

    // Operación CRUD: Listar todos los álbumes [cite: 7]
    public List<Album> listarAlbumes() {
        return albumRepository.findAll();
    }

    // Funcionalidad Especial: Obtener láminas repetidas 
    public List<Lamina> obtenerRepetidas(Long albumId) {
        return laminaRepository.findByAlbumIdAndCantidadGreaterThan(albumId, 1);
    }

    // Funcionalidad Especial: Obtener láminas faltantes 
    public List<Lamina> obtenerFaltantes(Long albumId) {
        return laminaRepository.findByAlbumIdAndCantidad(albumId, 0);
    }
    
    // Funcionalidad Especial: Carga masiva de láminas 
    public List<Lamina> cargarLaminas(List<Lamina> laminas) {
        return laminaRepository.saveAll(laminas);
    }
}