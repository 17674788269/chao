package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * @Autor lvchao
 * @date 2018/6/2
 */
@Controller
@RequestMapping(value = "hello")
public class HelloController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello(){
        return restTemplate.getForEntity("http://USER-SERVICE/user/hello",String.class).getBody();
    }
}
