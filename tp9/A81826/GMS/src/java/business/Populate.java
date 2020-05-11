package business;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

public class Populate {
    public static void main(String[] args) throws PersistentException {
        
        GMS facade = GMS.getGMS();
        PersistentSession s = MddpPersistentManager.instance().getSession();
        PersistentTransaction t = s.beginTransaction();
        
        //-------------------------------------------------------------------//
        //Plataforms
        //MegaDrive
        Platform p1 = new Platform();
        p1.setName("MegaDrive");
        p1.setDescription("A 16-bit home video game console.");
        p1.setManufacturer("SEGA");
        p1.setYear(1988);
        try {
            facade.registerPlatform(p1);
        } catch (PlatformAlreadyExistsException | PersistentException e) {
            e.printStackTrace();
        }

        //PC
        Platform p2 = new Platform();
        p2.setName("PC");
        p2.setDescription("A personal computer (PC) is a multi-purpose electronic computer whose size, capabilities, and price make it feasible for individual use.");
        p2.setManufacturer("N/A");
        p2.setYear(1977);
        try {
            facade.registerPlatform(p2);
        } catch (PlatformAlreadyExistsException | PersistentException e) {
            e.printStackTrace();
        }

        //Playstation 4
        Platform p3 = new Platform();
        p3.setName("Playstation 4");
        p3.setDescription("The PlayStation 4 (abbreviated as PS4) is a home video game console developed by Sony Computer Entertainment.");
        p3.setManufacturer("SONY");
        p3.setYear(2013);
        try {
            facade.registerPlatform(p3);
        } catch (PlatformAlreadyExistsException | PersistentException e) {
            e.printStackTrace();
        }

        //-------------------------------------------------------------------//
        //Games
        //Sonic the Hedgehog
        Game g1 = new Game();
        g1.setName("Sonic the Hedgehog");
        g1.setPrice(60.0f);
        g1.setDescription("Sonic the Hedgehog is a platform video game developed by Sonic Team and published by Sega for the Sega Genesis console.");
        g1.setYear(1991);
        g1.setPlatform(p1);
        try {
            facade.registerGame(g1);
        } catch (GameAlreadyExistsException | PersistentException e) {
            e.printStackTrace();
        }

        //Dune
        Game g2 = new Game();
        g2.setName("Dune");
        g2.setPrice(65.0f);
        g2.setDescription("Dune: The Battle for Arrakis is a real-time strategy Dune video game developed by Westwood Studios.");
        g2.setYear(1993);
        g2.setPlatform(p1);
        try {
            facade.registerGame(g2);
        } catch (GameAlreadyExistsException | PersistentException e) {
            e.printStackTrace();
        }

        //Half Life 3
        Game g3 = new Game();
        g3.setName("Half Life 3");
        g3.setPrice(60.0f);
        g3.setDescription("Half-Life 3 is a first-person shooter video game developed and published by Valve Corporation.");
        g3.setYear(2018);
        g3.setPlatform(p2);
        try {
            facade.registerGame(g3);
        } catch (GameAlreadyExistsException | PersistentException e) {
            e.printStackTrace();
        }

        //Age of Empires
        Game g4 = new Game();
        g4.setName("Age of Empires");
        g4.setPrice(70.0f);
        g4.setDescription("Age of Empires is a series of personal computer games developed by Ensemble Studios (defunct in 2009) and published by Microsoft Studios.");
        g4.setYear(1997);
        g4.setPlatform(p2);
        try {
            facade.registerGame(g4);
        } catch (GameAlreadyExistsException | PersistentException e) {
            e.printStackTrace();
        }

        //GTA V
        Game g5 = new Game();
        g5.setName("GTA V");
        g5.setPrice(70.0f);
        g5.setDescription("Grand Theft Auto V is an action-adventure video game developed by Rockstar North and published by Rockstar Games.");
        g5.setYear(2013);
        g5.setPlatform(p3);
        try {
            facade.registerGame(g5);
        } catch (GameAlreadyExistsException | PersistentException e) {
            e.printStackTrace();
        }

        //-------------------------------------------------------------------//
        //Users
        User u = new User();
        u.setName("Joao");
        u.setEmail("a81826@alunos.uminho.pt");
        u.addGame(g3);
        u.addGame(g5);
        String password = null;
        try {
            password = Checksum.getFileChecksum("naotedigo".getBytes(), MessageDigest.getInstance("sha-256"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        u.setPassword(password);
        try {
            facade.registerUser(u);
        } catch (UserAlreadyExistsException | PersistentException e) {
            e.printStackTrace();
        }
        
        try {
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        }
        s.close();
    }
}
