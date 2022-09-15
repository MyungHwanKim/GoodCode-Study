package com.example.goodcodestudy.behavioral.chain_of_responsibility;

public class Main {
    public static void main(String[] args) {
        User user = new User();

        MessageSenderChain smsSenderChain = new SmsSenderChain();
        smsSenderChain.next(new PushSenderChain())
                .next(new EmailSenderChain());

        smsSenderChain.send(user, new MessageDetail());
    }
}
