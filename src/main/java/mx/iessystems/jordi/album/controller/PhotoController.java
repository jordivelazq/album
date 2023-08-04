package mx.iessystems.jordi.album.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import mx.iessystems.jordi.album.model.Album;
import mx.iessystems.jordi.album.model.Photo;
import mx.iessystems.jordi.album.service.PhotoService;

@RestController
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @GetMapping("/photo")
    public List<Photo> getAllPhotos() {
        return this.photoService.getAllPhotos();

    }

    @PostMapping("/photo/album/{id}")
    public Photo createAlbum(@PathVariable(name = "id") Long albumId, @RequestBody @Valid Photo photo) {
        return photoService.createPhoto(albumId, photo);
    }

}
