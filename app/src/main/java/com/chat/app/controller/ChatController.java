package com.chat.app.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.chat.app.model.ChatMessage;

@Controller
public class ChatController {//going to handle all incoming messages that is being sent from fronted and going to add it to all the clients
	
	@MessageMapping("/sendMessage")//maps web socket messages to destination
	@SendTo("/topic/messages")
	public ChatMessage sendMessage(ChatMessage message) {
		return message;
	}
	
	@GetMapping("chat")
	public String chat() {
		return "chat";//anyone going on localhost/,,/chat will go to a thymeleaf template
	}

}
