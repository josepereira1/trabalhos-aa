
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

    private final static QName _UserDetails_QNAME = new QName("http://webservices/", "userDetails");
    private final static QName _Hello_QNAME = new QName("http://webservices/", "hello");
    private final static QName _UserDetailsResponse_QNAME = new QName("http://webservices/", "userDetailsResponse");
    private final static QName _HelloResponse_QNAME = new QName("http://webservices/", "helloResponse");
    private final static QName _UserNotExistsException_QNAME = new QName("http://webservices/", "UserNotExistsException");
    private final static QName _PersistentException_QNAME = new QName("http://webservices/", "PersistentException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PersistentException }
     * 
     */
    public PersistentException createPersistentException() {
        return new PersistentException();
    }

    /**
     * Create an instance of {@link UserNotExistsException }
     * 
     */
    public UserNotExistsException createUserNotExistsException() {
        return new UserNotExistsException();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link UserDetailsResponse }
     * 
     */
    public UserDetailsResponse createUserDetailsResponse() {
        return new UserDetailsResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link UserDetails }
     * 
     */
    public UserDetails createUserDetails() {
        return new UserDetails();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link UserDetails }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "userDetails")
    public JAXBElement<UserDetails> createUserDetails(UserDetails value) {
        return new JAXBElement<UserDetails>(_UserDetails_QNAME, UserDetails.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link UserDetailsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "userDetailsResponse")
    public JAXBElement<UserDetailsResponse> createUserDetailsResponse(UserDetailsResponse value) {
        return new JAXBElement<UserDetailsResponse>(_UserDetailsResponse_QNAME, UserDetailsResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link UserNotExistsException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "UserNotExistsException")
    public JAXBElement<UserNotExistsException> createUserNotExistsException(UserNotExistsException value) {
        return new JAXBElement<UserNotExistsException>(_UserNotExistsException_QNAME, UserNotExistsException.class, null, value);
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
