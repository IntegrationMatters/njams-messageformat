package com.faizsiegeln.njams.messageformat.v4.command.wrapper.example;

import com.faizsiegeln.njams.messageformat.v4.command.Instruction;
import com.faizsiegeln.njams.messageformat.v4.command.wrapper.NjamsMessageFormatException;
import com.faizsiegeln.njams.messageformat.v4.command.wrapper.ResponseListener;
import com.faizsiegeln.njams.messageformat.v4.command.wrapper.request.ReplayRequest;
import com.faizsiegeln.njams.messageformat.v4.command.wrapper.response.*;

import java.time.LocalDateTime;

public class Server implements MessageListener, ResponseListener {

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

        onInstruction(processedBySDK);
    }

    @Override
    public void onInstruction(ReplayResponse response) throws NjamsMessageFormatException {
        //Read the response!
        final int resultCode = response.getResultCode();
        final String resultMessage = response.getResultMessage();
        final LocalDateTime dateTime = response.getDateTime();
        final String mainLogId = response.getMainLogId();
        final String exception = response.getException();

        //Finished
    }

    @Override
    public void onInstruction(ConfigureExtractResponse response) throws NjamsMessageFormatException {
        //Do nothing for this example
    }

    @Override
    public void onInstruction(DeleteExtractResponse response) throws NjamsMessageFormatException {
        //Do nothing for this example
    }

    @Override
    public void onInstruction(GetExtractResponse response) throws NjamsMessageFormatException {
        //Do nothing for this example
    }

    @Override
    public void onInstruction(GetLogLevelResponse response) throws NjamsMessageFormatException {
        //Do nothing for this example
    }

    @Override
    public void onInstruction(GetLogModeResponse response) throws NjamsMessageFormatException {
        //Do nothing for this example
    }

    @Override
    public void onInstruction(GetTracingResponse response) throws NjamsMessageFormatException {
        //Do nothing for this example
    }

    @Override
    public void onInstruction(RecordResponse response) throws NjamsMessageFormatException {
        //Do nothing for this example
    }

    @Override
    public void onInstruction(SendProjectMessageResponse response) throws NjamsMessageFormatException {
        //Do nothing for this example
    }

    @Override
    public void onInstruction(SetLogLevelResponse response) throws NjamsMessageFormatException {
        //Do nothing for this example
    }

    @Override
    public void onInstruction(SetLogModeResponse response) throws NjamsMessageFormatException {
        //Do nothing for this example
    }

    @Override
    public void onInstruction(SetTracingResponse response) throws NjamsMessageFormatException {
        //Do nothing for this example
    }

    @Override
    public void onInstruction(TestExpressionResponse response) throws NjamsMessageFormatException {
        //Do nothing for this example
    }
}
