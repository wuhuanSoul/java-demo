package com.systec.main;

import javax.jws.*;
import javax.xml.ws.Endpoint;

/**
 * Created by wh on 8/29/2017.
 */
@javax.jws.WebService
public class PublishWebService {

    public String helloWorld(String name){
        return "Hello:" + name;
    }

    @WebMethod(exclude = true)
    public String helloWorld2(String name){
        return "Hello:" + name;
    }

    public static void main(String[] args) {
        Endpoint.publish("http://192.168.22.193:456/helloWord", new PublishWebService());
    }

}
