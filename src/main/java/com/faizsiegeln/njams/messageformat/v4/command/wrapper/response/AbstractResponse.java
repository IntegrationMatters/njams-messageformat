/*
 * Copyright (c) 2019 Faiz & Siegeln Software GmbH
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and
 * to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of
 * the Software.
 *
 * The Software shall be used for Good, not Evil.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO
 * THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 */
package com.faizsiegeln.njams.messageformat.v4.command.wrapper.response;

import com.faizsiegeln.njams.messageformat.v4.command.Command;
import com.faizsiegeln.njams.messageformat.v4.command.Instruction;
import com.faizsiegeln.njams.messageformat.v4.command.Response;
import com.faizsiegeln.njams.messageformat.v4.command.wrapper.NjamsMessageFormatException;

import java.util.Objects;

@Deprecated(since = "5.0.0", forRemoval = true)
public class AbstractResponse {

    protected Instruction instructionToAdapt;

    /**
     * This constructor should be used by the SDK to write a resultCode and a resultMessage to the instruction.
     *
     * @param instructionToWriteTo
     * @param resultCode
     * @param resultMessage
     */
    public AbstractResponse(Instruction instructionToWriteTo, int resultCode, String resultMessage) {
        Objects.requireNonNull(instructionToWriteTo, "instructionToWriteTo must not be null");
        Objects.requireNonNull(resultMessage, "resultMessage must not be null");

        instructionToAdapt = instructionToWriteTo;
        if (instructionToAdapt.getResponse() == null) {
            Response response = new Response();
            instructionToAdapt.setResponse(response);
        }
        instructionToAdapt.setResponseResultCode(resultCode);
        instructionToAdapt.setResponseResultMessage(resultMessage);
    }

    /**
     * This constructor should be used by the Server to read from the instruction.
     *
     * @param instructionToReadFrom
     */
    public AbstractResponse(Instruction instructionToReadFrom) {
        Objects.requireNonNull(instructionToReadFrom, "instructionToReadFrom must not be null");
        this.instructionToAdapt = instructionToReadFrom;
    }

    public int getResultCode() {
        return instructionToAdapt.getResponse().getResultCode();
    }

    public boolean wasSuccessful() {
        return getResultCode() == 0;
    }

    public String getResultMessage() {
        return instructionToAdapt.getResponse().getResultMessage();
    }

    public Instruction getInstruction() {
        return instructionToAdapt;
    }

    protected void validateCommand(Command command) {
        if (!instructionToAdapt.getCommand().equals(command.commandString())) {
            throw new NjamsMessageFormatException(
                "Request command " + instructionToAdapt.getCommand() + " is not suitable for Response command "
                    + command.commandString());
        }
    }
}
