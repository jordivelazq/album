package mx.iessystems.jordi.album.model;

import java.io.Serializable;
import java.util.Date;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Album")
public class Album implements Serializable {

    private static final long serialVersionUID = 2564064980L;

    private Long id;
    private String name;
    private Date creationDate;

    public Album() {
    }

    public Album(Long id, String name, Date creationDate) {
        this.id = id;
        this.name = name;
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

    @Column(name = "name", nullable = false)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @CreationTimestamp
    @Column(name = "creation_date", nullable = false)
    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

}
