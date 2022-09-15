package com.example.goodcodestudy.behavioral.chain_of_responsibility;

public class PushSenderChain extends MessageSenderChain {
    @Override
    protected void execute(User user, MessageDetail messageDetail) {
        System.out.println("PUSH 메시지 전송!");
    }
}
