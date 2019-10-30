package com.faizsiegeln.njams.messageformat.v4.command.wrapper.example;

import com.faizsiegeln.njams.messageformat.v4.command.Instruction;
import com.faizsiegeln.njams.messageformat.v4.command.wrapper.NjamsMessageFormatException;

import java.util.LinkedList;

public class MessageQueue extends LinkedList<Instruction> {

    private MessageListener messageListener;

    @Override
    public boolean add(Instruction instruction) {
        boolean add = super.add(instruction);
        messageListener.onMessage();
        return add;
    }

    public void addListener(MessageListener messageListener) {
        this.messageListener = messageListener;
    }
}
