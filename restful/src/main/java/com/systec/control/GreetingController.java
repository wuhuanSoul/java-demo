package com.systec.control;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.systec.domain.Greeting;
import com.systec.socket.WebSocketSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by wh on 6/30/2017.
 */
@RestController
public class GreetingController {
    private static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public JSONPObject greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        Greeting greeting = new  Greeting(counter.incrementAndGet(), String.format(template, name));
        JSONPObject json = new JSONPObject("success", greeting);
        return json;
    }

}
