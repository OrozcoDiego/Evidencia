package com.mycompany.evidencia_java;

import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author diego
 */
public class Doctor {
        
    public Integer id;
    public String nombre;
    public String especialidad;
   
    public Doctor (Integer id, String nombre, String especialidad){
       this.id = id;
       this.nombre = nombre;
       this.especialidad = especialidad;
    }
   
}
