package aa;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.orm.PersistentException;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.hibernate.Query;
import org.orm.PersistentSession;

public class GMS implements IGMS {
    
    private static IGMS gms;
    
    private GMS() {}
    
    public static IGMS getGMS() {
        if (gms == null) gms = new GMS();
        return gms;
    }
    
    public void addGameToUser(String username, Game game, PersistentSession persistentSession) throws PersistentException, UserNotExistsException {
        User user = getUser(username, persistentSession);  
        user.games.add(game);
        UserDAO.save(user);
    }

    @Override
    public void registerUser(User user, PersistentSession s) throws PersistentException, UserAlreadyExistsException {
        if (s == null) {
            if (UserDAO.getUserByORMID(user.getName()) != null) throw new UserAlreadyExistsException(user.getName());
        }
        else {
            if (UserDAO.getUserByORMID(s, user.getName()) != null) throw new UserAlreadyExistsException(user.getName());
        }
        UserDAO.save(user);
    }

    @Override
    public void registerGame(Game game, PersistentSession s) throws PersistentException, GameAlreadyExistsException {
        if (s == null) {
            if (GameDAO.getGameByORMID(game.getName()) != null) throw new GameAlreadyExistsException(game.getName());
        }
        else {
            if (GameDAO.getGameByORMID(s, game.getName()) != null) throw new GameAlreadyExistsException(game.getName());
        }
        GameDAO.save(game);
    }

    @Override
    public void registerPlatform(Platform platform, PersistentSession s) throws PersistentException, PlatformAlreadyExistsException {
        if (s == null) {
            if (PlatformDAO.getPlatformByORMID(platform.getName()) != null) throw new PlatformAlreadyExistsException(platform.getName());
        }
        else {
            if (PlatformDAO.getPlatformByORMID(s, platform.getName()) != null) throw new PlatformAlreadyExistsException(platform.getName());
        }
        PlatformDAO.save(platform);
    }
    
    @Override
    public User getUser(String name, PersistentSession s) throws PersistentException, UserNotExistsException {
        User user = null;
        if (s == null) user = UserDAO.getUserByORMID(name);
        else user = UserDAO.getUserByORMID(s, name);
        if (user == null) throw new UserNotExistsException(name);
        return user;
    }
    
    @Override
    public Platform getPlatform(String platformname, PersistentSession s) throws PersistentException, PlatformNotExistsException {
        Platform platform = null;
        if (s == null) platform = PlatformDAO.getPlatformByORMID(platformname);
        else platform = PlatformDAO.getPlatformByORMID(s, platformname);
        if (platform == null) throw new PlatformNotExistsException(platformname);
        return platform;
    }
    
    @Override
    public boolean autenticateUser(String name, String password, PersistentSession s) throws PersistentException, UserNotExistsException {
        User user = this.getUser(name, s);
        return user.getPassword().equals(password);
    }

    @Override
    public Collection<Game> getUserGames(String userName, PersistentSession s) throws PersistentException, UserNotExistsException {
        User user = null;
        if (s == null) user =  UserDAO.getUserByORMID(userName);
        else user = UserDAO.getUserByORMID(s, userName);
        if (user == null) throw new UserNotExistsException(userName);
        return Arrays.asList(user.games.toArray());
    }

    @Override
    public Collection<Game> getAllGames(PersistentSession s) throws PersistentException {
        Game[] games = null;
        if (s == null) games = GameDAO.listGameByCriteria(new GameCriteria());
        else games = GameDAO.listGameByCriteria(new GameCriteria(s));
        return Arrays.asList(games);
    }

    @Override
    public Game getGame(String gameName, PersistentSession s) throws PersistentException, GameNotExistsException {
        Game game = null;
        if (s == null) game = GameDAO.getGameByORMID(gameName);
        else game = GameDAO.getGameByORMID(s, gameName);
        if (game == null) throw new GameNotExistsException(gameName);
        return game;
    }

    @Override
    public void deleteGame(String gameName, PersistentSession s) throws PersistentException, GameNotExistsException {
        Game game = null;
        if (s == null) game = GameDAO.getGameByORMID(gameName);
        else game = GameDAO.getGameByORMID(s, gameName);
        if (game == null) throw new GameNotExistsException(gameName);

        // Aceder a cada User e remover o Game da sua Collection
        Iterator it = game.users.getIterator();
        while(it.hasNext()) {
            User user = (User) it.next();
            user.games.remove(game);
        }

        // Aceder a cada Platform e remover o Game da sua Collection
        it = game.platforms.getIterator();
        while(it.hasNext()) {
            Platform platform = (Platform) it.next();
            platform.games.remove(game);
        }

        GameDAO.delete(game);
    }
    
    @Override
    public Collection<Platform> getAllPlatforms(PersistentSession s) throws PersistentException {
        Platform[] platforms = null;
        if (s == null) platforms = PlatformDAO.listPlatformByCriteria(new PlatformCriteria());
        else platforms = PlatformDAO.listPlatformByCriteria(new PlatformCriteria(s));
        return Arrays.asList(platforms);
    }
}