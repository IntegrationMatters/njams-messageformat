package com.faizsiegeln.njams.messageformat.v4.command.wrapper;

import com.faizsiegeln.njams.messageformat.v4.command.wrapper.response.*;

/**
 * This interface should be implemented in the Server to receive processed instruction responses.
 */
public interface ResponseListener {

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
