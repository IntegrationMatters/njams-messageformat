/* 
 * Copyright (c) 2018 Faiz & Siegeln Software GmbH
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * 
 * The Software shall be used for Good, not Evil.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 */
package com.faizsiegeln.njams.messageformat.v4.projectmessage;

import com.faizsiegeln.njams.messageformat.v4.command.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author pnientiedt
 */
public enum LogLevel {
    INFO(0),
    SUCCESS(1),
    WARNING(2),
    ERROR(3);

    private static final Logger LOG = LoggerFactory.getLogger(Command.class);

    private final int value;

    private LogLevel(int cmd) {
        value = cmd;
    }

    public int value() {
        return value;
    }

    public static LogLevel getFromValue(int value) {
        for (LogLevel logLevel : values()) {
            if (logLevel.value == value) {
                return logLevel;
            }
        }
        LOG.debug("LogLevel not found: {}", value);
        return null;
    }
}
