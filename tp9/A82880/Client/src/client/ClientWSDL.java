/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import webservices.Game;
import webservices.GameNotExistsException_Exception;
import webservices.Games;
import webservices.Games_Service;
import webservices.InvalidParametersException_Exception;
import webservices.NoSuchAlgorithmException_Exception;
import webservices.PersistentException_Exception;
import webservices.User;
import webservices.UserNotExistsException_Exception;
import webservices.Users;
import webservices.UsersWithTokens;
import webservices.UsersWithTokens_Service;
import webservices.Users_Service;

/**
 *
 * @author josepereira
 */
public class ClientWSDL {
    
    static String token;
    String name;
    
    public static void searchGame(OkHttpClient client){
        String name = "";
        System.out.println("name:");
        Scanner input = new Scanner(System.in);
        name = input.nextLine();
        
        Games games = new Games_Service().getGamesPort();
        Game g = null;
        try {
            g = games.searchGame(name);
        } catch (GameNotExistsException_Exception ex) {
            System.err.println("Game not exists!"); 
            return ;
            //Logger.getLogger(ClientWSDL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidParametersException_Exception ex) {
            System.err.println("Invalid parameters!"); 
            return ;
            //Logger.getLogger(ClientWSDL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PersistentException_Exception ex) {
           System.err.println("Error!"); 
           return ;
           //Logger.getLogger(ClientWSDL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(g != null){
            System.out.println("name:"+g.getName());
            System.out.println("price:"+g.getPrice());
            System.out.println("year:"+g.getYear());
            System.out.println("platform:"+g.getDescription());
        }else System.err.println("Error!"); 
    }
    
    public static void listGames(OkHttpClient client){
        Games games = new Games_Service().getGamesPort();
        try {
            for(Game g : games.listGames()){
                System.out.println(g.getName());
                System.out.println(g.getPrice());
                System.out.println(g.getYear());
                System.out.println(g.getDescription());
            }
        } catch (PersistentException_Exception ex) {
            System.err.println("Error!"); 
            //Logger.getLogger(ClientWSDL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void userDetails(OkHttpClient client){
        
        String name = "", password = "";
        Scanner input = new Scanner(System.in);
        System.out.println("you need login:");
        
        System.out.println("name:");
        name = input.nextLine();
        
        System.out.println("password:");
        password = input.nextLine();
        
        Users users = new Users_Service().getUsersPort();
        User user = null;
        
        try {
            user = users.userDetails(name, password);
        } catch (PersistentException_Exception ex) {
            System.err.println("Error!"); 
            //Logger.getLogger(ClientWSDL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UserNotExistsException_Exception ex) {
            System.err.println("Invalid credentials!"); 
            //Logger.getLogger(ClientWSDL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(user != null){
            System.out.println("name:" + user.getName());
            System.out.println("email:" + user.getEmail());
            System.out.println("games:" + user.getGames());
        }else System.err.println("Error!");
    }
    
    public void userDetailsUsingTokens(OkHttpClient client){
        UsersWithTokens users = new UsersWithTokens_Service().getUsersWithTokensPort();
        Scanner input = new Scanner(System.in);
        String password = "";
        User user = null;
        if(this.token == null){
            System.out.println("you need login:");

            System.out.println("name:");
            this.name = input.nextLine();

            System.out.println("password:");
            password = input.nextLine();
   
            try {
                this.token = users.login(this.name, password);
            } catch (NoSuchAlgorithmException_Exception ex) {
                System.err.println("Error!"); 
                //Logger.getLogger(ClientWSDL.class.getName()).log(Level.SEVERE, null, ex);
            } catch (PersistentException_Exception ex) {
                System.err.println("Error!"); 
                //Logger.getLogger(ClientWSDL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        try {
            user = users.userDetails(token, this.name);
        } catch (PersistentException_Exception ex) {
            System.err.println("Error!"); 
            //Logger.getLogger(ClientWSDL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UserNotExistsException_Exception ex) {
            System.err.println("User do not exists!"); 
            //Logger.getLogger(ClientWSDL.class.getName()).log(Level.SEVERE, null, ex);
        }

        if(user != null){
            System.out.println("name:" + user.getName());
            System.out.println("email:" + user.getEmail());
            System.out.println("games:" + user.getGames());
        }else{
            token = null;   //  token era inválido
            System.err.println("Error!");
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        // WSDL Webservice
        /*
        Games games = new Games_Service().getGamesPort();
        for(Game g : games.listGames())System.out.println(g.getName());
        */
        
       
        Scanner input = new Scanner(System.in);
        
        String option = "";
        boolean in = true;
        
        OkHttpClient client = new OkHttpClient();
        
        ClientWSDL wsdlClient = new ClientWSDL();
        
        while(in){
            System.out.println("choose option (type): userDetails, searchGame, listGames or exit");
            option = input.nextLine();
            switch(option){
                case "searchGame":
                    searchGame(client);
                    break;
                case "listGames":
                    listGames(client);
                    break;
                case "userDetails":
                    //userDetails(client);                //  without tokens
                    wsdlClient.userDetailsUsingTokens(client);     //  with tokens   
                    break;
                case "exit":
                    in = false;
                    break;
                default:
                    System.err.println("Error!");
                    break;
            }
            
        }
    }

    private static Object Users_Service() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
