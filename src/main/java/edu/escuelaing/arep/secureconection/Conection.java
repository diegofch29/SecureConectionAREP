/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.secureconection;

import static spark.Spark.*;
/**
 *
 * @author diego
 */
public class Conection {
    
    public static void main(String[] args){
        getPort();
        secure("keystores/ecikeystore.p12", "123456", null, null);
        get("/hello",(req, res) -> "hello");
    }
    
    private  static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000; //returns default port if heroku-port isn't set (i.e. on localhost)
    } 
}



