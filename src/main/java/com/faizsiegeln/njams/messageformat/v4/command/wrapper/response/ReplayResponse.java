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
import com.faizsiegeln.njams.messageformat.v4.command.wrapper.request.ReplayRequest;

import java.time.LocalDateTime;
import java.util.Objects;

public class ReplayResponse extends AbstractResponse {

    public static final Command COMMAND_FOR_THIS_CLASS = Command.REPLAY;

    private static final String MAIN_LOG_ID = "MainLogId";
    private static final String EXCEPTION = "Exception";

    public ReplayResponse(ReplayRequest request, int resultCode, String resultMessage, String mainLogId,
                          String exception, LocalDateTime dateTime) {
        super(request.getInstruction(), resultCode, resultMessage);

        Objects.requireNonNull(mainLogId, "mainLogId must not be null");
        Objects.requireNonNull(exception, "exception must not be null");
        Objects.requireNonNull(dateTime, "dateTime must not be null");
        this.instructionToAdapt.setResponseParameter(MAIN_LOG_ID, mainLogId);
        this.instructionToAdapt.setResponseParameter(EXCEPTION, exception);
        this.instructionToAdapt.getResponse().setDateTime(dateTime);
    }

    public ReplayResponse(Instruction instructionToReadFrom) {
        super(instructionToReadFrom);
        validateCommand(COMMAND_FOR_THIS_CLASS);
    }

    public String getMainLogId() {
        return instructionToAdapt.getResponseParameterByName(MAIN_LOG_ID);
    }

    public String getException() {
        return instructionToAdapt.getResponseParameterByName(EXCEPTION);
    }

    public LocalDateTime getDateTime() {
        return instructionToAdapt.getResponse().getDateTime();
    }
}
