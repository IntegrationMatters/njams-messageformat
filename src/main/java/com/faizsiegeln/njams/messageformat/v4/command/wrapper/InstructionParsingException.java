package com.faizsiegeln.njams.messageformat.v4.command.wrapper;

/**
 * Use this exception if you cannot parse stuff from instruction
 *
 * @author bwand
 * @version 4.1.0
 */
public class InstructionParsingException extends RuntimeException{
    /**
     * Use this if you do not have a Root Cause. Provide clear and informative Message with all needed Context
     * Information.
     *
     * @param message the message for the exception
     */
    public InstructionParsingException(String message) {
        super(message);
    }

    /**
     * Use this one if you have a Root Cause. Provide clear and informative Message with all needed Context Information.
     *
     * @param message the message for the exception
     * @param cause   the root cause for the exception
     */
    public InstructionParsingException(String message, Throwable cause) {
        super(message, cause);
    }

}
