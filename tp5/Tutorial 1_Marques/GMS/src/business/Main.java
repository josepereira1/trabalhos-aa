package business;

import org.orm.PersistentException;

public class Main {
    public static void main(String[] args) {
        Platform platform = new Platform();
        platform.setName("PS4");
        platform.setDescription("Playstation 4");
        platform.setManufacturer("SONY");
        platform.setYear(2013);

        Game game = new Game();
        game.setName("GTA V");
        game.setDescription("Kill them all!");
        game.setPrice(59.99f);
        game.setYear(2014);
        game.setPlatform(platform);

        User user = new User();
        user.setName("João");
        user.setEmail("a81826@alunos.uminho.pt");
        user.setPassword("naotedigo");
        user.games.add(game);

        //Criar uma plataforma
        try {
            GMS.createPlatform(platform);
        } catch (PlatformAlreadyExistsException | PersistentException e) {
            e.printStackTrace();
        }

        //Procurar uma plataforma
        try {
            platform = GMS.getPlatformByName("PS4");
            System.out.println("Platform: " + platform.getName());
        } catch (PersistentException | PlatformDontExistException ex) {
            ex.printStackTrace();
        }

        //criar um jogo
        try {
            GMS.createGame(game);
        } catch (GameAlreadyExistsException | PersistentException e) {
            e.printStackTrace();
        }

        //Procurar um jogo
        try {
            game = GMS.getGameByName("GTA V");
            System.out.println("Game: " + game.getName());
        } catch (PersistentException | GameDontExistException ex) {
            ex.printStackTrace();
        }

        //Criar um utilizador
        try {
            GMS.createUser(user);
        } catch (UserAlreadyExistsException | PersistentException e) {
            e.printStackTrace();
        }

        //Procurar um utilizador
        try {
            user = GMS.getUserByName("João");
            System.out.println("User: " + user.getName());
        } catch (PersistentException | UserDontExistException ex) {
            ex.printStackTrace();
        }

        //Print all users and respective games
        try {
            for (User u : GMS.getAllUsers().toArray(new User[0])) {
                System.out.println("User: " + u.toString());
                for(Game g : u.games.toArray()) {
                    System.out.println("\tGame: " + g.getName());
                }
            }
        } catch (PersistentException e) {
            e.printStackTrace();
        }

        //Remove a game
        try {
            GMS.deleteGame(game.getName());
            System.out.println("Game removed");
        } catch (GameDontExistException | PersistentException e) {
            e.printStackTrace();
        }
    }
}
