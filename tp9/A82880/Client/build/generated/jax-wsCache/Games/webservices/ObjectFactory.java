
package webservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservices package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ListGames_QNAME = new QName("http://webservices/", "listGames");
    private final static QName _Hello_QNAME = new QName("http://webservices/", "hello");
    private final static QName _SearchGame_QNAME = new QName("http://webservices/", "searchGame");
    private final static QName _InvalidParametersException_QNAME = new QName("http://webservices/", "InvalidParametersException");
    private final static QName _ListGamesResponse_QNAME = new QName("http://webservices/", "listGamesResponse");
    private final static QName _GameNotExistsException_QNAME = new QName("http://webservices/", "GameNotExistsException");
    private final static QName _HelloResponse_QNAME = new QName("http://webservices/", "helloResponse");
    private final static QName _PersistentException_QNAME = new QName("http://webservices/", "PersistentException");
    private final static QName _SearchGameResponse_QNAME = new QName("http://webservices/", "searchGameResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SearchGameResponse }
     * 
     */
    public SearchGameResponse createSearchGameResponse() {
        return new SearchGameResponse();
    }

    /**
     * Create an instance of {@link PersistentException }
     * 
     */
    public PersistentException createPersistentException() {
        return new PersistentException();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link GameNotExistsException }
     * 
     */
    public GameNotExistsException createGameNotExistsException() {
        return new GameNotExistsException();
    }

    /**
     * Create an instance of {@link ListGamesResponse }
     * 
     */
    public ListGamesResponse createListGamesResponse() {
        return new ListGamesResponse();
    }

    /**
     * Create an instance of {@link InvalidParametersException }
     * 
     */
    public InvalidParametersException createInvalidParametersException() {
        return new InvalidParametersException();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link SearchGame }
     * 
     */
    public SearchGame createSearchGame() {
        return new SearchGame();
    }

    /**
     * Create an instance of {@link ListGames }
     * 
     */
    public ListGames createListGames() {
        return new ListGames();
    }

    /**
     * Create an instance of {@link Game }
     * 
     */
    public Game createGame() {
        return new Game();
    }

    /**
     * Create an instance of {@link Platform }
     * 
     */
    public Platform createPlatform() {
        return new Platform();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListGames }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "listGames")
    public JAXBElement<ListGames> createListGames(ListGames value) {
        return new JAXBElement<ListGames>(_ListGames_QNAME, ListGames.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchGame }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "searchGame")
    public JAXBElement<SearchGame> createSearchGame(SearchGame value) {
        return new JAXBElement<SearchGame>(_SearchGame_QNAME, SearchGame.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidParametersException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "InvalidParametersException")
    public JAXBElement<InvalidParametersException> createInvalidParametersException(InvalidParametersException value) {
        return new JAXBElement<InvalidParametersException>(_InvalidParametersException_QNAME, InvalidParametersException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListGamesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "listGamesResponse")
    public JAXBElement<ListGamesResponse> createListGamesResponse(ListGamesResponse value) {
        return new JAXBElement<ListGamesResponse>(_ListGamesResponse_QNAME, ListGamesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GameNotExistsException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "GameNotExistsException")
    public JAXBElement<GameNotExistsException> createGameNotExistsException(GameNotExistsException value) {
        return new JAXBElement<GameNotExistsException>(_GameNotExistsException_QNAME, GameNotExistsException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersistentException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "PersistentException")
    public JAXBElement<PersistentException> createPersistentException(PersistentException value) {
        return new JAXBElement<PersistentException>(_PersistentException_QNAME, PersistentException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchGameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "searchGameResponse")
    public JAXBElement<SearchGameResponse> createSearchGameResponse(SearchGameResponse value) {
        return new JAXBElement<SearchGameResponse>(_SearchGameResponse_QNAME, SearchGameResponse.class, null, value);
    }

}
