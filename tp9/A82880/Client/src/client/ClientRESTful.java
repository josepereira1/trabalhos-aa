/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.util.Base64;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 *
 * @author josepereira
 */
public class ClientRESTful {
    
    String name;

    /**
     * @param args the command line arguments
     */
    
    public static void searchGame(OkHttpClient client){
        String name = "";
        System.out.println("name:");
        Scanner input = new Scanner(System.in);
        name = input.nextLine();
        
        MediaType mediaType = MediaType.parse("application/JSON");
        MediaType JSON = MediaType.get("application/json; charset=utf-8");


        RequestBody body = RequestBody.create(JSON, "{\"name\":\"" + name + "\"}");
        Request request;
        request = new Request.Builder().url("http://localhost:8080/GMSWeb/MyServlet/game").post(body).addHeader("content-type", "application/JSON").build();

        Response response = null;

        try {
            response = client.newCall(request).execute();
        } catch (IOException ex) {
            Logger.getLogger(ClientRESTful.class.getName()).log(Level.SEVERE, null, ex);
        }
        print(response);
    }
    
    public static void listGames(OkHttpClient client){
        Request request = new Request.Builder().url("http://localhost:8080/GMSWeb/MyServlet/games").get().build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException ex) {
            Logger.getLogger(ClientRESTful.class.getName()).log(Level.SEVERE, null, ex);
        }
        print(response);
    }
    
    private static void print(Response response){
        if(response != null){
            Scanner sc = new Scanner(response.body().byteStream());
            while(sc.hasNextLine())System.out.println(sc.nextLine());
        }
    }
    
    public boolean login(OkHttpClient client){
        String password = "";
        Scanner input = new Scanner(System.in);
        System.out.println("you need login:");
        
        System.out.println("name:");
        this.name = input.nextLine();
        
        System.out.println("password:");
        password = input.nextLine();
        
        Request request;
        request = new Request.Builder().url("http://localhost:8080/GMSWeb/LoginRestService/login").header("Basic", hash(this.name, password)).get().build(); //  header("Basic", hash(name, password))

        Response response = null;
        
        try {
            response = client.newCall(request).execute();
            int res = response.code();
            
            if(res == 200){
                System.out.println("Sucess!");
                return true;
            }
            else {
                System.err.println("Error!");
                return false;
            }
        } catch (IOException ex) {
            //Logger.getLogger(ClientRESTful.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void userDetails(OkHttpClient client){
        
        MediaType mediaType = MediaType.parse("application/JSON");
        MediaType JSON = MediaType.get("application/json; charset=utf-8");

        RequestBody body = RequestBody.create(JSON, "{\"name\":\"" + this.name + "\"}");
        Request request;
        request = new Request.Builder().url("http://localhost:8080/GMSWeb/UserDetails/user").post(body).addHeader("content-type", "application/JSON").build(); //  header("Basic", hash(name, password))
        
        Response response = null;
        
        //  fiz a sugestão do tutorial onde diz para fazermos a autenticação usando o HTTP authentication framework

        try {
            response = client.newCall(request).execute();
            if(response.code() == 401){ //  ERRO 401, NÃO AUTENTICADO
                while(!login(client));  //  vai insistir no login e voltar a repetir o pedido
                body = RequestBody.create(JSON, "{\"name\":\"" + this.name + "\"}");
                request = new Request.Builder().url("http://localhost:8080/GMSWeb/UserDetails/user").post(body).addHeader("content-type", "application/JSON").build();
                response = client.newCall(request).execute();
            }
        } catch (IOException ex) {
            Logger.getLogger(ClientRESTful.class.getName()).log(Level.SEVERE, null, ex);
        }
        print(response);
    }
    
    private static String hash(String name, String password){
       return Base64.getEncoder().encodeToString((name + ":" + password).getBytes());     
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        // WSDL Webservice
       
        Scanner input = new Scanner(System.in);
        
        String option = "";
        boolean in = true;
        
        OkHttpClient client = new OkHttpClient();
        
        ClientRESTful clientRest = new ClientRESTful();
        
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
                    clientRest.userDetails(client);
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
}
