/*
 * Copyright (c) 2026 Salesfive Integration Services GmbH
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge,
 * publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of
 * the Software.
 *
 * The Software shall be used for Good, not Evil.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO
 * THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
 *  FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 */
package com.faizsiegeln.njams.messageformat.v4.command.wrapper;

import com.faizsiegeln.njams.messageformat.v4.command.Command;
import com.faizsiegeln.njams.messageformat.v4.command.Instruction;
import com.faizsiegeln.njams.messageformat.v4.command.wrapper.request.*;

/**
 * This interface should be implemented in the SDK to process incoming instruction requests.
 */
@Deprecated(since = "5.0.0", forRemoval = true)
public interface RequestListener {

    /**
     * This calls the correct onInstruction(...Request) method if the command in the instruction has
     * a corresponding Request class.
     *
     * @param instruction the incoming instruction
     * @return true, if a corresponding request class was found and used, else false
     */
    default boolean onInstruction(Instruction instruction) {
        boolean foundCorrespondingRequestClass = true;
        if (instruction != null) {
            Command command = Command.getFromCommandString(instruction.getCommand());
            if (command != null) {
                switch (command) {
                case CONFIGURE_EXTRACT:
                    onInstruction(new ConfigureExtractRequest(instruction));
                    break;
                case DELETE_EXTRACT:
                    onInstruction(new DeleteExtractRequest(instruction));
                    break;
                case GET_EXTRACT:
                    onInstruction(new GetExtractRequest(instruction));
                    break;
                case GET_LOG_LEVEL:
                    onInstruction(new GetLogLevelRequest(instruction));
                    break;
                case GET_LOG_MODE:
                    onInstruction(new GetLogModeRequest(instruction));
                    break;
                case GET_TRACING:
                    onInstruction(new GetTracingRequest(instruction));
                    break;
                case RECORD:
                    onInstruction(new RecordRequest(instruction));
                    break;
                case REPLAY:
                    onInstruction(new ReplayRequest(instruction));
                    break;
                case SEND_PROJECTMESSAGE:
                    onInstruction(new SendProjectMessageRequest(instruction));
                    break;
                case SET_LOG_LEVEL:
                    onInstruction(new SetLogLevelRequest(instruction));
                    break;
                case SET_LOG_MODE:
                    onInstruction(new SetLogModeRequest(instruction));
                    break;
                case SET_TRACING:
                    onInstruction(new SetTracingRequest(instruction));
                    break;
                case TEST_EXPRESSION:
                    onInstruction(new TestExpressionRequest(instruction));
                    break;
                default:
                    foundCorrespondingRequestClass = false;
                    break;
                }
            } else {
                foundCorrespondingRequestClass = false;
            }
        } else {
            foundCorrespondingRequestClass = false;
        }
        return foundCorrespondingRequestClass;
    }

    void onInstruction(ConfigureExtractRequest request);

    void onInstruction(DeleteExtractRequest request);

    void onInstruction(GetExtractRequest request);

    void onInstruction(GetLogLevelRequest request);

    void onInstruction(GetLogModeRequest request);

    void onInstruction(GetTracingRequest request);

    void onInstruction(RecordRequest request);

    void onInstruction(ReplayRequest request);

    void onInstruction(SendProjectMessageRequest request);

    void onInstruction(SetLogLevelRequest request);

    void onInstruction(SetLogModeRequest request);

    void onInstruction(SetTracingRequest request);

    void onInstruction(TestExpressionRequest request);
}
