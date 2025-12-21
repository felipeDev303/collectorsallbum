package ipss.cl.collectorsallbum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ipss.cl.collectorsallbum.model.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

}