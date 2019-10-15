package com.faizsiegeln.njams.messageformat.v4.command.wrapper.example;

import com.faizsiegeln.njams.messageformat.v4.command.Instruction;
import com.faizsiegeln.njams.messageformat.v4.command.wrapper.NjamsMessageFormatException;
import com.faizsiegeln.njams.messageformat.v4.command.wrapper.request.ReplayRequest;
import com.faizsiegeln.njams.messageformat.v4.command.wrapper.response.ReplayResponse;

import java.time.LocalDateTime;

public class Server implements MessageListener{

    private MessageQueue toClient;

    private MessageQueue toServer;

    public Server(MessageQueue toClient, MessageQueue toServer){
        this.toClient = toClient;
        this.toServer = toServer;
    }

    public void triggerReplayEvent() {
        ReplayRequest replayRequest = createReplayRequest();

        //get the Instruction from replayRequest
        Instruction instructionToSendToClient = replayRequest.getInstruction();

        this.toClient.add(instructionToSendToClient);
    }

    private ReplayRequest createReplayRequest() {
        //--> Gather data from Server
        final String process = "testProcess";
        final String startActivity = "testActivity";
        final String payload = "testPayload";
        final boolean isDeepTrace = true;
        final boolean isTest = true;

        //init ReplayRequest with data
        return new ReplayRequest(process, startActivity, payload, isDeepTrace, isTest);
    }

    @Override
    public void onMessage() throws NjamsMessageFormatException {
        //--> receive Instruction via connection
        Instruction processedBySDK = toServer.remove();
        //iterate over all commands and find the correct one
        ReplayResponse replayResponse = new ReplayResponse(processedBySDK);
        //Read the response!
        final int resultCode = replayResponse.getResultCode();
        final String resultMessage = replayResponse.getResultMessage();
        final LocalDateTime dateTime = replayResponse.getDateTime();
        final String mainLogId = replayResponse.getMainLogId();
        final String exception = replayResponse.getException();

        //Finished
    }
}
