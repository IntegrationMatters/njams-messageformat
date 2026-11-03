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
import com.faizsiegeln.njams.messageformat.v4.command.wrapper.NjamsMessageFormatException;
import com.faizsiegeln.njams.messageformat.v4.command.wrapper.request.*;
import com.faizsiegeln.njams.messageformat.v4.command.wrapper.response.*;
import org.junit.Test;

import static org.mockito.Mockito.*;


public class InstructionWrapperTest {

    @Test
    public void replayFromServerToClientAndBack() {

        MessageQueue toServer = new MessageQueue();
        MessageQueue toClient = new MessageQueue();
        //This is for simulating the Server and the SDK
        Server server = spy(new Server(toClient, toServer));
        Client client = spy(new Client(toClient, toServer));

        toServer.addListener(server);
        toClient.addListener(client);

        server.triggerReplayEvent();

        verifyServerMethods(server);
        verifyClientMethods(client);
    }

    private void verifyServerMethods(Server server) {
        verify(server, times(1)).triggerReplayEvent();
        verify(server, times(1)).onMessage();
        verify(server, times(1)).onInstruction((Instruction) any());
        verify(server, times(1)).onInstruction((ReplayResponse) any());

        verify(server, times(0)).onInstruction((ConfigureExtractResponse) any());
        verify(server, times(0)).onInstruction((DeleteExtractResponse) any());
        verify(server, times(0)).onInstruction((GetExtractResponse) any());
        verify(server, times(0)).onInstruction((GetLogLevelResponse) any());
        verify(server, times(0)).onInstruction((GetLogModeResponse) any());
        verify(server, times(0)).onInstruction((GetTracingResponse) any());
        verify(server, times(0)).onInstruction((RecordResponse) any());
        verify(server, times(0)).onInstruction((SendProjectMessageResponse) any());
        verify(server, times(0)).onInstruction((SetLogLevelResponse) any());
        verify(server, times(0)).onInstruction((SetLogModeResponse) any());
        verify(server, times(0)).onInstruction((SetTracingResponse) any());
        verify(server, times(0)).onInstruction((TestExpressionResponse) any());
    }

    private void verifyClientMethods(Client client) {
        verify(client, times(1)).onMessage();
        verify(client, times(1)).onInstruction((Instruction) any());
        verify(client, times(1)).onInstruction((ReplayRequest) any());

        verify(client, times(0)).onInstruction((ConfigureExtractRequest) any());
        verify(client, times(0)).onInstruction((DeleteExtractRequest) any());
        verify(client, times(0)).onInstruction((GetExtractRequest) any());
        verify(client, times(0)).onInstruction((GetLogLevelRequest) any());
        verify(client, times(0)).onInstruction((GetLogModeRequest) any());
        verify(client, times(0)).onInstruction((GetTracingRequest) any());
        verify(client, times(0)).onInstruction((RecordRequest) any());
        verify(client, times(0)).onInstruction((SendProjectMessageRequest) any());
        verify(client, times(0)).onInstruction((SetLogLevelRequest) any());
        verify(client, times(0)).onInstruction((SetLogModeRequest) any());
        verify(client, times(0)).onInstruction((SetTracingRequest) any());
        verify(client, times(0)).onInstruction((TestExpressionRequest) any());
    }
}
