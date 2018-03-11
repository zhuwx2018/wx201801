package com.wx.config.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
@EnableWebSocket
public class CustomWebSocketConfig implements WebSocketConfigurer {

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(customWebSocketHandler(), "/socket").withSockJS();
		
	}
	@Bean
	public CustomWebSocketHandler customWebSocketHandler(){
		return new CustomWebSocketHandler();
	}
}
