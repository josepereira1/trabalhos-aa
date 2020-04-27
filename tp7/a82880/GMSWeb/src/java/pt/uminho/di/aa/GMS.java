package pt.uminho.di.aa;

import org.orm.PersistentException;
import org.orm.PersistentSession;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GMS {
    
    private static GMS gms; //  Singleton
    
    protected GMS(){
        
    }
    
    //  Singleton
    public static GMS getGMS(){
        if(gms == null)gms = new GMS();
        return gms;
    }
    
    public boolean login(String name, String password, PersistentSession session) throws PersistentException, NoSuchAlgorithmException {
        if(name != null && password !=null && containsUser(name, session)){
            String cryptPassword = Checksum.getFileChecksum(password.getBytes(), MessageDigest.getInstance("SHA-256"));
            return cryptPassword.equals(UserDAO.getUserByORMID(name).getPassword());
        }else
            return false;
    }
    public void registerUser(User user, PersistentSession session) throws PersistentException, UserExistsException, NoSuchAlgorithmException, InvalidParametersException {
        if((user.getName() == null || user.getName().equals("")) || (user.getPassword() == null || user.getPassword().equals("")) || (user.getEmail() == null || user.getEmail().equals(""))) throw new InvalidParametersException();
        if(!containsUser(user.getName(), session)){
            //  create user with an hashed password.
            if(user.getPassword() != null)user.setPassword(Checksum.getFileChecksum(user.getPassword().getBytes(), MessageDigest.getInstance("SHA-256")));
            UserDAO.save(user);
        }
        else throw new UserExistsException(user.getName());
    }

    public void registerGame(Game game, PersistentSession session) throws PersistentException, GameExistsException, InvalidParametersException {
        if(game.getName() == null || game.getName().equals("") || game.getPlatform() == null) throw new InvalidParametersException();
        if(!containsGame(game.getName(), session)){
            GameDAO.save(game);
        }else throw new GameExistsException(game.getName());
    }

    public void addGameToPersonalLibrary(String username, String gameName, PersistentSession session) throws PersistentException, UserNotExistsException, InvalidParametersException, GameNotExistsException {

        if(username == null || username.equals("") || gameName == null || gameName.equals("")) throw new InvalidParametersException();
        if(!containsUser(username, session)) throw new UserNotExistsException(username);

        if(containsGame(gameName, session)){
            Game game = null;

            if(session == null) game = GameDAO.getGameByORMID(gameName);
            else game = GameDAO.getGameByORMID(session, gameName);

            User user = UserDAO.getUserByORMID(username);
            user.games.add(game);
            UserDAO.save(user);
        }
        else throw new GameNotExistsException(gameName);
    }

    public void registerPlatform(Platform platform, PersistentSession session) throws PersistentException, PlatformExistsException {
        if(!containsPlatform(platform.getName(), session)) PlatformDAO.save(platform);
        else throw new PlatformExistsException(platform.getName());
    }

    public GameSetCollection listUserGames(String username, PersistentSession session) throws PersistentException {
        if(containsUser(username, session))
            if(session != null)
                return UserDAO.getUserByORMID(session, username).games;
            else return UserDAO.getUserByORMID(username).games;
        return null;
    }

    public Game[] listAllGames(PersistentSession session) throws PersistentException {
        if(session != null)return GameDAO.listGameByCriteria(new GameCriteria(session));
        else return GameDAO.listGameByCriteria(new GameCriteria());
    }

    public Game searchGame(String name, PersistentSession session) throws PersistentException, GameNotExistsException, InvalidParametersException {
        if(name == null || name.equals("")) throw new InvalidParametersException();
        if(containsGame(name, session))
            if(session != null) return GameDAO.getGameByORMID(session, name);
            else return GameDAO.getGameByORMID(name);
        else throw new GameNotExistsException(name);
    }

    public boolean deleteGame(Game game, PersistentSession session) throws PersistentException, GameNotExistsException {
        if(containsGame(game.getName(), session)) return GameDAO.delete(game);
        else throw new GameNotExistsException(game.getName());
    }

    private boolean containsUser(String name, PersistentSession session) throws PersistentException {
        User res = null;
        if(session != null)res = UserDAO.getUserByORMID(session, name);
        else res = UserDAO.getUserByORMID(name);
        if(res == null) return false;
        else return true;
    }

    private boolean containsGame(String name, PersistentSession session) throws PersistentException {
        Game res = null;
        if(session != null)res = GameDAO.getGameByORMID(session, name);
        else res = GameDAO.getGameByORMID(name);
        if(res == null) return false;
        else return true;
    }

    private boolean containsPlatform(String name, PersistentSession session) throws PersistentException {
        Platform res = null;
        if(session != null)res = PlatformDAO.getPlatformByORMID(session, name);
        else res = PlatformDAO.getPlatformByORMID(name);
        if(res == null) return false;
        else return true;
    }
}
