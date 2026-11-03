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
import com.faizsiegeln.njams.messageformat.v4.command.wrapper.response.*;

/**
 * This interface should be implemented in the Server to receive processed instruction responses.
 */
@Deprecated(since = "5.0.0", forRemoval = true)
public interface ResponseListener {

    /**
     * This calls the correct onInstruction(...Response) method if the command in the instruction has
     * a corresponding Response class.
     *
     * @param instruction the incoming instruction
     * @return true, if a corresponding response class was found and used, else false
     */
    default boolean onInstruction(Instruction instruction) {
        boolean foundCorrespondingResponseClass = true;
        if (instruction != null) {
            Command command = Command.getFromCommandString(instruction.getCommand());
            if (command != null) {
                switch (command) {
                case CONFIGURE_EXTRACT:
                    onInstruction(new ConfigureExtractResponse(instruction));
                    break;
                case DELETE_EXTRACT:
                    onInstruction(new DeleteExtractResponse(instruction));
                    break;
                case GET_EXTRACT:
                    onInstruction(new GetExtractResponse(instruction));
                    break;
                case GET_LOG_LEVEL:
                    onInstruction(new GetLogLevelResponse(instruction));
                    break;
                case GET_LOG_MODE:
                    onInstruction(new GetLogModeResponse(instruction));
                    break;
                case GET_TRACING:
                    onInstruction(new GetTracingResponse(instruction));
                    break;
                case RECORD:
                    onInstruction(new RecordResponse(instruction));
                    break;
                case REPLAY:
                    onInstruction(new ReplayResponse(instruction));
                    break;
                case SEND_PROJECTMESSAGE:
                    onInstruction(new SendProjectMessageResponse(instruction));
                    break;
                case SET_LOG_LEVEL:
                    onInstruction(new SetLogLevelResponse(instruction));
                    break;
                case SET_LOG_MODE:
                    onInstruction(new SetLogModeResponse(instruction));
                    break;
                case SET_TRACING:
                    onInstruction(new SetTracingResponse(instruction));
                    break;
                case TEST_EXPRESSION:
                    onInstruction(new TestExpressionResponse(instruction));
                    break;
                default:
                    foundCorrespondingResponseClass = false;
                    break;
                }
            } else {
                foundCorrespondingResponseClass = false;
            }
        } else {
            foundCorrespondingResponseClass = false;
        }
        return foundCorrespondingResponseClass;
    }

    void onInstruction(ConfigureExtractResponse response);

    void onInstruction(DeleteExtractResponse response);

    void onInstruction(GetExtractResponse response);

    void onInstruction(GetLogLevelResponse response);

    void onInstruction(GetLogModeResponse response);

    void onInstruction(GetTracingResponse response);

    void onInstruction(RecordResponse response);

    void onInstruction(ReplayResponse response);

    void onInstruction(SendProjectMessageResponse response);

    void onInstruction(SetLogLevelResponse response);

    void onInstruction(SetLogModeResponse response);

    void onInstruction(SetTracingResponse response);

    void onInstruction(TestExpressionResponse response);
}
