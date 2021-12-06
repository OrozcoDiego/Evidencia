package com.mycompany.evidencia_java;


import com.mycompany.evidencia_java.Doctor;
import com.mycompany.evidencia_java.Paciente;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author diego
 */
public class Cita {
    
    public Integer id;
    public String fecha;
    public String motivo;
    public String doctor;
    public String paciente;
    
    public Cita (Integer id, String fecha, String motivo, String doctor, String paciente){
        this.id = id;
        this.fecha = fecha;
        this.motivo = motivo;
        this.doctor = doctor;
        this.paciente = paciente;
    }   
    
}
