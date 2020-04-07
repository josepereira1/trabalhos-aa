import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import pt.uminho.di.aa.*;

import java.util.Collection;
import java.util.List;

public class GMS {
    private StandardServiceRegistry sr;
    private Session s;
    private Collection<User> users;

    public GMS() {
        //1 - Configuration
        Configuration configuration = new Configuration().configure();
        this.sr = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        //2 - SessionFactory
        SessionFactory sf = configuration.buildSessionFactory(sr);
        this.s = sf.openSession();
        this.s.setFlushMode(FlushMode.COMMIT); //propagate changes on commit
        Query query = this.s.createQuery("from User u");
        this.users = query.list();
    }

    public Collection<User> getAllUsers() {
        return this.users;
    }

    public Collection<Game> getUserGames(String name) throws UserDontExistException {
        Query query = s.createQuery("from User u where u.name = '" + name + "'");
        List results = query.list();
        if(results.size()==0) throw new UserDontExistException(name);
        User user = (User) results.get(0);
        return user.getGames();
    }

    public void registerUser(User user) throws UserAlreadyExistsException {
        for(User u : users) {
            if(u.getEmail().equals(user.getEmail()))
                throw new UserAlreadyExistsException(user.getName());
        }
        users.add(user);
        s.save(user);
    }

    public void registerGame(Game game) throws GameAlreadyExistsException {
        Query query = s.createQuery("from Game g where g.name = '" + game.getName() + "'");
        List games = query.list();
        if(games.size()!=0) throw new GameAlreadyExistsException(game.getName());
        s.save(game);
    }

    public void registerPlatform(Platform platform) throws PlatformAlreadyExistsException {
        Query query = s.createQuery("from Platform p where p.name = '" + platform.getName() +"'");
        List platforms = query.list();
        if(platforms.size()!=0) throw new PlatformAlreadyExistsException(platform.getName());
        s.save(platform);
    }

    public void registerFormat(Format format)throws FormatAlreadyExistsException {
        Query query = s.createQuery("from Format f where f.kind = " + format.getKind());
        List formats = query.list();
        if(formats.size()!=0) throw new FormatAlreadyExistsException(Integer.toString(format.getKind()));
        s.save(format);
    }

    public void deleteGame(String name) throws GameDontExistsException {
        Query query = s.createQuery("from Game g where g.name = '" + name + "'");
        List games = query.list();
        if(games.size()==0) throw new GameDontExistsException(name);
        //s.createQuery("delete from User_Game ug where ug.games_id = "+ ((Game)games.get(0)).getId()).executeUpdate();
        s.createQuery("delete from Game g where g.id = " + ((Game)games.get(0)).getId()).executeUpdate();
    }

    public void deleteGame(Game game) throws GameDontExistsException {
        Query query = s.createQuery("from Game g where g.name = '" + game.getName() + "'");
        List games = query.list();
        if(games.size()==0) throw new GameDontExistsException(game.getName());
        s.createQuery("delete from user_game ug where ug.game_id = " + ((Game)games.get(0)).getId()).executeUpdate();
        s.createQuery("delete from Game g where g.id = " + ((Game)games.get(0)).getId()).executeUpdate();
    }

    public Game searchGame(String name) throws GameDontExistsException {
        Query query = s.createQuery("from Game g where g.name = '" + name + "'");
        List games = query.list();
        if(games.size()==0) throw new GameDontExistsException(name);
        return (Game) games.get(0);
    }

    public void close() {
        s.close();
        StandardServiceRegistryBuilder.destroy(sr);
    }

    public Transaction beginTransaction() {
        return s.beginTransaction();
    }
}
