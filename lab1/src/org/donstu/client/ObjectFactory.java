
package org.donstu.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.donstu.client package. 
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

    private final static QName _GetCompanyListResponse_QNAME = new QName("https://donstu.org/hh", "getCompanyListResponse");
    private final static QName _GetCompanyList_QNAME = new QName("https://donstu.org/hh", "getCompanyList");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.donstu.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCompanyList }
     * 
     */
    public GetCompanyList createGetCompanyList() {
        return new GetCompanyList();
    }

    /**
     * Create an instance of {@link GetCompanyListResponse }
     * 
     */
    public GetCompanyListResponse createGetCompanyListResponse() {
        return new GetCompanyListResponse();
    }

    /**
     * Create an instance of {@link Company }
     * 
     */
    public Company createCompany() {
        return new Company();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCompanyListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://donstu.org/hh", name = "getCompanyListResponse")
    public JAXBElement<GetCompanyListResponse> createGetCompanyListResponse(GetCompanyListResponse value) {
        return new JAXBElement<GetCompanyListResponse>(_GetCompanyListResponse_QNAME, GetCompanyListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCompanyList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://donstu.org/hh", name = "getCompanyList")
    public JAXBElement<GetCompanyList> createGetCompanyList(GetCompanyList value) {
        return new JAXBElement<GetCompanyList>(_GetCompanyList_QNAME, GetCompanyList.class, null, value);
    }

}
