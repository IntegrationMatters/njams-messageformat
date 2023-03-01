/*
 * Copyright (c) 2018 Faiz & Siegeln Software GmbH
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * The Software shall be used for Good, not Evil.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 */
package com.faizsiegeln.njams.messageformat.v4.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Defines the commands handled by this instruction listener implementation.
 */
public enum Command {
    GET_LOG_LEVEL("GetLogLevel"),
    SET_LOG_LEVEL("SetLogLevel"),
    GET_LOG_MODE("GetLogMode"),
    SET_LOG_MODE("SetLogMode"),
    SET_TRACING("SetTracing"),
    GET_TRACING("GetTracing"),
    CONFIGURE_EXTRACT("ConfigureExtract"),
    DELETE_EXTRACT("DeleteExtract"),
    GET_EXTRACT("GetExtract"),
    SEND_PROJECTMESSAGE("SendProjectmessage"),
    REPLAY("Replay"),
    RECORD("Record"),
    TEST_EXPRESSION("TestExpression"),
    PING("Ping"),
    GET_REQUEST_HANDLER("GetRequestHandler");

    private static final Logger LOG = LoggerFactory.getLogger(Command.class);

    private final String commandString;

    Command(String cmd) {
        commandString = cmd;
    }

    /**
     * Returns the command's string representation as used in JMS messages.
     *
     * @return the command's string representation as used in JMS messages.
     */
    public String commandString() {
        return commandString;
    }

    /**
     * Extracts the command from the given {@link Instruction}.
     *
     * @param instruction the instruction
     * @return <code>null</code> if no such command is defined, or the given
     * instruction was <code>null</code>.
     */
    public static Command getFromInstruction(Instruction instruction) {
        if (instruction == null) {
            return null;
        }
        return getFromCommandString(instruction.getRequest().getCommand());
    }

    /**
     * Returns the {@link Command} instance according to given command string
     * (from a JMS message).
     *
     * @param commandString the command string
     * @return <code>null</code> if no such command is defined, or the given
     * command string was <code>null</code>.
     */
    public static Command getFromCommandString(String commandString) {
        if (commandString == null) {
            return null;
        }
        for (Command cmd : values()) {
            if (cmd.commandString.equalsIgnoreCase(commandString)) {
                return cmd;
            }
        }
        LOG.debug("Command not found: {}", commandString);
        return null;
    }
}
