/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.secureconection.Persistence;

/**
 *
 * @author diego
 */
public interface AppPersistence {
    
    public boolean auth(String nombre, String pass);
    
    public String hashing(String pass);
    
    public String bytesToStringHex(byte[] bytes);
}
