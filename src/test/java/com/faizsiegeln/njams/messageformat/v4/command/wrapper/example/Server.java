package com.faizsiegeln.njams.messageformat.v4.command.wrapper.example;

import com.faizsiegeln.njams.messageformat.v4.command.Instruction;
import com.faizsiegeln.njams.messageformat.v4.command.wrapper.ResponseListener;
import com.faizsiegeln.njams.messageformat.v4.command.wrapper.request.ReplayRequest;
import com.faizsiegeln.njams.messageformat.v4.command.wrapper.response.*;

import java.time.LocalDateTime;

public class Server implements MessageListener, ResponseListener {

    private final MessageQueue toClient;

    private final MessageQueue toServer;

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
    public void onMessage() {
        //--> receive Instruction via connection
        Instruction processedBySDK = toServer.remove();

        onInstruction(processedBySDK);
    }

    @Override
    public void onInstruction(ReplayResponse response){
        //Read the response!
        final int resultCode = response.getResultCode();
        final String resultMessage = response.getResultMessage();
        final LocalDateTime dateTime = response.getDateTime();
        final String mainLogId = response.getMainLogId();
        final String exception = response.getException();

        //Finished
    }

    @Override
    public void onInstruction(ConfigureExtractResponse response) {
        //Do nothing for this example
    }

    @Override
    public void onInstruction(DeleteExtractResponse response) {
        //Do nothing for this example
    }

    @Override
    public void onInstruction(GetExtractResponse response) {
        //Do nothing for this example
    }

    @Override
    public void onInstruction(GetLogLevelResponse response) {
        //Do nothing for this example
    }

    @Override
    public void onInstruction(GetLogModeResponse response) {
        //Do nothing for this example
    }

    @Override
    public void onInstruction(GetTracingResponse response) {
        //Do nothing for this example
    }

    @Override
    public void onInstruction(RecordResponse response) {
        //Do nothing for this example
    }

    @Override
    public void onInstruction(SendProjectMessageResponse response) {
        //Do nothing for this example
    }

    @Override
    public void onInstruction(SetLogLevelResponse response) {
        //Do nothing for this example
    }

    @Override
    public void onInstruction(SetLogModeResponse response) {
        //Do nothing for this example
    }

    @Override
    public void onInstruction(SetTracingResponse response) {
        //Do nothing for this example
    }

    @Override
    public void onInstruction(TestExpressionResponse response) {
        //Do nothing for this example
    }
}
