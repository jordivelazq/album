package mx.iessystems.jordi.album.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.iessystems.jordi.album.model.Album;
import mx.iessystems.jordi.album.model.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long> {

    public List<Photo> findByAlbum(Album album);

}
