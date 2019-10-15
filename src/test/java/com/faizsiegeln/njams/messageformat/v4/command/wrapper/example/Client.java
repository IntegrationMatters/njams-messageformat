package com.faizsiegeln.njams.messageformat.v4.command.wrapper.example;

import com.faizsiegeln.njams.messageformat.v4.command.Instruction;
import com.faizsiegeln.njams.messageformat.v4.command.wrapper.NjamsMessageFormatException;
import com.faizsiegeln.njams.messageformat.v4.command.wrapper.request.ReplayRequest;
import com.faizsiegeln.njams.messageformat.v4.command.wrapper.response.ReplayResponse;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Client implements MessageListener {

    private MessageQueue toClient;

    private MessageQueue toServer;

    public Client(MessageQueue toClient, MessageQueue toServer){
        this.toClient = toClient;
        this.toServer = toServer;
    }

    @Override
    public void onMessage() throws NjamsMessageFormatException {
        //--> receive Instruction via connection
        Instruction instructionFromServer = toClient.remove();
        //iterate over all commands and find the correct one
        ReplayRequest replayRequest = new ReplayRequest(instructionFromServer);
        //process Instruction accordingly
        //...
        //Success!
        ReplayResponse replayResponse = new ReplayResponse(instructionFromServer, 0, "Success", "testMainLogId",
                "testException", LocalDateTime.now(ZoneOffset.UTC));
        //send back to Server!
        Instruction processedInstruction = replayResponse.getInstruction();
        toServer.add(processedInstruction);
    }
}
