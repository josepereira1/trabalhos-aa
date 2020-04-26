package aa;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.orm.PersistentException;
import ormsamples.CreateGMSDatabaseSchema;
import ormsamples.DropGMSDatabaseSchema;

public class Populate {

    public static void main(String[] args) {

        IGMS gms = GMS.getGMS();
        
        DropGMSDatabaseSchema.main(null);
        CreateGMSDatabaseSchema.main(null);

        Platform megadrive = new Platform();
        Platform pc = new Platform();
        Platform ps4 = new Platform();
        
        Game sonic = new Game();
        Game dune = new Game();
        Game halfLife3 = new Game();
        Game ageOfEmpires = new Game();
        Game gtaV = new Game();
        
        User ricardo = new User();
        
        megadrive.setName("MegaDrive");
        megadrive.setDescription("A 16-bit home video game console.");
        megadrive.setManufacturer("SEGA");
        megadrive.setYear(1988);
        megadrive.games.add(sonic);
        megadrive.games.add(dune);         
 
        pc.setName("PC");
        pc.setDescription("A personal computer (PC) is a multi-purpose electronic computer whose size, capabilities, and price make it feasible for individual use.");
        pc.setManufacturer("N/A");
        pc.setYear(1977);
        pc.games.add(halfLife3);
        pc.games.add(ageOfEmpires);
        
        ps4.setName("Playstation 4");
        ps4.setDescription("The PlayStation 4 (abbreviated as PS4) is a home video game console developed by Sony Computer Entertainment.");
        ps4.setManufacturer("SONY");
        ps4.setYear(2013);
        ps4.games.add(gtaV);
       
        sonic.setName("Sonic the Hedgehog");
        sonic.setPrice(60.0f);
        sonic.setDescription("Sonic the Hedgehog is a platform video game developed by Sonic Team and published by Sega for the Sega Genesis console.");
        sonic.setYear(1991);
        sonic.platforms.add(megadrive);
        sonic.users.add(ricardo);
        
        dune.setName("Dune");
        dune.setPrice(65.0f);
        dune.setDescription("Dune: The Battle for Arrakis is a real-time strategy Dune video game developed by Westwood Studios.");
        dune.setYear(1993);
        dune.platforms.add(megadrive);

        halfLife3.setName("Half Life 3");
        halfLife3.setPrice(60.0f);
        halfLife3.setDescription("Half-Life 3 is a first-person shooter video game developed and published by Valve Corporation.");
        halfLife3.setYear(2018);
        halfLife3.platforms.add(pc);

        ageOfEmpires.setName("Age of Empires");
        ageOfEmpires.setPrice(70.0f);
        ageOfEmpires.setDescription("Age of Empires is a series of personal computer games developed by Ensemble Studios (defunct in 2009) and published by Microsoft Studios.");
        ageOfEmpires.setYear(1997);
        ageOfEmpires.platforms.add(pc);
        
        gtaV.setName("GTA V");
        gtaV.setPrice(70.0f);
        gtaV.setDescription("Grand Theft Auto V is an action-adventure video game developed by Rockstar North and published by Rockstar Games.");
        gtaV.setYear(2013);
        gtaV.platforms.add(ps4);
        gtaV.users.add(ricardo);

        ricardo.setName("Ricardo");
        ricardo.setEmail("a81744@alunos.uminho.pt");
        try {
            String password = Checksum.getFileChecksum("password".getBytes(), MessageDigest.getInstance("SHA-256"));
            ricardo.setPassword(password);       
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        
        try {
            gms.registerPlatform(megadrive, null);
        } catch (PlatformAlreadyExistsException e) {
            e.printStackTrace();
        } catch (PersistentException ex) {
            Logger.getLogger(Populate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          try {
            gms.registerPlatform(pc, null);
        } catch (PlatformAlreadyExistsException e) {
            e.printStackTrace();
        } catch (PersistentException ex) {
            Logger.getLogger(Populate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            gms.registerPlatform(ps4, null);
        } catch (PlatformAlreadyExistsException e) {
            e.printStackTrace();
        } catch (PersistentException ex) {
            Logger.getLogger(Populate.class.getName()).log(Level.SEVERE, null, ex);
        }
                  
        try {
            gms.registerGame(sonic, null);
        } catch (GameAlreadyExistsException e) {
            e.printStackTrace();
        } catch (PersistentException ex) {
            Logger.getLogger(Populate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            gms.registerGame(dune, null);
        } catch (GameAlreadyExistsException e) {
            e.printStackTrace();
        } catch (PersistentException ex) {
            Logger.getLogger(Populate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            gms.registerGame(halfLife3, null);
        } catch (GameAlreadyExistsException e) {
            e.printStackTrace();
        } catch (PersistentException ex) {
            Logger.getLogger(Populate.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            gms.registerGame(ageOfEmpires, null);
        } catch (GameAlreadyExistsException e) {
            e.printStackTrace();
        } catch (PersistentException ex) {
            Logger.getLogger(Populate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            gms.registerGame(gtaV, null);
        } catch (GameAlreadyExistsException e) {
            e.printStackTrace();
        } catch (PersistentException ex) {
            Logger.getLogger(Populate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            gms.registerUser(ricardo, null);
        } catch (UserAlreadyExistsException e) {
            e.printStackTrace();
        } catch (PersistentException ex) {
            Logger.getLogger(Populate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

