import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import pt.uminho.di.aa.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GMS {
    private StandardServiceRegistry sr;
    private Session s;
    private Transaction t;
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

    public Collection<Game> getAllGames() {
        Query query = this.s.createQuery("from Game g");
        List result = query.list();
        if(result.size()==0) return new ArrayList<>();
        return new ArrayList<>(result);
    }

    public Collection<Game> getUserGames(String name) throws UserDontExistException {
        User user = (User)this.s.get(User.class,name);
        if(user==null) throw new UserDontExistException(name);
        return user.getGames();
    }

    public void registerUser(User user) throws UserAlreadyExistsException {
        for(User u: this.users) {
            if(u.getName().equals(user.getName()))
                throw new UserAlreadyExistsException(user.getName());
        }
        this.users.add(user);
        this.s.save(user);
    }

    public void registerGame(Game game) throws GameAlreadyExistsException {
        Game g = (Game)this.s.get(Game.class,game.getName());
        if(g!=null) throw new GameAlreadyExistsException(game.getName());
        s.save(game);
    }

    public void registerPlatform(Platform platform) throws PlatformAlreadyExistsException {
        Platform p = (Platform)this.s.get(Platform.class,platform.getName());
        if(p!=null) throw new PlatformAlreadyExistsException(platform.getName());
        this.s.save(platform);
    }

    public void registerFormat(Format format)throws FormatAlreadyExistsException {
        Format f = (Format)this.s.get(Format.class,format.getKind());
        if(f!=null) throw new FormatAlreadyExistsException(Integer.toString(format.getKind()));
        this.s.save(format);
    }

    public void deleteGame(String name) throws GameDontExistsException {
        Game game = (Game)this.s.get(Game.class,name);
        if(game==null) throw new GameDontExistsException(name);
        for(User user: this.users) {
            user.getGames().remove(game);
            this.s.update(user);
        }
        game.setPlatform(null);
        this.s.delete(game);
    }

    public Game searchGame(String name) throws GameDontExistsException {
        Game game = (Game)this.s.get(Game.class,name);
        if (game==null) throw new GameDontExistsException(name);
        return game;
    }

    public void close() {
        this.s.close();
        StandardServiceRegistryBuilder.destroy(this.sr);
    }

    public void beginTransaction() {
        this.t = this.s.beginTransaction();
    }

    public void commit() {
        this.t.commit();
    }

    public void rollback() {
        this.t.rollback();
    }
}
