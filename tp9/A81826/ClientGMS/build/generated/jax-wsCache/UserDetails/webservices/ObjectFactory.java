
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

    private final static QName _UserDontExistException_QNAME = new QName("http://webservices/", "UserDontExistException");
    private final static QName _Login_QNAME = new QName("http://webservices/", "login");
    private final static QName _SearchuserResponse_QNAME = new QName("http://webservices/", "searchuserResponse");
    private final static QName _Hello_QNAME = new QName("http://webservices/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://webservices/", "helloResponse");
    private final static QName _Searchuser_QNAME = new QName("http://webservices/", "searchuser");
    private final static QName _LoginResponse_QNAME = new QName("http://webservices/", "loginResponse");
    private final static QName _PersistentException_QNAME = new QName("http://webservices/", "PersistentException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link PersistentException }
     * 
     */
    public PersistentException createPersistentException() {
        return new PersistentException();
    }

    /**
     * Create an instance of {@link Searchuser }
     * 
     */
    public Searchuser createSearchuser() {
        return new Searchuser();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link SearchuserResponse }
     * 
     */
    public SearchuserResponse createSearchuserResponse() {
        return new SearchuserResponse();
    }

    /**
     * Create an instance of {@link UserDontExistException }
     * 
     */
    public UserDontExistException createUserDontExistException() {
        return new UserDontExistException();
    }

    /**
     * Create an instance of {@link GameSetCollection }
     * 
     */
    public GameSetCollection createGameSetCollection() {
        return new GameSetCollection();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserDontExistException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "UserDontExistException")
    public JAXBElement<UserDontExistException> createUserDontExistException(UserDontExistException value) {
        return new JAXBElement<UserDontExistException>(_UserDontExistException_QNAME, UserDontExistException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchuserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "searchuserResponse")
    public JAXBElement<SearchuserResponse> createSearchuserResponse(SearchuserResponse value) {
        return new JAXBElement<SearchuserResponse>(_SearchuserResponse_QNAME, SearchuserResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Searchuser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "searchuser")
    public JAXBElement<Searchuser> createSearchuser(Searchuser value) {
        return new JAXBElement<Searchuser>(_Searchuser_QNAME, Searchuser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersistentException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "PersistentException")
    public JAXBElement<PersistentException> createPersistentException(PersistentException value) {
        return new JAXBElement<PersistentException>(_PersistentException_QNAME, PersistentException.class, null, value);
    }

}
