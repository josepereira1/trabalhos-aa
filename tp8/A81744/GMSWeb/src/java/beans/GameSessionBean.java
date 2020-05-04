/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import aa.GMS;
import aa.Game;
import aa.GameAlreadyExistsException;
import aa.GameCriteria;
import aa.GameDAO;
import aa.GameNotExistsException;
import aa.Platform;
import aa.User;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import javax.ejb.Stateless;
import org.orm.PersistentException;
import org.orm.PersistentSession;

/**
 *
 * @author Ricardo Petronilho
 */
@Stateless
public class GameSessionBean implements GameSessionBeanLocal {

    @Override
    public void registerGame(Game game) throws PersistentException, GameAlreadyExistsException {
        if (GameDAO.getGameByORMID(GMS.getSession(), game.getName()) != null) throw new GameAlreadyExistsException(game.getName());
        GameDAO.save(game);
    }
    
    @Override
    public Collection<Game> getAllGames() throws PersistentException {
        Game[] games = GameDAO.listGameByCriteria(new GameCriteria(GMS.getSession()));
        return Arrays.asList(games);
    }

    @Override
    public Game getGame(String gameName) throws PersistentException, GameNotExistsException {
        Game game = GameDAO.getGameByORMID(GMS.getSession(), gameName);
        if (game == null) throw new GameNotExistsException(gameName);
        return game;
    }
    
    @Override
    public void deleteGame(String gameName) throws PersistentException, GameNotExistsException {
        Game game = GameDAO.getGameByORMID(GMS.getSession(), gameName);
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
}
