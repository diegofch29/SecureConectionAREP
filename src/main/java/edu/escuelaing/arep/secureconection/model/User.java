/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.secureconection.model;

/**
 *
 * @author diego
 */
public class User {
    private final String name;
    private final String passwd;
    
    public User(String nombre, String passwd){
        this.name = nombre;
        this.passwd = passwd;
    }
    
    
    public String getName(){
        return this.name;
    }
    
    public boolean comparePass(String pass){
        return this.passwd.contentEquals(pass);
    }
    
    
    
}
