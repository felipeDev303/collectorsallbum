package ipss.cl.collectorsallbum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import ipss.cl.collectorsallbum.model.Album;
import ipss.cl.collectorsallbum.model.Lamina;
import ipss.cl.collectorsallbum.service.AlbumService;

@RestController
@RequestMapping("/api/albumes")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    // 1. Crear un nuevo álbum (CRUD) [cite: 36]
    @PostMapping
    public ResponseEntity<Album> crearAlbum(@Valid @RequestBody Album album) {
        return ResponseEntity.ok(albumService.guardarAlbum(album));
    }

    // 2. Listar todos los álbumes (CRUD - Leer) [cite: 36]
    @GetMapping
    public ResponseEntity<List<Album>> listarTodos() {
        return ResponseEntity.ok(albumService.listarAlbumes());
    }

    // 3. Cargar listado de láminas masivamente [cite: 40]
    @PostMapping("/laminas/carga-masiva")
    public ResponseEntity<List<Lamina>> cargarLaminas(@RequestBody List<Lamina> laminas) {
        return ResponseEntity.ok(albumService.cargarLaminas(laminas));
    }

    // 4. Obtener láminas repetidas y su cantidad 
    @GetMapping("/{id}/repetidas")
    public ResponseEntity<List<Lamina>> getRepetidas(@PathVariable Long id) {
        return ResponseEntity.ok(albumService.obtenerRepetidas(id));
    }

    // 5. Obtener láminas faltantes 
    @GetMapping("/{id}/faltantes")
    public ResponseEntity<List<Lamina>> getFaltantes(@PathVariable Long id) {
        return ResponseEntity.ok(albumService.obtenerFaltantes(id));
    }
}