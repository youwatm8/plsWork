package com.example.zack.newapplication;

/**
 * Created by devin.diamond on 5/18/2016.
 */
public class ChatMessage {
    private String author;
    private String message;

    public ChatMessage(String message){

    }

    public ChatMessage(String author, String message){
        this.message = message;
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public String getAuthor() {
        return author;
    }
}
