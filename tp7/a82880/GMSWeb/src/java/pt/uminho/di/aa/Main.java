package pt.uminho.di.aa;

import org.orm.PersistentException;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        GMS gms = new GMS();
        try {
            gms.addGameToPersonalLibrary("jose", "GTA V", null);
        } catch (PersistentException e) {
            e.printStackTrace();
        } catch (UserNotExistsException e) {
            e.printStackTrace();
        } catch (InvalidParametersException e) {
            e.printStackTrace();
        } catch (GameNotExistsException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        GameSetCollection games = null;
        try {
            games = gms.listUserGames("jose", null);
        } catch (PersistentException e) {
            e.printStackTrace();
        }

        Iterator it = games.getIterator();
        while(it.hasNext()){
            Game g = (Game) it.next();
            System.out.println(g);
        }


    }
}
