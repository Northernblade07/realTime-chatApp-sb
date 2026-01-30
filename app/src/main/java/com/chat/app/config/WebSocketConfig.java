package com.chat.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
       registry.addEndpoint("/chat")
               .setAllowedOrigins("http://localhost:8080")
               .withSockJS();

//       since we are using thymeleaf , the allowed origins will be 8080
//       , if React was used then it would have been 5173
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
//      set message broker

        registry.enableSimpleBroker("/topic");
//        expect message with /app/sendMessage
        registry.setApplicationDestinationPrefixes("/app");

    }
}
