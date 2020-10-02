/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.secureconection;

import edu.escuelaing.arep.secureconection.Persistence.AppPersistence;
import edu.escuelaing.arep.secureconection.Persistence.AppPersistenceService;
import java.util.Properties;
import spark.Request;
import spark.Response;
import spark.Service;
import static spark.Spark.*;
import spark.staticfiles.StaticFilesConfiguration;
/**
 *
 * @author diego
 */
public class Conection {
    public static AppPersistence s;
    public static void main(String[] args){
        run();
    }
    public static void run(){
        s= new AppPersistenceService();
        getPort();
        secure("keystores/ecikeystore.p12", "123456", null, null);
        get("/login", (req, res) -> inputDataPage(req, res));
        get("/results", (req, res) -> resultsPage(req, res));
        
        
    }
    
    private static String inputDataPage(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>Value of PI</h2>"
                + "<h3>Please login</h3>"
                + "<form action=\"/results\">"
                + "  Login:<br>"
                + "  <input type=\"text\" name=\"Usuario\" value=\"mail\">"
                + "  <br><br>"
                + "  <input type=\"text\" name=\"passwd\" value=\"password\">"
                + "  <br><br>"
                + "  <input type=\"submit\" name=\"login\" value=\"login\">"
                + "</form>"
                + "</body>"
                + "</html>";
        return pageContent;
    }
    
    private static String resultsPage(Request req, Response res) {
        System.out.println(req.queryParams("Usuario")+" "+req.queryParams("passwd"));
        if(s.auth(req.queryParams("Usuario"), req.queryParams("passwd"))){
            return "El valor de Pi es "+Double.toString(Math.PI);
        }
        return "please login";
    }
    
    
    
    private  static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000;
    } 
}



