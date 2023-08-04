package mx.iessystems.jordi.album.service;

import java.util.List;
import java.util.Map;
import mx.iessystems.jordi.album.exception.ResourceNotFoundException;
import mx.iessystems.jordi.album.model.Album;

public interface AlbumService {

    List<Album> getAlbums();

    Album createAlbum(Album album);

    Map<String, Boolean> deleteAlbum(Long id) throws ResourceNotFoundException;
}
