package com.chat.app.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ChatMessage {

    private Long id;
    private String sender;
    private String content;

}
