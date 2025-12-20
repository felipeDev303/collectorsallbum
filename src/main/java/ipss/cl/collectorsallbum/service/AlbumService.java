package ipss.cl.collectorsallbum.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ipss.cl.collectorsallbum.exception.ResourceNotFoundException;
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

    /**
     * Crea un álbum y genera automáticamente sus láminas (Sprint 2 - Día 4)
     * Requerimiento: "Gestionar colecciones desde la creación hasta el seguimiento" 
     */
    @Transactional
    public Album guardarAlbum(Album album) {
        // Primero guardamos el álbum para obtener su ID
        Album nuevoAlbum = albumRepository.save(album);
        
        // Lógica de generación automática según el total de láminas definido
        // Si el álbum dice que tiene 100 láminas, creamos los 100 registros con cantidad 0
        if (album.getTotalLaminas() != null && album.getTotalLaminas() > 0) {
            List<Lamina> espaciosVacios = new ArrayList<>();
            for (int i = 1; i <= album.getTotalLaminas(); i++) {
                Lamina lamina = new Lamina();
                lamina.setNumero(i);
                lamina.setNombre("Lámina N° " + i);
                lamina.setCantidad(0); // Inicia como faltante [cite: 41]
                lamina.setAlbum(nuevoAlbum);
                espaciosVacios.add(lamina);
            }
            laminaRepository.saveAll(espaciosVacios);
        }
        
        return nuevoAlbum;
    }

    public List<Album> listarAlbumes() {
        return albumRepository.findAll();
    }

    public Album obtenerAlbumPorId(Long id) {
        return albumRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Álbum", "id", id));
    }

    public void eliminarAlbum(Long id) {
        if (!albumRepository.existsById(id)) {
            throw new ResourceNotFoundException("Álbum", "id", id);
        }
        albumRepository.deleteById(id);
    }

    /**
     * Devuelve láminas repetidas (Cantidad > 1) [cite: 41]
     */
    public List<Lamina> obtenerRepetidas(Long albumId) {
        // Verificar que el álbum existe
        obtenerAlbumPorId(albumId);
        return laminaRepository.findByAlbumIdAndCantidadGreaterThan(albumId, 1);
    }

    /**
     * Devuelve láminas faltantes (Cantidad == 0) [cite: 41]
     */
    public List<Lamina> obtenerFaltantes(Long albumId) {
        // Verificar que el álbum existe
        obtenerAlbumPorId(albumId);
        return laminaRepository.findByAlbumIdAndCantidad(albumId, 0);
    }
    
    /**
     * Carga masiva de láminas (Sprint 2 - Día 5)
     * Requerimiento: "Permitir ingresar un listado de láminas para facilitar la carga" [cite: 40]
     */
    @Transactional
    public List<Lamina> cargarLaminas(List<Lamina> laminas) {
        // Aquí podrías agregar validaciones de auditoría antes de guardar (IL2) 
        return laminaRepository.saveAll(laminas);
    }
}