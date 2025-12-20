package ipss.cl.collectorsallbum.service;

import java.util.List;
import java.util.stream.Collectors;

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

    // Operación CRUD: Obtener álbum por ID [cite: 7]
    public Album obtenerAlbumPorId(Long id) {
        return albumRepository.findById(id).orElse(null);
    }

    // Operación CRUD: Eliminar álbum por ID [cite: 7]
    public void eliminarAlbum(Long id) {
        albumRepository.deleteById(id);
    }

    // Funcionalidad Especial: Obtener láminas repetidas 
    public List<Lamina> obtenerRepetidas(Long albumId) {
        List<Lamina> todas = laminaRepository.findAll();
        return todas.stream()
                .filter(l -> l.getAlbum().getId().equals(albumId) && l.getCantidad() > 1)
                .collect(Collectors.toList());
    }

    // Funcionalidad Especial: Obtener láminas faltantes 
    public List<Lamina> obtenerFaltantes(Long albumId) {
        List<Lamina> todas = laminaRepository.findAll();
        return todas.stream()
                .filter(l -> l.getAlbum().getId().equals(albumId) && l.getCantidad() == 0)
                .collect(Collectors.toList());
    }
    
    // Funcionalidad Especial: Carga masiva de láminas 
    public List<Lamina> cargarLaminas(List<Lamina> laminas) {
        return laminaRepository.saveAll(laminas);
    }
}