package com.faizsiegeln.njams.messageformat.v4.command.wrapper.example;

import com.faizsiegeln.njams.messageformat.v4.command.Instruction;
import com.faizsiegeln.njams.messageformat.v4.command.wrapper.NjamsMessageFormatException;
import com.faizsiegeln.njams.messageformat.v4.command.wrapper.request.*;
import com.faizsiegeln.njams.messageformat.v4.command.wrapper.response.*;
import org.junit.Test;

import static org.mockito.Mockito.*;


public class InstructionWrapperTest {

    @Test
    public void replayFromServerToClientAndBack() throws NjamsMessageFormatException {

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

    private void verifyServerMethods(Server server) throws NjamsMessageFormatException {
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

    private void verifyClientMethods(Client client) throws NjamsMessageFormatException {
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
