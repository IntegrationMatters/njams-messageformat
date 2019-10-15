package com.faizsiegeln.njams.messageformat.v4.command.wrapper.example;

import com.faizsiegeln.njams.messageformat.v4.command.wrapper.NjamsMessageFormatException;

public interface MessageListener {

    void onMessage() throws NjamsMessageFormatException;
}
