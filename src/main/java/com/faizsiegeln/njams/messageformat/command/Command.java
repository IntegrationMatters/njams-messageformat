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
package com.faizsiegeln.njams.messageformat.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Defines the commands handled by this instruction listener implementation.
 *
 * @deprecated Message format V3 has been removed in nJAMS server 5.2.0
 *
 */
@Deprecated
public enum Command {
    GET_RESOURCE("GetResource"),
    /**
     * actually not used by the server, not implemented yet
     */
    GET_STATS("GetStats"),
    GET_LOG_LEVEL("GetLogLevel"),
    /**
     * actually not used by the server, not implemented yet
     */
    GET_IMAGE("GetImage"),
    SET_LOG_LEVEL("SetLogLevel"),
    /**
     * actually not used by the server, not implemented yet
     */
    GET_ASPECT_CONFIG("GetAspectConfig"),
    SET_TRACING("SetTracing"),
    CONFIGURE_ASPECT("ConfigureAspect"),
    DELETE_ASPECT_CONFIG("DeleteAspectConfig"),
    HEARTBEAT("HeartBeat"),
    SEND_PROJECTMESSAGE("SendProjectmessage");

    private static final Logger LOG = LoggerFactory.getLogger(Command.class);

    private final String commandString;

    private Command(String cmd) {
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
     * Extracts the command from the given message.
     *
     * @param text
     *            the message
     * @return <code>null</code> if no such command is defined, or an error occurred.
     */
    public static Command getFromMessage(String text) {
        InstructionExt instruction = InstructionExt.createInstructionExt(text);
        return getFromInstruction(instruction);
    }

    /**
     * Extracts the command from the given {@link Instruction}.
     *
     * @param instruction
     *            the instruction
     * @return <code>null</code> if no such command is defined, or the given instruction was <code>null</code>.
     */
    public static Command getFromInstruction(Instruction instruction) {
        if (instruction == null) {
            return null;
        }
        return getFromCommandString(instruction.getRequest().getCommand());
    }

    /**
     * Returns the {@link Command} instance according to given command string (from a JMS message).
     *
     * @param commandString
     *            the command string
     * @return <code>null</code> if no such command is defined, or the given command string was <code>null</code>.
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
