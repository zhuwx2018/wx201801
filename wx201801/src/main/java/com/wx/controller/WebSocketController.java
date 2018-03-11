package com.wx.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wx.model.Message;

@Controller
public class WebSocketController {
	@RequestMapping("/chart")
	public String chartView(){
		return "chart";
	}
	
	@MessageMapping("/hello")
	@SendTo("/topic/hello")
	public Message greet(Message message){
		return message;
	}
	
	/** 
     * 订阅，当有客户端订阅该内容，会有一次性响应 
     * @return 
     */  
    @SubscribeMapping("/subscribeme")  
    public String subscribeThing() {  
        System.out.println("subscribe message called.");  
        return "thank you subscribe my channel";  
    } 
    
    @MessageMapping("/hi")  
    @SendTo("/topic/hi")  
    public String handleHi(String incoming) {  
        System.out.println("receive message : " + incoming);  
        return "hello, " + incoming;   
    }  

}
