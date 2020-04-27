/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uminho.di.aa;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.orm.PersistentException;

/**
 *
 * @author josepereira
 */
public class Populate {
    public static void main (String[] args){
        GMS gms = new GMS();
        
        Platform megadrive = new Platform();
        megadrive.setName("MegaDrive");
        megadrive.setDescription("A 16-bit home video game console.");
        megadrive.setManufacture("SEGA");
        megadrive.setYear(1988);
        try {
            gms.registerPlatform(megadrive, null);
        } catch (PlatformExistsException e) {
            e.printStackTrace();
        } catch (PersistentException ex) {
            Logger.getLogger(Populate.class.getName()).log(Level.SEVERE, null, ex);
        }
        Platform pc = new Platform();
        pc.setName("PC");
        pc.setDescription("A personal computer (PC) is a multi-purpose electronic computer whose size, capabilities, and price make it feasible for individual use.");
        pc.setManufacture("N/A");
        pc.setYear(1977);
        try {
            gms.registerPlatform(pc, null);
        } catch (PlatformExistsException e) {
            e.printStackTrace();
        } catch (PersistentException ex) {
            Logger.getLogger(Populate.class.getName()).log(Level.SEVERE, null, ex);
        }
        Platform ps4 = new Platform();
        ps4.setName("Playstation 4");
        ps4.setDescription("The PlayStation 4 (abbreviated as PS4) is a home video game console developed by Sony Computer Entertainment.");
        ps4.setManufacture("SONY");
        ps4.setYear(2013);
        try {
            gms.registerPlatform(ps4, null);
        } catch (PlatformExistsException e) {
            e.printStackTrace();
        } catch (PersistentException ex) {
            Logger.getLogger(Populate.class.getName()).log(Level.SEVERE, null, ex);
        }
        Game sonic = new Game();
        sonic.setName("Sonic the Hedgehog");
        sonic.setPrice(60.0f);
        sonic.setDescription("Sonic the Hedgehog is a platform video game developed by Sonic Team and published by Sega for the Sega Genesis console.");
        sonic.setYear(1991);
        sonic.setPlatform(megadrive);
        try {
            gms.registerGame(sonic, null);
        } catch (GameExistsException e) {
            e.printStackTrace();
        } catch (PersistentException ex) {
            Logger.getLogger(Populate.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidParametersException ex) {
            Logger.getLogger(Populate.class.getName()).log(Level.SEVERE, null, ex);
        }
        Game dune = new Game();
        dune.setName("Dune");
        dune.setPrice(65.0f);
        dune.setDescription("Dune: The Battle for Arrakis is a real-time strategy Dune video game developed by Westwood Studios.");
        dune.setYear(1993);
        dune.setPlatform(megadrive);
        try {
            gms.registerGame(dune, null);
        } catch (GameExistsException e) {
            e.printStackTrace();
        } catch (PersistentException ex) {
            Logger.getLogger(Populate.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidParametersException ex) {
            Logger.getLogger(Populate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Game halfLife3 = new Game();
        halfLife3.setName("Half Life 3");
        halfLife3.setPrice(60.0f);
        halfLife3.setDescription("Half-Life 3 is a first-person shooter video game developed and published by Valve Corporation.");
        halfLife3.setYear(2018);
        halfLife3.setPlatform(pc);
        try {
            gms.registerGame(halfLife3, null);
        } catch (GameExistsException e) {
            e.printStackTrace();
        } catch (PersistentException ex) {
            Logger.getLogger(Populate.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidParametersException ex) {
            Logger.getLogger(Populate.class.getName()).log(Level.SEVERE, null, ex);
        }
        Game ageOfEmpires = new Game();
        ageOfEmpires.setName("Age of Empires");
        ageOfEmpires.setPrice(70.0f);
        ageOfEmpires.setDescription("Age of Empires is a series of personal computer games developed by Ensemble Studios (defunct in 2009) and published by Microsoft Studios.");
        ageOfEmpires.setYear(1997);
        ageOfEmpires.setPlatform(pc);
        try {
            gms.registerGame(ageOfEmpires, null);
        } catch (GameExistsException e) {
            e.printStackTrace();
        } catch (PersistentException ex) {
            Logger.getLogger(Populate.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidParametersException ex) {
            Logger.getLogger(Populate.class.getName()).log(Level.SEVERE, null, ex);
        }
        Game gtaV = new Game();
        gtaV.setName("GTA V");
        gtaV.setPrice(70.0f);
        gtaV.setDescription("Grand Theft Auto V is an action-adventure video game developed by Rockstar North and published by Rockstar Games.");
        gtaV.setYear(2013);
        gtaV.setPlatform(ps4);
        try {
            gms.registerGame(gtaV, null);
        } catch (GameExistsException e) {
            e.printStackTrace();
        } catch (PersistentException ex) {
            Logger.getLogger(Populate.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidParametersException ex) {
            Logger.getLogger(Populate.class.getName()).log(Level.SEVERE, null, ex);
        }
        Collection<Game> games = new ArrayList();
        
        User user = new User();
        user.setName("Joana");
        user.setEmail("joanan@email");
        user.setPassword("password");
        user.games.add(sonic);
        user.games.add(gtaV);
    
        try {
            gms.registerUser(user, null);
        } catch (UserExistsException e) {
            e.printStackTrace();
        } catch (PersistentException e){
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        } catch (InvalidParametersException ex) {
            Logger.getLogger(Populate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
