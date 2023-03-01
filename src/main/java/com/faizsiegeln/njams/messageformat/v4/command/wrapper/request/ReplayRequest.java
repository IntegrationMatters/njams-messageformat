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
import com.faizsiegeln.njams.messageformat.v4.command.wrapper.InstructionMapper;

import java.util.Objects;

public class ReplayRequest extends AbstractRequest{

    public static final Command COMMAND_FOR_THIS_CLASS = Command.REPLAY;

    private static final String PROCESS = "Process";
    private static final String PAYLOAD = "Payload";
    private static final String DEEPTRACE = "Deeptrace";
    private static final String TEST = "Test";

    public ReplayRequest(String processPath, String payload, boolean deepTrace,
                         boolean test) {
        Objects.requireNonNull(processPath, "processPath must not be null");
        Objects.requireNonNull(payload, "payload must not be null");

        Request requestToSet = new Request();
        requestToSet.setCommand(COMMAND_FOR_THIS_CLASS.commandString());

        instructionToAdapt = new Instruction();
        instructionToAdapt.setRequest(requestToSet);
        instructionToAdapt.setRequestParameter(PROCESS, processPath);
        instructionToAdapt.setRequestParameter(PAYLOAD, payload);
        instructionToAdapt.setRequestParameter(DEEPTRACE,
                InstructionMapper.InstructionSerializer.serializeBoolean(deepTrace));
        instructionToAdapt
                .setRequestParameter(TEST, InstructionMapper.InstructionSerializer.serializeBoolean(test));
    }

    public ReplayRequest(Instruction instructionToAdapt) {
        super(instructionToAdapt);
        validateCommand(COMMAND_FOR_THIS_CLASS);
    }

    public String getProcess() {
        return instructionToAdapt.getRequestParameterByName(PROCESS);
    }

    public String getPayload() {
        return instructionToAdapt.getRequestParameterByName(PAYLOAD);
    }

    public boolean isDeepTrace() {
        return InstructionMapper.InstructionParser
                .parseBoolean(instructionToAdapt.getRequestParameterByName(DEEPTRACE));
    }

    public boolean isTest() {
        return InstructionMapper.InstructionParser.parseBoolean(instructionToAdapt.getRequestParameterByName(TEST));
    }

    public Instruction getInstruction() {
        return instructionToAdapt;
    }

}
