package mx.iessystems.jordi.album.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.iessystems.jordi.album.exception.ResourceNotFoundException;
import mx.iessystems.jordi.album.model.Album;
import mx.iessystems.jordi.album.model.Photo;
import mx.iessystems.jordi.album.repository.AlbumRepository;
import mx.iessystems.jordi.album.repository.PhotoRepository;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Override
    public List<Photo> getAllPhotos() {
        return this.photoRepository.findAll();
    }

    @Override
    public List<Photo> getPhotosByAlbum(Long album) {
        Optional<Album> albumDb = this.albumRepository.findById(album);
        if (albumDb.isPresent()) {
            return this.photoRepository.findByAlbum(albumDb.get());
        } else {
            throw new ResourceNotFoundException("Album not found. Id: " + album);
        }

    }

    @Override
    public Photo createPhoto(Long albumId, Photo photo) {
        Optional<Album> albumDb = this.albumRepository.findById(albumId);
        if (albumDb.isPresent()) {
            photo.setAlbum(albumDb.get().getId());
            return this.photoRepository.save(photo);
        } else {
            throw new ResourceNotFoundException("Album not found. Id: " + albumId);
        }
    }

    @Override
    public List<Photo> addPhotosToAlbum(Long albumId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addPhotosToAlbum'");
    }

}
