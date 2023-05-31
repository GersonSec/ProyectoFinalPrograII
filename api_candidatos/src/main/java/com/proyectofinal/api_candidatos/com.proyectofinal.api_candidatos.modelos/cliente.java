package com.proyectofinal.api_candidatos.com.proyectofinal.api_candidatos.modelos;

public class cliente implements Serializable {
    private static final long serialVeresionUID = 1l;
    
    private long id;
    
    private String nombre;

    private String apellido;

    private String email;

    public Cliente() {

    } 
        
    public long getId(){
        return id;
    }

    
    
}
