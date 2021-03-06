package com.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lvchao
 * @date 2018/6/13
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

    private  final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private DiscoveryClient client;

    @GetMapping(value = "hello")
    public String hello(){
        ServiceInstance serviceInstance = client.getLocalServiceInstance();
        logger.info("/user/hello host:{} service_id:{}",serviceInstance.getHost(),serviceInstance.getServiceId());
        System.out.println(serviceInstance.getHost()+"@@@@@@@@@@@"+serviceInstance.getServiceId());
        return "hello";
    }
}
