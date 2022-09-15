package com.example.goodcodestudy.behavioral.chain_of_responsibility;

public class EmailSenderChain extends MessageSenderChain {
    @Override
    protected void execute(User user, MessageDetail messageDetail) {
        System.out.println("EMAIL 메시지 전송!");
    }
}
