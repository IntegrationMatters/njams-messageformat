package com.faizsiegeln.njams.messageformat.v4.command.wrapper.example;

import com.faizsiegeln.njams.messageformat.v4.command.Instruction;
import com.faizsiegeln.njams.messageformat.v4.command.wrapper.NjamsMessageFormatException;
import com.faizsiegeln.njams.messageformat.v4.command.wrapper.RequestListener;
import com.faizsiegeln.njams.messageformat.v4.command.wrapper.request.*;
import com.faizsiegeln.njams.messageformat.v4.command.wrapper.response.ReplayResponse;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Client implements MessageListener, RequestListener {

    private MessageQueue toClient;

    private MessageQueue toServer;

    public Client(MessageQueue toClient, MessageQueue toServer) {
        this.toClient = toClient;
        this.toServer = toServer;
    }

    @Override
    public void onMessage() throws NjamsMessageFormatException {
        //--> receive Instruction via connection
        Instruction instructionFromServer = toClient.remove();
        //Iterate over all possible instructions
        boolean wasCorrectInstruction = true;
        try {
            wasCorrectInstruction = onInstruction(instructionFromServer);
        }catch(NjamsMessageFormatException ex){
            //might be thrown if something happened inside the corresponding onInstruction(...Request) methods
        }
        if(!wasCorrectInstruction) {
            //Error handling because the instruction wasn't a correct instruction
        }
    }

    @Override
    public void onInstruction(ReplayRequest request) throws NjamsMessageFormatException {
        //Process the request...
        ReplayResponse replayResponse = new ReplayResponse(request.getInstruction(), 0, "Success", "testMainLogId",
                "testException", LocalDateTime.now(ZoneOffset.UTC));

        //send back to Server!
        Instruction processedInstruction = replayResponse.getInstruction();
        toServer.add(processedInstruction);
    }

    @Override
    public void onInstruction(ConfigureExtractRequest request) {
        //Do nothing for this example
    }

    @Override
    public void onInstruction(DeleteExtractRequest request) {
        //Do nothing for this example
    }

    @Override
    public void onInstruction(GetExtractRequest request) {
        //Do nothing for this example
    }

    @Override
    public void onInstruction(GetLogLevelRequest request) {
        //Do nothing for this example
    }

    @Override
    public void onInstruction(GetLogModeRequest request) {
        //Do nothing for this example
    }

    @Override
    public void onInstruction(GetTracingRequest request) {
        //Do nothing for this example
    }

    @Override
    public void onInstruction(RecordRequest request) {
        //Do nothing for this example
    }

    @Override
    public void onInstruction(SendProjectMessageRequest request) {
        //Do nothing for this example
    }

    @Override
    public void onInstruction(SetLogLevelRequest request) {
        //Do nothing for this example
    }

    @Override
    public void onInstruction(SetLogModeRequest request) {
        //Do nothing for this example
    }

    @Override
    public void onInstruction(SetTracingRequest request) {
        //Do nothing for this example
    }

    @Override
    public void onInstruction(TestExpressionRequest request) {
        //Do nothing for this example
    }
}
