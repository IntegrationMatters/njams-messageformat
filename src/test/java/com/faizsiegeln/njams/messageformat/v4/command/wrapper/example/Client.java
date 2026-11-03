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
import com.faizsiegeln.njams.messageformat.v4.command.wrapper.RequestListener;
import com.faizsiegeln.njams.messageformat.v4.command.wrapper.request.*;
import com.faizsiegeln.njams.messageformat.v4.command.wrapper.response.ReplayResponse;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Client implements MessageListener, RequestListener {

    private final MessageQueue toClient;

    private final MessageQueue toServer;

    public Client(MessageQueue toClient, MessageQueue toServer) {
        this.toClient = toClient;
        this.toServer = toServer;
    }

    @Override
    public void onMessage() {
        //--> receive Instruction via connection
        Instruction instructionFromServer = toClient.remove();
        //Iterate over all possible instructions
        boolean wasCorrectInstruction = true;
        wasCorrectInstruction = onInstruction(instructionFromServer);
        if(!wasCorrectInstruction) {
            //Error handling because the instruction wasn't a correct instruction
        }
    }

    @Override
    public void onInstruction(ReplayRequest request) {
        //Process the request...
        ReplayResponse replayResponse = new ReplayResponse(request, 0, "Success", "testMainLogId",
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
