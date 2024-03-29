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

import java.io.Serializable;

/**
 *
 * @author pnientiedt
 */
public class Predecessor implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID of the transition in the process model; required
     */
    private String modelId;

    /**
     * ID of the activity instance from where the transition starts; required
     */
    private String fromInstanceId;

    public Predecessor() {
    }

    public Predecessor(String modelId, String fromInstanceId) {
        this.modelId = modelId;
        this.fromInstanceId = fromInstanceId;
    }

    /**
     * @return the fromInstanceId
     */
    public String getFromInstanceId() {
        return fromInstanceId;
    }

    /**
     * @param fromInstanceId the fromInstanceId to set
     */
    public void setFromInstanceId(String fromInstanceId) {
        this.fromInstanceId = fromInstanceId;
    }

    /**
     * @return the modelId
     */
    public String getModelId() {
        return modelId;
    }

    /**
     * @param modelId the modelId to set
     */
    public void setModelId(String modelId) {
        this.modelId = modelId;
    }
}
