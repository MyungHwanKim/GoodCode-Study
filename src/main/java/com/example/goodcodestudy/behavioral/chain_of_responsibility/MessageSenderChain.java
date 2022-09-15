package com.example.goodcodestudy.behavioral.chain_of_responsibility;

import static java.util.Objects.*;

public abstract class MessageSenderChain {
    private MessageSenderChain next;

    public MessageSenderChain next(MessageSenderChain next) {
        this.next = next;
        return next;
    }

    public void send(User user, MessageDetail messageDetail) {
        // TODO
        execute(user, messageDetail);

        // NEXT
        if (nonNull(next)) {
            next.send(user, messageDetail);
        }
    }

    protected abstract void execute(User user, MessageDetail messageDetail);
}
