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
import com.faizsiegeln.njams.messageformat.v4.projectmessage.LogLevel;
import com.faizsiegeln.njams.messageformat.v4.projectmessage.LogMode;

import java.util.Objects;

import static com.faizsiegeln.njams.messageformat.v4.command.wrapper.InstructionConstants.*;

public class SetLogLevelRequest extends AbstractRequest{

    public static final Command COMMAND_FOR_THIS_CLASS = Command.SET_LOG_LEVEL;

    public SetLogLevelRequest(String processPath, LogLevel logLevel, boolean exclude, LogMode logMode) {
        Objects.requireNonNull(processPath, "processPath must not be null");
        Objects.requireNonNull(logLevel, "logLevel must not be null");
        Objects.requireNonNull(logMode, "logMode must not be null");

        Request requestToSet = new Request();
        requestToSet.setCommand(COMMAND_FOR_THIS_CLASS.commandString());

        instructionToAdapt = new Instruction();
        instructionToAdapt.setRequest(requestToSet);
        instructionToAdapt.setRequestParameter(PROCESS_PATH_KEY, processPath);
        instructionToAdapt.setRequestParameter(LOG_LEVEL_KEY, InstructionMapper.InstructionSerializer.serializeLogLevel(logLevel));
        instructionToAdapt.setRequestParameter(EXCLUDE_KEY, InstructionMapper.InstructionSerializer.serializeBoolean(exclude));
        instructionToAdapt.setRequestParameter(LOG_MODE_KEY, InstructionMapper.InstructionSerializer.serializeLogMode(logMode));
    }

    public SetLogLevelRequest(Instruction instructionToAdapt) {
        super(instructionToAdapt);
        validateCommand(COMMAND_FOR_THIS_CLASS);
    }

    public String getProcessPath() {
        return instructionToAdapt.getRequestParameterByName(PROCESS_PATH_KEY);
    }

    public LogLevel getLogLevel() {
        return InstructionMapper.InstructionParser.parseLogLevel(instructionToAdapt.getRequestParameterByName(LOG_LEVEL_KEY));
    }

    public boolean isExcluded() {
        return InstructionMapper.InstructionParser.parseBoolean(instructionToAdapt.getRequestParameterByName(EXCLUDE_KEY));
    }

    public LogMode getLogMode() {
        return InstructionMapper.InstructionParser.parseLogMode(instructionToAdapt.getRequestParameterByName(LOG_MODE_KEY));
    }

    public Instruction getInstruction() {
        return instructionToAdapt;
    }

}
