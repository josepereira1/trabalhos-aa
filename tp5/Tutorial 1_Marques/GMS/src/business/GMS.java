package business;

import org.orm.PersistentException;

import java.util.Arrays;
import java.util.Collection;

public class GMS {

    public static Collection<User> getAllUsers() throws PersistentException {
        return Arrays.asList(UserDAO.listUserByCriteria(new UserCriteria()));
    }

    public static Collection<Game> allGames() throws PersistentException {
        return  Arrays.asList(GameDAO.listGameByCriteria(new GameCriteria()));
    }

    public static Collection<Platform> allPlatforms() throws PersistentException {
        return Arrays.asList(PlatformDAO.listPlatformByCriteria(new PlatformCriteria()));
    }

    public static User getUserByName(String name) throws PersistentException, UserDontExistException {
        User u = UserDAO.getUserByORMID(name);
        if(u == null) throw new UserDontExistException(name);
        return u;
    }

    public static Game getGameByName(String name) throws PersistentException, GameDontExistException {
        Game g = GameDAO.getGameByORMID(name);
        if(g == null) throw new GameDontExistException(name);
        return g;
    }

    public static Platform getPlatformByName(String name) throws PersistentException, PlatformDontExistException {
        Platform p = PlatformDAO.getPlatformByORMID(name);
        if(p == null) throw new PlatformDontExistException(name);
        return p;
    }

    public static Collection<Game> getGamesByUser(String name) throws UserDontExistException, PersistentException {
        User u = UserDAO.getUserByORMID(name);
        if(u == null) throw new UserDontExistException(name);
        return Arrays.asList(u.games.toArray());
    }

    public static void createUser(User user) throws UserAlreadyExistsException, PersistentException {
        User u = UserDAO.getUserByORMID(user.getName());
        if(u != null) throw new UserAlreadyExistsException(user.getName());
        UserDAO.save(user);
    }

    public static void createGame(Game game) throws GameAlreadyExistsException, PersistentException {
        Game g = GameDAO.getGameByORMID(game.getName());
        if(g != null) throw new GameAlreadyExistsException(game.getName());
        GameDAO.save(game);
    }

    public static void createPlatform(Platform platform) throws PlatformAlreadyExistsException, PersistentException {
        Platform p = PlatformDAO.getPlatformByORMID(platform.getName());
        if(p != null) throw new PlatformAlreadyExistsException(platform.getName());
        PlatformDAO.save(platform);
    }

    public static void addGameToUser(String game, User user) throws GameDontExistException, PersistentException {
        Game g = GameDAO.getGameByORMID(game);
        if(g == null) throw new GameDontExistException(game);
        user.games.add(g);
        UserDAO.save(user);
    }

    public static void deleteGame(String name) throws GameDontExistException, PersistentException {
        Game game = GameDAO.getGameByORMID(name);
        if(game == null) throw new GameDontExistException(name);
        User[] users = UserDAO.listUserByCriteria(new UserCriteria());
        for (User user : users) {
            Game[] games = user.games.toArray();
            for (Game value : games) {
                if (value.equals(game)) {
                    user.games.remove(game);
                    break;
                }
            }
        }
        GameDAO.delete(game);
    }
}
