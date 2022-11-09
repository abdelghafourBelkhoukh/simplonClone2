package com.simplonclone.simplonclone2.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Rendus {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "message")
    private String message;
    @Basic
    @Column(name = "apprenantId")
    private int apprenantId;
    @Basic
    @Column(name = "formateurId")
    private int formateurId;
    @Basic
    @Column(name = "briefId")
    private int briefId;
    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at")
    private Timestamp updatedAt;
    @ManyToOne
    @JoinColumn(name = "apprenantId", referencedColumnName = "id", nullable = false , insertable = false, updatable = false)
    private Apprenant apprenantByApprenantId;
    @ManyToOne
    @JoinColumn(name = "formateurId", referencedColumnName = "id", nullable = false , insertable = false, updatable = false)
    private Formateur formateurByFormateurId;
    @ManyToOne
    @JoinColumn(name = "briefId", referencedColumnName = "id", nullable = false , insertable = false, updatable = false)
    private Brief briefByBriefId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getApprenantId() {
        return apprenantId;
    }

    public void setApprenantId(int apprenantId) {
        this.apprenantId = apprenantId;
    }

    public int getFormateurId() {
        return formateurId;
    }

    public void setFormateurId(int formateurId) {
        this.formateurId = formateurId;
    }

    public int getBriefId() {
        return briefId;
    }

    public void setBriefId(int briefId) {
        this.briefId = briefId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rendus rendus = (Rendus) o;

        if (id != rendus.id) return false;
        if (apprenantId != rendus.apprenantId) return false;
        if (formateurId != rendus.formateurId) return false;
        if (briefId != rendus.briefId) return false;
        if (message != null ? !message.equals(rendus.message) : rendus.message != null) return false;
        if (createdAt != null ? !createdAt.equals(rendus.createdAt) : rendus.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(rendus.updatedAt) : rendus.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + apprenantId;
        result = 31 * result + formateurId;
        result = 31 * result + briefId;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    public Apprenant getApprenantByApprenantId() {
        return apprenantByApprenantId;
    }

    public void setApprenantByApprenantId(Apprenant apprenantByApprenantId) {
        this.apprenantByApprenantId = apprenantByApprenantId;
    }

    public Formateur getFormateurByFormateurId() {
        return formateurByFormateurId;
    }

    public void setFormateurByFormateurId(Formateur formateurByFormateurId) {
        this.formateurByFormateurId = formateurByFormateurId;
    }

    public Brief getBriefByBriefId() {
        return briefByBriefId;
    }

    public void setBriefByBriefId(Brief briefByBriefId) {
        this.briefByBriefId = briefByBriefId;
    }
}
