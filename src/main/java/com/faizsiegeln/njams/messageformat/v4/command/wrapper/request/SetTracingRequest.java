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
import java.util.Objects;

import static com.faizsiegeln.njams.messageformat.v4.command.wrapper.InstructionConstants.*;

public class SetTracingRequest extends AbstractRequest{

    public static final Command COMMAND_FOR_THIS_CLASS = Command.SET_TRACING;

    public SetTracingRequest(String processPath, String activityId, boolean enableTracing) {
        Objects.requireNonNull(processPath, "processPath must not be null");
        Objects.requireNonNull(activityId, "activityId must not be null");

        Request requestToSet = new Request();
        requestToSet.setCommand(COMMAND_FOR_THIS_CLASS.commandString());

        instructionToAdapt = new Instruction();
        instructionToAdapt.setRequest(requestToSet);
        instructionToAdapt.setRequestParameter(PROCESS_PATH_KEY, processPath);
        instructionToAdapt.setRequestParameter(ACTIVITY_ID_KEY, activityId);
        instructionToAdapt.setRequestParameter(ENABLE_TRACING_KEY,
                InstructionMapper.InstructionSerializer.serializeBoolean(enableTracing));
    }

    public SetTracingRequest(Instruction instructionToAdapt) {
        validateCommand(COMMAND_FOR_THIS_CLASS);
        this.instructionToAdapt = instructionToAdapt;
    }

    public String getProcessPath() {
        return instructionToAdapt.getRequestParameterByName(PROCESS_PATH_KEY);
    }

    public String getActivityId() {
        return instructionToAdapt.getRequestParameterByName(ACTIVITY_ID_KEY);
    }

    public boolean isTracingEnabled() {
        return InstructionMapper.InstructionParser
                .parseBoolean(instructionToAdapt.getRequestParameterByName(ENABLE_TRACING_KEY));
    }

    public void setStartTime(LocalDateTime startTimeToSet) {
        instructionToAdapt.setRequestParameter(START_TIME_KEY,
                InstructionMapper.InstructionSerializer.serializeLocalDateTime(startTimeToSet));
    }

    public LocalDateTime getStartTime() {
        return InstructionMapper.InstructionParser
                .parseLocalDateTime(instructionToAdapt.getRequestParameterByName(START_TIME_KEY));
    }

    public void setEndTime(LocalDateTime endTimeToSet) {
        instructionToAdapt.setRequestParameter(END_TIME_KEY,
                InstructionMapper.InstructionSerializer.serializeLocalDateTime(endTimeToSet));
    }

    public LocalDateTime getEndTime() {
        return InstructionMapper.InstructionParser
                .parseLocalDateTime(instructionToAdapt.getRequestParameterByName(END_TIME_KEY));
    }

    public void setIterations(int iterationsToSet) {
        instructionToAdapt.setRequestParameter(ITERATIONS_KEY,
                InstructionMapper.InstructionSerializer.serializeInteger(iterationsToSet));
    }

    public int getIterations() {
        return InstructionMapper.InstructionParser
                .parseInteger(instructionToAdapt.getRequestParameterByName(ITERATIONS_KEY));
    }

    public void setDeepTrace(boolean isDeepTrace) {
        instructionToAdapt.setRequestParameter(DEEP_TRACE_KEY,
                InstructionMapper.InstructionSerializer.serializeBoolean(isDeepTrace));
    }

    public boolean isDeepTrace() {
        return InstructionMapper.InstructionParser
                .parseBoolean(instructionToAdapt.getRequestParameterByName(DEEP_TRACE_KEY));
    }

    public Instruction getInstruction() {
        return instructionToAdapt;
    }

}
