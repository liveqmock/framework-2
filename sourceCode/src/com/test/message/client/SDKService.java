package com.test.message.client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.11
 * 2014-05-20T16:23:19.542+08:00
 * Generated source version: 2.7.11
 * 
 */
@WebServiceClient(name = "SDKService", 
                  wsdlLocation = "http://sdk4report.eucp.b2m.cn:8080/sdk/SDKService?wsdl",
                  targetNamespace = "http://sdkhttp.eucp.b2m.cn/") 
public class SDKService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://sdkhttp.eucp.b2m.cn/", "SDKService");
    public final static QName SDKService = new QName("http://sdkhttp.eucp.b2m.cn/", "SDKService");
    static {
        URL url = null;
        try {
            url = new URL("http://sdk4report.eucp.b2m.cn:8080/sdk/SDKService?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(SDKService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://sdk4report.eucp.b2m.cn:8080/sdk/SDKService?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public SDKService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public SDKService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SDKService() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     *
     * @return
     *     returns SDKClient
     */
    @WebEndpoint(name = "SDKService")
    public SDKClient getSDKService() {
        return super.getPort(SDKService, SDKClient.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SDKClient
     */
    @WebEndpoint(name = "SDKService")
    public SDKClient getSDKService(WebServiceFeature... features) {
        return super.getPort(SDKService, SDKClient.class, features);
    }

}