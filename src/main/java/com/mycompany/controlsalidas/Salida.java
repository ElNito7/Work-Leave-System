/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controlsalidas;

import java.sql.Time;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 *
 * @author Keloc
 */
@Entity
@Table(name="salida")
public class Salida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    
    @ManyToOne
    @JoinColumn(name = "defensor_id", nullable = true)
    private Defensor defensor;
    
    @Column(name="fecha")
    private LocalDate fecha;
    
    @Column(name="hora_salida")
    private Time hora;
    
    @Column(name="diligencia")
    private String diligencia;
    
    @Column(name="lugar")
    private String lugar;
    
    @Column(name="expediente")
    private String expediente;
    
    @Column(name="duracion")
    private String duracion;
    
    @Column(name="eliminado")
    private String eliminado;
    
    public Salida(){}
    public Salida(Defensor defensor, LocalDate fecha, Time hora, String diligencia, String lugar, String expediente, String duracion){
        this.defensor = defensor;
        this.fecha = fecha;
        this.hora = hora;
        this.diligencia = diligencia;
        this.lugar = lugar;
        this.expediente = expediente;
        this.duracion = duracion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Defensor getDefId() {
        return defensor;
    }

    public void setDefId(Defensor defId) {
        this.defensor = defId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getDiligencia() {
        return diligencia;
    }

    public void setDiligencia(String diligencia) {
        this.diligencia = diligencia;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getEliminado() {
        return eliminado;
    }

    public void setEliminado(String eliminado) {
        this.eliminado = eliminado;
    }
    
}
