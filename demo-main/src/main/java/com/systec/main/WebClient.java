package com.systec.main;


import com.systec.test.PublishWebService;
import com.systec.test.PublishWebServiceService;

/**
 * Created by wh on 8/29/2017.
 */
public class WebClient {
    public static void main(String[] args) {
        PublishWebService publishWebService = new PublishWebServiceService().getPublishWebServicePort();
        String name = publishWebService.helloWorld("haha");
        System.out.println(name);
    }
}
