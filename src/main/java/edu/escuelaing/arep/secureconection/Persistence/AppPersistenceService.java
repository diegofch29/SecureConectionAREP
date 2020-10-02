/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.secureconection.Persistence;

import edu.escuelaing.arep.secureconection.model.User;
import java.util.ArrayList;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import spark.Service;

/**
 *
 * @author diego
 */
public class AppPersistenceService implements AppPersistence{
    
    private ArrayList<User> users = new ArrayList<>();
    
    public AppPersistenceService() {
        System.out.println(hashing("asdf"));
        System.out.println(hashing("1234"));
        users.add(new User("usuario1@hotmail.com",hashing("asdf")));
        users.add(new User("usuario2@hotmail.com",hashing("1234")));
    }

    @Override
    public boolean auth(String nombre, String pass) {
        for (User user:users){
            if(user.getName().equals(nombre)){
                System.out.println(pass+" "+hashing(pass)+ user.comparePass(hashing(pass)));
                return user.comparePass(hashing(pass));
            }
        }
        return false;
    }

    @Override
    public String hashing(String pass) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.reset();
            byte[] hash = digest.digest(pass.getBytes());
            return bytesToStringHex(hash);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "ok";
    }
    
    
    private final static char[] hexArray ="0123456789ABCDEF".toCharArray();
    
    @Override
    public String bytesToStringHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length*2];
        for (int i = 0; i<bytes.length; i++){
            int v = bytes[i] & 0xFF;
            hexChars[i*2] = hexArray[v>>>4];
            hexChars[i*2+1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
    
    
    
}
