
package com.sltc.soa.client.stub;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "BankWSService", targetNamespace = "http://soa.sltc.com/", wsdlLocation = "http://localhost:8888/DemoWebService?wsdl")
public class BankWSService
    extends Service
{

    private final static URL BANKWSSERVICE_WSDL_LOCATION;
    private final static WebServiceException BANKWSSERVICE_EXCEPTION;
    private final static QName BANKWSSERVICE_QNAME = new QName("http://soa.sltc.com/", "BankWSService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8888/DemoWebService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        BANKWSSERVICE_WSDL_LOCATION = url;
        BANKWSSERVICE_EXCEPTION = e;
    }

    public BankWSService() {
        super(__getWsdlLocation(), BANKWSSERVICE_QNAME);
    }

    public BankWSService(WebServiceFeature... features) {
        super(__getWsdlLocation(), BANKWSSERVICE_QNAME, features);
    }

    public BankWSService(URL wsdlLocation) {
        super(wsdlLocation, BANKWSSERVICE_QNAME);
    }

    public BankWSService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, BANKWSSERVICE_QNAME, features);
    }

    public BankWSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BankWSService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns BankWS
     */
    @WebEndpoint(name = "BankWSPort")
    public BankWS getBankWSPort() {
        return super.getPort(new QName("http://soa.sltc.com/", "BankWSPort"), BankWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BankWS
     */
    @WebEndpoint(name = "BankWSPort")
    public BankWS getBankWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://soa.sltc.com/", "BankWSPort"), BankWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (BANKWSSERVICE_EXCEPTION!= null) {
            throw BANKWSSERVICE_EXCEPTION;
        }
        return BANKWSSERVICE_WSDL_LOCATION;
    }

}
