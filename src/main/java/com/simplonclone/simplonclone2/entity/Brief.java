package com.simplonclone.simplonclone2.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Brief {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "promoId")
    private Integer promoId;
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "promoId", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)})
    private Promos promosByPromoId;
    @OneToMany(mappedBy = "briefByBriefId")
    private Collection<Rendus> rendusesById;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPromoId() {
        return promoId;
    }

    public void setPromoId(Integer promoId) {
        this.promoId = promoId;
    }

    public void setPromoId(int promoId) {
        this.promoId = promoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Brief brief = (Brief) o;

        if (id != brief.id) return false;
        if (promoId != brief.promoId) return false;
        if (name != null ? !name.equals(brief.name) : brief.name != null) return false;
        if (description != null ? !description.equals(brief.description) : brief.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        if (promoId != null) {
            result = 31 * result + promoId.hashCode();
        }else {

            result = 31 * result + 0;
        }
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
