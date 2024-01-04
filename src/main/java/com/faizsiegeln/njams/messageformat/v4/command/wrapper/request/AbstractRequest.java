package com.faizsiegeln.njams.messageformat.v4.command.wrapper.request;

import com.faizsiegeln.njams.messageformat.v4.command.Command;
import com.faizsiegeln.njams.messageformat.v4.command.Instruction;
import com.faizsiegeln.njams.messageformat.v4.command.wrapper.NjamsMessageFormatException;

@Deprecated(since = "5.0.0", forRemoval = true)
public class AbstractRequest {

    protected Instruction instructionToAdapt;

    AbstractRequest() {
    }

    AbstractRequest(Instruction instructionToAdapt) {
        this.instructionToAdapt = instructionToAdapt;
    }

    public Instruction getInstruction() {
        return instructionToAdapt;
    }

    protected void validateCommand(Command command) {
        if (!instructionToAdapt.getCommand().equals(command.commandString())) {
            throw new NjamsMessageFormatException(
                "Command " + instructionToAdapt.getCommand() + " is not suitable for " + command.commandString());
        }
    }
}
