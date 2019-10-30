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

import static com.faizsiegeln.njams.messageformat.v4.command.wrapper.InstructionConstants.*;

public class RecordRequest extends AbstractRequest{

    public static final Command COMMAND_FOR_THIS_CLASS = Command.RECORD;

    /**
     * This constructor should be used if clientWideRecording should be set and afterwards the processRecording for one
     * specific
     * process should be changed as well.
     *  @param processPath
     * @param clientWideRecording
     * @param processRecording
     */
    public RecordRequest(String processPath, boolean clientWideRecording, boolean processRecording) {
        this(processPath, InstructionMapper.InstructionSerializer.serializeBoolean(clientWideRecording),
                processRecording);
    }

    /**
     * This constructor should be used if all processes in the client should be set accordingly.
     *
     * @param clientWideRecording
     */
    public RecordRequest(boolean clientWideRecording) {
        this(null, clientWideRecording, false);
    }

    /**
     * This constructor should be used if the clientWideRecording should not be touched and only the recording for one
     * process should be set accordingly.
     *
     * @param processPathToSet
     * @param processRecording
     */
    public RecordRequest(String processPathToSet, boolean processRecording) {
        this(processPathToSet, null, processRecording);
    }

    private RecordRequest(String processPathToSet, String clientWideRecordingAsString, boolean processRecording) {
        this.instructionToAdapt = new Instruction();
        Request requestToSet = new Request();
        requestToSet.setCommand(COMMAND_FOR_THIS_CLASS.commandString());

        instructionToAdapt.setRequest(requestToSet);
        instructionToAdapt.setRequestParameter(PROCESS_PATH_KEY, processPathToSet);
        instructionToAdapt.setRequestParameter(CLIENT_WIDE_RECORDING_KEY, clientWideRecordingAsString);
        instructionToAdapt.setRequestParameter(PROCESS_RECORDING_KEY,
                InstructionMapper.InstructionSerializer.serializeBoolean(processRecording));
    }

    /**
     * This constructor should be used if you have got an instruction and want to adapt it with this class.
     *
     * @param instructionToAdapt
     */
    public RecordRequest(Instruction instructionToAdapt) {
        validateCommand(COMMAND_FOR_THIS_CLASS);
        this.instructionToAdapt = instructionToAdapt;
    }

    public String getProcessPath() {
        return instructionToAdapt.getRequestParameterByName(PROCESS_PATH_KEY);
    }

    public boolean isClientWideRecording() {
        return InstructionMapper.InstructionParser
                .parseBoolean(instructionToAdapt.getRequestParameterByName(CLIENT_WIDE_RECORDING_KEY));
    }

    public boolean isProcessRecording() {
        return InstructionMapper.InstructionParser
                .parseBoolean(instructionToAdapt.getResponseParameterByName(PROCESS_RECORDING_KEY));
    }

    public Instruction getInstruction() {
        return instructionToAdapt;
    }

}
