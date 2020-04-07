import org.hibernate.*;
import pt.uminho.di.aa.*;

import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        try {
            GMS facade = new GMS();
            //4 - start the transaction
            facade.beginTransaction();

            Collection<Format> formats = new ArrayList<>();
            Collection<Game> games = new ArrayList<>();

            //Create and save new objects
            Format f = new Format();
            f.setDescription("Dont know");
            f.setKind(1);
            try {
                facade.registerFormat(f);
            } catch (FormatAlreadyExistsException e) {
                e.printStackTrace();
            }
            formats.add(f);

            Platform p = new Platform();
            p.setName("PS4");
            p.setDescription("Playstation 4");
            p.setManufacturer("SONY");
            p.setYear(2013);
            p.setFormats(formats);
            try {
                facade.registerPlatform(p);
            } catch (PlatformAlreadyExistsException e) {
                e.printStackTrace();
            }

            Game g1 = new Game();
            g1.setName("GTA V");
            g1.setPrice(60.0f);
            g1.setDescription("Kill them all!");
            g1.setYear(2014);
            g1.setPlatform(p);
            try {
                facade.registerGame(g1);
            } catch (GameAlreadyExistsException e) {
                e.printStackTrace();
            }
            games.add(g1);

            Game g2 = new Game();
            g2.setName("Gran Turismo Sport");
            g2.setPrice(59.99f);
            g2.setDescription("Race them all!");
            g2.setYear(2015);
            g2.setPlatform(p);
            try {
                facade.registerGame(g2);
            } catch (GameAlreadyExistsException e) {
                e.printStackTrace();
            }
            games.add(g2);

            User u = new User();
            u.setName("João");
            u.setEmail("a81826@alunos.uminho.pt");
            u.setPassword("naotedigo");
            u.setGames(games);
            try {
                facade.registerUser(u);
            } catch (UserAlreadyExistsException e) {
                e.printStackTrace();
            }

            try {
                //6 - commit the transaction
                facade.commit();
            } catch (Exception e) {
                //6 - rollback in case of exception
                facade.rollback();
                e.printStackTrace();
                System.out.println("Unable to commit changes");
            }

            System.out.println("Todos os Users");
            //Get allUsers
            Collection<User> users = facade.getAllUsers();
            for(User user : users) {
                System.out.println("User: " + user.toString());
            }

            System.out.println("##############################################################");

            System.out.println("Todos os Games");
            //Get allGames
            Collection<Game> gamess = facade.getAllGames();
            for(Game game: gamess) {
                System.out.println("Game: " + game.toString());
            }

            System.out.println("##############################################################");

            System.out.println("Todos os Games do User: " + u.getGames());
            //Get User games
            try {
                Collection<Game> user_games = facade.getUserGames(u.getName());
                for (Game game : user_games) {
                    System.out.println("User game: " + game.toString());
                }
            } catch (UserDontExistException e) {
                e.printStackTrace();
            }

            System.out.println("##############################################################");

            System.out.println("Jogo: " + g1.getName());
            //Get Game
            try {
                Game get = facade.searchGame("GTA V");
                System.out.println("Game: " + get.toString());
            } catch (GameDontExistsException e) {
                e.printStackTrace();
            }

            System.out.println("##############################################################");

            facade.beginTransaction();
            //Delete Game
            try {
                facade.deleteGame(g2.getName());
                //facade.deleteGame("Call of Duty");
                //Print user to show that game is remove
                System.out.println("User games after remove: " + facade.getUserGames(u.getName()).toString());
            } catch (GameDontExistsException e) {
                e.printStackTrace();
            }

            try {
                //6 - commit the transaction
                facade.commit();
            } catch (Exception e) {
                //6 - rollback in case of exception
                facade.rollback();
                e.printStackTrace();
                System.out.println("Unable to commit changes");
            }

            //7 - Close the session and end process
            facade.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable to connect to hibernate");
        }
    }
}
