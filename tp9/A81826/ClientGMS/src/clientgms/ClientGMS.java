/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientgms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import webservices.PersistentException_Exception;
import webservices.User;
import webservices.UserDetails;
import webservices.UserDetails_Service;
import webservices.UserDontExistException_Exception;

/**
 *
 * @author joaomarques
 */
public class ClientGMS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, PersistentException_Exception {
        //WSDL
        /*MyWebservice web = new MyWebservice_Service().getMyWebservicePort();
        Collection<Game> games = web.games();
        for(Game game: games)
            System.out.println(game.getName());
        */
        
        //REST
        /*OkHttpClient client = new OkHttpClient();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Request request;
        Response response;
        Scanner sc;
        while (true) {
            String line = in.readLine();
            String[] aux = line.split(" ",2);
            switch (aux[0]) {
                case "search":
                    //Para o POST
                    MediaType mediaType = MediaType.parse("application/JSON");
                    MediaType JSON = MediaType.get("application/json; charset=utf-8");
                    if(aux[1] != null && !aux[1].equals("")) {
                        String a = "{\"name\":\"" + aux[1] + "\"}";
                        RequestBody body = RequestBody.create(JSON,a);
                        request = new Request.Builder()
                                .url("http://localhost:8080/GMS/MyServlet/games")
                                .post(body)
                                .addHeader("content-type", "application/JSON")
                                .build();
                        response = client.newCall(request).execute();
                        sc = new Scanner(response.body().byteStream());
                        while(sc.hasNextLine()) {
                            System.out.println(sc.nextLine());
                        }
                    } else {
                        System.out.println("Use 'search <game_name>'");
                    }
                    break;
            
                case "games":
                    //Para o GET
                    request = new Request.Builder()
                            .url("http://localhost:8080/GMS/MyServlet/games")
                            .get()
                            .build();
                    response = client.newCall(request).execute();
                    sc = new Scanner(response.body().byteStream());
                    while(sc.hasNextLine()) {
                        System.out.println(sc.nextLine());
                    }
                    break;
                    
                default:
                    System.out.println("Unknown command");
                    break;
            }
            System.out.flush();
            if (aux[0].equals("exit"))
                break;
        }*/
        
        //Task 6
        //1 - REST
        /*OkHttpClient client = new OkHttpClient();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Request request;
        Response response;
        MediaType JSON = MediaType.get("application/json; charset=utf-8");
        Scanner sc;
        String username = in.readLine();
        String password = in.readLine();
        String json = "{\"username\":\"" + username + "\" , \"password\":\"" + Checksum.getFileChecksum(password.getBytes(),MessageDigest.getInstance("sha-256")) + "\"}";
        RequestBody body = RequestBody.create(json,JSON);
        request = new Request.Builder()
                .url("http://localhost:8080/GMS/UserDetailss/login")
                .post(body)
                .addHeader("content-type", "application/JSON")
                .build();
        response = client.newCall(request).execute();
        sc = new Scanner(response.body().byteStream());
        while(sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
        
        //2 - WSDL sem token
        UserDetails web = new UserDetails_Service().getUserDetailsPort();
        User u;
        try {
            u = web.searchuser(username,Checksum.getFileChecksum(password.getBytes(),MessageDigest.getInstance("sha-256")));
            System.out.println(u.getName());
        } catch (UserDontExistException_Exception e) {
            e.printStackTrace();
            System.out.println("User " + username + " dont exist");
        }*/
        
        //3 - WSDL com token
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String username = in.readLine();
        String password = in.readLine();
        UserDetails web = new UserDetails_Service().getUserDetailsPort();
        User u;
        try {
            String token = web.login(username,Checksum.getFileChecksum(password.getBytes(),MessageDigest.getInstance("sha-256")));
            u = web.searchuser(token);
            System.out.println(token);
            System.out.println(u.getName());
        } catch (UserDontExistException_Exception e) {
            e.printStackTrace();
            System.out.println("User " + username + " dont exist");
        }
    }
}
