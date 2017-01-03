package com.smriti.controller;

import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smriti.model.Message;
import com.smriti.model.OutputMessage;

@Controller
public class ChatController {

	@RequestMapping(value="/user/viewChat", method = RequestMethod.GET)
	  public String viewChat() {
	    return "user/chat";
	  }
	    
	  @MessageMapping("/chat")
	  @SendTo("/topic/message")
	  public OutputMessage sendMessage(Message message) {
	    return new OutputMessage(message, new Date());
	  }

}
