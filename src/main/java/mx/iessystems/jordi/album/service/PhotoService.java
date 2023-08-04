package mx.iessystems.jordi.album.service;

import java.util.List;

import mx.iessystems.jordi.album.model.Photo;

public interface PhotoService {

    List<Photo> getAllPhotos();

    List<Photo> getPhotosByAlbum(Long albumId);

    Photo createPhoto(Long albumId, Photo photo);

    List<Photo> addPhotosToAlbum(Long albumId);

}
