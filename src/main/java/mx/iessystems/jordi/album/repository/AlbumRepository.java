package mx.iessystems.jordi.album.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.iessystems.jordi.album.model.Album;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    
}
