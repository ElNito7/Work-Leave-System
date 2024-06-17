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
    
    @Column(name="defensor_id")
    private long defId;
    
    @Column(name="fecha")
    private LocalDate fecha;
    
    @Column(name="hora")
    private Time hora;
    
    @Column(name="diligencia")
    private String diligencia;
    
    @Column(name="lugar")
    private String lugar;
    
    @Column(name="expediente")
    private String expediente;
    
    @Column(name="duracion")
    private String duracion;
    
    public Salida(){}
    public Salida(long defId, Time hora, String diligencia, String lugar, String expediente, String duracion){
        this.defId = defId;
        this.fecha = LocalDate.now();
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

    public long getDefId() {
        return defId;
    }

    public void setDefId(long defId) {
        this.defId = defId;
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
    
}
