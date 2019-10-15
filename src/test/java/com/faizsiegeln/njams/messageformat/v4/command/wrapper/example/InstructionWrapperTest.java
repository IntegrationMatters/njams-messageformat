package com.faizsiegeln.njams.messageformat.v4.command.wrapper.example;

import org.junit.Test;

public class InstructionWrapperTest {

    @Test
    public void replayFromServerToClientAndBack() {

        MessageQueue toServer = new MessageQueue();
        MessageQueue toClient = new MessageQueue();
        //This is for simulating the Server and the SDK
        Server server = new Server(toClient, toServer);
        Client client = new Client(toClient, toServer);

        toServer.addListener(server);
        toClient.addListener(client);

        server.triggerReplayEvent();
    }
}
