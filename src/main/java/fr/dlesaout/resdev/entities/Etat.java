package fr.dlesaout.resdev.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "etats")
@Entity
public class Etat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nom")
    private String nom;

    @OneToMany(mappedBy = "etat")
    @JsonManagedReference
    private List<Ressource> ressources = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Etat etat = (Etat) o;
        return id != null && Objects.equals(id, etat.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
