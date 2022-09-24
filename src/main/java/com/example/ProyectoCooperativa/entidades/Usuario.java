package com.example.ProyectoCooperativa.entidades;

import javax.persistence.*;

@Entity
@Table

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column(name="email")
    private String email;
    @Column(name = "imagen")
    private String imagen;
    @Column(name = "nombreusuario")
    private String nombreusuario;

    public Usuario(String id, String email, String imagen, String nombreusuario) {
        this.id = id;
        this.email = email;
        this.imagen = imagen;
        this.nombreusuario = nombreusuario;
    }
    public Usuario(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }
}
