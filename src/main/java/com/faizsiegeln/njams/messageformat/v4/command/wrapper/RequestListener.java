package com.faizsiegeln.njams.messageformat.v4.command.wrapper;

import com.faizsiegeln.njams.messageformat.v4.command.wrapper.request.*;

/**
 * This interface should be implemented in the SDK to process incoming instruction requests.
 */
public interface RequestListener {

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
