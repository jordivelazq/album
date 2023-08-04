package mx.iessystems.jordi.album.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import mx.iessystems.jordi.album.model.Album;
import mx.iessystems.jordi.album.service.AlbumService;

@RestController
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping("/album")
    public List<Album> getAlbums() {
        return albumService.getAlbums();
    }

    @PostMapping("/album")
    public Album createAlbum(@RequestBody @Valid Album album) {
        return albumService.createAlbum(album);
    }

    @DeleteMapping("/album/{id}")
    public Map<String, Boolean> deleteAlbum(@PathVariable(value = "id") Long id) {
        return albumService.deleteAlbum(id);
    }

}
