package mx.iessystems.jordi.album.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import mx.iessystems.jordi.album.exception.ResourceNotFoundException;
import mx.iessystems.jordi.album.model.Album;
import mx.iessystems.jordi.album.model.Photo;
import mx.iessystems.jordi.album.repository.AlbumRepository;
import mx.iessystems.jordi.album.repository.PhotoRepository;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private PhotoRepository photoRepository;

    @Override
    public Album createAlbum(Album album) {
        return albumRepository.save(album);
    }

    @Override
    public Map<String, Boolean> deleteAlbum(Long id) {
        Optional<Album> albumDb = this.albumRepository.findById(id);

        if (albumDb.isPresent()) {
            this.albumRepository.delete(albumDb.get());
            Map<String, Boolean> response = new HashMap<>();
            response.put("Deleted", Boolean.TRUE);
            return response;
        } else {
            throw new ResourceNotFoundException("Album not found. Id: " + id);
        }

    }

    @Override
    public List<Album> getAlbums() {
        return this.albumRepository.findAll();
    }

}
