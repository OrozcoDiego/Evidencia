package com.mycompany.evidencia_java;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author diego
 */
public class Principal {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String usuarioAdmin = "admin";
        String usuario;
        String contrasenaAdmin = "admin27";
        String contrasena;
        int opcion = 0;
        Integer idDoc = -1;
        Integer idPac = -1;
        Integer idCita = -1;
        
        do{
            System.out.println("Ingresa tu usuario: (la contraseña es 'admin')");
            usuario = br.readLine();
            System.out.println("Ingresa tu contraseña: (la contraseña es 'admin27')");
            contrasena = br.readLine();
            if (!contrasenaAdmin.equals(contrasena) || !usuarioAdmin.equals(usuario)){
                System.out.println("El usuario o contraseña son incorrectos, intente de nuevo");
            }
            System.out.println();
        }while (!contrasenaAdmin.equals(contrasena) || !usuarioAdmin.equals(usuario));
        
        do{
            System.out.println("Elige una opcion:\n"
                    + "1. Dar de alta a medico\n"
                    + "2. Dar de alta a un paciente\n"
                    + "3. Crear una cita\n"
                    + "4. Salir");
            try{
                opcion = Integer.parseInt(br.readLine());
            }catch(Exception e){
                System.out.println("No se selecciono una opcion valida");
            }
            
            Doctor [] doctor = new Doctor[20];
            Paciente [] paciente = new Paciente[20];
            Cita [] cita = new Cita[20];
        
            switch(opcion){
                case 1:                    
                    System.out.println("Ingresa el nombre del doctor");
                    String doc = br.readLine();
                    idDoc = idDoc + 1;
                    System.out.println("Ingresa la especialidad del doctor");
                    String esp = br.readLine();
                    doctor[idDoc] = new Doctor(idDoc, doc, esp);
                    System.out.println("El doctor ha sido dado de alta");
                    break;

                case 2:
                    System.out.println("Ingresa el nombre del paciente");
                    String pac = br.readLine();
                    idPac = idPac + 1;
                    paciente[idDoc] = new Paciente(idPac, pac);
                    System.out.println("El paciente ha sido dado de alta");
                    break;

                case 3:
                    System.out.println("Ingresa el nombre del doctor");
                    doc = br.readLine();
                    for (int i = 0; i<doctor.length; i++) {
                        if(!doctor[i].nombre.contains(doc)){
                            System.out.print("Doctor no disponible o no existe");
                            break;
                        }
                    }
                    
                    System.out.println("Ingresa el nombre del paciente");
                    pac = br.readLine();
                    for (int i = 0; i<paciente.length; i++) {
                        if(!paciente[i].nombre.contains(pac)){
                            System.out.print("Paciente no disponible o no existe");
                            break;
                        }
                    }
                    
                    System.out.println("Ingresa la fecha de la cita");
                    String fecha = br.readLine();
                    
                    System.out.println("Ingresa el motivo de la cita");
                    String motivo = br.readLine();
                    
                    idCita = idCita + 1;
                    cita[idCita] = new Cita(idCita, fecha, motivo, doc, pac);
                    System.out.println("Se ha creado la cita");
                    break;

                case 4:
                    save(doctor, paciente, cita);
                    System.out.println("Adios.");
                    break;

                default:
                    System.out.println("Seleccione una opcion valida");

            }            
            System.out.println();
            
        }while(opcion != 4); 
    }
    
    public static void save(Doctor[] doctor, Paciente[] paciente, Cita[] cita){
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonDoc = mapper.writeValueAsString(doctor);
            String jsonPac = mapper.writeValueAsString(paciente);
            String jsonCita = mapper.writeValueAsString(cita);
            System.out.println(jsonDoc);
            System.out.println(jsonPac);
            System.out.println(jsonCita);
        } catch (Exception e) {
            System.out.println("ERROR->" + e.getMessage());
        }        
    }
    
    public static void load(Doctor[] doctor, Paciente[] paciente, Cita[] cita, String jsonDoc, String ajsonPac, String jsonCita){
        Gson gson = new Gson();
        Doctor gsonDoctor = gson.fromJson(jsonDoc, Doctor.class);
        Paciente gsonPaciente = gson.fromJson(jsonCita, Paciente.class);
        Cita gsonCita = gson.fromJson(jsonCita, Cita.class);
    }
    
}