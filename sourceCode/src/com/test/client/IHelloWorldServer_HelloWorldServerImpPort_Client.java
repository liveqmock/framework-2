
package com.test.client;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.11
 * 2014-05-19T14:30:22.512+08:00
 * Generated source version: 2.7.11
 * 
 */
public final class IHelloWorldServer_HelloWorldServerImpPort_Client {

    private static final QName SERVICE_NAME = new QName("http://server.test.com/", "HelloService");

    private IHelloWorldServer_HelloWorldServerImpPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = HelloService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        HelloService ss = new HelloService(wsdlURL, SERVICE_NAME);
        IHelloWorldServer port = ss.getHelloWorldServerImpPort();  
        
        {
        System.out.println("Invoking findUsers...");
        com.test.client.ListObject _findUsers__return = port.findUsers();
        System.out.println("findUsers.result=" + _findUsers__return);


        }
        {
        System.out.println("Invoking sayHello...");
        java.lang.String _sayHello_userName = "";
        java.lang.String _sayHello__return = port.sayHello(_sayHello_userName);
        System.out.println("sayHello.result=" + _sayHello__return);


        }
        {
        System.out.println("Invoking sayUserName...");
        com.test.client.User _sayUserName_user = null;
        java.lang.String _sayUserName__return = port.sayUserName(_sayUserName_user);
        System.out.println("sayUserName.result=" + _sayUserName__return);


        }
        {
        System.out.println("Invoking say...");
        java.lang.String _say_arg0 = "";
        java.lang.String _say__return = port.say(_say_arg0);
        System.out.println("say.result=" + _say__return);


        }

        System.exit(0);
    }

}
