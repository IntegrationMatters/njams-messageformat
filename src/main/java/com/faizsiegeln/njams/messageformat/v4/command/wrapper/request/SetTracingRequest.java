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
import com.faizsiegeln.njams.messageformat.v4.command.wrapper.NjamsMessageFormatException;

import java.time.LocalDateTime;

import static com.faizsiegeln.njams.messageformat.v4.command.wrapper.InstructionConstants.*;

public class SetTracingRequest {

    public static final Command COMMAND_FOR_THIS_CLASS = Command.SET_TRACING;

    private Instruction instructionToAdapt;

    public SetTracingRequest(String processPath, String activityId, boolean enableTracing) {
        this.instructionToAdapt = new Instruction();
        Request requestToSet = new Request();
        requestToSet.setCommand(COMMAND_FOR_THIS_CLASS.commandString());

        instructionToAdapt.setRequest(requestToSet);
        instructionToAdapt.setRequestParameter(PROCESS_PATH_KEY, processPath);
        instructionToAdapt.setRequestParameter(ACTIVITY_ID_KEY, activityId);
        instructionToAdapt.setRequestParameter(ENABLE_TRACING_KEY,
                InstructionMapper.InstructionSerializer.serializeBoolean(enableTracing));
    }

    public SetTracingRequest(Instruction instructionToAdapt) throws NjamsMessageFormatException {
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

    public boolean isTracingEnabled() throws NjamsMessageFormatException {
        return InstructionMapper.InstructionParser
                .parseBoolean(instructionToAdapt.getRequestParameterByName(ENABLE_TRACING_KEY));
    }

    public void setStartTime(LocalDateTime startTimeToSet) throws NjamsMessageFormatException {
        instructionToAdapt.setRequestParameter(START_TIME_KEY,
                InstructionMapper.InstructionSerializer.serializeLocalDateTime(startTimeToSet));
    }

    public LocalDateTime getStartTime() throws NjamsMessageFormatException {
        return InstructionMapper.InstructionParser
                .parseLocalDateTime(instructionToAdapt.getRequestParameterByName(START_TIME_KEY));
    }

    public void setEndTime(LocalDateTime endTimeToSet) throws NjamsMessageFormatException {
        instructionToAdapt.setRequestParameter(END_TIME_KEY,
                InstructionMapper.InstructionSerializer.serializeLocalDateTime(endTimeToSet));
    }

    public LocalDateTime getEndTime() throws NjamsMessageFormatException {
        return InstructionMapper.InstructionParser
                .parseLocalDateTime(instructionToAdapt.getRequestParameterByName(END_TIME_KEY));
    }

    public void setIterations(int iterationsToSet) {
        instructionToAdapt.setRequestParameter(ITERATIONS_KEY,
                InstructionMapper.InstructionSerializer.serializeInteger(iterationsToSet));
    }

    public int getIterations() throws NjamsMessageFormatException {
        return InstructionMapper.InstructionParser
                .parseInteger(instructionToAdapt.getRequestParameterByName(ITERATIONS_KEY));
    }

    public void setDeepTrace(boolean isDeepTrace) {
        instructionToAdapt.setRequestParameter(DEEP_TRACE_KEY,
                InstructionMapper.InstructionSerializer.serializeBoolean(isDeepTrace));
    }

    public boolean isDeepTrace() throws NjamsMessageFormatException {
        return InstructionMapper.InstructionParser
                .parseBoolean(instructionToAdapt.getRequestParameterByName(DEEP_TRACE_KEY));
    }

    public Instruction getInstruction() {
        return instructionToAdapt;
    }

}
