package com.faizsiegeln.njams.messageformat.v4.command.wrapper;

import com.faizsiegeln.njams.messageformat.v4.command.Command;
import com.faizsiegeln.njams.messageformat.v4.command.Instruction;
import com.faizsiegeln.njams.messageformat.v4.command.wrapper.response.*;

/**
 * This interface should be implemented in the Server to receive processed instruction responses.
 */
public interface ResponseListener {

    /**
     * This calls the correct onInstruction(...Response) method if the command in the instruction has
     * a corresponding Response class.
     *
     * @param instruction the incoming instruction
     * @return true, if a corresponding response class was found and used, else false
     * @throws NjamsMessageFormatException could be thrown while processing one of the onInstruction methods
     */
    default boolean onInstruction(Instruction instruction) throws NjamsMessageFormatException {
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

    void onInstruction(ConfigureExtractResponse response) throws NjamsMessageFormatException;

    void onInstruction(DeleteExtractResponse response) throws NjamsMessageFormatException;

    void onInstruction(GetExtractResponse response) throws NjamsMessageFormatException;

    void onInstruction(GetLogLevelResponse response) throws NjamsMessageFormatException;

    void onInstruction(GetLogModeResponse response) throws NjamsMessageFormatException;

    void onInstruction(GetTracingResponse response) throws NjamsMessageFormatException;

    void onInstruction(RecordResponse response) throws NjamsMessageFormatException;

    void onInstruction(ReplayResponse response) throws NjamsMessageFormatException;

    void onInstruction(SendProjectMessageResponse response) throws NjamsMessageFormatException;

    void onInstruction(SetLogLevelResponse response) throws NjamsMessageFormatException;

    void onInstruction(SetLogModeResponse response) throws NjamsMessageFormatException;

    void onInstruction(SetTracingResponse response) throws NjamsMessageFormatException;

    void onInstruction(TestExpressionResponse response) throws NjamsMessageFormatException;
}
