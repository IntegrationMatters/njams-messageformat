/*
 * Copyright (c) 2026 Salesfive Integration Services GmbH
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge,
 * publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of
 * the Software.
 *
 * The Software shall be used for Good, not Evil.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO
 * THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
 *  FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 */
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
        final String payload = "testPayload";
        final boolean isDeepTrace = true;
        final boolean isTest = true;

        //init ReplayRequest with data
        return new ReplayRequest(process, payload, isDeepTrace, isTest);
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
