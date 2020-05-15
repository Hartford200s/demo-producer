package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController { 
	
	private final Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@RequestMapping("/hello")
    public String index(@RequestParam String name) {
        return "hello "+name+"，this is first messge";
    }
	
	@RequestMapping("/hello2")
    public String hello2(@RequestParam String name) {
		logger.info("request two name is "+name);
	    try{
	        Thread.sleep(1000000);//模擬此method有異常
	    }catch ( Exception e){
	        logger.error(" hello two error",e);
	    }
	    return "hello "+name+"，this is two messge";
    }
}
