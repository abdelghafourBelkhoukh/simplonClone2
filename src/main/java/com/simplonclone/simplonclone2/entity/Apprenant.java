package com.simplonclone.simplonclone2.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Apprenant {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "firstname")
    private String firstname;
    @Basic
    @Column(name = "lastname")
    private String lastname;
    @Basic
    @Column(name = "promoId")
    private Integer promoId;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password")
    private String password;
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "promoId", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)})
    private Promos promosByPromoId;
    @OneToMany(mappedBy = "apprenantByApprenantId")
    private Collection<Rendus> rendusesById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getPromoId() {

        if (promoId == null) return 0;
        return promoId;
    }

    public void setPromoId(Integer promoId) {
        this.promoId = promoId;
    }

    public void setPromoId(int promoId) {
        this.promoId = promoId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Apprenant apprenant = (Apprenant) o;

        if (id != apprenant.id) return false;
        if (promoId != apprenant.promoId) return false;
        if (firstname != null ? !firstname.equals(apprenant.firstname) : apprenant.firstname != null) return false;
        if (lastname != null ? !lastname.equals(apprenant.lastname) : apprenant.lastname != null) return false;
        if (email != null ? !email.equals(apprenant.email) : apprenant.email != null) return false;
        if (password != null ? !password.equals(apprenant.password) : apprenant.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        if (promoId != null) {
            result = 31 * result + promoId.hashCode();
        }else {

            result = 31 * result + 0;
        }
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public Promos getPromosByPromoId() {
        return promosByPromoId;
    }

    public void setPromosByPromoId(Promos promosByPromoId) {
        this.promosByPromoId = promosByPromoId;
    }

    public Collection<Rendus> getRendusesById() {
        return rendusesById;
    }

    public void setRendusesById(Collection<Rendus> rendusesById) {
        this.rendusesById = rendusesById;
    }
}
