package fr.dlesaout.resdev.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "ressources")
@Entity
public class Ressource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nom", columnDefinition = "nvarchar(255)")
    private String nom;

    @Column(name = "url", columnDefinition = "nvarchar(255)")
    private String url;

    @Column(name = "description", columnDefinition = "nvarchar(MAX)")
    private String description;

    @Column(name = "utilisation", columnDefinition = "nvarchar(MAX)")
    private String utilisation;

    @ManyToMany
    @JoinTable(
            name = "ressources_categories",
            joinColumns = {@JoinColumn(name = "ressource_id")},
            inverseJoinColumns = {@JoinColumn(name = "categorie_id")}
    )
    @ToString.Exclude
    @JsonBackReference
    private List<Categorie> categories = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "etat_id")
    @JsonBackReference
    private Etat etat;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Ressource ressource = (Ressource) o;
        return id != null && Objects.equals(id, ressource.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
