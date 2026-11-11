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
package com.faizsiegeln.njams.messageformat.v4.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class CommandTest {

    @Test
    public void commandStringReturnsWireValue() {
        assertEquals("GetLogLevel", Command.GET_LOG_LEVEL.commandString());
        assertEquals("SetLogLevel", Command.SET_LOG_LEVEL.commandString());
        assertEquals("GetLogMode", Command.GET_LOG_MODE.commandString());
        assertEquals("SetLogMode", Command.SET_LOG_MODE.commandString());
        assertEquals("SetTracing", Command.SET_TRACING.commandString());
        assertEquals("GetTracing", Command.GET_TRACING.commandString());
        assertEquals("ConfigureExtract", Command.CONFIGURE_EXTRACT.commandString());
        assertEquals("DeleteExtract", Command.DELETE_EXTRACT.commandString());
        assertEquals("GetExtract", Command.GET_EXTRACT.commandString());
        assertEquals("SendProjectmessage", Command.SEND_PROJECTMESSAGE.commandString());
        assertEquals("Replay", Command.REPLAY.commandString());
        assertEquals("Record", Command.RECORD.commandString());
        assertEquals("TestExpression", Command.TEST_EXPRESSION.commandString());
        assertEquals("Ping", Command.PING.commandString());
        assertEquals("GetRequestHandler", Command.GET_REQUEST_HANDLER.commandString());
        assertEquals("GetRecording", Command.GET_RECORDING.commandString());
    }

    @Test
    public void getFromCommandStringMatchesIgnoringCase() {
        for (Command command : Command.values()) {
            assertEquals(command, Command.getFromCommandString(command.commandString()));
            assertEquals(command, Command.getFromCommandString(command.commandString().toUpperCase()));
            assertEquals(command, Command.getFromCommandString(command.commandString().toLowerCase()));
        }
    }

    @Test
    public void getFromCommandStringReturnsNullForUnknownOrNullValue() {
        assertNull(Command.getFromCommandString("not-a-command"));
        assertNull(Command.getFromCommandString(null));
    }

    @Test
    public void getFromInstructionReturnsNullWhenInstructionHasNoCommand() {
        assertNull(Command.getFromInstruction(null));
        assertNull(Command.getFromInstruction(new Instruction()));

        Instruction instruction = new Instruction();
        instruction.setRequest(new Request());
        assertNull(Command.getFromInstruction(instruction));

        instruction.getRequest().setCommand("not-a-command");
        assertNull(Command.getFromInstruction(instruction));
    }

    @Test
    public void getFromInstructionResolvesRequestCommand() {
        Instruction instruction = new Instruction();
        Request request = new Request();
        request.setCommand("sEtLoGmOdE");
        instruction.setRequest(request);

        assertEquals(Command.SET_LOG_MODE, Command.getFromInstruction(instruction));
    }
}
