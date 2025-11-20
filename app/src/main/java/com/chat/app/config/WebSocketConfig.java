package com.chat.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker//this annotation is going to enable web socket messaging in spring boot it tells spring this app will use web socket to handle real time communication
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{
	//it provides a underline protocol to keep the continuous two line communication channel open b/w a client and server
		//STOMP -> sit on a top of web socket & gives a structure to the communication that we do
		//so, Websocket enables realtime connection stomp basically defines how messages are organized, route within that connection
		
		//what is message broking? -> so it is a way of routing message. in message app it is a middle man so, it is going to direct the message at right place

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/chat")
			.setAllowedOrigins("https://full-stack-chat-application-21a3.onrender.com")
			.withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableSimpleBroker("/topic");//set message broker that can handle messages for topic so whoever subscribe to /topic so they will get a broadcast of whatever message are sent over eg. // /topic/chatroom
		registry.setApplicationDestinationPrefixes("/app");//telling server whatever message got with this prefix then process it 
		//set message broker
		//expect message with /app/sendmessage
	}
	
	
	
	
}
