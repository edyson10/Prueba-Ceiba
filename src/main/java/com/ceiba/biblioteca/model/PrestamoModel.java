package com.ceiba.biblioteca.model;

import javax.persistence.*;

@Entity
@Table(name = "prestamo")
public class PrestamoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,unique = true)
    private Long id;

    @Column(nullable = false,length = 10)
    private String isbn;

    @Column(nullable = false, length = 10)
    private String identificacionUsuario;

    @Column(nullable = true)
    private int tipoUsuario;

    @Column(nullable = false)
    private String fechaMaximaDevolucion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public void setIdentificacionUsuario(String identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(byte tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getFechaMaximaDevolucion() {
        return fechaMaximaDevolucion;
    }

    public void setFechaMaximaDevolucion(String fechaMaximaDevolucion) {
        this.fechaMaximaDevolucion = fechaMaximaDevolucion;
    }
}
