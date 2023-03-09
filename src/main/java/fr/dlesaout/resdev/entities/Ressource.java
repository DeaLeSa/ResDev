package fr.dlesaout.resdev.entities;

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

    @Column(name = "nom")
    private String nom;

    @Column(name = "url")
    private String url;

    @Column(name = "description")
    private String description;

    @Column(name = "utilisation")
    private String utilisation;

    @ManyToMany
    @JoinTable(
            name = "ressources_categories",
            joinColumns = {@JoinColumn(name = "ressource_id")},
            inverseJoinColumns = {@JoinColumn(name = "categorie_id")}
    )
    @ToString.Exclude
    private List<Categorie> categories = new ArrayList<>();

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
