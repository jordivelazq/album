package mx.iessystems.jordi.album.model;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Photo")
public class Photo implements Serializable {

    private static final long serialVersionUID = 1449216335L;

    private Long id;
    @ManyToOne
    @JoinColumn(name = "album_id")
    private Long album;
    private String url;
    private String description;
    private Date creationDate;

    public Photo() {
    }

    public Photo(Long id, String url, String description, Date creationDate) {
        this.id = id;
        this.url = url;
        this.description = description;
        this.creationDate = creationDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "url", nullable = false)
    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "description", nullable = true)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @CreationTimestamp
    @Column(name = "creation_date")
    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getAlbum() {
        return this.album;
    }

    public void setAlbum(Long album) {
        this.album = album;
    }

}
