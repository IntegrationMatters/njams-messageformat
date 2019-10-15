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
package com.faizsiegeln.njams.messageformat.v4.command.wrapper.request;

import com.faizsiegeln.njams.messageformat.v4.command.Command;
import com.faizsiegeln.njams.messageformat.v4.command.Instruction;
import com.faizsiegeln.njams.messageformat.v4.command.Request;
import com.faizsiegeln.njams.messageformat.v4.command.wrapper.NjamsMessageFormatException;

import static com.faizsiegeln.njams.messageformat.v4.command.wrapper.InstructionConstants.*;

public class DeleteExtractRequest {

    public static final Command COMMAND_FOR_THIS_CLASS = Command.DELETE_EXTRACT;

    private Instruction instructionToAdapt;

    public DeleteExtractRequest(String processPathToSet, String activityIdToSet) {
        this.instructionToAdapt = new Instruction();
        Request requestToSet = new Request();
        requestToSet.setCommand(COMMAND_FOR_THIS_CLASS.commandString());

        instructionToAdapt.setRequest(requestToSet);
        instructionToAdapt.setRequestParameter(PROCESS_PATH_KEY, processPathToSet);
        instructionToAdapt.setRequestParameter(ACTIVITY_ID_KEY, activityIdToSet);
    }

    public DeleteExtractRequest(Instruction instructionToAdapt) throws NjamsMessageFormatException {
        if (instructionToAdapt.getCommand().equals(COMMAND_FOR_THIS_CLASS.commandString())) {
            this.instructionToAdapt = instructionToAdapt;
        } else {
            throw new NjamsMessageFormatException(
                    "Command " + instructionToAdapt.getCommand() + " is not suitable for " + this.getClass());
        }
    }

    public String getProcessPath() {
        return instructionToAdapt.getRequestParameterByName(PROCESS_PATH_KEY);
    }

    public String getActivityId() {
        return instructionToAdapt.getRequestParameterByName(ACTIVITY_ID_KEY);
    }

    public Instruction getInstruction() {
        return instructionToAdapt;
    }

}
