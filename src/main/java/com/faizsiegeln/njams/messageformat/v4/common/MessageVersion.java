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
package com.faizsiegeln.njams.messageformat.v4.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Information about the version of the message. nJAMS server needs it to decide on how to process it.
 */
public enum MessageVersion {

    /**
     * Old Messageformat of nJAMS server 3
     *
     * @deprecated
     */
    @Deprecated
    V3(3),
    /**
     * Messageformat of nJAMS4 Server.
     */
    V4(4);

    private final Integer value;

    private static final Map<Integer, MessageVersion> map = new HashMap<>();

    static {
        for (MessageVersion mv : MessageVersion.values()) {
            map.put(mv.getValue(), mv);
        }
    }

    MessageVersion(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public static MessageVersion getMessageVersion(Integer value) {
        return map.get(value);
    }

}
