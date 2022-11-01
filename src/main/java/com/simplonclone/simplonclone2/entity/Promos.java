package com.simplonclone.simplonclone2.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Promos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "promosByPromoId")
    private Collection<Apprenant> apprenantsById;
    @OneToMany(mappedBy = "promosByPromoId")
    private Collection<Brief> briefsById;
    @OneToMany(mappedBy = "promosByPromoId")
    private Collection<Formateur> formateursById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Promos promos = (Promos) o;

        if (id != promos.id) return false;
        if (name != null ? !name.equals(promos.name) : promos.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Collection<Apprenant> getApprenantsById() {
        return apprenantsById;
    }

    public void setApprenantsById(Collection<Apprenant> apprenantsById) {
        this.apprenantsById = apprenantsById;
    }

    public Collection<Brief> getBriefsById() {
        return briefsById;
    }

    public void setBriefsById(Collection<Brief> briefsById) {
        this.briefsById = briefsById;
    }

    public Collection<Formateur> getFormateursById() {
        return formateursById;
    }

    public void setFormateursById(Collection<Formateur> formateursById) {
        this.formateursById = formateursById;
    }
}
