package com.wx.config.websocket;

import java.util.concurrent.CopyOnWriteArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

public class CustomWebSocketHandler extends AbstractWebSocketHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomWebSocketHandler.class);
	
	public static CopyOnWriteArrayList<WebSocketSession> online = new CopyOnWriteArrayList<WebSocketSession>();
	
	/***
	 * 处理文本message
	 */
	protected void handleTextMessage(WebSocketSession session,
			TextMessage message) throws Exception {
		logger.info("Received message:"+message.getPayload());
		for(WebSocketSession wss :online){
			wss.sendMessage(message);
		}
		session.sendMessage(new TextMessage("send a new Message"));
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session)
			throws Exception {
		logger.info("一个用户连接！");
		online.add(session);
		session.sendMessage(new TextMessage("链接成功！"));
		super.afterConnectionEstablished(session);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session,
			CloseStatus status) throws Exception {
		logger.info("一个用户离开");
		online.remove(session);
		super.afterConnectionClosed(session, status);
	}
}
