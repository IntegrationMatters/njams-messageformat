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
package com.faizsiegeln.njams.messageformat.v4.logmessage;

import java.util.Arrays;

/**
 *
 * @author pnientiedt
 */
public enum ActivityStatus {
    RUNNING(0), SUCCESS(1), WARNING(2), ERROR(3);

    private final int numeric;

    private ActivityStatus(int num) {
        numeric = num;
    }

    /**
     * Return the numeric status value for this instance,
     * @return The numeric status value for this instance
     */
    public int numericStatus() {
        return numeric;
    }

    /**
     * Returns the instance with the given numeric value or <code>null</code> if not exists.
     * @param numeric
     * @return Returns the instance with the given numeric value or <code>null</code> if not exists.
     */
    public static ActivityStatus byNumericStatus(final int numeric) {
        return Arrays.stream(values()).filter(s -> numeric == s.numeric).findAny().orElse(null);
    }

    /**
     * Returns the instance with the given name or <code>null</code> if not exists.
     * Ignores case.
     * @param name
     * @return Returns the instance with the given name or <code>null</code> if not exists.
     */
    public static ActivityStatus byName(final String name) {
        return Arrays.stream(values()).filter(s -> s.name().equalsIgnoreCase(name)).findAny().orElse(null);
    }
}
