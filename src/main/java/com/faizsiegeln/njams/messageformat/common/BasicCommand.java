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
package com.faizsiegeln.njams.messageformat.common;

/**
 *
 * @author pnientiedt
 */
public interface BasicCommand {

    public String getCommand();

    /**
     * Returns the value of the request parameter with a name matching the given one, ignoring case.
     * @param name The name of parameter to return (case-insensitive)
     * @return The parameter value, or <code>null</code> if not found
     */
    public String getRequestParameterByName(String name);

    /**
     * Returns the value of the response parameter with a name matching the given one, ignoring case.
     * @param name The name of parameter to return (case-insensitive)
     * @return The parameter value, or <code>null</code> if not found
     */
    public String getResponseParameterByName(String name);

    /**
     * Sets a request parameter.
     * @param name The name of the parameter.
     * @param value The value to set.
     */
    public void setRequestParameter(String name, String value);

    /**
     * Sets a response parameter.
     * @param name The name of the parameter.
     * @param value The value to set.
     */
    public void setResponseParameter(String name, String value);
}
