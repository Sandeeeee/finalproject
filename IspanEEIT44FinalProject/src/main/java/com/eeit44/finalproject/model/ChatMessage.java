package com.eeit44.finalproject.model;

import java.awt.TrayIcon.MessageType;

import lombok.Builder;
import lombok.Data;

/**
 * Created by rajeevkumarsingh on 24/07/17.
 */
@Builder
@Data
public class ChatMessage {
    private MessageType type;
    private String content;
    private String senderId;
    private String receiverId;
    private String senderName;
    private String receiverName;
    private String channel;

 
}
